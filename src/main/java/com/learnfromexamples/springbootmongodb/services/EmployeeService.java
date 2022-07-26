package com.learnfromexamples.springbootmongodb.services;

import com.learnfromexamples.springbootmongodb.model.Employee;
import com.learnfromexamples.springbootmongodb.repository.EmployeeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class EmployeeService {
    private final EmployeeRepository employeeRepository;
    private final SequenceGeneratorService sequenceGeneratorService;
    public Employee save(Employee employee){
        employee.setId(sequenceGeneratorService.generateSequence(Employee.SEQUENCE_NAME));
        return employeeRepository.save(employee);
    }

    public List<Employee> getAllEmployees(){
        return employeeRepository.findAll();
    }

    public Employee getEmployee(int  employeeId){
        return employeeRepository.findById(employeeId).get();
    }

    public  List<Employee> findByFirstName(String  employeeName){
        return employeeRepository.findByFirstName(employeeName);
    }

    public  List<Employee> findByLastName(String  employeeName){
        return employeeRepository.findByLastName(employeeName);
    }



    public Employee update(int  employeeId, Employee employee){
        Employee existingEmployee = employeeRepository.findById(employeeId).get();
        existingEmployee = employee;
        existingEmployee.setId(employeeId);
        return employeeRepository.save(existingEmployee);
    }

    public  void delete(int  employeeId){
        employeeRepository.deleteById(employeeId);
    }
}
