package com.example.FINALMODELMAPPER.converter.impl;

import com.example.FINALMODELMAPPER.converter.ProjectConverter;
import com.example.FINALMODELMAPPER.dto.ProjectDto;
import com.example.FINALMODELMAPPER.dto.ProjectResponceDto;
import com.example.FINALMODELMAPPER.model.Project;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class ProjectConverterImpl implements ProjectConverter {

    public final ModelMapper modelMapper;

    public ProjectConverterImpl(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public Project projectDtoToproject(ProjectDto projectDto)
    {
        return modelMapper.map(projectDto, Project.class);
    }

    @Override
    public ProjectResponceDto projectResponceDtoToProject(Project project)
    {
        return modelMapper.map(project, ProjectResponceDto.class);
    }
}
