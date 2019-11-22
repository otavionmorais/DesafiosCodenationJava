package com.challenge.repository;

import com.challenge.entity.Candidate;
import com.challenge.entity.CandidateId;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CandidateRepository extends CrudRepository<Candidate,Long> {

    @Query("SELECT can FROM Candidate can WHERE can.id = :id")
    Optional<Candidate> findById(@Param("id") CandidateId id);

    @Query("SELECT can FROM Candidate can WHERE can.id.user.id = :userId AND can.id.company.id = :companyId AND " +
            "can.id.acceleration.id = :accelerationId")
    Optional<Candidate> findById(@Param("userId") Long userId, @Param("companyId") Long companyId, @Param("accelerationId") Long accelerationId);

    @Query("SELECT can FROM Candidate can WHERE can.id.company.id = :companyId")
    List<Candidate> findByCompanyId(@Param("companyId") Long companyId);

    @Query("SELECT can FROM Candidate can WHERE can.id.acceleration.id = :accelerationId")
    List<Candidate> findByAccelerationId(@Param("accelerationId") Long accelerationId);

}
