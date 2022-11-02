package com.example.FINALMODELMAPPER.service;

import com.example.FINALMODELMAPPER.dto.ImageDto;
import com.example.FINALMODELMAPPER.model.Image;
import com.example.FINALMODELMAPPER.repository.EmployeeRepository;
import com.example.FINALMODELMAPPER.repository.ImageRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Base64;
import java.util.List;
import java.util.Optional;

@Service
public class ImageService {

    private ImageRepository imageRepository;
    private EmployeeRepository employeeRepository;

    public ImageService(ImageRepository imageRepository, EmployeeRepository employeeRepository) {
        this.imageRepository = imageRepository;
        this.employeeRepository = employeeRepository;
    }

    public void saveImage(ImageDto imageDto){
        MultipartFile file = imageDto.getProfileImage();
        Image img = new Image();
        try{
            img.setProfileImage(Base64.getEncoder().encodeToString(file.getBytes()));
            Path path= Paths.get("C:\\Users\\SHUVRA PATRA\\Downloads\\show");
            if(!Files.isDirectory(path))
            {
                Files.createDirectory(path);
            }
            else {
                path=Paths.get(path + "\\" + file.getOriginalFilename());
                file.transferTo(path);
                img.setName(file.getOriginalFilename());
            }
        }catch(Exception e)
        {
            e.printStackTrace();
        }

        img.setEmployee(employeeRepository.findById(imageDto.getEmployee_id()).get());
        imageRepository.save(img);
    }

    public List<Image> getAllImages() {
        return imageRepository.findAll();
    }

    public Image getImageByEmployeeId(int id) {
        Optional<Image> img = imageRepository.findByEmployeeId(id);
        if(img.isPresent())
            return img.get();
        return null;
    }

    public void updateImage(ImageDto imageDto)
    {
       Optional<Image>optionalImage=imageRepository.findByEmployeeId(imageDto.getEmployee_id());
       Image image=optionalImage.get();
       MultipartFile file= imageDto.getProfileImage();
       try{
         image.setProfileImage(Base64.getEncoder().encodeToString(file.getBytes()));

           Path path= Paths.get("C:\\Users\\SHUVRA PATRA\\Downloads\\show\\" + file.getOriginalFilename());
           Path path1=Paths.get("C:\\Users\\SHUVRA PATRA\\Downloads\\show\\" + imageRepository.findByEmployeeId(imageDto.getEmployee_id()).get().getName());


           Files.delete(path1);
           file.transferTo(path);
           image.setName(file.getOriginalFilename());
       }
       catch (Exception e)
       {
           e.printStackTrace();
       }
       image.setEmployee(employeeRepository.findById(imageDto.getEmployee_id()).get());
       imageRepository.save(image);
    }


}
