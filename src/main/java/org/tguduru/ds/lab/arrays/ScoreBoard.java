package org.tguduru.ds.lab.arrays;

import java.util.Arrays;

/**
 * Holds the score of each player for a game
 *
 * @author Guduru, Thirupathi Reddy
 * @modified 5/30/16.
 */
public class ScoreBoard {
    private GameEntry[] scores;
    private int elements;

    public ScoreBoard(int numberOfPlayers) {
        scores = new GameEntry[numberOfPlayers];
    }

    public void addEntry(GameEntry entry) {
        if (elements < scores.length) {
            scores[elements == 0 ? 0 : elements] = entry;
            elements++;
        } else
            System.out.println("Score Board is full");
    }

    public GameEntry[] getScores() {
        return scores;
    }

    public static void main(String[] args) {
        ScoreBoard scoreBoard = new ScoreBoard(4);
        GameEntry entry1 = new GameEntry("Tom", 200);
        GameEntry entry2 = new GameEntry("Peter", 300);
        GameEntry entry3 = new GameEntry("John", 100);
        GameEntry entry4 = new GameEntry("Tammy", 100);
        scoreBoard.addEntry(entry1);
        scoreBoard.addEntry(entry2);
        scoreBoard.addEntry(entry3);
        scoreBoard.addEntry(entry4);
        Arrays.sort(scoreBoard.getScores(), (o1, o2) -> o1.getScore() > o2.getScore() ? 1 : -1);
        Arrays.stream(scoreBoard.getScores()).forEach(System.out::println);
    }
}
