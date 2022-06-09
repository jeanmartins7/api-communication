package br.com.martins.jean.api.communication.services;

import br.com.martins.jean.api.communication.interfaces.json.request.CommunicationRequest;
import br.com.martins.jean.api.communication.interfaces.json.response.CommunicationResponse;

import java.util.UUID;

public interface CommunicationService {

    CommunicationResponse  getStatusCommunication(UUID id);

    void postCommunication(CommunicationRequest communicationRequest);

    void deleteCommunication(UUID id);

}
