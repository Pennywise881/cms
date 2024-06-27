package com.example.cms.employee;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmployeeDetailsRepository extends JpaRepository<EmployeeDetails, Long> {

    @Query("select ed from EmployeeDetails ed where ed.employee.id = ?1")
    Optional<EmployeeDetails> findDetailsByEmployeeId(Long id);

}
