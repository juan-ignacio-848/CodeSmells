package com.codesmells;

public class Game {
    private char _lastSymbol = ' ';
    private Board _board = new Board();

    public void Play(char symbol, int x, int y) throws Exception {
        isMovementValid(symbol, x, y);

        _lastSymbol = symbol;
        _board.AddTileAt(symbol, x, y);
    }

    private void isMovementValid(char symbol, int x, int y) throws Exception {
        if (_lastSymbol == ' ') {
            if (symbol == 'O') {
                throw new Exception("Invalid first player");
            }
        } else if (symbol == _lastSymbol) {
            throw new Exception("Invalid next player");
        } else if (_board.TileAt(x, y).Symbol != ' ') {
            throw new Exception("Invalid position");
        }
    }

    public char Winner() {
        if (checkRow(0)) return _board.TileAt(0, 0).Symbol;

        if (checkRow(1)) return _board.TileAt(1, 0).Symbol;

        if (checkRow(2)) return _board.TileAt(2, 0).Symbol;

        return ' ';
    }

    private boolean checkRow(int i) {
        if (_board.TileAt(i, 0).Symbol != ' ' &&
                _board.TileAt(i, 1).Symbol != ' ' &&
                _board.TileAt(i, 2).Symbol != ' ') {
            //if first row is full with same symbol
            if (_board.TileAt(i, 0).Symbol ==
                    _board.TileAt(i, 1).Symbol &&
                    _board.TileAt(i, 2).Symbol == _board.TileAt(i, 1).Symbol) {
                return true;
            }
        }
        return false;
    }

}

