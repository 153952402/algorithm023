import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * 字母异位词分组
 */
public class GroupAnagramsSolution {

    /**
     * 排序法 + hash
     */
    public List<List<String>> groupAnagrams_sort(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);
            List<String> groupList = map.getOrDefault(key, new ArrayList<>());
            groupList.add(str);
        }
        return new ArrayList(map.values());
    }


    /**
     * char数组计数法 + hash
     */
    public List<List<String>> groupAnagrams_count(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] chars = new char[26];
            for (char c : str.toCharArray()) chars[c - 'a']++;
            String key = new String(chars);
            List<String> groupList = map.getOrDefault(key, new ArrayList<>());
            groupList.add(str);
        }
        return new ArrayList(map.values());
    }
}
