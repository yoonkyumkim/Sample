import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class 주차장 {
    public static void main(String[] args) throws ParseException {
        주차장 p = new 주차장();
        int[] fees = {180, 5000, 10, 600};
        String[] records = {"05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT",
                "07:59 5961 OUT", "07:59 0148 IN", "18:59 0000 IN",
                "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT"};
        p.solution(fees, records);
    }

    public int[] solution(int[] fees, String[] records) throws ParseException {
        long defm = fees[0];
        int defp = fees[1];
        int min = fees[2];
        int price = fees[3];

        String time1;
        String time2;
        long timediff;

        HashMap<String, String> park = new HashMap<>();
        HashMap<String, Long> timeMap = new HashMap<>();

        for (int i = 0; i < records.length; i++) {
            String[] temp = records[i].split(" ");
            if (temp[2].equals("IN")) {
                park.put(temp[1], temp[0]);
            } else if (temp[2].equals("OUT")) {
                time1 = park.get(temp[1]);
                time2 = temp[0];
                timediff = timeDiff(time1, time2);
                if (timeMap.containsKey(temp[1]))
                    timeMap.put(temp[1], timeMap.get(temp[1]) + timediff);
                else
                    timeMap.put(temp[1], timediff);
                park.remove(temp[1]);
            }
        }

        for (String key : park.keySet()) {
            time1 = park.get(key);
            time2 = "23:59";
            timediff = timeDiff(time1, time2);
            if (timeMap.containsKey(key))
                timeMap.put(key, timeMap.get(key) + timediff);
            else
                timeMap.put(key, timediff);
        }

        List<String> keySet = new ArrayList<>(timeMap.keySet());

        // 키 값으로 오름차순 정렬
        Collections.sort(keySet);

        List<Integer> priceList = new ArrayList<>();
        int p;
        for (String key : keySet) {
            p = (int) (timeMap.get(key) - defm);
            if ((p % min) > 0)
                p = (p / min) + 1;
            else
                p = p / min;
            p = p * price;
            if (p < 0)
                priceList.add(defp);
            else
                priceList.add(defp + p);
        }

        int[] arr2 = priceList.stream()
                .mapToInt(i -> i)
                .toArray();

        System.out.println(priceList);

        return arr2;
    }

    public static long timeDiff(String a, String b) throws ParseException {
        SimpleDateFormat f = new SimpleDateFormat("HH:mm", Locale.KOREA);

        Date d1 = f.parse(a);
        Date d2 = f.parse(b);
        long diff = d2.getTime() - d1.getTime();
        long minute = diff / 60000;

        return minute;
    }

}
