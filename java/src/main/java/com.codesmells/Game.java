package com.codesmells;

public class Game {
    private char lastPlayer = ' ';
    private Board board = new Board();

    public void Play(char nextUp, int x, int y) throws Exception {
        isMovementValid(nextUp, x, y);

        lastPlayer = nextUp;
        board.AddTileAt(nextUp, x, y);
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
        if (playerAt(x, y) != ' ') {
            throw new Exception("Invalid position");
        }
    }

    private char playerAt(int x, int y) {
        return board.TileAt(x, y).Symbol;
    }

    public char Winner() {
        if (checkRow(0)) return playerAt(0, 0);

        if (checkRow(1)) return playerAt(1, 0);

        if (checkRow(2)) return playerAt(2, 0);

        return ' ';
    }

    private boolean checkRow(int i) {
        if (playerAt(i, 0) != ' ' &&
                playerAt(i, 1) != ' ' &&
                playerAt(i, 2) != ' ') {
            //if first row is full with same symbol
            if (playerAt(i, 0) ==
                    playerAt(i, 1) &&
                    playerAt(i, 2) == playerAt(i, 1)) {
                return true;
            }
        }
        return false;
    }

}

