/* Если квадратное уравнение имеет вещественные корни,
 то вывести на экран. Иначе вывести на экран «нет вещественных корней».
 */
public class Main {
    public static void main(String[] args){
        int a = 1;
        int b = -5;
        int c = 6;
        double D = b * b - 4 * a * c;
        if(D >0){
            double x1 = (-b + Math.sqrt(D)) / (2 * a);
            double x2 = (-b - Math.sqrt(D)) / (2 * a);
            System.out.println("x1 = " + x1);
            System.out.println("x2 = " + x2);
        }
        else if (D == 0 ){
            double x = -b / (2 * a);
            System.out.println(x);
        }
        else if (D<0){
            System.out.println("нет вещественных корней");
        }
        else{
            System.out.println("ошибка");
        }
    }

}