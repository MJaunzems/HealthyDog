package com.example.HealthyDog.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter @NoArgsConstructor
public class UserEntity {

    @Id
    private long userId;
    private String userRole;
    private String userNickname;
    private String userEmail;
    private int userPhone;
    private String userPassword;

    public UserEntity(long userId, String userRole, String userNickname, String userEmail, int userPhone, String userPassword) {
        this.userId = userId;
        this.userRole = userRole;
        this.userNickname = userNickname;
        this.userEmail = userEmail;
        this.userPhone = userPhone;
        this.userPassword = userPassword;
    }
}
