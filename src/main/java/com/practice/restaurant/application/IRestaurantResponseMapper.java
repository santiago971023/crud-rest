package com.practice.restaurant.application;

import com.practice.restaurant.domain.Restaurant;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring",
        unmappedSourcePolicy = ReportingPolicy.IGNORE,
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface IRestaurantResponseMapper {

    RestaurantResponseDto toResponse(Restaurant restaurant);

    List<RestaurantResponseDto> toResponseList(List<Restaurant> restaurantList);

}
