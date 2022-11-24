package Exam;

/*클래스는 Singleton 클래스가 Load 될 때에도 Load 되지 않다가 getInstance()가 호출됐을 때 비로소 JVM 메모리에 로드되고, 인스턴스를 생성하게 됩니다. 아울러 synchronized를 사용하지 않기 때문에 위에서 문제가 되었던 성능 저하 또한 해결됩니다
static이기 떄문에 초기화가 이루어집니다. LazyHolder 클래스가 초기화 되면서 instance 객체의 생성도 이루어지며, 이 과정에서 static이기 때문에 하나의 인스턴스만 생성되는 것을 보장해줍니다. 그리고 final로 선언했기 때문에 다시instance 가 할당되는 것 또한 막을 수 있습니다.
Synchronzied 를 사용하지 않아도 JVM 자체가 보장하는 원자성을 사용하여 Thread-Safe 하게 싱글톤 패턴을 구현할 수 있습니다.*/
public class Singleton {
    private Singleton() {}

    private static class LazyHolder {
        private static final Singleton instance = new Singleton();
    }

    public static Singleton getInstance() {
        return LazyHolder.instance;
    }
}
