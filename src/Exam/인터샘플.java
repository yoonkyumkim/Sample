package Exam;

public interface 인터샘플 {

    //인터페이스는 접근제어자를 안적으면 public으로 적용
    public void sample();
    private void sample2() {
        System.out.println("프라이빗");
    }

    default void sample3() {
        sample2();
        System.out.println("디폴트");
    }

}
