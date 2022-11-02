package com.example.FINALMODELMAPPER.webView;

import com.example.FINALMODELMAPPER.dto.ImageDto;
import com.example.FINALMODELMAPPER.model.Image;
import com.example.FINALMODELMAPPER.repository.DepartmentRepository;
import com.example.FINALMODELMAPPER.repository.EmployeeRepository;
import com.example.FINALMODELMAPPER.repository.ImageRepository;
import com.example.FINALMODELMAPPER.repository.ProjectRepository;
import com.example.FINALMODELMAPPER.service.ImageService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Optional;

@Controller
public class ImageView {

    private ImageService imageService;
    private EmployeeRepository employeeRepository;
    private DepartmentRepository departmentRepository;
    private ProjectRepository projectRepository;
    private ImageRepository imageRepository;


    public ImageView(ImageService imageService, EmployeeRepository employeeRepository,
                     DepartmentRepository departmentRepository,
                     ProjectRepository projectRepository,
                     ImageRepository imageRepository) {
        this.imageService = imageService;
        this.employeeRepository = employeeRepository;
        this.departmentRepository = departmentRepository;
        this.projectRepository = projectRepository;
        this.imageRepository=imageRepository;
    }

    @GetMapping("/about/{id}")
    public String index(@PathVariable int id, Model model){
        ImageDto img = new ImageDto();
        model.addAttribute("img", img);
        model.addAttribute("empId", id);
        model.addAttribute("thisEmployee", employeeRepository.findById(id).get());
        model.addAttribute("image", imageService.getImageByEmployeeId(id));
        return "/profile";
    }
    @PostMapping("/employees/about/upload")
    public String index(@ModelAttribute ImageDto image){
        Optional<Image>optionalImage=imageRepository.findByEmployeeId(image.getEmployee_id());
        if(optionalImage.isPresent())
        {
            imageService.updateImage(image);
        }
        else {
            imageService.saveImage(image);
        }
        return "redirect:/about/" + image.getEmployee_id();
    }
}
