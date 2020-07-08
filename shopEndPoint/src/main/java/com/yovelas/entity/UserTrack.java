package com.yovelas.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UserTrack {
	private int userTrackId;
    private int userId;
    private int goodsId;
    private String createTime;
}
