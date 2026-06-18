interface Keyboard {
    void type();
}

class WiredKeyboard implements Keyboard {

    public void type() {
        System.out.println("Typing using wired keyboard");
    }
}

class Computer {

    private Keyboard keyboard;

    public Computer(Keyboard keyboard) {
        this.keyboard = keyboard;
    }

    public void startTyping() {
        keyboard.type();
    }
}

public class DIPExample {

    public static void main(String[] args) {

        Keyboard keyboard = new WiredKeyboard();

        Computer computer = new Computer(keyboard);

        computer.startTyping();
    }
}