package com.nardy.app.persistence.session;

import com.nardy.app.persistence.user.Users;
import lombok.Data;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayDeque;

@Data
public class Session {

    @NotNull
    @Size(min = 3,max = 32)
    private Users playerOne;

    @NotNull
    @Size(min = 3,max = 32)
    private Users playerTwo;

    @NotNull
    private ArrayDeque<Piece>[] board;

}
