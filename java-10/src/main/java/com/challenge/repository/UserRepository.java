package com.challenge.repository;

import com.challenge.entity.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<User,Long> {

    @Query("SELECT usr FROM User usr WHERE usr.id = :userId")
    Optional<User> findById(@Param("userId") Long userId);

    @Query("SELECT usr FROM User usr JOIN usr.candidates can WHERE can.id.acceleration.name = :name")
    List<User> findByAccelerationName(@Param("name") String name);

    @Query("SELECT usr FROM User usr JOIN usr.candidates can WHERE can.id.company.id = :companyId")
    List<User> findByCompanyId(@Param("companyId") Long companyId);

}
