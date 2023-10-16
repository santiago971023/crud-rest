package com.practice.restaurant.infraestructure.output.jpa;


import com.practice.restaurant.domain.Restaurant;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring",
    unmappedTargetPolicy = ReportingPolicy.IGNORE,
    unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface IRestaurantEntityMapper {

    RestaurantEntity toEntity(Restaurant restaurant);

    Restaurant toRestaurant(RestaurantEntity restaurantEntity);

    List<Restaurant> toRestaurantList(List<RestaurantEntity> restaurantEntityList);

}
