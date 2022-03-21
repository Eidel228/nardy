package com.nardy.app.entity;

import com.nardy.app.entity.Board;
import com.nardy.app.entity.Users;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
public class GameSession implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    private long id;

    @OneToOne(targetEntity= Users.class)
    private Users playerOne;
    public void addPlayerOne(Users playerOne) {
        this.playerOne = playerOne;
    }

    @OneToOne(targetEntity=Users.class)
    private Users playerTwo;
    public void addPlayerTwo(Users playerTwo) {
        this.playerTwo = playerTwo;
    }

    @OneToOne(targetEntity= Board.class)
    private Board board;

    public void addBoard(Board board) {
        this.board = board;
    }

    private Date createdAt;
    @PrePersist
    void createdAt(){
        this.createdAt = new Date();
    }
}
