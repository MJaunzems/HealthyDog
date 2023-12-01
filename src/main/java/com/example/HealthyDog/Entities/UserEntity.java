package com.example.HealthyDog.Entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter @NoArgsConstructor
public class UserEntity {

    @Id
    @Column(name="user_id")
    private long userId;
    @Column(name="user_role")
    private String userRole;
    @Column(name="user_nickname")
    private String userNickname;
    @Column(name="user_email")
    private String userEmail;
    @Column(name="user_phone")
    private int userPhone;
    @Column(name="user_password")
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
