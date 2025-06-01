package com.example.demo.mappers;

import com.example.demo.entities.UserProducts;
import com.example.demo.models.UserProductsModel;

import java.util.ArrayList;
import java.util.List;

public class UserProductsMapper {
    // za citanje usera koji je kupio product
    public static UserProductsModel toModel(UserProducts entity){
        return UserProductsModel.builder()
                .id(entity.getId())
                .email(entity.getEmail())
                .firstName(entity.getFirstName())
                .lastName(entity.getLastName())
                .contactNumber(entity.getContactNumber())
                .products(ProductMapper.toModelList(entity.getProducts())).build();
    }

    // za citanje liste korisnika koji su kupili proizvod
    public static List<UserProductsModel> toModelList(List<UserProducts> entities){
        var list = new ArrayList<UserProductsModel>();

        for(var entity : entities){
            list.add(toModel(entity));
        }
        return list;
    }


}
