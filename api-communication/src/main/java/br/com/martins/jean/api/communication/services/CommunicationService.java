package br.com.martins.jean.api.communication.services;

import br.com.martins.jean.api.communication.interfaces.json.request.CommunicationRequest;
import br.com.martins.jean.api.communication.interfaces.json.response.CommunicationResponse;
import br.com.martins.jean.api.communication.interfaces.json.response.StatusResponse;

import java.util.UUID;

public interface CommunicationService {

    StatusResponse getStatusCommunication(UUID id);

    CommunicationResponse postCommunication(CommunicationRequest communicationRequest);

    void deleteCommunication(UUID id);

}
