package org.advyteam.entites;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class User {

  public String id;
  public String username;
  public String lastName;
  public String firstName;
  public String email;
  public Boolean enabled;
  public Attributes attributes;

  public static class  Attributes {
    public String [] imgUrl;
  }

}
