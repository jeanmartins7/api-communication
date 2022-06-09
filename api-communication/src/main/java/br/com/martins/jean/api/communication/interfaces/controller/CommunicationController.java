package br.com.martins.jean.api.communication.interfaces.controller;

import br.com.martins.jean.api.communication.interfaces.json.request.Request;
import br.com.martins.jean.api.communication.services.CommunicationService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@AllArgsConstructor
public class CommunicationController {

    private final CommunicationService communicationService;

    @PostMapping
    public ResponseEntity<Void>postCommunication(@RequestBody Request request){

        communicationService.postCommunication(request);

        return null;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCommunication(
            @PathVariable UUID id
            ){

        communicationService.deleteCommunication(id);

        return ResponseEntity
                .noContent()
                .build();
    }

}
