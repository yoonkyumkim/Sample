import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class 숫자짝꿍 {

    public String solution(String X, String Y) {
        String answer = "";

        int[] cntX = new int[10];
        int[] cntY = new int[10];

        for (String tmpX : X.split("")) cntX[Integer.parseInt(tmpX)]++;
        for (String tmpY : Y.split("")) cntY[Integer.parseInt(tmpY)]++;

        StringBuilder sb = new StringBuilder();

        for (int i = 9; i >= 0; i--){
            while(cntX[i] > 0 && cntY[i] > 0){
                sb.append(i);
                cntX[i]--;
                cntY[i]--;
            }
        }

        if ("".equals(sb.toString())) {
            answer = "-1";
        } else if ("0".equals(sb.substring(0,1))) {
            answer = "0";
        } else {
            answer = sb.toString();
        }
//        int cnt = 0;
//
//        if (X.length() < 3 || Y.length() < 3 || X.length() > 3000000 || Y.length() > 3000000)
//            return "-1";
//
//        char[] xChar = X.toCharArray();
//        char[] yChar = Y.toCharArray();
//        StringBuilder str = new StringBuilder();
//
//        if (xChar[0] == '0' || yChar[0] == '0')
//            return "-1";
//
//        for (char x : xChar) {
//            for (int i = 0; i < yChar.length ; i++) {
//                if (x == yChar[i]) {
//                    str.append(x);
//                    yChar[i] = 'x';
//                    break;
//                }
//            }
//        }
//
//        char[] cList = str.toString().toCharArray();
//        Arrays.sort(cList);
//        for (char s : str.toString().toCharArray()) {
//            if (s == '0') {
//                cnt++;
//            }
//        }
//
//        if (cnt > 0 && cnt == cList.length )
//            answer = "0";
//        else if (cList.length == 0)
//            answer = "-1";
//        else {
//            for (char s : cList) {
//                answer += s;
//            }
//            answer = new StringBuilder(new String(cList)).reverse().toString();
//        }

        return answer;
    }


    public static void main(String[] args) {
        숫자짝꿍 s = new 숫자짝꿍();
        s.solution("100227222", "20222222220");
    }
}
