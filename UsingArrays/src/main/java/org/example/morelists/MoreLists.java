package org.example.morelists;

import java.util.List;

public class MoreLists {

    public static void main(String[] args) {
        String[] items = {"apple", "banana", "orange", "pear", "grape", "pineapple", "mango", "strawberry", "blueberry", "raspberry"};

        List<String> list = List.of(items);
        System.out.println(list);
    }
}
