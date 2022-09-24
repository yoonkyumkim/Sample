public class 카팻 {

    public int[] solution(int brown, int yellow) {
        int[] answer = {0 ,0};


        int sum = brown + yellow;
        int y = 0;
        int center;
        for (int i = 3; i < sum; i++) {
            y = sum / i;
            //약수가 아님
            if (sum % i > 0 && y < 3) {
                continue;
            }
            center = (i - 2) * (y - 2);
            if (center == yellow && i >= y) {
                answer[0] = i;
                answer[1] = y;
            }
        }


        return answer;
    }

    public static void main(String[] args) {
        카팻 k = new 카팻();
        k.solution(10, 2);
    }

}
