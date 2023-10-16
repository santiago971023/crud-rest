package com.practice.restaurant.domain.exception;

public enum ErrorMessages {

        // RESTAURANTS
        NAME_INVALID("El nombre no puede estar vacío."),
        USER_NOT_FOUND("No hemos encontrado el usuario que nos indicaste."),
        ADDRESS_INVALID("La dirección proporcionada no es válida."),
        PHONE_INVALID("El número de telefono no es válido.");

        private final String message;

        ErrorMessages(String message) {
            this.message = message;
        }

        public String getMessage() {
            return message;
        }

}
