package com.async.asyncMuseum.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Map;



public class MyResponse {

    /**
     * @param status le status de la reponse HttpStatus
     * @param message  le message de la response
     * @param data le / les donnees a retourner
     * @return Le map acec les parametres
     */
    public static ResponseEntity<Object> response(HttpStatus status, String message, Object data) {
        Map<String, Object> map = Map.of();
        map.put("code", status.value());
        map.put("message", message);

        if (data != null){
            if (status == HttpStatus.BAD_REQUEST) map.put("errors", data);
            else map.put("data", data);
        }
        return new ResponseEntity<>(map, status);
    }

}
