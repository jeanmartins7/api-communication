package br.com.martins.jean.api.communication.services.impl;

import br.com.martins.jean.api.communication.domain.CommunicationDomain;
import br.com.martins.jean.api.communication.exceptions.MessageError;
import br.com.martins.jean.api.communication.interfaces.json.request.CommunicationRequest;
import br.com.martins.jean.api.communication.interfaces.json.response.CommunicationResponse;
import br.com.martins.jean.api.communication.repository.CommunicationRepository;
import br.com.martins.jean.api.communication.services.CommunicationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
public class CommunicationServiceImpl implements CommunicationService {
    private final CommunicationRepository communicationRepository;
    private final MessageError messageError;


    @Override
    public CommunicationResponse getStatusCommunication(UUID id) {
        log.info("Getting status for =[{}]", id);

       CommunicationDomain communicationDomain = getCommunicationDomain(id);

        return CommunicationResponse.builder()
              .status(communicationDomain.getStatus())
                .build();
    }

    @Override
    public void postCommunication(CommunicationRequest communicationRequest) {
        log.info("POST communication");

    }

    @Override
    public void deleteCommunication(UUID id) {
        log.info("DELETE communication");
    }

    public CommunicationDomain getCommunicationDomain(final UUID id) {
      return communicationRepository.findById(id.toString())
            .orElseThrow(() -> new IllegalArgumentException("CommunicationDomain not found by: " +  id));
    }


}
