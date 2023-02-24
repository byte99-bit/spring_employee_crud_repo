package com.monotechie.EmpDetails.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.monotechie.EmpDetails.model.Employee;

@Repository
public interface EmpRepo extends JpaRepository<Employee,Long> {

}
