package adventOfCode.day13Java;

public class Cart {
    public enum Turn {
        LEFT,
        STRAIGHT,
        RIGHT
    }

    public enum Direction {
        UP,
        DOWN,
        LEFT,
        RIGHT
    }

    private int x = -1;
    private int y = -1;
    private Turn nextTurn = Turn.LEFT;
    private Direction direction = Direction.UP;

    private Cart() {
        // do nothing
    }

    public Cart(int x, int y, Direction d) {
        this.x = x;
        this.y = y;
        this.direction = d;
    }

    public void move(RoadNetwork network) {
        
        switch (direction) {
            case RIGHT:
            case LEFT:
            case UP:
            case DOWN:
                break;
        }
    }

    private void adjustNextTurn() {
        switch (nextTurn) {
            case LEFT:
                nextTurn = Turn.STRAIGHT;
                break;
            case RIGHT:
                nextTurn = Turn.LEFT;
                break;
            case STRAIGHT:
                nextTurn = Turn.STRAIGHT;
        }
    }
}
