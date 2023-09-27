package com.jj.jirademo.user.service;

import com.jj.jirademo.common.model.Project;
import com.jj.jirademo.user.dto.CreateProjectRequest;
import com.jj.jirademo.user.dto.ProjectDto;
import com.jj.jirademo.user.dto.converter.ProjectDtoConverter;
import com.jj.jirademo.user.repository.ProjectRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;


import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProjectService {
    private final ProjectRepository projectRepository;
    private final ProjectDtoConverter projectDtoConverter;

    public ProjectService(ProjectRepository projectRepository, ProjectDtoConverter projectDtoConverter) {
        this.projectRepository = projectRepository;
        this.projectDtoConverter = projectDtoConverter;
    }

    public ProjectDto createProject(CreateProjectRequest createProjectRequest) {
        Project project = new Project(null,
                createProjectRequest.getProjectName(),
                LocalDateTime.now(),
                null,
                new HashSet<>()


        );
        projectRepository.save(project);
        return projectDtoConverter.convert(project);
    }

    public List<ProjectDto> getAllProjects(int pageNumber) {
        PageRequest pageable  =  PageRequest.of(pageNumber-1,2);

        return projectRepository.findAll(pageable)
                .stream()
                .map(projectDtoConverter::convert)
                .collect(Collectors.toList());

    }
}
