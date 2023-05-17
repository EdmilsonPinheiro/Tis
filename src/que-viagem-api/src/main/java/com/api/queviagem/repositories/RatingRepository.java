package com.api.queviagem.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.yaml.snakeyaml.events.Event.ID;

import com.api.queviagem.models.RatingModel;

@Repository
public interface RatingRepository extends JpaRepository<RatingModel, ID> {

    // boolean existsByFk_id_user_rating(int userId);
    // boolean existsByPackageId(int packageId);

    @Query(value = "SELECT * FROM ratings WHERE fk_id_package_rating = ?1", nativeQuery = true)
    List<RatingModel> getRatings(int idPackage);
}
