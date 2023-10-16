package com.practice.restaurant.infraestructure.input.rest;


import com.practice.restaurant.application.IRestaurantHandler;
import com.practice.restaurant.application.IRestaurantResponseMapper;
import com.practice.restaurant.application.RestaurantRequestDto;
import com.practice.restaurant.application.RestaurantResponseDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/restaurant")
@RequiredArgsConstructor
public class RestaurantRestController {

    private final IRestaurantHandler restaurantHandler;

    @Operation(summary = "Add a new object")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Object created", content = @Content),
            @ApiResponse(responseCode = "409", description = "Object already exists", content = @Content)
    })
    @PostMapping("/")
    public ResponseEntity<Void> saveRestaurantInApp(@RequestBody RestaurantRequestDto restaurantRequestDto){
        restaurantHandler.saveRestaurantInApp(restaurantRequestDto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
    @Operation(summary = "Actualizar un restaurante en la aplicación")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Restaurante actualizado exitosamente"),
            @ApiResponse(responseCode = "400", description = "Solicitud incorrecta")
    })
    @PutMapping("/")
    public ResponseEntity<RestaurantResponseDto> updateRestaurantInApp(@RequestBody RestaurantRequestDto restaurantRequestDto){
        restaurantHandler.updateRestaurant(restaurantRequestDto);
        return ResponseEntity.noContent().build();
    }


    @Operation(summary = "Get all objects")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "All objects returned",
                    content = @Content(mediaType = "application/json",
                            array = @ArraySchema(schema = @Schema(implementation = RestaurantResponseDto.class)))),
            @ApiResponse(responseCode = "404", description = "No data found", content = @Content)
    })
    @GetMapping("/")
    public ResponseEntity<List<RestaurantResponseDto>> getAllRestaurantsFromApp(){
        return ResponseEntity.ok(restaurantHandler.getAllRestaurantsFromApp());
    }


    @Operation(summary = "Get object by name")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Objects returned",
                    content = @Content(mediaType = "application/json",
                            array = @ArraySchema(schema = @Schema(implementation = RestaurantResponseDto.class)))),
            @ApiResponse(responseCode = "404", description = "No data found", content = @Content)
    })
    @GetMapping("/name/{name}")
    public ResponseEntity<RestaurantResponseDto> getRestaurantByNameFromApp(@PathVariable(name = "name") String name){
        return ResponseEntity.ok(restaurantHandler.getRestaurantByName(name));
    }

}
