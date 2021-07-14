package com.sda.springhrapp.controller;

import com.sda.springhrapp.model.Project;
import com.sda.springhrapp.service.ProjectService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequestMapping(value = "/humanresources/api")
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    @GetMapping("/projects")
    public ResponseEntity<String> findAllProjects(@RequestParam(value = "budget") double x)
    {
        List<Project> projectList= projectService.findAllProjectWithBudget(x);
        log.info("projects found.");
        log.debug(projectList.toString());
        return new ResponseEntity<>(projectList.toString(), HttpStatus.OK);
    }

    @PostMapping("/projects")
    public ResponseEntity<String> createProject(@RequestBody Project project) {
        try {
            projectService.saveProject(project);
        } catch (IllegalArgumentException e) {
            log.info("Something went wrong, IllegalArgumentException");
            return new ResponseEntity<>("There is some missing data, check your request..", HttpStatus.I_AM_A_TEAPOT);
        }
        log.info(project.toString());
        return new ResponseEntity<>(project.toString(), HttpStatus.CREATED);
    }

    @PutMapping("/projects")
    public ResponseEntity<Project> updateEmployee( @RequestBody Project project) {
        Project updatedProject= projectService.saveProject(project);
        return ResponseEntity.ok(updatedProject);
    }
}
