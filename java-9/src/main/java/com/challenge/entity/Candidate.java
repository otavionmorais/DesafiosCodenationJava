package com.challenge.entity;

import com.challenge.entity.ids.CandidateId;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.Objects;

@Entity(name = "candidate")
@EntityListeners({})
@Table(name = Candidate.TABLE_NAME)
public class Candidate {

    public static final String TABLE_NAME="candidate";

    public Candidate(){

    }

    @EmbeddedId
    @NotNull
    private CandidateId candidateId;

    @NotNull
    private int status;

    @CreatedDate
    @Column(name = "created_at")
    private Date created_at;

    public static String getTableName() {
        return TABLE_NAME;
    }

    public CandidateId getCandidateId() {
        return candidateId;
    }

    public void setCandidateId(CandidateId candidateId) {
        this.candidateId = candidateId;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Candidate candidate = (Candidate) o;
        return status == candidate.status &&
                Objects.equals(candidateId, candidate.candidateId) &&
                Objects.equals(created_at, candidate.created_at);
    }

    @Override
    public int hashCode() {
        return Objects.hash(candidateId, status, created_at);
    }
}
