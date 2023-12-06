package com.example.HealthyDog.Services;

import com.example.HealthyDog.Entities.UserEntity;
import com.example.HealthyDog.MyUserDetails;
import com.example.HealthyDog.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Service
public class UserService implements UserDetailsService{
    @Autowired
    UserRepository userRepository;
    @Lazy
    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        Optional<UserEntity> user = userRepository.findByUserNickname(userName);
        user.orElseThrow(() -> new UsernameNotFoundException("Not found: " + userName));
        return user.map(MyUserDetails::new).get();
    }

    /*public void saveUser(UserEntity user){
        user.setUserPassword(passwordEncoder.encode(user.getUserPassword()));
        userRepository.save(user);
    }*/

    public void changePassword(String username, String currentPassword, String newPassword) {
        UserEntity userEntity = userRepository.findByUserNickname(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found with username: " + username));
        if (passwordEncoder.matches(currentPassword, userEntity.getUserPassword())) {
            String encodedNewPassword = passwordEncoder.encode(newPassword);
            userEntity.setUserPassword(encodedNewPassword);
            userRepository.save(userEntity);
        } else {
            throw new IllegalArgumentException("Incorrect current password");
        }
    }

    public void updateUser(UserDetails userDetails, String username, int phone, String email) {
        String currentUsername = userDetails.getUsername();
        Optional<UserEntity> userDetailsOptional = userRepository.findByUserNickname(currentUsername);
        if(userDetailsOptional.isPresent()){
            UserEntity userEntity = userDetailsOptional.get();
            userEntity.setUserNickname(username);
            userEntity.setUserPhone(phone);
            userEntity.setUserEmail(email);
            userRepository.save(userEntity);
        }else{
            throw new UsernameNotFoundException("User not found with username: " + currentUsername);
        }
    }
}
