package com.api.queviagem.dtos;

import java.time.LocalDate;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class RatingDto {
    @NotNull
    private int note_rating;
    @NotBlank
    private String comment_rating;
    @NotNull
    private int fk_id_user_rating;
    @NotNull
    private int fk_id_package_rating;
    private LocalDate date_rating;


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

    public int getFk_id_user_rating() {
        return this.fk_id_user_rating;
    }

    public void setFk_id_user_rating(int fk_id_user_rating) {
        this.fk_id_user_rating = fk_id_user_rating;
    }

    public int getFk_id_package_rating() {
        return this.fk_id_package_rating;
    }

    public void setFk_id_package_rating(int fk_id_package_rating) {
        this.fk_id_package_rating = fk_id_package_rating;
    }

    public LocalDate getDate_rating() {
        return this.date_rating;
    }

    public void setDate_rating(LocalDate date_rating) {
        this.date_rating = date_rating;
    }

}
