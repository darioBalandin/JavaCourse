package org.dario;

import java.util.ArrayList;
import java.util.List;

public class Monster implements ISaveable{

    private String name;
    private int hitPoints,strength;

    public Monster(String name, int hitPoints, int strength) {
        this.name = name;
        this.hitPoints = hitPoints;
        this.strength = strength;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHitPoints() {
        return hitPoints;
    }

    public void setHitPoints(int hitPoints) {
        this.hitPoints = hitPoints;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    @Override
    public List<String> write() {
        List<String> list= new ArrayList<>();
        var array= this.toString().substring(8,this.toString().length()-2).split(", ");

        for(var element:array){

            var temp=element.split("=")[1];
            list.add(temp);
        }

        return list;
    }

    @Override
    public void read(List<String> list) {

    }

    @Override
    public String toString() {
        return "Monster{" +
                "name='" + name + '\'' +
                ", hitPoints=" + hitPoints +
                ", strength=" + strength +
                '}';
    }
}
