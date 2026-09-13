public class Main {
    public static void main(String[] args){
                double sum = 0.0;
                int n = 2;
                double term = 1.0;
                while (term >= 1e-6) {
                    term = 1.0 / (n * n + n - 2);
                    sum += term;
                    n++;
                }
                System.out.println("Сумма ряда = " + sum);
            }
        }

