package com.learnfromexamples.springbootmongodb.repository;

import com.learnfromexamples.springbootmongodb.model.Employee;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends MongoRepository<Employee, Integer> {

    @Query("{'firstName':?0}")
    List<Employee> findByFirstName(String firstName);

    @Query("{'lastName': :#{#lastName}}")
    List<Employee> findByLastName( @Param("lastName") String lastName);

    @Query(value = "{'salary': {'$gte': :#{#minSalary}, '$lte': :#{#maxSalary}}}")
    List<Employee> findEmployeesBetween(@Param("minSalary")Double minSalary, @Param("maxSalary") Double maxSalary);
}
