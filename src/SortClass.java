import java.util.*;
import java.util.concurrent.ConcurrentSkipListSet;

public class SortClass {

    public static ConcurrentSkipListSet<Person> set = new ConcurrentSkipListSet<>();
    //public static SortedSet<Person> set = new TreeSet<>();

    //public static HashSet<Person> set = new HashSet<>();
    public static List<Person> list = new ArrayList<>();

    public static void main(String[] args) {
        SortClass sortClass = new SortClass();
        sortClass.solve();
    }

    public void solve() {
        set.add(new Person(1, 1));
        set.add(new Person(3, 3));
        set.add(new Person(4, 4));
        set.add(new Person(2, 2));
        set.remove(new Person(1, 1));
        set.add(new Person(1, 3));
//        list.add(new Person(1, 1));
//        list.add(new Person(3, 3));
//        list.add(new Person(4, 4));
//        list.add(new Person(2, 2));


        for(Person p : set) {
            System.out.println("uidx : " + p.uidx);
            System.out.println("score : " + p.score);
        }
    }


    public class Person implements Comparable<Person>{
        int uidx;
        int score;

        public Person(int uidx, int score) {
            this.uidx = uidx;
            this.score = score;
        }

        @Override
        public int compareTo(Person o) {
            if (score == o.score)
                return uidx - o.uidx;

            return score - o.score;
        }
    }
}



