public class 최댓값최솟값 {
    public String solution(String s) {
        String answer = "";

        String[] str = s.split(" ");

        int max = Integer.parseInt(str[0]);
        int min = Integer.parseInt(str[0]);
        for (String num : str) {
            max = Math.max(max, Integer.parseInt(num));
            min = Math.min(min, Integer.parseInt(num));
        }
        answer =+ min + " " + max;

        return answer;
    }

    public static void main(String[] args) {
        최댓값최솟값 c = new 최댓값최솟값();
        System.out.println(c.solution("-1 -2 -3 -4"));
    }
}
