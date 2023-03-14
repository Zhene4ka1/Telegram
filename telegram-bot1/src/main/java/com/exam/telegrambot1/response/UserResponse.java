package com.exam.telegrambot1.response;


import com.exam.telegrambot1.entity.UserEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
@Data
@EqualsAndHashCode(callSuper = false)
public class UserResponse extends BaseResponse {
    public UserResponse(boolean success, String message, UserEntity user){
        super(success,message);
        this.user=user;
    }
    public UserResponse(UserEntity user){
        super(true,"Данные пользователя");
    }
    private UserEntity user;
}
