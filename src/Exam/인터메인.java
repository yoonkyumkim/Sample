package Exam;

public class 인터메인 implements 인터샘플{

    @Override
    public void sample() {
        System.out.println("퍼블릭");
    }

    public static void main(String[] args) {
        인터메인 I = new 인터메인();
        I.sample();
        I.sample3();
    }
}
