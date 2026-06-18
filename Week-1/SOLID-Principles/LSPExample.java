class Bird {
    public void move() {
        System.out.println("Bird is moving");
    }
}

class FlyingBird extends Bird {
    public void fly() {
        System.out.println("Bird is flying");
    }
}

public class LSPExample {

    public static void main(String[] args) {

        Bird bird = new FlyingBird();

        bird.move();

        ((FlyingBird) bird).fly();
    }
}