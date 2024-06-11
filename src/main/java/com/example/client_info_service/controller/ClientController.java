package com.example.client_info_service.controller;

import com.example.client_info_service.model.Client;
import com.example.client_info_service.exception.ClientNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/clients")
public class ClientController {
    @GetMapping("/{type}/{number}")
    public ResponseEntity<Client> getClientInfo(@PathVariable String type, @PathVariable String number) {
        if (!type.equalsIgnoreCase("C") && !type.equalsIgnoreCase("P")) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        if (type.equalsIgnoreCase("C") && number.equals("23445322")) {
            Client client = new Client("Juan", "Carlos", "Perez", "Gomez", "555123456", "Calle Falsa 123", "Bogotá");
            return new ResponseEntity<>(client, HttpStatus.OK);
        } else {
            throw new ClientNotFoundException("Client not found with document type " + type + " and number " + number);
        }
    }
}
