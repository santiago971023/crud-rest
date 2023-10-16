package com.practice.restaurant.application;

import com.practice.restaurant.domain.Restaurant;

import java.util.List;

public interface IRestaurantHandler {

    void saveRestaurantInApp(RestaurantRequestDto restaurantRequestDto);

    List<RestaurantResponseDto> getAllRestaurantsFromApp();

    RestaurantResponseDto getRestaurantByName(String name);

    void updateRestaurant(RestaurantRequestDto restaurantRequestDto);

    void deleteRestaurant(Long restaurantId);

}
