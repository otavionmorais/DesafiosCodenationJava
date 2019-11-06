package com.challenge.entity;

import com.challenge.entity.ids.AccelerationId;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = Acceleration.TABLE_NAME)
@EntityListeners({})
public class Acceleration {

    public static final String TABLE_NAME="acceleration";

    @EmbeddedId
    private AccelerationId accelerationId;

    @NotNull
    @OneToMany
    private List<Candidate> candidates;

    @NotNull
    @ManyToOne
    private Challenge challenge;

    @NotNull
    @NotBlank
    @Size(max = 100)
    private String name;

    @NotNull
    @NotBlank
    @Size(max = 50)
    private String slug;

    @CreatedDate
    @Column(name = "created_at")
    private Date created_at;


    public static String getTableName() {
        return TABLE_NAME;
    }

    public AccelerationId getAccelerationId() {
        return accelerationId;
    }

    public void setAccelerationId(AccelerationId accelerationId) {
        this.accelerationId = accelerationId;
    }

    public List<Candidate> getCandidates() {
        return candidates;
    }

    public void setCandidates(List<Candidate> candidates) {
        this.candidates = candidates;
    }

    public Challenge getChallenge() {
        return challenge;
    }

    public void setChallenge(Challenge challenge) {
        this.challenge = challenge;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
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
        Acceleration that = (Acceleration) o;
        return Objects.equals(accelerationId, that.accelerationId) &&
                Objects.equals(candidates, that.candidates) &&
                Objects.equals(challenge, that.challenge) &&
                Objects.equals(name, that.name) &&
                Objects.equals(slug, that.slug) &&
                Objects.equals(created_at, that.created_at);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accelerationId, candidates, challenge, name, slug, created_at);
    }
}
