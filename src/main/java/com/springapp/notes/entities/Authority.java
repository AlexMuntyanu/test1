package com.springapp.notes.entities;

import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="authorities")
public class Authority {

    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "increment")
    @Column(name = "id")
    private long id;
    private String authority;

    @ManyToOne()
    @JoinColumn(name = "username")
    private User user;

    public Authority() {
        super();
    }

    public Authority(String role, User user) {
        this.authority = role;
        this.user = user;

    }

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

}
