package ru.praktikum.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Courier {

    private Integer id;
    private String login;
    private String password;
    private String firstName;

    public String getIncorrectPassword(){
        return password + 1;
    }

    public String getIncorrectLogin(){
        return login + 1;
    }
}
