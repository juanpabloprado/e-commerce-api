package com.juanpabloprado.ecommerceapi.user;

import com.juanpabloprado.ecommerceapi.core.BaseEntity;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;

@Entity
public class Role extends BaseEntity implements Serializable {
  private String name;

  @ManyToMany(mappedBy = "roles")
  private List<User> users;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public List<User> getUsers() {
    return users;
  }

  public void setUsers(List<User> users) {
    this.users = users;
  }
}
