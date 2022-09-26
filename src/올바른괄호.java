import java.util.LinkedList;
import java.util.Queue;

public class 올바른괄호 {

    boolean solution(String s) {
        boolean answer = true;

        Queue q = new LinkedList();

        String c;
        boolean isFirst = true;
        for(int i = 0; i < s.length(); i++) {
            c = s.substring(i, i + 1);
            if (c.equals(")") && isFirst) {
                answer = false;
                break;
            }
            else if (c.equals("(")) {
                q.add("(");
            } else {
                if (!q.isEmpty())
                    q.remove();
            }
            isFirst = false;
        }

        if (!q.isEmpty())
            answer = false;

        return answer;
    }

    public static void main(String[] args) {
        올바른괄호 o = new 올바른괄호();

        System.out.println(o.solution("))()(("));
    }
}
