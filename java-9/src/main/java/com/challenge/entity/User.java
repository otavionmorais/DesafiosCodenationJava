package com.challenge.entity;

import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Entity
@EntityListeners({})
@Table(name = User.TABLE_NAME)
public class User {

    public static final String TABLE_NAME="user";

    public User(){

    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToMany
    @NotNull
    List<Submission> submissions;

    @OneToMany
    @NotNull
    List<Candidate> candidates;

    @NotNull
    @NotBlank
    @Size(max = 100)
    private String fullname;

    @NotNull
    @NotBlank
    @Email
    @Size(max = 100)
    private String email;

    @NotNull
    @NotBlank
    @Size(max = 50)
    private String nickname;

    @NotNull
    @NotBlank
    @Size(max = 255)
    private String password;

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

    public List<Submission> getSubmissions() {
        return submissions;
    }

    public void setSubmissions(List<Submission> submissions) {
        this.submissions = submissions;
    }

    public List<Candidate> getCandidates() {
        return candidates;
    }

    public void setCandidates(List<Candidate> candidates) {
        this.candidates = candidates;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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
        User user = (User) o;
        return Objects.equals(id, user.id) &&
                Objects.equals(submissions, user.submissions) &&
                Objects.equals(candidates, user.candidates) &&
                Objects.equals(fullname, user.fullname) &&
                Objects.equals(email, user.email) &&
                Objects.equals(nickname, user.nickname) &&
                Objects.equals(password, user.password) &&
                Objects.equals(created_at, user.created_at);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, submissions, candidates, fullname, email, nickname, password, created_at);
    }
}
