package com.nardy.app.persistence;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NonNull;

import javax.validation.constraints.NotNull;
import java.util.ArrayDeque;

@EqualsAndHashCode(callSuper = true)
@Data
public class LongGameSession extends AbstractEntity {
    @NotNull
    private User playerOne;
    @NotNull
    private User playerTwo;
    @NotNull
    private ArrayDeque<Piece>[] board;
}
