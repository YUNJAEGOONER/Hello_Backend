import java.util.Optional;

public class Test_Optional {

    private static Optional<String> getString(){
        return Optional.empty();
        //return Optional.ofNullable("not null");
    }

    public static void main(String[] args){
        Optional<String> isThisNull = getString();
        isThisNull.ifPresent(str -> System.out.println(str.toUpperCase()));

        //null이라면 false를, 문자열이 존재하는 경우에는 true를 return
        System.out.println(isThisNull.isPresent());

    }
}
