public class Test_Identity_Equality {
    public static void main(String[] args) {
        String str1 = new String("is same?");
        String str2 = new String("is same?");
    
        //동일성을 비교 (두 개의 instance가 서로 같은지를 체크)
        //new로 생성한 str1, str2는 서로 다른 instance이다.
        System.out.println(str1 == str2);//false
        
        //동등성을 비교(문자열이 서로 같은지를 비교)
        System.out.println(str1.equals(str2));//true
    }
}
