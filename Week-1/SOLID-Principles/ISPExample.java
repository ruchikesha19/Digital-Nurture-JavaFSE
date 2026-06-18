interface Workable {
    void work();
}

interface Eatable {
    void eat();
}

class Human implements Workable, Eatable {

    public void work() {
        System.out.println("Human is working");
    }

    public void eat() {
        System.out.println("Human is eating");
    }
}

public class ISPExample {

    public static void main(String[] args) {

        Human human = new Human();

        human.work();
        human.eat();
    }
}