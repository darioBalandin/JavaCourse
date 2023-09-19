package org.dario;

import java.util.ArrayList;
import java.util.List;

public class Player implements ISaveable{

    private  String weapon;
    private String name;
    private int hitPoints,strength;

    public Player(String name, int hitPoints, int strength) {
        this.name = name;
        this.hitPoints = hitPoints;
        this.strength = strength;
        weapon = "Sword";
    }

    public String getWeapon() {
        return weapon;
    }

    public void setWeapon(String weapon) {
        this.weapon = weapon;
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
        var array= this.toString().substring(7,this.toString().length()-2).split(", ");

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
        return "Player{" +
                "name='" + name + '\'' +
                ", hitPoints=" + hitPoints +
                ", strength=" + strength +
                ", weapon='" + weapon + '\'' +
                '}';
    }
}
