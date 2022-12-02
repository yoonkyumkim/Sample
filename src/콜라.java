public class 콜라 {

    public int solution(int a, int b, int n) {
        int answer = 0;
        int temp;
        while (n >= a) {
            temp = n % a;
            n = (n / a) * b;
            answer += n;
            n += temp;
        }

        System.out.println(answer);
        return answer;
    }

    public static void main(String[] args) {
        콜라 k = new 콜라();
        k.solution(2, 1, 20);
    }
}
