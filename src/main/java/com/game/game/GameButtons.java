package com.game.game;

import java.util.ArrayList;

/**
 * Created by Paul Brown on 12.01.2017.
 */
public class GameButtons {

    private static GameButtons instance;

    private static ArrayList<String> buttonsX = new ArrayList<String>();

    private static ArrayList<String> buttonsO = new ArrayList<String>();

    public static synchronized GameButtons getInstance(){
        if (instance == null){
            instance = new GameButtons();
        }
        return instance;
    }

    private GameButtons(){}

    public void addButton(String type,String step){
        if (type.equals("X")) {
            System.out.println("buttonX добавлена");
            buttonsX.add(step);
        }
        else {
            System.out.println("buttonO добавлена");
            buttonsO.add(step);
        }
    }

    public String getButton(Integer x, Integer y){
        Boolean bool = buttonCycle(x, y, "X");
        if (!bool){
            return "X";
        }
        else {
            bool = buttonCycle(x, y, "O");
            if (!bool){
                return "O";
            }
        }
        return "B";
    }

    private boolean buttonCycle(Integer x, Integer y, String type){
        Boolean bool = true;
        ArrayList<String> buttons;
        if (type.equals("X")){
            buttons = buttonsX;
        }
        else {
            buttons = buttonsO;
        }
        for (int i = 0; i < buttons.size(); i++){
            System.out.println(x.toString().charAt(0) + "" + y.toString().charAt(0));
            System.out.println(buttons.get(i).charAt(0) + "" + buttons.get(i).charAt(1));
            String num = x + "" + y;
            if (buttons.get(i).equals(num)){
                bool = false;
                System.out.println("Цикл на " + type + " завершился успешно");
                break;
            }
            System.out.println("Цикл на " + type + " идет...");
        }
        return bool;
    }

    public static ArrayList<String> getButtons(String type) {
        if (type.equals("X")){
            return buttonsX;
        }
        else {
            return buttonsO;
        }
    }

    public void resetButtons(){
        buttonsX = new ArrayList<String>();
        buttonsO = new ArrayList<String>();
    }
}
