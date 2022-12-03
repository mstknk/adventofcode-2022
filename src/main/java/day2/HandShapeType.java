package day2;

public enum HandShapeType {
    ROCK(1), PAPER(2), SCISSORS(3);
    private final int score;

    HandShapeType(int score) {
        this.score = score;
    }

    public int getScore() {
        return score;
    }

}
