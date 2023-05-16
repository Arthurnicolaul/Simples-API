package com.arthurpj.aprendendo.models;




import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = tesk.TABLE_NAME)
public class tesk {

  public static final String TABLE_NAME  = "task";

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", unique = true)
  private long Id;


  @ManyToOne
  @JoinColumn(name = "user_id", nullable = false, updatable = false)
  private User user;

  @Column(name = "description", length = 250, nullable = false)
  @NotNull
  @NotEmpty
  @Size(min = 1, max = 250)
  private String description;


  public tesk() {
  }

  public tesk(long Id, User user, String description) {
    this.Id = Id;
    this.user = user;
    this.description = description;
  }

  public long getId() {
    return this.Id;
  }

  public void setId(long Id) {
    this.Id = Id;
  }

  public User getUser() {
    return this.user;
  }

  public void setUser(User user) {
    this.user = user;
  }

  public String getDescription() {
    return this.description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public tesk Id(long Id) {
    setId(Id);
    return this;
  }

  public tesk user(User user) {
    setUser(user);
    return this;
  }

  public tesk description(String description) {
    setDescription(description);
    return this;
  }

  @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof tesk)) {
            return false;
        }
        tesk tesk = (tesk) o;
        return Id == tesk.Id && Objects.equals(user, tesk.user) && Objects.equals(description, tesk.description);
  }

  @Override
  public int hashCode() {
    return Objects.hash(Id, user, description);
  }

  
}
