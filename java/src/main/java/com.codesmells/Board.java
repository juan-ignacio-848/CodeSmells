package com.codesmells;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static com.codesmells.Player.*;

class Board {
    private Map<Tile, Player> playedTiles = new HashMap<>();

    void take(Tile tile, Player player) {
        playedTiles.put(tile, player);
    }

    char playerAt(Tile tile) {
        Player player = playedTiles.get(tile);
        return player == null ? NONE.toSymbol() : player.toSymbol();
    }

    boolean winningCombinationInRow(int row) {
        return horizontalWinBy(X, row) || horizontalWinBy(O, row);
    }

    private boolean horizontalWinBy(Player player, int row) {
        Stream<Tile> winningCombination = Stream.of(
                new Tile(row, 0),
                new Tile(row, 1),
                new Tile(row, 2)
        );

        return winningCombination.allMatch(tilesBy(player)::contains);
    }

    private Set<Tile> tilesBy(Player player) {
        return playedTiles
                .entrySet()
                .stream()
                .filter(e -> e.getValue() == player)
                .map(Map.Entry::getKey)
                .collect(Collectors.toSet());
    }

}

