package Exam;

public class 추상메인 extends 추상샘플{
    @Override
    public void test2() {
        test("오버라이딩 호출");
    }

    public static void main(String[] args) {
        추상메인 c = new 추상메인();
        c.test2();
        c.test("그냥호출");
    }
}
