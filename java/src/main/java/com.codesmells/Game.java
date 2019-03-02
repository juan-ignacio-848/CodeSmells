package com.codesmells;

import static com.codesmells.Player.*;

class Game {

    private Player lastPlayer = NONE;
    private Board board = new Board();

    void Play(char nextUp, int x, int y) throws Exception {
        isMovementValid(nextUp, x, y);

        lastPlayer = Player.from(nextUp);
        board.take(new Tile(x, y), nextUp);
    }

    char Winner() {
        if (board.winningCombinationInRow(0))
            return board.playerAt(new Tile(0, 0));

        if (board.winningCombinationInRow(1))
            return board.playerAt(new Tile(1, 0));

        if (board.winningCombinationInRow(2))
            return board.playerAt(new Tile(2, 0));

        return ' ';
    }

    private void isMovementValid(char nextUp, int x, int y) throws Exception {
        firstPlayerIsX(nextUp);

        cannotPlayTwiceInARow(from(nextUp));

        cannotPlayInPlayedPosition(x, y);
    }

    private void firstPlayerIsX(char nextUp) throws Exception {
        if (lastPlayer == NONE) {
            if (nextUp == 'O') {
                throw new Exception("Invalid first player");
            }
        }
    }

    private void cannotPlayTwiceInARow(Player symbol) throws Exception {
        if (symbol == lastPlayer) {
            throw new Exception("Invalid next player");
        }
    }

    private void cannotPlayInPlayedPosition(int x, int y) throws Exception {
        if (board.playerAt(new Tile(x, y)) != ' ') {
            throw new Exception("Invalid position");
        }
    }

}

