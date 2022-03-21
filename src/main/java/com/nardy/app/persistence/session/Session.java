package com.nardy.app.persistence.session;

import com.nardy.app.persistence.board.Board;
import com.nardy.app.persistence.user.Users;
import lombok.AllArgsConstructor;
import lombok.Data;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.sql.Date;

@Data
@AllArgsConstructor
public class Session {

    @NotNull
    @Size(min = 3,max = 32)
    private Users playerOne;

    @NotNull
    @Size(min = 3,max = 32)
    private Users playerTwo;

    @NotNull
    private Date createdAt;

    @NotNull
    private Board board;

}
