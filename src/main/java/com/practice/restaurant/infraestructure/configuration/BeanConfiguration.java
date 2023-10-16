package com.practice.restaurant.infraestructure.configuration;

import com.practice.restaurant.domain.IRestaurantPersistencePort;
import com.practice.restaurant.domain.IRestaurantServicePort;
import com.practice.restaurant.domain.RestaurantUseCase;
import com.practice.restaurant.infraestructure.output.jpa.IRestaurantEntityMapper;
import com.practice.restaurant.infraestructure.output.jpa.IRestaurantRepository;
import com.practice.restaurant.infraestructure.output.jpa.RestaurantJpaAdapter;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class BeanConfiguration {

    private final IRestaurantRepository restaurantRepository;

    private final IRestaurantEntityMapper restaurantEntityMapper;

    @Bean
    public IRestaurantPersistencePort restaurantPersistencePort(){
        return new RestaurantJpaAdapter(restaurantRepository, restaurantEntityMapper);
    }


    @Bean
    public IRestaurantServicePort restaurantServicePort(){
        return new RestaurantUseCase(restaurantPersistencePort());
    }


}
