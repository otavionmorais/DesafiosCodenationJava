package com.challenge.repository;

import com.challenge.entity.Acceleration;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AccelerationRepository extends CrudRepository<Acceleration,Long> {

    @Query("SELECT ac FROM Acceleration ac WHERE ac.id = :id")
    Optional<Acceleration> findById(@Param("id") Long id);

    @Query("SELECT ac FROM Acceleration ac JOIN ac.candidates cand WHERE cand.id.company.id = :companyId")
    List<Acceleration> findByCompanyId(@Param("companyId")Long companyId);

}
