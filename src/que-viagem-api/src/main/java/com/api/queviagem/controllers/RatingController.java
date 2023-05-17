package com.api.queviagem.controllers;

import java.time.LocalDate;
import java.time.ZoneId;

import java.util.List;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.api.queviagem.dtos.RatingDto;
import com.api.queviagem.models.RatingModel;
import com.api.queviagem.services.RatingService;

import jakarta.validation.Valid;

@RestController
@CrossOrigin
@RequestMapping("/ratings")
public class RatingController {

    final RatingService ratingService;

    public RatingController(RatingService ratingService) {
        this.ratingService = ratingService;
    }
    
    @PostMapping
    public ResponseEntity<Object> saveRating(@RequestBody @Valid RatingDto ratingDto) {
        var ratingModel = new RatingModel();
        // this.validateExists(ratingDto);
        BeanUtils.copyProperties(ratingDto, ratingModel);
        ratingModel.setDate_rating(LocalDate.now(ZoneId.of("UTC")));
        return ResponseEntity.status(HttpStatus.CREATED).body(ratingService.save(ratingModel));
    }

    

    @GetMapping("/get-ratings")
	public ResponseEntity<List<RatingModel>> index(@RequestParam(name = "fk_id_package_rating") int fk_id_package_rating) {

		ResponseEntity<List<RatingModel>> all = ResponseEntity.status(HttpStatus.OK)
				.body(ratingService.getRatings(fk_id_package_rating));
		return all;
	}

    // private void validateExists(RatingDto ratingDto) {
    //     if (ratingService.existsByFk_id_user_rating(ratingDto.getUser_id_rating())) {
    //         // PlateAlreadyInUseException.throwException();
    //     }
    //     // if (ratingService.existsByParkingSpotNumber(ratingDto.getParkingSpotNumber())) {
    //     //     // ParkingSpotAlreadyInUseException.throwException();
    //     // }
    // }
}
