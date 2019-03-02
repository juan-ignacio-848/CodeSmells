package com.codesmells;

import java.util.HashMap;
import java.util.Map;

import static com.codesmells.Player.*;

class Board {
    private Map<Tile, Player> playedTiles = new HashMap<>();

    void take(Tile tile, char symbol) {
        playedTiles.put(tile, playerBy(symbol));
    }

    char playerAt(Tile tile) {
        Player player = playedTiles.get(tile);
        return player == null ? ' ' : player == X ? 'X' : 'O';
    }

    boolean winningCombinationInRow(int i) {
        if (playerAt(new Tile(i, 0)) != ' ' &&
                playerAt(new Tile(i, 1)) != ' ' &&
                playerAt(new Tile(i, 2)) != ' ') {
            if (playerAt(new Tile(i, 0)) ==
                    playerAt(new Tile(i, 1)) &&
                    playerAt(new Tile(i, 2)) == playerAt(new Tile(i, 1))) {
                return true;
            }
        }
        return false;
    }

}