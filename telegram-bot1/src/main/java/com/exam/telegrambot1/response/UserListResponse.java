package com.exam.telegrambot1.response;

import com.exam.telegrambot1.entity.UserEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class UserListResponse extends  BaseResponse{
    public UserListResponse(Iterable<UserEntity> data){
        super(true,"Авторы");
        this.data=data;
    }
    private Iterable<UserEntity> data;
}
