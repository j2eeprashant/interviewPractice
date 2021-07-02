package com.bestinterview.department;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employees")
public class DepartmentController {

    @Autowired
    DepartmentService departmentService;
    
    @PostMapping("")
    public DepartmentDTO saveEmployee(@RequestBody DepartmentDTO departmentDTO){
        return departmentService.save(departmentDTO);
    }
    
    @GetMapping("/{}")
    public DepartmentDTO getEmploee(@RequestParam(name = "id") int id) {
        return departmentService.findById(id).get();
    }
        

}
