package com.api.queviagem.models;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "package")

public class PackageModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_package;
    @Column(nullable = false)
    private LocalDate insertdate_package;
    @Column(nullable = false)
    private LocalDate updatedate_package;
    @Column(nullable = false)
    private int size_group_package;
    @Column(nullable = false)
    private Float price_package;
    @Column(nullable = false)
    private Boolean finished_package;
    @Column(nullable = false)
    private LocalDate init_date_travel_package;
    @Column(nullable = false)
    private LocalDate final_date_travel_package;
    @Column(nullable = false)
    private String destiny_package;
    @Column(nullable = false)
    private String title_package;
    @Column(nullable = false)
    private String description_package;


    public int getId_package() {
        return this.id_package;
    }

    public void setId_package(int id_package) {
        this.id_package = id_package;
    }

    public LocalDate getInsertdate_package() {
        return this.insertdate_package;
    }

    public void setInsertdate_package(LocalDate insertdate_package) {
        this.insertdate_package = insertdate_package;
    }

    public LocalDate getUpdatedate_package() {
        return this.updatedate_package;
    }

    public void setUpdatedate_package(LocalDate updatedate_package) {
        this.updatedate_package = updatedate_package;
    }

    public int getSize_group_package() {
        return this.size_group_package;
    }

    public void setSize_group_package(int size_group_package) {
        this.size_group_package = size_group_package;
    }

    public Float getPrice_package() {
        return this.price_package;
    }

    public void setPrice_package(Float price_package) {
        this.price_package = price_package;
    }

    public Boolean isFinished_package() {
        return this.finished_package;
    }

    public Boolean getFinished_package() {
        return this.finished_package;
    }

    public void setFinished_package(Boolean finished_package) {
        this.finished_package = finished_package;
    }

    public LocalDate getInit_date_travel_package() {
        return this.init_date_travel_package;
    }

    public void setInit_date_travel_package(LocalDate init_date_travel_package) {
        this.init_date_travel_package = init_date_travel_package;
    }

    public LocalDate getFinal_date_travel_package() {
        return this.final_date_travel_package;
    }

    public void setFinal_date_travel_package(LocalDate final_date_travel_package) {
        this.final_date_travel_package = final_date_travel_package;
    }

    public String getDestiny_package() {
        return this.destiny_package;
    }

    public void setDestiny_package(String destiny_package) {
        this.destiny_package = destiny_package;
    }

    public String getTitle_package() {
        return this.title_package;
    }

    public void setTitle_package(String title_package) {
        this.title_package = title_package;
    }

    public String getDescription_package() {
        return this.description_package;
    }

    public void setDescription_package(String description_package) {
        this.description_package = description_package;
    }

}
