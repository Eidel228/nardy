package com.nardy.app.entity;

import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Collection;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
public class User implements UserDetails {
    private static final long serialVersionUID = 1L;

    @Id
    @NonNull
    @Size(min = 3, max = 32, message="Name must be between 3 and 32 characters long")
    private String username;

    @NonNull
    @Size(min = 3, max = 32, message="Name must be between 3 and 32 characters long")
    private String password;

    @NonNull
    private int rating;

    private Date createdAt;
    @PrePersist
    void createdAt(){
        this.createdAt = new Date();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority("ROLE_USER"));
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

}
