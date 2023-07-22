package Homework4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    /*public static void main(String[] args) {
        RedBlackTree tree = new RedBlackTree();
        tree.add(5);
        tree.add(7);
        tree.add(10);
        tree.add(3);
        tree.add(8);

        System.out.println(tree.root);
    }*/



    public static void main(String[] args) {
        final Homework4.RedBlackTree tree = new Homework4.RedBlackTree();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            while (true) {
                try {
                    int value = Integer.parseInt(reader.readLine());
                    tree.add(value);
                    System.out.println("finish");
                } catch (Exception ignored) {

                }
            }
        } catch (IOException e) {
            throw new RuntimeException();
        }
    }
}
