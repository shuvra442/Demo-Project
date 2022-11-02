package com.example.FINALMODELMAPPER.converter;

import com.example.FINALMODELMAPPER.dto.ProjectDto;
import com.example.FINALMODELMAPPER.dto.ProjectResponceDto;
import com.example.FINALMODELMAPPER.model.Project;

public interface ProjectConverter {

    Project projectDtoToproject(ProjectDto projectDto);

    ProjectResponceDto projectResponceDtoToProject(Project project);

}
