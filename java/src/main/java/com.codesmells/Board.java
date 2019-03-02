package com.codesmells;

import java.util.HashMap;
import java.util.Map;

class Board {
    private Map<Tile, Player> playedTiles = new HashMap<>();

    void take(Tile tile, char symbol) {
        playedTiles.put(tile, playerBy(symbol));
    }

    char playerAt(int x, int y) {
        Player player = playedTiles.get(new Tile(x, y));
        return player == null ? ' ' : player == Player.X ? 'X' : 'O';
    }

    boolean winningCombinationInRow(int i) {
        if (playerAt(i, 0) != ' ' &&
                playerAt(i, 1) != ' ' &&
                playerAt(i, 2) != ' ') {
            if (playerAt(i, 0) ==
                    playerAt(i, 1) &&
                    playerAt(i, 2) == playerAt(i, 1)) {
                return true;
            }
        }
        return false;
    }

    private Player playerBy(char symbol) {
        switch (symbol) {
            case 'X':
                return Player.X;
            case 'O':
                return Player.O;
            default:
                return Player.NONE;
        }
    }

    private enum Player {
        X, O, NONE
    }
}