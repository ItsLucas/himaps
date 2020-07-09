package com.example.himaps;

import java.util.Random;

class MemberData {
    private String name;
    private String color;

    public MemberData(String name) {
        this.name = name;
        this.color = getRandomColor();
    }
    private String getRandomColor() {
        Random r = new Random();
        StringBuffer sb = new StringBuffer("#");
        while(sb.length() < 7){
            sb.append(Integer.toHexString(r.nextInt()));
        }
        return sb.toString().substring(0, 7);
    }
    // Add an empty constructor so we can later parse JSON into MemberData using Jackson
    public MemberData() {
    }

    public String getName() {
        return name;
    }

    public String getColor() {
        return color;
    }
}