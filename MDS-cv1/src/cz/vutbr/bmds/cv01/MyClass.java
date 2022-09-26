package cz.vutbr.bmds.cv01;

import java.util.ArrayList;

public class MyClass implements ISum {
    private static int count = 0;

    private ArrayList<Integer> list = new ArrayList<Integer>();

    // CONSTRUCTORS

    public MyClass() {
        count++;
    }

    public MyClass(int...numbers) throws IllegalArgumentException {
        this();

        for (int i: numbers) {
            addInteger(i);
        }
    }


    // STATIC METHODS

    public static int getCount() {
        return count;
    }

    public static MyClass createUnited(MyClass first, MyClass second) {
        MyClass newClass = new MyClass();

        newClass.list.addAll(first.list);
        newClass.list.addAll(second.list);

        return newClass;
    }


    // CLASS METHODS

    public void addInteger(int i) throws IllegalArgumentException {
        if (i > 0)
            list.add(i);
        else
            throw new IllegalArgumentException("Cant include negative nums");
    }

    public boolean integerExists(int i) {
        return list.contains(i);
    }

    @Override
    public String toString() {
        return "List size: " + list.size() + ", with sum of nums: " + sum();
    }

    @Override
    public int sum() {
        int sum = 0;

        for (int i: list) {
            sum += i;
        }

        return sum;
    }

    public void print() {
        System.out.print("List(" + list.size() + "); ");
        for (int i: list) {
            System.out.print(i+ " ");
        }
        System.out.println();
    }
}