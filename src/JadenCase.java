public class JadenCase {

    public String solution(String s) {
        String answer = "";

        String[] spl = s.toLowerCase().split("");

        boolean space = true;
        for (String str : spl) {
            answer += space ? str.toUpperCase() : str;
            //연속 중복 공백에 대한 처리
            space = str.equals(" ") ? true : false;
        }

        return answer;
    }


    public static void main(String[] args) {
        JadenCase j = new JadenCase();
        j.solution("hEllo 1woRld  ");
    }
}
