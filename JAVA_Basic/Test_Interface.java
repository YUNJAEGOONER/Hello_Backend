interface CarInterface{}

class Sonata implements CarInterface{}

class K5 implements CarInterface{}

public class Test_Interface {
    //인터페이스
    // 다른 클래스를 작성할 때 기본이 되는 틀을 제공
    // 다른 클래스 사이의 중간 매개 역할까지 담당하는 추상 클래스
    public static void main(String[] args) {
        CarInterface car1 = new Sonata();
        CarInterface car2 = new K5();
    }
}
