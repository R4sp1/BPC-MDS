import cz.vutbr.bmds.cv01.MapClass;
import cz.vutbr.bmds.cv01.MyClass;

public class Main {
    public static void main(String[] args) {
        MyClass first = new MyClass();
        MyClass second = new MyClass();
        MyClass third = null;

        MapClass firstMap = new MapClass(1, "jedna");

        try {
            third = new MyClass(1, 2, 3, 4, 5, 6);

            first.addInteger(10);
            first.addInteger(20);
            first.addInteger(30);

            second.addInteger(50);
            second.addInteger(60);

            first.print();
            second.print();
        } catch (IllegalArgumentException e) {
            System.err.println("Error " + e.getMessage());
        }

        System.out.println("Num of created classes: " + MyClass.getCount());

        System.out.println("Does num 4 exist in third class? " + third.integerExists(4));

        System.out.println("Sum of nums in first list " + first.sum());

        MyClass united = MyClass.createUnited(first, second);
        united.print();

        System.out.println(united.toString());

        System.out.println(firstMap.toString());
    }
}