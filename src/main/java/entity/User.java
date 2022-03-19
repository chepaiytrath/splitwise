package entity;

import lombok.Getter;

import java.util.UUID;

@Getter
public class User {
    public User(String name, String email, String phone, String address) {
        this.userId = UUID.randomUUID().toString();
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.address = address;
    }

    private String userId;
    private String name;
    private String email;
    private String phone;
    private String address;
}
