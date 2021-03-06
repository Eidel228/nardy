package com.nardy.app.entity;

import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;

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

    public Board startingMatch(){
        return new Board();
    }

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
}
