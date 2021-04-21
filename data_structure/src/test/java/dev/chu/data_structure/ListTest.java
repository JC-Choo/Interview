package dev.chu.data_structure;

import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;

import dev.chu.data_structure.list.MyArrayList;
import dev.chu.data_structure.list.MyLinkedList;

public class ListTest {
    @Test
    public void testMyLinkedList() {
        MyLinkedList list = new MyLinkedList();
        for (int i=0; i<10; i++) {
            list.add(i);
        }
        list.add(3, 100);
        list.set(5, 10);
        System.out.println("indexOf = "+list.indexOf(5));
        for (int i=0; i<list.size(); i++) {
            System.out.println(list.get(i));
        }
    }

    @Test
    public void testMyArrayList() {
        MyArrayList<Integer> list = new MyArrayList<Integer>();
        for (int i=0; i<10; i++) {
            list.add(i);
        }
        list.add(3, 100);
        list.set(5, 10);
        System.out.println("indexOf = "+list.indexOf(5));
        for (int i=0; i<list.size(); i++) {
            System.out.println(list.get(i));
        }
    }
}
