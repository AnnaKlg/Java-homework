
public class Main {
    public static void main(String[] args) {
        Button myButton = new Button();
        myButton.click();
        myButton.click();
        myButton.click();
    }
}
class Button {
    private int clicks;

    public void click() {
        this.clicks++;
        System.out.println(this.clicks);
    }
}
