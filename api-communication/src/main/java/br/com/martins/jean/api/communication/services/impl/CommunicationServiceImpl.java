package br.com.martins.jean.api.communication.services.impl;

import br.com.martins.jean.api.communication.domain.CommunicationDomain;
import br.com.martins.jean.api.communication.enumerators.StatusEnum;
import br.com.martins.jean.api.communication.exceptions.ObjectNotFoundException;
import br.com.martins.jean.api.communication.exceptions.UnprocessableEntityException;
import br.com.martins.jean.api.communication.interfaces.json.request.CommunicationRequest;
import br.com.martins.jean.api.communication.interfaces.json.response.CommunicationResponse;
import br.com.martins.jean.api.communication.interfaces.json.response.StatusResponse;
import br.com.martins.jean.api.communication.repository.CommunicationRepository;
import br.com.martins.jean.api.communication.services.CommunicationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

import static org.springframework.web.client.HttpClientErrorException.UnprocessableEntity;

@Service
@RequiredArgsConstructor
@Slf4j
public class CommunicationServiceImpl implements CommunicationService {
    private final CommunicationRepository communicationRepository;
    @Override
    public StatusResponse getStatusCommunication(UUID id) {
       log.info("Getting status for =[{}]", id);
        return CommunicationDomain.toStatusResponse(getCommunicationDomain(id).getStatus());
    }

    @Override
    public CommunicationResponse postCommunication(CommunicationRequest communicationRequest) {
        log.info("POST communication");

       CommunicationDomain communicationDomain = CommunicationDomain.toCommunicationDomain(communicationRequest);

       return CommunicationResponse.toCommunicationResponse(communicationRepository.save(communicationDomain).getId());

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
            .orElseThrow(() -> new ObjectNotFoundException(String.format("Communication not found for CommunicationId = %s " , id )));
    }

    private void validateStatus(CommunicationDomain communicationDomain) throws UnprocessableEntity {
        if (StatusEnum.CANCELLED.equals(communicationDomain.getStatus())) {
            log.info("Communications already {}", StatusEnum.CANCELLED);
            throw new UnprocessableEntityException(String.format("Communication already CANCELLED for CommunicationId = %s", communicationDomain.getId()));

        }
    }
}
