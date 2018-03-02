package Test;

import java.util.ArrayList;
import chessgame.Game;
import chessgame.Command;

public class Testing {
    public static ArrayList<String> checkTest(){
        ArrayList<String> moveSet = new ArrayList();
        moveSet.add("e2 e4");
        moveSet.add("d7 d5");
        moveSet.add("e1 e2");
        moveSet.add("d8 d6");
        moveSet.add("e2 e3");
        moveSet.add("d6 a3");

        return moveSet;
    }
}
