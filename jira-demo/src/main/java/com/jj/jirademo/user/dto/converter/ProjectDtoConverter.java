package com.jj.jirademo.user.dto.converter;

import com.jj.jirademo.common.model.Project;
import com.jj.jirademo.user.dto.ProjectDto;
import com.jj.jirademo.user.dto.UserProjectDto;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class ProjectDtoConverter {
    public UserProjectDto convertToUserProject(Optional<Project> from){
        return from.map(f -> new UserProjectDto(f.getId(), f.getProjectName())).orElseThrow(null);
    }
    public ProjectDto convert(Project from){
        return new ProjectDto(
                from.getId(),
                from.getProjectName()

        );
    }

}
