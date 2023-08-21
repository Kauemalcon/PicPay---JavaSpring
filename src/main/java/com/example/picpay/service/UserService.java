package com.example.picpay.service;

import com.example.picpay.domain.user.User;
import com.example.picpay.domain.user.UserType;
import com.example.picpay.dtos.UserDTO;
import com.example.picpay.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public  void validateTransaction(User sender, BigDecimal amount) throws Exception {
        if(sender.getUserType() == UserType.COMMUN){
            throw  new Exception("Usuario do tipo Lojista não está autorizado a realizar transação");
        }

        if(sender.getBalance().compareTo(amount) < 0){
            throw new Exception("Saldo insuficiente");
        }
    }

    public User findUserById(Long id) throws Exception {
        return this.userRepository.userFindById(id).orElseThrow(() -> new Exception("Usuario não encontrado"));
    }
    public User createUser(UserDTO userDTO){
        User user = new User(userDTO);
        this.saveUser(user);
        return user;
    }

    public List<User> getAllUsers(){
        return this.userRepository.findAll();
    }
    public void saveUser(User user){
        this.userRepository.save(user);
    }
}
