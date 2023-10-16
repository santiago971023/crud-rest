package com.practice.restaurant.application;

import com.practice.restaurant.domain.IRestaurantServicePort;
import com.practice.restaurant.domain.Restaurant;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RestaurantHandlerImpl implements IRestaurantHandler{

    private final IRestaurantServicePort restaurantServicePort;
    private final IRestaurantRequestMapper restaurantRequestMapper;
    private final IRestaurantResponseMapper restaurantResponseMapper;


    @Override
    public void saveRestaurantInApp(RestaurantRequestDto restaurantRequestDto) {
        Restaurant restaurant = restaurantRequestMapper.toRestaurant(restaurantRequestDto);
        restaurantServicePort.saveRestaurant(restaurant);
    }

    @Override
    public List<RestaurantResponseDto> getAllRestaurantsFromApp() {
        return restaurantResponseMapper.toResponseList(restaurantServicePort.getAllRestaurants());
    }

    @Override
    public RestaurantResponseDto getRestaurantByName(String name) {
        return restaurantResponseMapper.toResponse(restaurantServicePort.getRestaurantByName(name));
    }

    @Override
    public void updateRestaurant(RestaurantRequestDto restaurantRequestDto) {
        Restaurant restaurant = restaurantRequestMapper.toRestaurant(restaurantRequestDto);
        restaurantServicePort.updateRestaurant(restaurant);
    }

    @Override
    public void deleteRestaurant(Long restaurantId) {
        restaurantServicePort.deleteRestaurant(restaurantId);
    }
}
