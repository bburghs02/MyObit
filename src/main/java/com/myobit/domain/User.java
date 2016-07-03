package com.myobit.domain;

import org.hibernate.annotations.*;
import org.hibernate.annotations.CascadeType;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Phillip on 6/26/2016.
 */
@Entity
@Table(name = "Users")
public class User extends BaseEntity {

    private String username;
    private String password;
    private boolean enabled;
    private Person person;
    private List<Authority> authorities;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        this.password = passwordEncoder.encode(password);
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "person_id")
    @Cascade(CascadeType.ALL)
    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    @OneToMany(orphanRemoval = true, mappedBy = "user", fetch = FetchType.EAGER)
    @Cascade(CascadeType.ALL)
    public List<Authority> getAuthorities() {
        if (this.authorities == null) {
            this.authorities = new ArrayList<Authority>();
        }
        return authorities;
    }

    public void setAuthorities(List<Authority> authorities) {
        this.authorities = authorities;
    }

    public void addAuthority(Authority authority) {
        if (authorities == null) {
            authorities = new ArrayList<Authority>();
        }
        authorities.add(authority);
        authority.setUser(this);
        authority.setUsername(username);
    }

    public void removeAuthority(String authority){
        if (authorities != null) {
            for (int i = 0; i< authorities.size();i++) {
                if (authorities.get(i).getAuthority().equalsIgnoreCase(authority)) {
                    authorities.get(i).setUser(null);
                    authorities.remove(i);
                }
            }
        }
    }
}
