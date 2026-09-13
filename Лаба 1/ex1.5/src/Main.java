public class Main {
    public static void main(String[] args) {
        String str = "роза мимоза";
        int len = str.length();
        String result = "";
        for (int i = len - 1; i >= 0; i-- ){
            result += str.charAt(i);
        }
        if (str.equals(result)){
            System.out.println("Палиндром");
        }
        else{
            System.out.println("Не палиндром");
        }

    }
}
