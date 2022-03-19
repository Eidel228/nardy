package com.nardy.app.persistence.session;

import com.nardy.app.persistence.AbstractEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class Piece {
    private boolean isBlack;
    public boolean isWhite(){
        return !isBlack;
    }
}
