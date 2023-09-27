package com.jj.jirademo.task.dto.converter;

import com.jj.jirademo.task.dto.TaskDto;
import com.jj.jirademo.task.model.Task;
import org.springframework.stereotype.Component;

@Component
public class TaskDtoConverter {
    public TaskDto convert(Task from){
        return new TaskDto(
                from.getId(),
                from.getDescription(),
                from.getTaskName(),
                from.getDueDate(),
                from.getPriority().getId(),
                from.getStatus().getId()
        );
    }
}
