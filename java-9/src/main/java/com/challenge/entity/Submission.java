package com.challenge.entity;

import com.challenge.entity.ids.SubmissionId;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.Objects;


@Entity(name = "submission")
@EntityListeners({})
@Table(name = Submission.TABLE_NAME)
public class Submission {

    public static final String TABLE_NAME="submission";

    public Submission(){

    }

    @EmbeddedId
    @NotNull
    private SubmissionId submissionId;

    @NotNull
    private float score;

    @CreatedDate
    @Column(name = "created_at")
    private Date created_at;

    public static String getTableName() {
        return TABLE_NAME;
    }

    public SubmissionId getSubmissionId() {
        return submissionId;
    }

    public void setSubmissionId(SubmissionId submissionId) {
        this.submissionId = submissionId;
    }

    public float getScore() {
        return score;
    }

    public void setScore(float score) {
        this.score = score;
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
        Submission that = (Submission) o;
        return Float.compare(that.score, score) == 0 &&
                Objects.equals(submissionId, that.submissionId) &&
                Objects.equals(created_at, that.created_at);
    }

    @Override
    public int hashCode() {
        return Objects.hash(submissionId, score, created_at);
    }
}
