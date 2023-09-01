package com.jj.jirademo.user.dto.converter;

import com.jj.jirademo.common.model.Project;
import com.jj.jirademo.user.dto.ProjectDto;
import org.springframework.stereotype.Component;

@Component
public class ProjectDtoConverter {
    public ProjectDto convert(Project from){
        return new ProjectDto(
                from.getId(),
                from.getProjectName(),
                from.getCreatedDate(),
                from.getUpdatedDate()
        );
    }

}
