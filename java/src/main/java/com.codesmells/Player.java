package com.codesmells;

public enum Player {
    X, O, NONE;

    static Player getPlayer(char symbol) {
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
