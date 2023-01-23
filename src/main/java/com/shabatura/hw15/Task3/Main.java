package com.shabatura.hw15.Task3;

import java.util.Comparator;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        Comparator<Box> comparator = new BoxComporator();
        TreeSet<Box> boxSet = new TreeSet<>(comparator);

        boxSet.add(new Box(2));
        boxSet.add(new Box(12));
        boxSet.add(new Box(22));
        boxSet.add(new Box(32));
        boxSet.add(new Box(0));
        boxSet.add(new Box(5));

        for (Box volume : boxSet) {
            System.out.println(volume.getVolume());
        }

    }
}
