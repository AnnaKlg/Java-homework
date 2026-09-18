public class Main {
    public static void main(String[] args) {
        Bell bell = new Bell();
        bell.sound();
        bell.sound();
        bell.sound();
        bell.sound();
    }
}
class Bell {
    private int count = 0;
    public void sound() {
        if (count % 2 == 0) {
            System.out.println("ding");
        } else {
            System.out.println("dong");
        }
        count++;
    }
}



