package com.practice.restaurant.domain;

import org.apache.catalina.LifecycleState;

import java.util.List;

public interface IRestaurantServicePort {

    void saveRestaurant(Restaurant restaurant);

    List<Restaurant> getAllRestaurants();

    Restaurant getRestaurantByName(String name);

    void updateRestaurant(Restaurant restaurant);

    void deleteRestaurant(Long restaurantId);

}
