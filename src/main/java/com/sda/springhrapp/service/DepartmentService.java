package com.sda.springhrapp.service;

import com.sda.springhrapp.model.Department;
import com.sda.springhrapp.model.Employee;
import com.sda.springhrapp.repository.DepartmentRepositoryIf;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class DepartmentService {

    @Autowired
    private DepartmentRepositoryIf departmentRepositoryIf;

    public Department saveDepartment(Department department)
    {
        departmentRepositoryIf.save(department);
        log.info("Department saved succesfully.");
        return department;
    }

    public Integer deleteById(Integer id) {

        Integer department = departmentRepositoryIf.deleteDepartmentById(id);
        if (department == 0) {
            log.warn("Department didn't get game ended");
        } else {
            log.info("Department with id " + department + " was game ended.");
        }
        return department;
    }

    public Integer deleteByName(String name) {

        Integer department = departmentRepositoryIf.deleteDepartmentByName(name);
        if (department == 0) {
            log.warn("Department didn't get game ended");
        } else {
            log.info("Department with id " + department + " was game ended.");
        }
        return department;
    }

    public Department findDepartmentWithEmployeeList(List<Employee> employeeList)
    {
        return departmentRepositoryIf.findDepartmentByEmployeeList(employeeList);
    }

}
