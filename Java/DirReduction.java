/*
 * link: https://www.codewars.com/kata/550f22f4d758534c1100025a/train/java
 */

import java.util.*;

public class DirReduction {
    static Map<String, String> opposites = new HashMap<>();
    static{
        opposites.put("NORTH", "SOUTH");
        opposites.put("SOUTH", "NORTH");
        opposites.put("WEST", "EAST");
        opposites.put("EAST", "WEST");
    }

    public static String[] dirReduc(String[] arr) {
        LinkedList<String> list = new LinkedList<>();
        for (String d : arr) {
            if (!list.isEmpty() && opposites.get(d).equals(list.getLast())) {
                list.removeLast();
            } else {
                list.addLast(d);
            }
        }
        return list.toArray(new String[0]);
    }

    public static void main(String[] args) {
        System.out.println(String.join(", ", dirReduc(new String[]{"EAST", "EAST", "WEST", "NORTH", "WEST", "EAST", "EAST", "SOUTH", "NORTH", "WEST"})));
    }
}