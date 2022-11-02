package com.example.FINALMODELMAPPER.webView;

import com.example.FINALMODELMAPPER.dto.EmployeeDto;
import com.example.FINALMODELMAPPER.repository.*;
import com.example.FINALMODELMAPPER.service.EmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class Index {
    private EmployeeRepository employeeRepository;
    private DepartmentRepository departmentRepository;
    private ProjectRepository projectRepository;
    private EmployeeService employeeService;
    private AddressRepository addressRepository;
    private ImageRepository imageRepository;

    public Index(EmployeeRepository employeeRepository,
                 DepartmentRepository departmentRepository,
                 ProjectRepository projectRepository,
                 EmployeeService employeeService,
                 AddressRepository addressRepository,
                 ImageRepository imageRepository) {
        this.employeeRepository = employeeRepository;
        this.departmentRepository = departmentRepository;
        this.projectRepository = projectRepository;
        this.employeeService = employeeService;
        this.addressRepository=addressRepository;
        this.imageRepository=imageRepository;
    }

    @GetMapping("/about")
    public String index(Model model){
        model.addAttribute("employees", employeeRepository.findAll());
        return "index";
    }
    @GetMapping("/signup")
    public String form(Model model)
    {
        EmployeeDto employeeDto=new EmployeeDto();
        model.addAttribute("employeeDto",employeeDto);
        return "form";
    }

    @GetMapping("/dropdown")
    public String dropdown(Model model)
    {
        EmployeeDto employeeDto=new EmployeeDto();
        model.addAttribute("employeeDto", employeeDto);
        model.addAttribute("department", departmentRepository.findAll());
        model.addAttribute("project",projectRepository.findAll());
        model.addAttribute("address", addressRepository.findAll());
        return "dropdown";
    }


    @GetMapping("/update/{id}")
    public String updateDetail(@PathVariable int id, Model model){
        EmployeeDto employeeDto=new EmployeeDto();
        model.addAttribute("employeeDto",employeeDto);
        model.addAttribute("empID", id);
        model.addAttribute("thisEmployee",employeeRepository.findById(id).get());
//        model.addAttribute("city", addressRepository.findById(id).get());
        return "updateDetail";
    }

   @PostMapping("/submit")
    public String submit(@ModelAttribute EmployeeDto employeeDto)
   {
//       if(!employeeService.findByname(employeeDto.getE_name()))
       employeeService.addEmployee(employeeDto);
      return "redirect:/about";
   }
   @PostMapping("/submitUpdate")
    public String submitUpadte(@ModelAttribute EmployeeDto employeeDto)
   {
       employeeService.updateEmp(employeeDto, employeeDto.getId());
        return "redirect:/about";
   }

   @GetMapping("/delete/{id}")
    public String deleteDetails(@PathVariable int id)
   {
       imageRepository.deleteByemployeeId(id);
      employeeService.deleteEmp(id);
      return "redirect:/about";
   }

}
