package domain;

import java.util.Objects;

public class Position {
    private final int value;

    public Position(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public Position move() {
        return new Position(this.value + 1);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass())
            return false;
        Position position = (Position)o;
        return value == position.value;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(value);
    }
}
