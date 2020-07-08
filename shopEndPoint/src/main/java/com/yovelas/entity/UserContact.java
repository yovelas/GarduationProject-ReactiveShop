package com.yovelas.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UserContact {
	private int userContactId;
    private int userId;
    private String userActualName;
    private String userPhone;
    private String userEmail;
    private String userAddress;
    private String createTime;
}
