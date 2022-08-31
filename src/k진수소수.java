public class k진수소수 {
    public static void main(String[] args) {

        k진수소수 k = new k진수소수();
        int a = k.solution(110011, 2);
        System.out.println(a);
    }

    public int solution(int n, int k) {
        int answer = 0;

        if (n < 1 || n > 1000000)
            return 0;

        if (k < 3 || k > 10)
            return 0;

        String changeNum = Integer.toString(n, k);

        String[] splitNum = changeNum.split("0");

        for (int i = 0; i < splitNum.length; i++) {
            if (splitNum[i].equals(""))
                continue;
            //가장 큰 n값을 2진수로 바꾸면 int를 넘어갈 수가 있다.
            if (is_prime(Long.parseLong(splitNum[i])))
                answer++;
        }

        return answer;
    }

    //소수판별 메소드
    public static boolean is_prime(long n){
        //0과 1은 소수가 아니므로 바로 종료.
        if(n == 0) return false;
        if(n == 1) return false;

        //2~n의 제곱근까지 돌면서 나누어 떨어지면 소수가 아니므로 메소드 종료.
        for(int i=2;i<=Math.sqrt(n);i++){
            if(n % i == 0) return false;
        }

        return true;
    }

}
