package com.example.springmock.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class User {

     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
      private Integer UserId;
      private String username;
      private String email;
      private String password;
}
