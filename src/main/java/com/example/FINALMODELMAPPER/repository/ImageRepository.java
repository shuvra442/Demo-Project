package com.example.FINALMODELMAPPER.repository;

import com.example.FINALMODELMAPPER.model.Image;
import org.springframework.data.jpa.repository.JpaRepository;
import org.thymeleaf.cache.ICacheManager;

import javax.transaction.Transactional;
import java.util.Optional;

public interface ImageRepository extends JpaRepository<Image,Integer> {
    Optional<Image> findByEmployeeId(int id);

    @Transactional
    void deleteByemployeeId(int id);
}
