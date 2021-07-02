package com.bestinterview.employee;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {
    
    @Autowired
    EmployeeRepository employeeRepository;

    public EmployeeDTO save(EmployeeDTO employeeDTO) {
        return employeeRepository.save(employeeDTO);
    }

    public Optional<EmployeeDTO> findById(int id) {
        return employeeRepository.findById(id);
    }

}
