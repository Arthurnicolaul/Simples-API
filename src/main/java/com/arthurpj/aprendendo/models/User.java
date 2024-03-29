package com.arthurpj.aprendendo.models;


import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = User.TABLE_NAME)
public class User {

  public interface CreateUser{}
  public interface UpdateUser{}

  public static final String TABLE_NAME="username";


  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", unique = true)
  private long id;

  @Column(name = "usarname", length = 100, nullable = false, unique = true)
  @NotNull(groups = CreateUser.class)
  @NotEmpty(groups = CreateUser.class)
  @Size(min = 2, max = 100)
  private String username;

  @JsonProperty(access = Access.WRITE_ONLY)
  @Column(name = "password", length = 60, unique = false)
  @NotNull(groups = {CreateUser.class, UpdateUser.class})
  @NotEmpty(groups = {CreateUser.class, UpdateUser.class})
  @Size(groups = {CreateUser.class, UpdateUser.class},min = 6, max = 25)
  private String password;


  @OneToMany(mappedBy = "user")
  private List<tesk> tasks = new ArrayList<tesk>();


  public User() {
  }

  public User(long id, String username, String password) {
    this.id = id;
    this.username = username;
    this.password = password;
  }

  public long getId() {
    return this.id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getUsername() {
    return this.username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getPassword() {
    return this.password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public List<tesk> getTasks() {
    return this.tasks;
  }

  public void setTasks(List<tesk> tasks) {
    this.tasks = tasks;
  }


  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + (int) (id ^ (id >>> 32));
    result = prime * result + ((username == null) ? 0 : username.hashCode());
    result = prime * result + ((password == null) ? 0 : password.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    User other = (User) obj;
    if (id != other.id)
      return false;
    if (username == null) {
      if (other.username != null)
        return false;
    } else if (!username.equals(other.username))
      return false;
    if (password == null) {
      if (other.password != null)
        return false;
    } else if (!password.equals(other.password))
      return false;
    return true;
  }



}
