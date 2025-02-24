package pcd.lab01.ex01;

import static pcd.lab01.ex01.AuxLib.*;
import static org.fusesource.jansi.Ansi.*;


public class Main {
    public static void main(String[] args) {

        var sentence = "This is a simple sentence with words ready to fall";

        var wordList = getWordsPos(sentence);

        for (var wp: wordList) {
            System.out.println("Word: " + wp.word() + " -- Pos: " + wp.pos());
        }

        Screen screen = Screen.getInstance();
        screen.clear();

        var x0 = 10;
        var y0 = 1;

        for (int i = 1; i < 80; i++) {
            for (var wp: wordList) {
                screen.writeStringAt(y0 + i, wp.pos(), Color.RED, wp.word());

            }
            try {
                Thread.sleep(100);
            } catch (Exception ex) {}
            screen.writeStringAt(y0, x0 + i, Color.WHITE, "Hello");
        }
    }
}
