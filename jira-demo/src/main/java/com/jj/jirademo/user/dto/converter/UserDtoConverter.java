package com.jj.jirademo.user.dto.converter;

import com.jj.jirademo.comment.dto.converter.CommentDtoConverter;
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
    private final CommentDtoConverter commentDtoConverter;

    public UserDtoConverter(ProjectDtoConverter projectDtoConverter, TaskDtoConverter taskDtoConverter, CommentDtoConverter commentDtoConverter) {
        this.projectDtoConverter = projectDtoConverter;
        this.taskDtoConverter = taskDtoConverter;
        this.commentDtoConverter = commentDtoConverter;
    }



    public UserDto convert(User from){
        return new UserDto(
                from.getId(),
                from.getName(),
                from.getSurname(),
                from.getPassword(),
                from.getEmail(),
                projectDtoConverter.convertToUserProject(Optional.ofNullable(from.getProject())),
                Objects.requireNonNull(from.getComment().stream().map(commentDtoConverter::convert).collect(Collectors.toSet())),
                Objects.requireNonNull(from.getTaskAssigned().stream().map(taskDtoConverter::convert)
                        .collect(Collectors.toSet())),
                Objects.requireNonNull(from.getTaskReported().stream().map(taskDtoConverter::convert)
                        .collect(Collectors.toSet())),
                from.getRole().name());



    }

}
