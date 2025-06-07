package com.example.demo.controllers;

import com.example.demo.models.UserModel;
import com.example.demo.models.UserPageModel;
import com.example.demo.models.UserProductsModel;
import com.example.demo.services.IUserService;
import jakarta.validation.Valid;
import jakarta.validation.ValidationException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@Slf4j
@RestController
@RequestMapping("user")
@RequiredArgsConstructor          //ovo automatski pise konstruktore, olaksava nam dependencyInjection
@CrossOrigin("*")
public class UserController {

    private final IUserService userService;

    // Vraca listu korisnika
    @GetMapping("get-list")
    public List<UserModel> getList() { return userService.findAll(); }

    // Vraca listu korisnika koji su kupili proizvod
    @GetMapping("get-user-products-list")
    public List<UserProductsModel> getUserProductsList() {
        return userService.findUserProductsAll();
    }
    // Vraca page-ovane usere za prikaz u tabeli na FN
    @GetMapping("get-page-list")
    public UserPageModel getPageList(Integer pageNumber, Integer pageSize) {
        return userService.findPagedList(PageRequest.of(pageNumber, pageSize));
    }

    @PostMapping("create")
    public ResponseEntity<?> create(@RequestBody @Valid UserModel userModel, BindingResult result) {
        if(result.hasErrors()) {
            return new ResponseEntity<>("Neuspesno registrovan!", HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<>(userService.create(userModel), HttpStatus.CREATED);
    }

    @PostMapping("update")
        public ResponseEntity<?> update(@RequestBody @Valid UserModel userModel, BindingResult result) {
            return ResponseEntity.ok(userService.update(userModel));
        }

}
