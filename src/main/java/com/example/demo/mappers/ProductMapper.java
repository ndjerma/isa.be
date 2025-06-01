package com.example.demo.mappers;

import com.example.demo.entities.Product;
import com.example.demo.models.ProductModel;
import com.example.demo.models.UserModel;

import java.util.ArrayList;
import java.util.List;

public class ProductMapper {

    // za citanje
    public static ProductModel toModel(Product entity){
       return ProductModel.builder()
                .name(entity.getName()).build();
    }
    // Pretvara sve sirove potake iz entiteta (koji je u sustini izmapirana SQL tabela)
    // u podatke koje zapravo zelimo da prikazemo korisniku.
    // ne mozemo da pokazemo ovde id, kada ga u productModelu nemamo, vec imamo samo ime


    // za citanje
    // OVO MI NIJE JASNO KAKO FUNKCIONISE => mislim da je ovo samo lista proizvoda ako ocemo negde da ih prikazemo
    // nije nista specijalno
    public static List<ProductModel> toModelList(List<Product> entities){
        var list = new ArrayList<ProductModel>();

        for (var entity : entities) {
            list.add(toModel(entity));
        }
        return list;
    }
}
