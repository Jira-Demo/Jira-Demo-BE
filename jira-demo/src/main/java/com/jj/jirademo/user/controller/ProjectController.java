package com.jj.jirademo.user.controller;

import com.jj.jirademo.user.dto.CreateProjectRequest;
import com.jj.jirademo.user.dto.ProjectDto;
import com.jj.jirademo.user.service.ProjectService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/project")
public class ProjectController {
    private final ProjectService projectService;


    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    @PostMapping
    public ResponseEntity<ProjectDto> createProject(@RequestBody CreateProjectRequest createProjectRequest){
        return ResponseEntity.ok(projectService.createProject(createProjectRequest));
    }




}
