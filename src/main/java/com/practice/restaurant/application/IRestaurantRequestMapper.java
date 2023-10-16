package com.practice.restaurant.application;

import com.practice.restaurant.domain.Restaurant;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
    unmappedSourcePolicy = ReportingPolicy.IGNORE,
    unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface IRestaurantRequestMapper {

    Restaurant toRestaurant(RestaurantRequestDto restaurantRequestDto);

}
