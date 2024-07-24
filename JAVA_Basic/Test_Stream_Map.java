import java.util.Arrays;
import java.util.List;

public class Test_Stream_Map {
    public static void main(String[] args){
        String[] lowercaseArray = new String[]{"passion fruit", "kiwi", "peach"};
        List<String> lowercaseList = Arrays.asList(lowercaseArray);
        
        //lowercaselist에 있는 모든 요소들을 대문자로 변경
        List<String> UPPERCASELIST = lowercaseList.stream()
                .map(element -> element.toUpperCase()).toList();

        //for_each를 이용한 list 출력
        UPPERCASELIST.stream().forEach(ELEMENT -> System.out.println(ELEMENT));
    }
}
