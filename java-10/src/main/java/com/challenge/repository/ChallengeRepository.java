package com.challenge.repository;

import com.challenge.entity.Challenge;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChallengeRepository extends CrudRepository<Challenge,Long> {

    @Query("SELECT cha FROM Challenge cha JOIN cha.accelerations acc JOIN acc.candidates can WHERE " +
            "can.id.user.id = :userId AND acc.id = :accelerationId")
    //@Query("SELECT ac FROM Acceleration ac JOIN ac.candidates cand WHERE cand.id.company.id = :companyId")
    List<Challenge> findByAccelerationIdAndUserId(@Param("accelerationId") Long accelerationId, @Param("userId") Long userId);

}
