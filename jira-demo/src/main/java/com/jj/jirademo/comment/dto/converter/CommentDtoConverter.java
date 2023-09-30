package com.jj.jirademo.comment.dto.converter;

import com.jj.jirademo.comment.dto.CommentDto;
import com.jj.jirademo.comment.model.Comment;
import com.jj.jirademo.common.model.Project;
import com.jj.jirademo.task.dto.converter.TaskDtoConverter;
import com.jj.jirademo.user.dto.UserProjectDto;
import com.jj.jirademo.user.dto.converter.UserDtoConverter;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class CommentDtoConverter {
    private final UserDtoConverter userDtoConverter;
    private final TaskDtoConverter taskDtoConverter;

    public CommentDtoConverter(@Lazy UserDtoConverter userDtoConverter, TaskDtoConverter taskDtoConverter) {
        this.userDtoConverter = userDtoConverter;
        this.taskDtoConverter = taskDtoConverter;
    }



    public CommentDto convert(Comment from){
        return new CommentDto(
                from.getId(),
                from.getComment(),
                userDtoConverter.convert(from.getUser()),
                taskDtoConverter.convert(from.getTask())

        );
    }
}
