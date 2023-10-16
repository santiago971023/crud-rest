package com.practice.restaurant.domain;

import com.practice.restaurant.domain.exception.ErrorMessages;
import com.practice.restaurant.domain.exception.RestaurantValidationException;

import java.util.List;

public class RestaurantUseCase implements IRestaurantServicePort{

    private final IRestaurantPersistencePort restaurantPersistencePort;

    public RestaurantUseCase(IRestaurantPersistencePort restaurantPersistencePort) {
        this.restaurantPersistencePort = restaurantPersistencePort;
    }

    @Override
    public void saveRestaurant(Restaurant restaurant) {
        if (!isValidName(restaurant.getName())){
            throw new RestaurantValidationException(ErrorMessages.NAME_INVALID.getMessage());
        }
        if (!isValidAddress(restaurant.getAddress())){
            throw new RestaurantValidationException(ErrorMessages.ADDRESS_INVALID.getMessage());
        }
        if (!isValidPhoneNumber(restaurant.getPhone())){
            throw new RestaurantValidationException(ErrorMessages.PHONE_INVALID.getMessage());
        }
        restaurantPersistencePort.saveRestaurant(restaurant);
    }

    @Override
    public List<Restaurant> getAllRestaurants() {
        return restaurantPersistencePort.getAllRestaurants();
    }

    @Override
    public Restaurant getRestaurantByName(String name) {
        return restaurantPersistencePort.getRestaurantByName(name);
    }

    @Override
    public void updateRestaurant(Restaurant restaurant) {
        if (!isValidName(restaurant.getName())){
            throw new RestaurantValidationException(ErrorMessages.NAME_INVALID.getMessage());
        }
        if (!isValidAddress(restaurant.getAddress())){
            throw new RestaurantValidationException(ErrorMessages.ADDRESS_INVALID.getMessage());
        }
        if (!isValidPhoneNumber(restaurant.getPhone())){
            throw new RestaurantValidationException(ErrorMessages.PHONE_INVALID.getMessage());
        }
        Restaurant updatedRestaurant = new Restaurant(restaurant.getName(), restaurant.getAddress(), restaurant.getPhone());
        restaurantPersistencePort.updateRestaurant(updatedRestaurant);
    }

    @Override
    public void deleteRestaurant(Long restaurantId) {
        restaurantPersistencePort.deleteRestaurant(restaurantId);
    }



    // VALIDACIONES CORRESPONDIENTES A LA CAPA DEL DOMINIO
    // En esta capa se hacen las validaciones para que el usuario digite un nombre válido (solo letras y números) y que no este vacío
    public boolean isValidName(String name) {
        if (name == null || name.isEmpty()) {
            return false;
        }
        // Usamos una expresión regular para verificar que el nombre contenga solo letras
        String regex = "^[A-Za-z]+$";
        return name.matches(regex);
    }

    // Validamos que la dirección también cumpla con lo que pretendemos
    public boolean isValidAddress(String address){
        if( address == null || address.isEmpty()){
            return false;
        }
        String regex = "^[a-zA-Z0-9\\s#-]*$";

        return address.matches(regex);
    }


    public boolean isValidPhoneNumber(String phoneNumber) {

        if (phoneNumber == null || phoneNumber.isEmpty()) {
            return false;
        }

        // Verificar que el número de teléfono tenga exactamente 10 dígitos y tenga solo números
        return phoneNumber.length() == 10 && phoneNumber.matches("^\\d+$");
    }

}
