public class Main {
    public static void main(String[] args) {
        OddEvenSeparator separator = new OddEvenSeparator();

        separator.addNumber(1);
        separator.addNumber(4);
        separator.addNumber(7);
        separator.addNumber(8);
        separator.addNumber(2);

        separator.even();
        separator.odd();
    }
}

class OddEvenSeparator {
    String evenText = "";
    String oddText = "";
    void addNumber(int number) {
        if (number % 2 == 0) {
            evenText = evenText + number + " ";
        } else {
            oddText = oddText + number + " ";
        }
    }
    void even() {
        System.out.println("Четные");
        System.out.println(evenText);
    }
    void odd() {
        System.out.println("Нечетные");
        System.out.println(oddText);
    }
}
