package com.game.logistic;

import com.game.game.GameButtons;

import java.util.ArrayList;

/**
 * Created by Paul Brown on 12.01.2017.
 */
public class Logistic {


    GameButtons game = GameButtons.getInstance();
    private String winner = "";
    private ArrayList<WinnerKey> keys = new WinnerKey().getKeys();
    private WinnerKey nextStepKey = keys.get(0);
    private Integer n = 0;
    private Boolean twocicle = false;

    public boolean endGame(){
        winner = win();
        if (winner.equals("Winner Computer") || winner.equals("Winner Human")){
            return true;
        }
        return false;
    }

    private String win(){
        Boolean bool = winCycle(GameButtons.getButtons("X"));
        if (bool){
            return "Winner Computer";
        }
        else {
            bool = winCycle(GameButtons.getButtons("O"));
            if (bool){
                return "Winner Human";
            }
            else {
                return "No winner";
            }
        }
    }

    private Boolean winCycle(ArrayList<String> arr){
        Boolean a = false;
        Boolean b = false;
        Boolean c = false;
        for (WinnerKey key: keys) {
            for (String s : arr) {
                if (s.equals(key.getA())) {
                    a = true;
                }
                if (s.equals(key.getB())) {
                    b = true;
                }
                if (s.equals(key.getC())) {
                    c = true;
                }
                if (a && b && c) {
                    return true;
                }
            }
            a = false;
            b = false;
            c = false;
        }
        return false;
    }

    public String nextStep(){
        String s;
        while (true){
            s = suitStep(nextStepKey);
            if (s.equals("nextkey")) {
                n++;
                if (n < keys.size() ) {
                    nextStepKey = keys.get(n);
                } else {
                    if (twocicle){
                        s = "No step";
                        twocicle = false;
                        return s;
                    }
                    if (!twocicle){
                        n = 0;
                        twocicle = true;
                    }
                }
            }
            else {
                return s;
            }
        }

    }

    private String suitStep(WinnerKey nextKey){
        String s = nextKey.getA();
        if (stepBool(s)){
            System.out.println("Next step: " + s);
            return s;
        }
        s = nextKey.getB();
        if (stepBool(s)){
            System.out.println("Next step: " + s);
            return s;
        }
        s = nextKey.getC();
        if (stepBool(s)){
            System.out.println("Next step: " + s);
            return s;
        }
        s = "nextkey";
        return s;
    }

    private boolean stepBool(String s){
        Boolean bool = stepCycle(GameButtons.getButtons("X"), s);
        if (bool){
            bool = stepCycle(GameButtons.getButtons("O"), s);
            if (bool){
                return true;
            }
            else {
                return false;
            }
        }
        return false;

    }

    private Boolean stepCycle(ArrayList<String> arr, String s){
        for (String x: arr) {
            if (x.equals(s)) {
                return false;
            }
        }
        return true;
    }

    public String getWinner() {
        return winner;
    }

    public void reset(){
        twocicle = false;
        game.resetButtons();
    }
}
