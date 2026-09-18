public class Main {
    public static void main(String[] args) {
        Balance scale = new Balance();
        scale.addLeft(10);
        scale.addRight(5);
        scale.result();
    }
}
class Balance {
    int left = 0;
    int right = 0;

    void addLeft(int weight) {
        left = left + weight;
    }
    void addRight(int weight) {
        right = right + weight;
    }
    void result() {
        if (left == right) {
            System.out.println("=");
        } else if (left > right) {
            System.out.println("L");
        } else {
            System.out.println("R");
        }
    }
}
