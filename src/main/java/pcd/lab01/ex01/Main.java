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
        int i = 1;
        for (var wp: wordList) {
            Thread t = new WordThread(screen, wp.pos(), wp.word(), i * 50);
            i = i + 1;
            t.start();
        }
    }
}
