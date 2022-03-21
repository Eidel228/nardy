package com.nardy.app.persistence.board;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.sql.Array;
import java.sql.SQLException;

@Data
public class Board {

    public Hole[] board;

    public Board(Hole[] holes) throws SQLException {
        this.board = holes;
        }


    @Data
    @AllArgsConstructor
    public static class Hole {
        private int pieceQuantity;
        private boolean white;
        public boolean isBlack(){
            return !white;
        }
    }
}
