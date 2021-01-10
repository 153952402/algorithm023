import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 前 K 个高频元素
 */
public class TopKFrequentElementsSolution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            Integer count = map.getOrDefault(nums[i], 0);
            map.put(nums[i], ++count);
        }

        List<Integer>[] bucket = new List[nums.length];
        for (Integer key : map.keySet()) {
            Integer count = map.get(key);
            List<Integer> groupList = bucket[count - 1]; //count - 1
            groupList = groupList == null ? new ArrayList<>() : groupList;
            groupList.add(key);
            bucket[count - 1] = groupList;
        }

        int[] result = new int[k];
        int index = 0;
        for (int i = bucket.length - 1; i >= 0 && index < k; i--) {
            List<Integer> groupList = bucket[i];
            if(groupList == null) continue;
            for (Integer num : groupList) {
                result[index++] = num;
            }
        }
        return result;
    }
}
