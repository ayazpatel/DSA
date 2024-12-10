package com.ayafitech.exam.linear;

import java.util.LinkedList;

public class linked_list__cf {
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<Integer>();
        
        list.add(4);
        list.addFirst(5);
        list.addLast(3);
        list.add(4);
        System.out.println(list);
        if (list.contains(5)) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }
        System.out.println(list.size());
        
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }
}
