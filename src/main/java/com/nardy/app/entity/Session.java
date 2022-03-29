package com.nardy.app.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@NoArgsConstructor(access = AccessLevel.PRIVATE,force = true)
public class Session implements Serializable {

    private static final long serialVersionUID = 1L;

    public Session(User playerOne, User playerTwo) {
        this.playerOne = playerOne;
        this.playerTwo = playerTwo;
        this.holes = "aaaaaaaaaaaaaaazzzzzzzzzzzzzzz";
    }

    @Id
    @GeneratedValue
    private long id;

    @OneToOne(targetEntity= User.class)
    private User playerOne;

    @OneToOne(targetEntity= User.class)
    private User playerTwo;

    @NonNull
    @Size
    private String holes;

    private Date createdAt;
    @PrePersist
    void createdAt(){
        this.createdAt = new Date();
    }

    @Getter
    @Setter
    @ToString
    @RequiredArgsConstructor
    @NoArgsConstructor(access = AccessLevel.PRIVATE,force = true)
    public class Board implements Serializable {

        private static final long serialVersionUID = 1L;

        private Board() {
            this.holes = "aaaaaaaaaaaaaaazzzzzzzzzzzzzzz";
        }

        public com.nardy.app.entity.Board startingMatch(){
            return new com.nardy.app.entity.Board();
        }


}
