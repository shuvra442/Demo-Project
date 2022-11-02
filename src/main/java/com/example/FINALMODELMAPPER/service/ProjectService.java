package com.example.FINALMODELMAPPER.service;

import com.example.FINALMODELMAPPER.converter.ProjectConverter;
import com.example.FINALMODELMAPPER.dto.ProjectDto;
import com.example.FINALMODELMAPPER.dto.ProjectResponceDto;
import com.example.FINALMODELMAPPER.model.Department;
import com.example.FINALMODELMAPPER.model.Project;
import com.example.FINALMODELMAPPER.repository.DepartmentRepository;
import com.example.FINALMODELMAPPER.repository.ProjectRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProjectService {

    private ProjectRepository projectRepository;
    private DepartmentRepository departmentRepository;
    private ProjectConverter projectConverter;

    public ProjectService(ProjectRepository projectRepository,
                          DepartmentRepository departmentRepository,
                          ProjectConverter projectConverter) {
        this.projectRepository = projectRepository;
        this.departmentRepository = departmentRepository;
        this.projectConverter = projectConverter;
    }

    public List<ProjectResponceDto> getAllProjects(){
        List<Project> projecteList = projectRepository.findAll();
        return projecteList.stream().map(projectConverter :: projectResponceDtoToProject)
                .collect(Collectors.toList());
    }

    public void addProject(ProjectDto projectDto) {
        Project project = projectConverter.projectDtoToproject(projectDto);

        Optional<Department> dept = departmentRepository.findById(projectDto.getDepartment_id());
        if(dept.isEmpty())
            System.out.println("No department!!!");
        project.setDepartment(dept.get());

        projectRepository.save(project);
    }

    public void updateProj(ProjectDto project, int id){
        Project data=projectRepository.findById(id).orElse(null);
        assert data != null;
        data.setPname(project.getPname());
        data.setPtype(project.getPtype());
        data.setDepartment(departmentRepository.findById(project.getDepartment_id()).get());
        projectRepository.save(data);
    }

    public  void deleteProj(int id){
        projectRepository.deleteById(id);
    }

}
