package adventOfCode.day13Java;

import java.util.LinkedList;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class RoadNetwork {
    private char[][] network;
    private List<Cart> carts = new LinkedList<>();

    public enum Road {
        VERTICLE('|'),
        HORIZONTAL('-'),
        RIGHT('/'),
        LEFT('\\'),
        INTERSECTION('+'),
        NONE(' ');

        private final char val;
        Road(char v) {
            val = v;
        }

        public char getVal() {
            return val;
        }

        @Override
        public String toString() {
            return String.valueOf(val);
        }

        public char valueOf() {
            return val;
        }

        public Road valueFrom(String v) {
            switch (v) {
                case "|" :
                    return VERTICLE;
                case "-" :
                    return HORIZONTAL;
                case "/" :
                    return RIGHT;
                case "\\" :
                    return LEFT;
                case "+" :
                    return INTERSECTION;
                default:
                    return NONE;
            }
        }
    }

    public RoadNetwork () {
        // nothing
        network = new char[0][0];
    }

    public RoadNetwork(List<String> input) {
        int y = input.size();

        network = new char[y][];
        final int i = 0;
        for (char [] a : input.stream().map(String::toCharArray).collect(toList())) {
            network[i] = a;
        }

    }
}