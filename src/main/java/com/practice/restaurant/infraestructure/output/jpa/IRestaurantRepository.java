package com.practice.restaurant.infraestructure.output.jpa;

import com.practice.restaurant.domain.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IRestaurantRepository extends JpaRepository<RestaurantEntity, Long> {

    Optional<RestaurantEntity> findByName(String name);

}
