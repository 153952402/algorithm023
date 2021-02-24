```java
    //冒泡排序
    public void bubbleSort(int[] nums) {
        for(int i = 0; i < nums.length; i++) {
            for(int j = 0; j < nums.length - i - 1; j++) {
                if(nums[j] > nums[j + 1]) {
                    int temp = nums[j];
                    nums[j] = nums[j+1];
                    nums[j + 1] = temp;
                }
            }
        }
    }
    
   //快速排序
    public void quickSort(int[] nums, int left, int right) {
        if(left >= right) return;
        int pivot = nums[left];
        int l = left, r = right;
        while(l < r) {
            // 使用 >= 而不是 > 是防止 {0,1,2,5,0}这种序列，当i和j指向的数都相等时可能会进入死循环
            while(l < r && nums[r] >= pivot) r--;
            if(l < r) nums[l] = nums[r];
            // 使用 >= 的作用和上面一样，实际只要任意一个地方会加入等于号 =即可避免死循环
            while(l < r && nums[l] <= pivot) l++;
            if(l < r) nums[r] = nums[l];
        }
        nums[l] = pivot;
        quickSort(nums, left, l - 1);
        quickSort(nums, l + 1, right);
    }
    
    //归并排序
    public void mergeSort(int[] nums, int left, int right) {
        if(left >= right) return;
        int mid = left + (right - left) / 2';
        mergeSort(nums, left, mid);
        mergeSort(nums, mid + 1, right);
        int[] cache = new int[right - left + 1];
        int i = left, j = mid + 1, c = 0;
        while(i <= mid && j <= right) {
            cache[c++] = nums[i] < nums[j] ? nums[i++] : nums[j++];
        }
        while(i <= mid) cache[c++] = nums[i++];
        while(j <= right) cache[c++] = nums[j++];
        System.arraycopy(cache, 0, nums, left, cache.length);
    }
    
    //堆排序
    public void sort(int[] nums) {
        if(nums == null || nums.length == 0) return;
        int n = nums.length;
        for(int i = n / 2 - 1; i--) {
            heapify(nums, i, n);
        }
        for(int i = n - 1; i >= 0; i--) {
            swap(nums, i, 0);
            heapify(nums, 0, i);
        }
    }
    public void heapify(int[] nums, int i, int length) {
        int left = i * 2 + 1;
        int right = i * 2 + 2;
        int largest = i;
        
        if(left < length && nums[left] > nums[largest]) {
            largest = left;
        }
        if(right < length && nums[right] > nums[largest]) {
            largest = right;
        }
        if(largest != i) {
            swap(nums, largest, i);
            heapify(nums, largest, length);
        }
    }