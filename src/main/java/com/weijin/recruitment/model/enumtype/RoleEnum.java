package com.weijin.recruitment.model.enumtype;

import lombok.Data;
import lombok.Getter;

import java.util.Objects;

/**
 * @Author WeiJin
 * @Version 1.0
 * @Date 2024/7/2 15:43
 */

public enum RoleEnum {



    SEEKER(1,"ROLE_seeker"),
    RECRUITER(2,"ROLE_recruiter"),
    ADMIN(3,"ROLE_admin");

    @Getter
    private final Integer code;
    private final String role;
    private RoleEnum(Integer code,String role){
        this.code = code;
        this.role = role;
    }

    public static String getRole(Integer code){
        for (RoleEnum roleEnum:RoleEnum.values()){
            if (Objects.equals(roleEnum.code, code)){
                return roleEnum.role;
            }
        }
        return null;
    }
}
