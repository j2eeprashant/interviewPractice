package com.bestinterview.department;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DepartmentService {
    
    @Autowired
    DepartmentRepository departmentRepository;

    public DepartmentDTO save(DepartmentDTO departmentDTO) {
        return departmentRepository.save(departmentDTO);
    }

    public Optional<DepartmentDTO> findById(int id) {
        return departmentRepository.findById(id);
    }

}
