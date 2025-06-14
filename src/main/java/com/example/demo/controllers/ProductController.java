package com.example.demo.controllers;

import com.example.demo.entities.Product;
import com.example.demo.mappers.ProductMapper;
import com.example.demo.mappers.UserMapper;
import com.example.demo.mappers.UserProductsMapper;
import com.example.demo.models.ProductModel;
import com.example.demo.models.UserModel;
import com.example.demo.models.UserPageModel;
import com.example.demo.models.UserProductsModel;
import com.example.demo.repositories.IProductRepository;
import com.example.demo.repositories.IUserProductsRepository;
import com.example.demo.repositories.IUserRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("product")
@RequiredArgsConstructor          //ovo automatski pise konstruktore, olaksava nam dependencyInjection
@CrossOrigin("*")
public class ProductController {
    private final IProductRepository productRepository;

//    @GetMapping("get-list")
//    public List<ProductModel> getList() {
//        return ProductMapper.toModelList(productRepository.findAll());
//    }

    @GetMapping("get-list")
    public List<Product> getList() {
        return productRepository.findAll();
    }
}
