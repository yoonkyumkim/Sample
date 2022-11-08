import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 양궁 {
    static int result = -1;
    static int[] answer = new int[11];
    static int maxDiff;

    public int[] solution(int n, int[] info) {
        int[] app = new int[11];
        dfs(0, info, app, n);
        int sum = 0;
        for (int i = 0; i < answer.length; i++) {
            System.out.println(answer[i]);
            sum += answer[i];
        }
        if (sum > 0)
            return answer;
        else
            return new int[]{-1};
    }


    //실제 과녁에 화살을 맞추는 로직
    public static void dfs (int idx, int[] lion, int[] app, int arrows) {
        if (idx > 10 || arrows == 0) {
            app[10] += arrows;
            calc(lion, app);
            app[10] -= arrows;
            return;
        }

        if (lion[idx] < arrows) {
            app[idx] += lion[idx] + 1;
            dfs (idx + 1, lion, app, arrows - app[idx]);
            app[idx] -= lion[idx] + 1;
        }
        dfs (idx + 1, lion, app ,arrows);
    }

    //점수 계산 및 최대 점수값 검증
    public static void calc(int[] lion, int[] app) {
        int l = 0;
        int a = 0;
        for (int i = 0; i < lion.length; i++) {
            if (lion[i] > app[i])
                l += 10 - i;
            else if (lion[i] + app[i] > 0)
                a += 10 - i;
        }
        int diff = a - l;
        if (diff > 0 && diff >= maxDiff) {
            if (maxDiff == diff && !isBetter(app))
                return;

            maxDiff = diff;
            answer = Arrays.stream(app).toArray();

        }
    }

    //최대 점수값인지 검사 (제일 높은 점수만 비교하면 된다)
    static boolean isBetter(int[] app) {
        for(int i=10; i>=0; i--) {
            if(app[i] > answer[i]) return true;
            else if(app[i] < answer[i]) return false;
        }
        return false;
    }

    public static void main(String[] args) {
        양궁 y = new 양궁();
        //int[] info = {2,1,1,1,0,0,0,0,0,0,0};
        int[] info = {0, 0, 1, 2, 0, 1, 1, 1, 1, 1, 1};
        y.solution(9 , info);
    }
}
