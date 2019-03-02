package com.codesmells;

enum Player {
    X, O, NONE;

    static Player playerBy(char symbol) {
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
