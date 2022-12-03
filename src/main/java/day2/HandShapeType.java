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

    public HandShapeType getWinHandShapeType() throws IllegalAccessException {
        switch (this) {
            case PAPER:
                return SCISSORS;
            case SCISSORS:
                return ROCK;
            case ROCK:
                return PAPER;
            default:
                throw new IllegalAccessException();
        }
    }

    public HandShapeType getLoseHandShapeType() throws IllegalAccessException {
        switch (this) {
            case SCISSORS:
                return PAPER;
            case ROCK:
                return SCISSORS;
            case PAPER:
                return ROCK;
            default:
                throw new IllegalAccessException();
        }
    }
}
