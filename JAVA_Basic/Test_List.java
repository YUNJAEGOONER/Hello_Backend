import java.util.ArrayList;
import java.util.List;

public class Test_List {
    public static void main(String[] args) {
        System.out.println("List를 테스트 합니다.");
        integer_list();
        string_list();
    }

    public static void integer_list(){
        List list = new ArrayList<Integer>();

        list.add(1);
        list.add(2);
        list.add(3);

        System.out.println("list의 0번째 요소 : " +  list.get(0));
        System.out.println("list의 1번째 요소 : " +  list.get(1));
    }

    public static void string_list(){
        List list = new ArrayList<String>();

        list.add("hello");
        list.add("java");
        list.add("backend"); //{"hello", "java", "backend"}

        for(int i = 0 ; i < list.size() ; i ++ ){
            System.out.println(list.get(i));
        }

        list.remove(1); //{"hello", "backend"}
        int get_index = list.indexOf("backend");
        System.out.println("backend의 index : " + get_index);

    }
}
