package com.practice.restaurant.domain;

import java.util.List;

public interface IRestaurantPersistencePort {

    void saveRestaurant(Restaurant restaurant);

    List<Restaurant> getAllRestaurants();

    Restaurant getRestaurantByName(String name);

    void updateRestaurant(Restaurant restaurant);

    void deleteRestaurant(Long restaurantId);

}
