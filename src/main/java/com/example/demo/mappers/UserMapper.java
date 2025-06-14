package com.example.demo.mappers;

import com.example.demo.entities.User;
import com.example.demo.entities.UserProducts;
import com.example.demo.models.RegisterUserModel;
import com.example.demo.models.UserModel;
import com.example.demo.models.UserPageModel;
import com.example.demo.models.UserProductsModel;
import org.springframework.data.domain.Page;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;
import java.util.List;

public class UserMapper {

    // za upis cistog usera (bez producta)
    public static User toEntity(UserModel model, PasswordEncoder passwordEncoder){
        User user = new User();
//        user.setId(model.getId());
        user.setFirstName(model.getFirstName());
        user.setLastName(model.getLastName());
        user.setEmail(model.getEmail());
        user.setContactNumber(model.getContactNumber());
        user.setPassword(passwordEncoder.encode(model.getPassword()));
        return user;
    }

    public static User toEntityForUpdate(UserModel model, PasswordEncoder passwordEncoder){
        User user = new User();
        user.setId(model.getId());
        user.setFirstName(model.getFirstName());
        user.setLastName(model.getLastName());
        user.setEmail(model.getEmail());
        user.setContactNumber(model.getContactNumber());
        user.setPassword(passwordEncoder.encode(model.getPassword()));
        return user;
    }

    // za upis registrovanog korisnika
    public static User toEntity(RegisterUserModel model, PasswordEncoder passwordEncoder){
        User user = new User();
        user.setEmail(model.getEmail());
        user.setPassword(passwordEncoder.encode(model.getPassword()));
        return user;
    }

    // za citanje cistog usera (bez producta)
    public static UserModel toModel(User entity){
       return UserModel.builder()
                .id(entity.getId())         // dto ne treba da ima ID ili phone number recimo, sta ce nam
                .email(entity.getEmail())
                .firstName(entity.getFirstName())
                .lastName(entity.getLastName())
                .contactNumber(entity.getContactNumber()).build();
    }

    // za citanje liste korisnika (bez producta)
    public static List<UserModel> toModelList(List<User> entities){
        var list = new ArrayList<UserModel>();
        for (var entity : entities) {
            list.add(toModel(entity));
        }
        return list;
    }

    // za front gde imamo prikaz na vise stranica
    public static UserPageModel toModelPagedList(Page<User> pageEntity){
        return UserPageModel.builder()
                .Users(toModelList(pageEntity.getContent()))
                .totalPages(pageEntity.getTotalPages())
                .totalElements(pageEntity.getTotalElements())
                .build();
    }






}
