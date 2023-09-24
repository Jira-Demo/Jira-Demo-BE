package com.jj.jirademo.user.dto.converter;

import com.jj.jirademo.user.dto.UserDto;
import com.jj.jirademo.user.model.User;
import org.springframework.stereotype.Component;

@Component
public class UserDtoConverter {
    public UserDto converter(User from){
        return new UserDto(
                from.getId(),
                from.getName(),
                from.getSurname(),
                from.getPassword(),
                from.getEmail(),
                from.getProject(),
                from.getTaskAssigned(),
                from.getRole()
        );
    }
}
