import package1.Car;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        Student rohan = new Student(10,"Rohan");
        Student mohan = rohan;
        mohan.name = "sohan";
        System.out.println(rohan.name);
        final Student rohan2;
        rohan2 = new Student(10,"r");
        rohan2.name  = "asdasd";
        Car lambo = new Car();

    }
}