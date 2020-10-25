package com.yovelas.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class User {
	private int userId;
    private String userName;
    private String userNickName;
    private String userPassword;
    private String userPicture;
    private String createTime;
    private List userTrack;
    private List userContact;
    private List userOrders;

    public User(String userName, String userPassword) {
        this.userName = userName;
        this.userPassword = userPassword;
    }
}
