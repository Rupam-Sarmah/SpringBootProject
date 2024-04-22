package com.example.march;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee, Integer> {
    // Custom query methods, if needed
}

	//Employee findByEmployeeId(int id);

