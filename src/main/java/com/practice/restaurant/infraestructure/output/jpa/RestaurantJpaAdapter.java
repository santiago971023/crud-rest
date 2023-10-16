package com.practice.restaurant.infraestructure.output.jpa;

import com.practice.restaurant.domain.IRestaurantPersistencePort;
import com.practice.restaurant.domain.Restaurant;
import com.practice.restaurant.infraestructure.exception.NoDataFoundException;
import com.practice.restaurant.infraestructure.exception.RestaurantAlreadyExistException;
import com.practice.restaurant.infraestructure.exception.RestaurantNotFoundException;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class RestaurantJpaAdapter implements IRestaurantPersistencePort {

    private final IRestaurantRepository restaurantRepository;

    private final IRestaurantEntityMapper restaurantEntityMapper;


    @Override
    public void saveRestaurant(Restaurant restaurant) {
        if (restaurantRepository.findByName(restaurant.getName()).isPresent()){
            throw new RestaurantAlreadyExistException();
        }
        restaurantRepository.save(restaurantEntityMapper.toEntity(restaurant));
    }

    @Override
    public List<Restaurant> getAllRestaurants() {
        List<RestaurantEntity> restaurantEntityList = restaurantRepository.findAll();
        if (restaurantEntityList.isEmpty()){
            throw new NoDataFoundException();
        }
        return restaurantEntityMapper.toRestaurantList(restaurantEntityList);
    }

    @Override
    public Restaurant getRestaurantByName(String name) {
        return restaurantEntityMapper.toRestaurant(restaurantRepository.findByName(name)
                .orElseThrow(RestaurantNotFoundException::new));
    }

    @Override
    public void updateRestaurant(Restaurant restaurant) {
        restaurantRepository.save(restaurantEntityMapper.toEntity(restaurant));
    }

    @Override
    public void deleteRestaurant(Long restaurantId) {
        restaurantRepository.deleteById(restaurantId);
    }
}
