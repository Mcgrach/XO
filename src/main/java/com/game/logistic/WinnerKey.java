package com.game.logistic;

import java.util.ArrayList;

/**
 * Created by Paul Brown on 12.01.2017.
 */
public class WinnerKey {

    private static ArrayList<WinnerKey> key = new ArrayList<WinnerKey>();

    private String a;

    private String b;

    private String c;

    private WinnerKey(String a, String b, String c){
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public WinnerKey(){}

    private void addKey(){
        key.add(new WinnerKey("00","11","22"));
        key.add(new WinnerKey("02","11","20"));
        key.add(new WinnerKey("00","10","20"));
        key.add(new WinnerKey("01","11","21"));
        key.add(new WinnerKey("02","12","22"));
        key.add(new WinnerKey("10","11","12"));
        key.add(new WinnerKey("00","01","02"));
        key.add(new WinnerKey("20","21","22"));
    }

    public ArrayList<WinnerKey> getKeys(){
        addKey();
        return key;
    }

    public String getA() {
        return a;
    }

    public String getB() {
        return b;
    }

    public String getC() {
        return c;
    }
}
