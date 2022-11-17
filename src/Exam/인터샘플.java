package Exam;

public interface 인터샘플 {

    public void sample();

    private void sample2() {
        System.out.println("프라이빗");
    }

    default void sample3() {
        sample2();
        System.out.println("디폴트");
    }

}
