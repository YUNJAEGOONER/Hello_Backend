import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Test_Stream2 {
    public static void main(String[] args) {
        Integer [] integerArray = new Integer[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        List<Integer> list = Arrays.asList(integerArray); //Array(배열)을 List(리스트)로 변환

        //ArrayList
        //데이터 추가-삭제시 내부에서 동적으로 배열의 길이를 조절
        List evenList = new ArrayList<Integer>();

        System.out.println("For문을 이용한 짝수 list 만들기");
        for(int i = 0 ; i < list.size() ; i ++ ){
            Integer temp = list.get(i);
            if(temp % 2 == 0){
                evenList.add(temp);
            }
        }
        evenList.stream().forEach(even_num -> System.out.println(even_num));

        System.out.println("Stream을 이용한 짝수 list 만들기");
        List stream_even = list.stream()
                .filter(element -> element % 2 == 0).collect(Collectors.toList());
        stream_even.stream().forEach(element -> System.out.println(element));

    }
}
