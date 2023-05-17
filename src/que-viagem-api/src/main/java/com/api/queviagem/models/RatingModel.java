package com.api.queviagem.models;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "ratings")

public class RatingModel implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id_rating;
    @Column(nullable = false)
    private int fk_id_package_rating;
    @Column(nullable = false)
    private int fk_id_user_rating;
    @Column(nullable = false)
    private int note_rating;
    @Column(nullable = false)
    private String comment_rating;
    @Column(nullable = false, length = 255)
    private LocalDate date_rating;


    public int getId_rating() {
        return this.id_rating;
    }

    public void setId_rating(int id_rating) {
        this.id_rating = id_rating;
    }

    public int getFk_id_package_rating() {
        return this.fk_id_package_rating;
    }

    public void setFk_id_package_rating(int fk_id_package_rating) {
        this.fk_id_package_rating = fk_id_package_rating;
    }

    public int getFk_id_user_rating() {
        return this.fk_id_user_rating;
    }

    public void setFk_id_user_rating(int fk_id_user_rating) {
        this.fk_id_user_rating = fk_id_user_rating;
    }

    public int getNote_rating() {
        return this.note_rating;
    }

    public void setNote_rating(int note_rating) {
        this.note_rating = note_rating;
    }

    public String getComment_rating() {
        return this.comment_rating;
    }

    public void setComment_rating(String comment_rating) {
        this.comment_rating = comment_rating;
    }

    public LocalDate getDate_rating() {
        return this.date_rating;
    }

    public void setDate_rating(LocalDate date_rating) {
        this.date_rating = date_rating;
    }
}
