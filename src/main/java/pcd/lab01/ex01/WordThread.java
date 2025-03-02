package pcd.lab01.ex01;

import org.fusesource.jansi.Ansi;

public class WordThread extends Thread{
    Screen screen;
    int pos;
    String word;
    int sleepTime;
    public WordThread(Screen screen, int pos, String word, int sleepTime) {
        this.screen = screen;
        this.pos = pos;
        this.word = word;
        this.sleepTime = sleepTime;

    }

    public void run() {
        int i;
        for (i = 1; i < 10; i++) {
            screen.writeStringAt(i, this.pos, Ansi.Color.RED, this.word);
            try {
                Thread.sleep(this.sleepTime);
            } catch (Exception ex) {
                System.out.println("Error");
            }
            screen.writeStringAt(i, this.pos, Ansi.Color.BLACK, this.word);
        }
        i += 1;
        screen.writeStringAt(i, this.pos, Ansi.Color.RED, this.word);
    }
}
