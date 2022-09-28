import java.util.Arrays;

public class 최솟값 {
    public int solution(int []A, int []B)
    {
        int answer = 0;

        Arrays.sort(A);
        Arrays.sort(B);

        for (int i = 0; i < A.length; i++) {
            answer += A[i] * B[B.length - i - 1];
        }
        return answer;
    }

    public static void main(String[] args) {
        최솟값 c = new 최솟값();
        int[] A = {1,2};
        int[] B = {3,4};
        c.solution(A, B);
    }
}
