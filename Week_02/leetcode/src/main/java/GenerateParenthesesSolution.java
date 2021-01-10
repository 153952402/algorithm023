import java.util.ArrayList;
import java.util.List;

/**
 * 括号生成
 */
public class GenerateParenthesesSolution {
    //递归解法
    List<String> res = new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        if(n <= 0){
            return res;
        }
        recursive(new StringBuffer(), n, n);
        return res;
    }
    private void recursive(StringBuffer sb, int left, int right) {
        if(left == 0 && right == 0 ){
            res.add(sb.toString());
            return;
        }
        if(left == right) {
            recursive(sb.append("("), left - 1, right);
        }else {
            if(left > 0) {
                recursive(sb.append("("), left - 1, right);
                sb.deleteCharAt(sb.length() - 1);//状态还原
            }
            recursive(sb.append(")"), left, right - 1);
        }
        sb.deleteCharAt(sb.length() - 1);//状态还原
    }
}
