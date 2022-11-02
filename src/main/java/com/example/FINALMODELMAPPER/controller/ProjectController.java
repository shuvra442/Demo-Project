package com.example.FINALMODELMAPPER.controller;

import com.example.FINALMODELMAPPER.dto.ProjectDto;
import com.example.FINALMODELMAPPER.dto.ProjectResponceDto;
import com.example.FINALMODELMAPPER.service.ProjectService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProjectController {

    private ProjectService projectService;

    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    @GetMapping("/projects")
    public List<ProjectResponceDto> getAllProjects(){
        return projectService.getAllProjects();
    }

    @PostMapping("/projects")
    public void addProject(@RequestBody ProjectDto projectDto) {
        projectService.addProject(projectDto);
    }

    @PutMapping("/projects/{id}")
    public void updateProject(@RequestBody ProjectDto project, @PathVariable int id) {
        projectService.updateProj(project, id);
    }
    @DeleteMapping("/projects/{id}")
    public void deleteProj(@PathVariable int id) {
        projectService.deleteProj( id);
    }
}
