import java.util.ArrayList;
import java.util.List;

public class Test_Stream_API {
    public static void main(String[] args) {
        List list = new ArrayList<String>();

        list.add("apple");
        list.add("orange");
        list.add("peach");
        
        System.out.println("for문을 이용한 list 출력");
        for(int i = 0 ; i < list.size(); i ++ ){
            System.out.println(list.get(i));
        }

        System.out.println("stream을 이용한 list 출력");
        list.stream().forEach(fruit -> System.out.println(fruit));

    }
}
