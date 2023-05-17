package com.api.queviagem.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.api.queviagem.models.RatingModel;
import com.api.queviagem.repositories.RatingRepository;

import jakarta.transaction.Transactional;

@Service
public class RatingService {
    final RatingRepository ratingRepository;

    public RatingService(RatingRepository ratingRepository) {
        this.ratingRepository = ratingRepository;
    }

    @Transactional
    public RatingModel save(RatingModel ratingModel) {
        return ratingRepository.save(ratingModel);
    }


    public List<RatingModel> getRatings(int fk_id_package_rating) {
        return ratingRepository.getRatings(fk_id_package_rating);
    }

    // public boolean existsByFk_id_user_rating(int idUser) {
    //     return ratingRepository.existsByFk_id_user_rating(idUser);
    // }
}
