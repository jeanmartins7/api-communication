package br.com.martins.jean.api.communication.services;

import br.com.martins.jean.api.communication.interfaces.json.request.Request;

import java.util.UUID;

public interface CommunicationService {

    void postCommunication(Request request);

    void deleteCommunication(UUID id);

}
