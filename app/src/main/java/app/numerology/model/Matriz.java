package app.numerology.model;

import java.util.HashMap;

public class Matriz {

    HashMap<String,Integer> map = new HashMap<>();

    public Matriz(){
        this.map.put("A",1);
        this.map.put("B",2);
        this.map.put("C",3);
        this.map.put("D",4);
        this.map.put("E",5);
        this.map.put("F",6);
        this.map.put("G",7);
        this.map.put("H",8);
        this.map.put("I",9);
        this.map.put("J",1);
        this.map.put("K",2);
        this.map.put("L",3);
        this.map.put("M",4);
        this.map.put("N",5);
        this.map.put("O",6);
        this.map.put("P",7);
        this.map.put("Q",8);
        this.map.put("R",9);
        this.map.put("S",1);
        this.map.put("T",2);
        this.map.put("U",3);
        this.map.put("V",4);
        this.map.put("W",5);
        this.map.put("X",6);
        this.map.put("Y",7);
        this.map.put("Z",8);
    }

    public int getLetterValue(char c){
        return this.map.get(String.valueOf(c));
    }

    public HashMap<String, Integer> getMap() {
        return map;
    }
}