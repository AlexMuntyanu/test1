package com.springapp.notes.entities;

import javax.persistence.*;

@Entity
@Table(name="authorities")
public class Authority {

    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    @Column(name="id")
    private long id;
    private String authority;

    @ManyToOne()
    @JoinColumn(name = "username")
    private User user;

    public void setAuthority(String authority) {
        this.authority = authority;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getAuthority() {
        return authority;
    }

    public User getUser() {
        return user;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
