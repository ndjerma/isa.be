package com.example.demo.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "users")      // za tabelu
@Data                       // za getere i setere
public class User {
    @Id
    private int id;
}
