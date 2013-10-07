package com.springapp.notes.entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;

import com.sun.istack.internal.NotNull;

@Entity
@Table(name = "users")
public class User {

  @Id
  @NotNull
  private String username;

  private String password;

  private Integer enabled;

  @OneToMany(mappedBy = "user", fetch = FetchType.EAGER,
      cascade = CascadeType.ALL, orphanRemoval = true)
  private final List<Authority> authorities = new LinkedList<Authority>();

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
    this.password = password;
  }

  public Integer getEnabled() {
    return enabled;
  }

  public void setEnabled(Integer enabled) {
    this.enabled = enabled;
  }

  public List<Authority> getAuthorities() {
    return authorities;
  }
}
