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
    private long user_id;
    private String user_role;
    private String user_nickname;
    private String user_email;
    private int user_phone;
    private String user_password;

    public UserEntity(long user_id, String user_role, String user_nickname, String user_email, int user_phone, String user_password) {
        this.user_id = user_id;
        this.user_role = user_role;
        this.user_nickname = user_nickname;
        this.user_email = user_email;
        this.user_phone = user_phone;
        this.user_password = user_password;
    }
}
