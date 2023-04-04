package com.rallo.pokemon;

enum Stats {
    HP(0),
    ATTACK(0),
    DEFENSE(0),
    SP_ATTACK(0),
    SP_DEFENSE(0),
    SPEED(0);
    private int value;

    Stats(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
