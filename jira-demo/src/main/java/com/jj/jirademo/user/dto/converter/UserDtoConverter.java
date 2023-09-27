package com.jj.jirademo.user.dto.converter;

import com.jj.jirademo.task.dto.converter.TaskDtoConverter;
import com.jj.jirademo.user.dto.UserDto;
import com.jj.jirademo.user.model.User;
import org.springframework.stereotype.Component;

import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class UserDtoConverter {
    private final ProjectDtoConverter projectDtoConverter;
    private  final TaskDtoConverter taskDtoConverter;

    public UserDtoConverter(ProjectDtoConverter projectDtoConverter, TaskDtoConverter taskDtoConverter) {
        this.projectDtoConverter = projectDtoConverter;
        this.taskDtoConverter = taskDtoConverter;
    }

    public UserDto convert(User from){
        return new UserDto(
                from.getId(),
                from.getName(),
                from.getSurname(),
                from.getPassword(),
                from.getEmail(),
                projectDtoConverter.convertToUserProject(Optional.ofNullable(from.getProject())),
                Objects.requireNonNull(from.getTaskAssigned()).stream().map(taskDtoConverter::convert)
                        .collect(Collectors.toSet()),
                from.getRole().name());



    }

}
