import java.util.ArrayList;
import java.util.List;

public class 순위검색 {
    static List<String> searchList = new ArrayList<>();
    public int[] solution(String[] info, String[] query) {
        List<Integer> anserList = new ArrayList<>();

        boolean isFirst = true;
        for (int i = 0; i < query.length; i++) {
            String score = query[i].substring(query[i].lastIndexOf(" ") + 1);
            String q = query[i].substring(0, query[i].lastIndexOf(" "));
            String[] qur = q.split(" and ");

            for (int j = 0; j < qur.length; j++) {
                if (qur[j].equals("-")) {
                    continue;
                }
                if (isFirst) {
                    fullSearch(info, qur[j]);
                    isFirst = false;
                } else {
                    indexSearch(qur[j]);
                }
            }
            if (isFirst)
                scoreFullSearch(info, Integer.parseInt(score));
            else
                scoreSearch(Integer.parseInt(score));

            isFirst = true;
            anserList.add(searchList.size());
            searchList.clear();

        }

        int[] arr2 = anserList.stream()
                .mapToInt(i -> i)
                .toArray();

        System.out.println(anserList);
        return arr2;
    }

    public void fullSearch(String[] info, String key) {
        for (int i = 0; i < info.length; i++) {
            if (info[i].contains(key))
                searchList.add(info[i]);
        }
    }

    public void indexSearch(String key) {
        List<String> afterList = new ArrayList<>();
        for(int i = 0; i < searchList.size(); i++) {
            if (searchList.get(i).contains(key)) {
                afterList.add(searchList.get(i));
            }
        }
        searchList.clear();
        searchList = afterList;
    }

    public void scoreSearch(int score) {
        int target;
        List<String> afterList = new ArrayList<>();
        for (int i = 0; i < searchList.size(); i++) {
            target = Integer.parseInt(searchList.get(i).substring(searchList.get(i).lastIndexOf(" ") + 1));
            if (target >= score)
                afterList.add(searchList.get(i));
        }
        searchList.clear();
        searchList = afterList;
    }

    public void scoreFullSearch(String[] info, int score) {
        int target;
        for (int i = 0; i < info.length; i++) {
            target = Integer.parseInt(info[i].substring(info[i].lastIndexOf(" ") + 1));
            if (target >= score)
                searchList.add(info[i]);
        }


    }

    public static void main(String[] args) {
        순위검색 S = new 순위검색();
        String[] info = {"java backend junior pizza 150",
                "python frontend senior chicken 210",
                "python frontend senior chicken 150",
                "cpp backend senior pizza 260",
                "java backend junior chicken 80",
                "python backend senior chicken 50"};

        String[] query = {"java and backend and junior and pizza 100",
                "python and frontend and senior and chicken 200",
                "cpp and - and senior and pizza 250",
                "- and backend and senior and - 150",
                "- and - and - and chicken 100",
                "- and - and - and - 150"};
        S.solution(info, query);
    }
}
