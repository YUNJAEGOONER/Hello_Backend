public class Test_Condition_Loop {
    public static void main(String[] args) {
        condition();
        loop();
    }

    public static void condition(){
        int num = 15;
        if(num == 1){
            System.out.println("1 입니다.");
        }
        else if(num == 2){
            System.out.println("2 입니다.");
        }
        else{
            System.out.println("1, 2가 모두 아닙니다.");
        }
    }

    public static void loop(){
        int [] array = {1, 2, 3, 4, 5};

        System.out.println("for문을 테스트 합니다.");
        for(int i = 0 ; i  < array.length ; i ++){
            System.out.println("i = " + array[i]);
        }

        System.out.println("while문을 테스트 합니다.");
        int i = 0;
        while(i < array.length){
            System.out.println("index = " + i + ", " + array[i++]);
        }
    }

}


