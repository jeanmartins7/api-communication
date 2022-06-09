package br.com.martins.jean.api.communication.interfaces.controller;

import br.com.martins.jean.api.communication.interfaces.json.request.CommunicationRequest;
import br.com.martins.jean.api.communication.interfaces.json.response.CommunicationResponse;
import br.com.martins.jean.api.communication.interfaces.json.response.StatusResponse;
import br.com.martins.jean.api.communication.services.CommunicationService;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@AllArgsConstructor
@RequestMapping(value = "/communications",
        produces = MediaType.APPLICATION_JSON_VALUE,
        consumes = MediaType.APPLICATION_JSON_VALUE)
public class CommunicationController {

    private final CommunicationService communicationService;
    @GetMapping("/{id}")
    StatusResponse findById(@PathVariable UUID id) {
        return communicationService.getStatusCommunication(id);
    }

    @PostMapping
    public ResponseEntity<Void>postCommunication(@RequestBody CommunicationRequest communicationRequest){

        communicationService.postCommunication(communicationRequest);

        return null;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void>deleteCommunication(@PathVariable UUID id){

        communicationService.deleteCommunication(id);

        return ResponseEntity
                .noContent()
                .build();
    }

}
