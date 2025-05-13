package com.example.demo.models;

import lombok.Data;

@Data    //alt + enter da moze da on importuje nesto
public class UserModel {
    private int id;
    private String firstName;
    private String lastName;

        // da ne bi pravili getere i setere koristimo u UserControlleru anotaciju @RequestBody koja instancira
        // ceo user model i prima podatke bez da se mi jebavamo rucno
}
