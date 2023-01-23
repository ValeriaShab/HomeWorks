package com.shabatura.hw15.Task3;

import java.util.Comparator;

public class BoxComporator implements Comparator<Box> {
    public int compare(Box box1, Box box2){
            if (box2.getVolume() == 0 || box1.getVolume() == 0){
                return box1.getVolume() - box2.getVolume();
            }
            return box2.getVolume() - box1.getVolume();
        }
}
