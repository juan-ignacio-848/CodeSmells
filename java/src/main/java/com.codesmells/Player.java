package com.codesmells;

enum Player {
    X('X'), O('O'), NONE(' ');

    private char symbol;

    Player(char symbol) {
        this.symbol = symbol;
    }

    static Player from(char symbol) {
        switch (symbol) {
            case 'X':
                return X;
            case 'O':
                return O;
            default:
                return NONE;
        }
    }
}
