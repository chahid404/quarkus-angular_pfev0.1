package org.acme.requestBody;

import java.util.List;
import java.util.Map;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class User {

  private String id;
  private String username;
  private String lastName;
  private String firstName;
  private String email;
  private Boolean enabled;
  private Attributes attributes;

  public static class Attributes {
    public String birthday;
    public String nationality;
    public String gender;
    public String telephone;
    public String zip_code;
    public String imgUrl;

  }

  public User() {
  }

  public User(String id, String username, String lastName, String firstName, String email, Boolean enabled,
      Attributes attributes) {
    this.id = id;
    this.username = username;
    this.lastName = lastName;
    this.firstName = firstName;
    this.email = email;
    this.enabled = enabled;
    this.attributes = attributes;
  }

  public String getId() {
    return this.id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getUsername() {
    return this.username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getLastName() {
    return this.lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public String getFirstName() {
    return this.firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getEmail() {
    return this.email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public Boolean isEnabled() {
    return this.enabled;
  }

  public Boolean getEnabled() {
    return this.enabled;
  }

  public void setEnabled(Boolean enabled) {
    this.enabled = enabled;
  }

  public Attributes getAttributes() {
    return this.attributes;
  }

  public void setAttributes(Attributes attributes) {
    this.attributes = attributes;
  }

  public void setAttributes(Map<String, List<String>> atte) {
    Attributes Newattributes = new Attributes();

    atte.entrySet().forEach(key -> {
      if (!key.getValue().isEmpty() && key.getKey().matches("birthday")) {
        Newattributes.birthday = key.getValue().get(0);
      }
      if (!key.getValue().isEmpty() && key.getKey().matches("gender")) {
        Newattributes.gender = key.getValue().get(0);
      }
      if (!key.getValue().isEmpty() && key.getKey().matches("imgUrl")) {
        Newattributes.imgUrl = key.getValue().get(0);
      }
      if (!key.getValue().isEmpty() && key.getKey().matches("nationality")) {
        Newattributes.nationality = key.getValue().get(0);
      }
      if (!key.getValue().isEmpty() && key.getKey().matches("telephone")) {
        Newattributes.telephone = key.getValue().get(0);
      }
      if (!key.getValue().isEmpty() && key.getKey().matches("zip_code")) {
        Newattributes.zip_code = key.getValue().get(0);
      }
      if (!key.getValue().isEmpty() && key.getKey().matches("birthday")) {
        Newattributes.birthday = key.getValue().get(0);
      }
    });
    this.attributes = Newattributes;
  }

  public User id(String id) {
    setId(id);
    return this;
  }

  public User username(String username) {
    setUsername(username);
    return this;
  }

  public User lastName(String lastName) {
    setLastName(lastName);
    return this;
  }

  public User firstName(String firstName) {
    setFirstName(firstName);
    return this;
  }

  public User email(String email) {
    setEmail(email);
    return this;
  }

  public User enabled(Boolean enabled) {
    setEnabled(enabled);
    return this;
  }

  public User attributes(Attributes attributes) {
    setAttributes(attributes);
    return this;
  }

  @Override
  public boolean equals(Object o) {
    if (o == this)
      return true;
    if (!(o instanceof User)) {
      return false;
    }
    User user = (User) o;
    return Objects.equals(id, user.id) && Objects.equals(username, user.username)
        && Objects.equals(lastName, user.lastName) && Objects.equals(firstName, user.firstName)
        && Objects.equals(email, user.email) && Objects.equals(enabled, user.enabled)
        && Objects.equals(attributes, user.attributes);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, username, lastName, firstName, email, enabled, attributes);
  }

  @Override
  public String toString() {
    return "{" + " id='" + getId() + "'" + ", username='" + getUsername() + "'" + ", lastName='" + getLastName() + "'"
        + ", firstName='" + getFirstName() + "'" + ", email='" + getEmail() + "'" + ", enabled='" + isEnabled() + "'"
        + ", attributes='" + getAttributes() + "'" + "}";
  }

}