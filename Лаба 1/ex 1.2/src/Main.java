/*Заведите переменную типа String со значением «make install». Выведите
ее на экран наоборот, то есть на экране должно вывестись «llatsni ekam».
Примечание: для разбора слова по буквам можно использовать функцию
charAt(). Например, str.charAt(i) вернет символ с позиции і в слове,
записанном в строковую переменную str. Команда str.length()
возвращает длину слова str.*/
public class Main {
    public static void main (String[] args){
        String str = "make install";
        String result = " ";
        int len = str.length();
        for (int i = len - 1; i>= 0; i--){
            result += str.charAt(i);
       }
        System.out.println(result);

    }
}