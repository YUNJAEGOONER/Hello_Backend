import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Test_Lambda_Sort {
    public static void main(String[] args) {
        List list = new ArrayList<String>();

        list.add("coconut");
        list.add("orange");
        list.add("banana");
        list.add("apple");

        System.out.println("list = " + list); //[coconut, orange, banana, apple]

        //[apple, banana, coconut, orange]
        list.sort(new Comparator<String>() {
            public int compare(String str1, String str2){
                return str1.compareTo(str2);
            }
        });
        System.out.println("sorted_list(오름차순) = " + list);


        //[apple, banana, coconut, orange]
        list.sort((Comparator<String>)(str1, str2)->str1.compareTo(str2));
        System.out.println("sorted_list(오름차순) = " + list);

        //[orange, coconut, banana, apple]
        list.sort((Comparator<String>)(str1, str2)->str2.compareTo(str1));
        System.out.println("sorted_list(내림차순) = " + list);

    }
}
