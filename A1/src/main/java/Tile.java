import java.util.Comparator;

public class Tile implements Comparable<Tile> {
    private int rank;
    private char color;
    private boolean justPlayed, justMoved;

    public Tile(char color, int rank){
        this.color = color;
        this.rank = rank;
        this.justMoved = false;
        this.justPlayed = false;
    }

    public char getColor() {
        return color;
    }

    public int getRank() { return rank; }

    public boolean moved() { return justMoved; }

    public void setJustMoved(boolean justMoved) {
        this.justMoved = justMoved;
    }

    public boolean played() { return justPlayed; }

    public void setJustPlayed(boolean justPlayed) {
        this.justPlayed = justPlayed;
    }

    @Override
    public int compareTo(Tile o) {
        return this.getRank() - o.getRank();
    }
}
