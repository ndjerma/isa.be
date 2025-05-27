package com.example.demo.mappers;

import com.example.demo.entities.User;
import com.example.demo.models.UserModel;
import com.example.demo.models.UserPageModel;
import org.springframework.data.domain.Page;

import java.util.ArrayList;
import java.util.List;

public class UserMapper {

    // za upis
    public static User toEntity(UserModel model){
        User user = new User();
        //user.setId(model.getId());            tokom upisa ne smem da imam id, jer baza generise automatski ID
        user.setFirstName(model.getFirstName());
        user.setLastName(model.getLastName());
        user.setEmail(model.getEmail());
        user.setContactNumber(model.getContactNumber());
        return user;
    }


    // za citanje
    public static UserModel toModel(User entity){
       return UserModel.builder()
                .id(entity.getId())         // dto ne treba da ima ID ili phone number recimo, sta ce nam
                .email(entity.getEmail())
                .firstName(entity.getFirstName())
                .lastName(entity.getLastName())
                .contactNumber(entity.getContactNumber()).build();
    }

    public static List<UserModel> toModelList(List<User> entities){
        var list = new ArrayList<UserModel>();
        for (var entity : entities) {
            list.add(toModel(entity));
        }
        return list;
    }

    public static UserPageModel toModelPagedList(Page<User> pageEntity){
        return UserPageModel.builder()
                .Users(toModelList(pageEntity.getContent()))
                .totalPages(pageEntity.getTotalPages())
                .totalElements(pageEntity.getNumberOfElements())
                .build();
    }



}
