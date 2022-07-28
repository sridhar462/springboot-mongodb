package com.learnfromexamples.springbootmongodb.controller;

import com.learnfromexamples.springbootmongodb.model.Employee;
import com.learnfromexamples.springbootmongodb.services.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
public class EmployeeController {
    private final EmployeeService employeeService;

    @GetMapping("/employees")
    public List<Employee> getAllEmployees(){
        return employeeService.getAllEmployees();
    }

    @GetMapping("/employee/{firstName}")
    public List<Employee> findByFirstName(@PathVariable("firstName") String  firstName){
        return employeeService.findByFirstName(firstName);
    }

    @GetMapping("/employee")
    public List<Employee> findByLastName(@RequestParam("lastName") String  lastName){
        return employeeService.findByLastName(lastName);
    }

    @GetMapping("/employees/{employeeId}")
    public Employee getEmployee(@PathVariable("employeeId") int  employeeId){
        return employeeService.getEmployee(employeeId);
    }

    @DeleteMapping("/delete/{employeeId}")
    public void deleteEmployee(@PathVariable( "employeeId") int  employeeId){
        employeeService.delete(employeeId);
    }

    @PostMapping("/add")
    public Employee saveEmployee(@RequestBody Employee employee){
       return employeeService.save(employee);
    }


    @PutMapping("/update/{employeeId}")
    public Employee deleteEmployee(@PathVariable( "employeeId") int  employeeId, @RequestBody Employee employee){
       return employeeService.update(employeeId, employee);
    }

    @GetMapping("/betweenSalary/{minSalary}/{maxSalary}")
    public List<Employee> findEmployeesBetween(@PathVariable("minSalary") double  minSalary, @PathVariable("maxSalary") double  maxSalary){
        return employeeService.findEmployeesBetween(minSalary, maxSalary);
    }
}
