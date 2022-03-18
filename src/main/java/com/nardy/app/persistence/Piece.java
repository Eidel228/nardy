package com.nardy.app.persistence;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@EqualsAndHashCode(callSuper = true)
@Data
public class Piece extends AbstractEntity {
    @NotNull
    private boolean isBlack;
    public boolean isWhite(){
        return !isBlack;
    }
}
