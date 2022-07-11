package com.project.movietickets.service;

import com.project.movietickets.entity.UserEntity;
import com.project.movietickets.model.Role;
import com.project.movietickets.model.UserModel;
import com.project.movietickets.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Log4j2
@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    public boolean isAdmin(String name) {
        var user = userRepository.findUserEntityByUsername(name).get();

        return user.getRole().equals(Role.ROLE_ADMIN);
    }

    public boolean deleteUser(int id){
        userRepository.deleteById(id);

        return userRepository.findById(id).isEmpty();
    }

    public UserEntity createUser(UserEntity user){
        if (user.getPassword().isBlank() || user.getUsername().isBlank()){
            return null;
        }

        var passwordEncode = passwordEncoder.encode(user.getPassword());
        user.setPassword(passwordEncode);

        try{
            return userRepository.save(user);
        } catch (Exception e){
            log.error(e);
        }

        return null;
    }

    public List<UserEntity> getAllEmployees() {
        return userRepository.findAll().stream()
                .filter(userEntity -> !userEntity.getRole().equals(Role.ROLE_USER))
                .collect(Collectors.toList());
    }

    public String getRole(String username) {
        var user = userRepository.findUserEntityByUsername(username).get();
        var role = user.getRole().name();
        return role;
    }

    public UserEntity findUserById(int id) {
        return userRepository.getOne(id);
    }

    public UserEntity updateUser(int id, UserModel model) {
        var user = userRepository.getOne(id);

        user.setFullName(model.getFullName());
        user.setUsername(model.getUsername());
        user.setEmail(model.getEmail());
        user.setRole(model.getRole());

        return userRepository.save(user);
    }

    public Optional<UserEntity> findUserByUsername(String username) {
        return userRepository.findUserEntityByUsername(username);
    }
}
