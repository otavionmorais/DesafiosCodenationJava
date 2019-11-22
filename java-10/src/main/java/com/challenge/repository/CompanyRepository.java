package com.challenge.repository;

import com.challenge.entity.Company;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CompanyRepository extends CrudRepository<Company,Long> {

    @Query("SELECT com FROM Company com WHERE com.id = :id")
    Optional<Company> findById(@Param("id") Long id);

    @Query("SELECT can.id.company FROM Company com JOIN com.candidates can WHERE can.id.acceleration.id = :accelerationId")
    List<Company> findByAccelerationId(@Param("accelerationId") Long accelerationId);

    @Query("SELECT com FROM Company com JOIN com.candidates can WHERE can.id.user.id = :userId")
    List<Company> findByUserId(@Param("userId") Long userId);

}
