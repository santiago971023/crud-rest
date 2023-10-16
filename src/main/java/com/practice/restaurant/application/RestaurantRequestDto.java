package com.practice.restaurant.application;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RestaurantRequestDto {

    @NotBlank(message = "El id no puede estar en blanco.")
    private Long id;

    @NotBlank(message = "El nombre del usuario no puede estar en blanco.")
    @Size(max = 20, message = "El nombre no puede tener más de 20 caracteres.")
    private String name;

    @NotBlank(message = "La dirección no puede estar en blanco")
    @Size(max = 30, message = "La dirección no puede tener más de 30 caracteres")
    private String address;

    @Pattern(regexp = "^[0-9]{10}$", message = "El número de teléfono debe contener 10 dígitos numéricos.")
    private String phone;


}
