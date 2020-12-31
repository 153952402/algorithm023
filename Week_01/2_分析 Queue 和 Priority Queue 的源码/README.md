## 一 java JDK中Queue.java源码分析
**Queue可以说是jdk中的一个古老的接口类，从jdk1.5中便存在，它代表一个先进先出（FIFO）的队列接口，其完整代码如下** 
    
```java
public interface Queue<E> extends Collection<E> {
    boolean add(E e);
    boolean offer(E e);
    
    E remove();
    E poll();
    
    E element();
    E peek();

}
```

**Queue拓展了Collection， 它的主要操作有3种**
* **在队列尾部添加元素 (add、 offer);**
* **返回头部元素，并从队列中删除 (remove, poll);**
* **返回头部元素，但不修改队列 (element peek)；**

**每种操作都有两种形式，区别在于对特殊情况的处理不同，在队列为空时，remove，element 会抛出NoSuchElementException，**
**而peek和poll会返回特殊值null；在队列未满时，add会抛出异常IllegalStateException，而offer只是返回false**



      
## 二 java JDK中PriorityQueue.java源码分析
**PriorityQueue是Queue接口的实现类之一，顾名思义，它是优先级队列，与一般队列的区别是，在入队时会进行一定规则进行排序，**
**而出队时会依次输出优先级最高的元素。** 
    
**PriorityQueue内部有如下成员：**

```java
public class PriorityQueue<E> extends AbstractQueue<E>
                            implements java.io.Serializable {
    //....
    private transient Object[] queue;
    private int size = 0;
    private final Comparator<? surper E> comparator;
    // ....
}

```
**在java中PriorityQueue的内部是由堆实现的，而堆的物理形式是数组，所以内部有用于存储数据且会根据需求进行动态扩容的数组 `object[] queue`，**
**而数组大小不代表数组中真实存在元素数量，所有还有字段 `int size` 用于记录实际队列元素个数；同时为了能够实现自由比较元素大小，**
**进而实现优先级的队列，内部还有用于保存外部传入的比较器 `Comparator<? surper E> comparator`字段**


**我们现在知道了PriorityQueue是Queue接口的实现类，内部用数据结构"堆"实现，其本质是动态数组，所以PriorityQueue的常用方法主要是**
**在添加、删除等操作时根据堆的性质去维护数组及数组元素间的位置**

**PriorityQueue的常用public方法就是Queue接口中的方法，有add()、remove()、element(), offer()、poll()、peek()，前三者方法中，**
**除add方法有被重写外，remove()、element()是继承AbstractQueue得来的，而且前三者方法实现主要是分别依赖于后三者的，也就是add依赖offer，依次类推，**
  
**没听懂？没关系，我们直接看前三者方法代码实现：**
```java
    @Override
    public boolean add(E e) {
        return offer(e);
    }
    
    //inherited from AbstractQueue
    public E remove() {
        E x = poll();
        if (x != null)
            return x;
        else
            throw new NoSuchElementException();
    }

    //inherited from AbstractQueue
    public E element() {
        E x = peek();
        if (x != null)
            return x;
        else
            throw new NoSuchElementException();
    }

```

**从以上代码可以看出，add()方法是直接调用了offer()，有人可能会问：Queue接口定义中不是说好的add方法会在队列满时抛出IllegalStateException异常?**
**没错，队列满时应该抛出异常，但是PriorityQueue的offer方法实现是在满时会进行动态扩容，这也是它重写add方法的原因，因此PriorityQueue属于无界队列。**
**类似的remove() 和 element()方法内部实现主要是分别调用poll()、peek()方法，并会对返回值进行非空校验，为空则抛出异常**


**接下来我们来了解下offer()方法的内部代码实现，代码如下：**
  
```java
    public boolean offer(E e) {
        //1. 判空
        if (e == null)
            throw new NullPointerException();

        //2. 记录修改次数，用于迭代时进行检查，以判断队列是否发生结构性变化
        modCount++;

        //3. 容量判断，不够则扩容
        int i = size;
        if (i >= queue.length)
            grow(i + 1);

        //4. 调整堆实际大小size，
        //5.1 空堆则直接存入数组头部，
        //5.2 非空堆，则调用siftUp方法根据堆的性质插入并调整
        size = i + 1;
        if (i == 0)
            queue[0] = e;
        else
            siftUp(i, e);
        return true;
    }
```

**offer()方法用于添加元素，内部实现有点覃超哥说的自顶向下的编程意味，我们且将方法中用到的 `扩容方法grow()` 和 `插入并向上调整方法siftUp()` 视为黑盒，然后根据以上代码注释理解内部实现**
**主要逻辑就是参数校验，然后判断当前容量是否足够加入新元素，不够则扩容，够则加入并调用siftUp方法调整元素位置以保证插入新元素后仍满足堆的性质。**
**对grow()方法源码感兴趣的同学可以类比ArrayList中的grow()方法去看, 而siftUp()方法则需要先了解堆的性质，这里就不进行展开讲述**

  
**接下来我们继续了解 poll()方法，源码如下：**

```java
    public E poll() {
        //判断是否还有元素可以返回
        if (size == 0)
            return null;
        
        //size - 1;
        int s = --size;
        
        //记录修改次数，用于迭代时进行检查，以判断队列是否发生结构性变化
        modCount++;
    
        //返回优先级最高的数组头部元素
        // priorityQueue会保证每次增删改操作都根据堆性质调整元素位置，
        // 并将优先级最高元素交换至数组头部
        E result = (E) queue[0];
        E x = (E) queue[s];
        
        //移除元素
        queue[s] = null;

        //删除后，堆非空则根据堆性质进行元素位置调整，
        //将下一个优先级最高的元素放置数组头部
        if (s != 0)
            siftDown(0, x);

        return result;
    }
```

**poll()是用于返回队列优先级最高的头部元素并从队列中移除，方法内部实现很简单，它先判断size以确定是否还有元素可以返回，有则返回数组头部元素，为什么一定是头部元素优先级最高？这是堆的具体实现保证的，**
**也就是对堆进行增、删、改操作时会根据堆的性质对数组元素的位置进行调整，将优先级最高的放置数组头部。**
**siftDown()方法这里我们也不展开讲**

  
**最后我们来喵一眼peek()方法, 代码实现如下，peek()方法用于返回队列优先级最高的队列头部元素，但不改变队列，这也是与poll方法的却别**
**所以代码也非常简单：队列判断是否为空，为空返回null，不为空返回数组头部元素**
```java
    public E peek() {
        return (size == 0) ? null : (E) queue[0];
    }
```