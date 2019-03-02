package com.codesmells;

class Game {
    private char lastPlayer = ' ';
    private Board board = new Board();

    void Play(char nextUp, int x, int y) throws Exception {
        isMovementValid(nextUp, x, y);

        lastPlayer = nextUp;
        board.addTileAt(nextUp, x, y);
    }

    char Winner() {
        if (board.winningCombinationInRow(0)) return board.playerAt(0, 0);

        if (board.winningCombinationInRow(1)) return board.playerAt(1, 0);

        if (board.winningCombinationInRow(2)) return board.playerAt(2, 0);

        return ' ';
    }

    private void isMovementValid(char nextUp, int x, int y) throws Exception {
        firstPlayerIsX(nextUp);

        cannotPlayTwiceInARow(nextUp);

        cannotPlayInPlayedPosition(x, y);
    }

    private void firstPlayerIsX(char nextUp) throws Exception {
        if (lastPlayer == ' ') {
            if (nextUp == 'O') {
                throw new Exception("Invalid first player");
            }
        }
    }

    private void cannotPlayTwiceInARow(char symbol) throws Exception {
        if (symbol == lastPlayer) {
            throw new Exception("Invalid next player");
        }
    }

    private void cannotPlayInPlayedPosition(int x, int y) throws Exception {
        if (board.playerAt(x, y) != ' ') {
            throw new Exception("Invalid position");
        }
    }

}

