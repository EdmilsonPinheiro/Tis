package com.api.queviagem.repositories;

import java.time.LocalDate;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

import com.api.queviagem.models.PackageModel;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface PackageRepository extends JpaRepository<PackageModel, LocalDate> {
    @Query(value = "SELECT * FROM package WHERE finished_package = 1 AND init_date_travel_package = ?1 AND final_date_travel_package = ?2", nativeQuery = true)
    List<PackageModel> getFinishedPackages(LocalDate initialDate, LocalDate finalDate);

    @Query(value = "SELECT * FROM package WHERE id_package = ?1", nativeQuery = true)
    Optional<PackageModel> getPackageById(int idPackage);

}
