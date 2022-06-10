package br.com.martins.jean.api.communication.services.impl;

import br.com.martins.jean.api.communication.domain.CommunicationDomain;
import br.com.martins.jean.api.communication.enumerators.StatusEnum;
import br.com.martins.jean.api.communication.exceptions.MessageError;
import br.com.martins.jean.api.communication.interfaces.json.request.CommunicationRequest;
import br.com.martins.jean.api.communication.interfaces.json.response.CommunicationResponse;
import br.com.martins.jean.api.communication.interfaces.json.response.StatusResponse;
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
    public StatusResponse getStatusCommunication(UUID id) {
       log.info("Getting status for =[{}]", id);
        return CommunicationDomain.toStatusResponse(getCommunicationDomain(id).getStatus());
    }

    @Override
    public CommunicationResponse postCommunication(CommunicationRequest communicationRequest) {
        log.info("POST communication");

       CommunicationDomain communicationDomain = CommunicationDomain.toCommunicationDomain(communicationRequest);

       communicationRepository.save(communicationDomain);

       return CommunicationResponse.toCommunicationResponse(communicationDomain.getId());

    }

    @Override
    public void deleteCommunication(UUID id) {
        log.info("DELETE communication");

       final CommunicationDomain communicationDomain = getCommunicationDomain(id);

        validateStatus(communicationDomain);

        communicationDomain.setStatus(StatusEnum.CANCELLED);

        communicationRepository.save(communicationDomain);
    }

    public CommunicationDomain getCommunicationDomain(final UUID id) {
      return communicationRepository.findById(id.toString())
            .orElseThrow(() -> new IllegalArgumentException("CommunicationDomain not found by: " +  id));
    }

    private void validateStatus(CommunicationDomain communicationDomain) {
        if (StatusEnum.CANCELLED.equals(communicationDomain.getStatus())){
            log.info("Communications already {}", StatusEnum.CANCELLED);
            throw new IllegalArgumentException("Communications already CANCELLED for id =[{}] " +  communicationDomain.getId());
        }
    }
}
