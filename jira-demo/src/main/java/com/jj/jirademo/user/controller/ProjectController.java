package com.jj.jirademo.user.controller;

import com.jj.jirademo.user.dto.CreateProjectRequest;
import com.jj.jirademo.user.dto.ProjectDto;
import com.jj.jirademo.user.service.ProjectService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("/{pageNumber}")
    public ResponseEntity<List<ProjectDto>> getAllProjects(@PathVariable int pageNumber){
        return ResponseEntity.ok(projectService.getAllProjects(pageNumber));
    }




}
