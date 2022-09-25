public class 다음큰숫자 {

    public int countOneBit(int value) {
        int i;
        for (i = 0; value != 0; i++) {
            value &= (value - 1);
        }
        return i;
    }

    public int solution(int n) {
        int answer = n;
        int countA = 0;
        int countB = 0;
        countA = countOneBit(n);
        while(countA != countB) {
            answer += 1;
            countB = countOneBit(answer);

        }

        return answer;
    }

    public static void main(String[] args) {
        다음큰숫자 n = new 다음큰숫자();
        System.out.println(n.solution(15));
    }
}
