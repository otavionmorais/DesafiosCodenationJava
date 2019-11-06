package com.challenge.entity;

import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Entity
@EntityListeners({})
@Table(name = Challenge.TABLE_NAME)
public class Challenge {

    public static final String TABLE_NAME="challenge";

    public Challenge(){

    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull
    @OneToMany
    private List<Acceleration> accelerations;

    @NotNull
    @OneToMany
    private List<Submission> submissions;

    @NotBlank
    @NotNull
    @Size(max = 100)
    private String name;

    @NotBlank
    @NotNull
    @Size(max = 50)
    private String slug;

    @CreatedDate
    @Column(name = "created_at")
    private Date created_at;

    public static String getTableName() {
        return TABLE_NAME;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<Acceleration> getAccelerations() {
        return accelerations;
    }

    public void setAccelerations(List<Acceleration> accelerations) {
        this.accelerations = accelerations;
    }

    public List<Submission> getSubmissions() {
        return submissions;
    }

    public void setSubmissions(List<Submission> submissions) {
        this.submissions = submissions;
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
        Challenge challenge = (Challenge) o;
        return Objects.equals(id, challenge.id) &&
                Objects.equals(accelerations, challenge.accelerations) &&
                Objects.equals(submissions, challenge.submissions) &&
                Objects.equals(name, challenge.name) &&
                Objects.equals(slug, challenge.slug) &&
                Objects.equals(created_at, challenge.created_at);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, accelerations, submissions, name, slug, created_at);
    }
}
