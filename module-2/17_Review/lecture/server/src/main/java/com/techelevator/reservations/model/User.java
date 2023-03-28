package com.techelevator.reservations.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class User {

   @JsonIgnore  // Tells server ignore the attribute in teh JASON when converting to object
   private Long id;
   private String username;
   @JsonIgnore
   private String password;
   private String firstname;
   private String lastname;
   private String email;
   @JsonIgnore
   private boolean activated;
   // Since a user may perform in multiple roles
   // We store the roles in a Set object
   // Authority is the Spring Security class to hold roles for a user
   private Set<Authority> authorities = new HashSet<>();

   public User(Long id, String username, String password, String role, boolean activated) {
      this.id = id;
      this.username = username;
      this.password = password;
      // Add the role for the user as an Authority object
      this.authorities.add(new Authority(role));  // Add the role for the user as an Authority object
      this.activated = activated;
   }

   public Long getId() {
      return id;
   }

   public void setId(Long id) {
      this.id = id;
   }

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

   public String getFirstname() {
      return firstname;
   }

   public void setFirstname(String firstname) {
      this.firstname = firstname;
   }

   public String getLastname() {
      return lastname;
   }

   public void setLastname(String lastname) {
      this.lastname = lastname;
   }

   public String getEmail() {
      return email;
   }

   public void setEmail(String email) {
      this.email = email;
   }

   public boolean isActivated() {
      return activated;
   }

   public void setActivated(boolean activated) {
      this.activated = activated;
   }

   public Set<Authority> getAuthorities() {
      return authorities;
   }

   public void setAuthorities(Set<Authority> authorities) {
      this.authorities = authorities;
   }

   @Override
   public boolean equals(Object o) {
      if (this == o) return true;
      if (o == null || getClass() != o.getClass()) return false;
      User user = (User) o;
      return id.equals(user.id);
   }

   @Override
   public int hashCode() {
      return Objects.hash(id);
   }

   @Override
   public String toString() {
      return "User{" +
         "username='" + username + '\'' +
         ", password='" + password + '\'' +
         ", firstname='" + firstname + '\'' +
         ", lastname='" + lastname + '\'' +
         ", email='" + email + '\'' +
         ", activated=" + activated +
         '}';
   }
}
