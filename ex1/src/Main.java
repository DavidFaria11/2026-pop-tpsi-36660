public class Main {
    public static void main(String[] args) {
        Person p1 = new Person("Alice", 30);
        Person p2 = new Person("Carreira", 25);

        System.out.println(p1.name + " tem " + p1.age + " anos.");
        System.out.println(p2.name + " tem " + p2.age + " anos.");
    }
}