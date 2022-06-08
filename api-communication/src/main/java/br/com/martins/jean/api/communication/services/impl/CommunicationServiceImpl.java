package br.com.martins.jean.api.communication.services.impl;

import br.com.martins.jean.api.communication.interfaces.json.request.Request;
import br.com.martins.jean.api.communication.services.CommunicationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
public class CommunicationServiceImpl implements CommunicationService {


    @Override
    public void postCommunication(Request request) {
        log.info("POST communication");

    }

    @Override
    public void deleteCommunication(UUID id) {
        log.info("DELETE communication");
    }


}
