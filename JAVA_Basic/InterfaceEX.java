//명품 JAVA Programming

interface PhoneInterface{
    void sendCall();
    void receiveCall();
    default void printLogo(){
        System.out.println("** Phone **");
    }
}

class SamsungPhone implements PhoneInterface{
    //phoneInterface의 모든 메소드 구현(SendCall, reveiveCall)
    @Override //오버라이딩 명시
    public void sendCall(){
        System.out.println("띠리리리링");
    }
    public void receiveCall(){
        System.out.println("전화가왔습니다.");
    }
    //메소드 추가 작성
    public void flash(){
        System.out.println("Samsung Phone Flash");
    }
}

class ApplePhone implements PhoneInterface{
    public void sendCall(){
        System.out.println("Designed by Apple in California");
    }
    public void receiveCall(){
        System.out.println("phone call");
    }
}

public class InterfaceEX {
    public static void main(String[] args) {
        SamsungPhone phone = new SamsungPhone();
        phone.printLogo();
        phone.sendCall();
        phone.receiveCall();
        phone.flash();

        PhoneInterface phone2 = new ApplePhone();
        phone2.printLogo();
        phone2.sendCall();
        phone2.receiveCall();
    }
}
