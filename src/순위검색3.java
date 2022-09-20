import java.util.*;

public class 순위검색3 {
    static List<Info> sList = new ArrayList<>();
    static HashMap<String, Integer> sMap = new HashMap<>();
    static List<Integer> searchList = new ArrayList<>();
    static boolean isFirst = true;
    public int[] solution(String[] info, String[] query) {
        List<Integer> anserList = new ArrayList<>();

        List<String[]> strList = new ArrayList<>();
        for (int i = 0; i < info.length; i++) {
            String[] p = info[i].split(" ");

            strList.add(p);
        }

        Collections.sort(strList, new Comparator<String[]>(){
            @Override
            public int compare(String[] o1, String[] o2) {
                if(o1[4] == o2[4]){
                    return o2[4].compareTo(o1[4]);
                }
                return Integer.parseInt(o1[4]) - Integer.parseInt(o2[4]);
            }
        });

        boolean f = true;
        for (int i = 0; i < query.length; i++) {
            int score = Integer.parseInt(query[i].substring(query[i].lastIndexOf(" ") + 1));
            String q = query[i].substring(0, query[i].lastIndexOf(" "));
            String[] qur = q.split(" and ");


            for (int j = 0; j < qur.length; j++) {
                if (f) {
                    fullSearch(strList, qur[j]);
                    f = false;
                }
                else{
                    indexSearch(qur[j]);
                }

            }
            f = true;
            if (isFirst) {
                for (int z = 0; i < strList.size(); i++) {
                    searchList.add(Integer.valueOf(strList.get(z)[4]));
                    isFirst = false;
                }
            } else {
                for (int z = 0; z < sList.size(); z++) {
                    searchList.add(sList.get(z).score);
                }
            }

            anserList.add(binarySearch(score));
            searchList.clear();
        }


        int[] arr2 = anserList.stream()
                .mapToInt(i -> i)
                .toArray();

        System.out.println(anserList);
        return arr2;
    }

    public void indexSearch(String key) {
        List<Info> afterList = new ArrayList<>();
        for(int i = 0; i < sList.size(); i++) {
            if (sList.get(i).data.contains(key)) {
                afterList.add(sList.get(i));
            }
        }
        sList.clear();
        sList = afterList;
    }

    public void fullSearch(List<String[]> info, String key) {
        boolean isSearch = false;
        for (int i = 0; i < info.size(); i++) {
            for (int j = 0; j < info.get(i).length; j++) {
                if (isSearch)
                    break;
                if (info.get(i)[j].contains(key)) {
                    sList.add(new Info(info.get(i)));
                    isSearch = true;
                }
            }
        }
        isFirst = false;
    }

    public static int binarySearch(int score) {
        int start = 0;
        int end = searchList.size() - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (searchList.get(mid) < score)
                start = mid + 1;
            else
                end = mid - 1;
        }

        return searchList.size() - start;
    }




    public static void main(String[] args) {
        순위검색3 S = new 순위검색3();
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

    public class Info {
        public String data = "";
        public int score = 0;

        public Info(String[] info) {
//            score = Integer.parseInt(info.substring(info.lastIndexOf(" ") + 1));
//            data = info.substring(0, info.lastIndexOf(" "));
            for (int i = 0; i < info.length - 1; i++) {
                data += info[i];
            }
            score = Integer.parseInt(info[4]);
        }
    }
}
