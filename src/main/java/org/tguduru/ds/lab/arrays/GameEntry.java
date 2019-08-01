package org.tguduru.ds.lab.arrays;

/**
 * Provides details about a person with name and his score in a game.
 *
 * @author Guduru, Thirupathi Reddy
 * @modified 5/30/16.
 */
public class GameEntry {
    private String name;
    private int score;

    public GameEntry(String name, int score) {
        this.name = name;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("GameEntry{");
        sb.append("name='").append(name).append('\'');
        sb.append(", score=").append(score);
        sb.append('}');
        return sb.toString();
    }
}
