package com.nardy.app.persistence;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.constraints.NotNull;
import java.sql.Date;

@Data
public class AbstractEntity {
    @NotNull
    private long id;
    @NotNull
    private Date createdAt;

}
