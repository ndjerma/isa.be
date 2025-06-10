package com.example.demo.services;

import com.example.demo.entities.User;
import com.example.demo.exceptions.user.UserAlreadyExistsException;
import com.example.demo.exceptions.user.UserException;
import com.example.demo.mappers.UserMapper;
import com.example.demo.mappers.UserProductsMapper;
import com.example.demo.models.UserModel;
import com.example.demo.models.UserPageModel;
import com.example.demo.models.UserProductsModel;
import com.example.demo.repositories.IUserProductsRepository;
import com.example.demo.repositories.IUserRepository;
import jdk.jshell.spi.ExecutionControl;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService implements IUserService {

    private final IUserRepository userRepository; //RequiredArgsConstructor sam implementira konstruktor, ovo je samo DepInjection
    private final IUserProductsRepository userProductsRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    @Override
    public List<UserModel> findAll() {
        return UserMapper.toModelList(userRepository.findAll());
    }

    @Override
    public UserPageModel findPagedList(PageRequest pageRequest) {
        var result = userRepository.findAll(pageRequest);
        return UserMapper.toModelPagedList(result);

        //isto se postize i sa:
                // return UserMapper.toModelPagedList(userRepository.findAll(pageRequest));
    }

    @Override
    public UserModel create(UserModel model) {
        var user = UserMapper.toEntity(model, passwordEncoder);

        var existingUser = userRepository.findByEmail(user.getEmail());

        if (existingUser.isPresent()) {
            throw new UserAlreadyExistsException("User with email " + model.getEmail() + " already exists");
        }

        var savedUser = userRepository.save(user);

        return UserMapper.toModel(savedUser);
    }

    @Override
    public UserModel update(UserModel model) {
        var entity = UserMapper.toEntityForUpdate(model, passwordEncoder);
        try {
            var result = userRepository.save(entity);
            return UserMapper.toModel(result);
        } catch (Exception e) {
            throw new UserException(e.getMessage());
        }
    }

    @Override
    public void delete(Integer userId) {
        var entity = userRepository.findById(userId).orElseThrow(() -> new UserException("User Not Found"));
        userRepository.delete(entity);
    }

    @Override
    public List<UserProductsModel> findUserProductsAll() {
//        var result = userProductsRepository.findAll();

        return UserProductsMapper.toModelList(userProductsRepository.findAll());
    }

}





/*
 *public UserModel create(UserModel model) {      // ovaj userModel nema ID, dolazi sa FRONTENDA
        var entity = UserMapper.toEntity(model);

        var result = userRepository.save(entity);
        /*
        * Da bi smo sacuvali entity koji smo prosledili tokom create-a, kada metoda save() vrati ceo entitet koji je sacuvan
        * to zapravo znaci da ce save() upisati u result `id` koji je upisan u bazi
        *
        * Onda taj result sada ima id i sve ostale podatke, pa ga vracamo opet u model u liniji koda ispod i onda imamo
        * */

// var returnedUser = UserMapper.toModel(result);
// result IMA ID, dolazi iz baze gde je ID generisan i vracamo SERVISU

// return returnedUser;  //vracamo ga nazad, i opet ga pretvaramo u userModel, ovoga puta da bi se sacuvao ID
       // return UserMapper.toModel(result);
//    }
