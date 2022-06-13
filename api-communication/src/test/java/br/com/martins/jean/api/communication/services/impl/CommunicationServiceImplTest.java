package br.com.martins.jean.api.communication.services.impl;

import br.com.martins.jean.api.communication.domain.CommunicationDomain;
import br.com.martins.jean.api.communication.enumerators.ContactTypeEnum;
import br.com.martins.jean.api.communication.enumerators.StatusEnum;
import br.com.martins.jean.api.communication.exceptions.ObjectNotFoundException;
import br.com.martins.jean.api.communication.exceptions.UnprocessableEntityException;
import br.com.martins.jean.api.communication.interfaces.json.request.CommunicationRequest;
import br.com.martins.jean.api.communication.interfaces.json.response.CommunicationResponse;
import br.com.martins.jean.api.communication.interfaces.json.response.StatusResponse;
import br.com.martins.jean.api.communication.interfaces.json.vo.DateTime;
import br.com.martins.jean.api.communication.interfaces.json.vo.Recipient;
import br.com.martins.jean.api.communication.repository.CommunicationRepository;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CommunicationServiceImplTest {

    private static UUID COMMUNICATION_ID;
    private static CommunicationDomain COMMUNICATION;
    private static LocalDate DATA;
    private static LocalTime TIME;
    private static CommunicationRequest COMMUNICATIONRQUEST;

    @Mock
    private CommunicationRepository communicationRepository;

    @InjectMocks
    private CommunicationServiceImpl communicationService;

    @BeforeAll
    static void initialize() {
        COMMUNICATION_ID = UUID.randomUUID();
        COMMUNICATION = toCommunicationDomainWithStatusSent();
        DATA = LocalDate.now();
        TIME = LocalTime.now();
        COMMUNICATIONRQUEST = toCommunicationRequest();

    }

    @DisplayName("Should Getting Communication Successfully")
    @Test
    void getCommunicationSuccessfully() {

        when(communicationRepository.findById(COMMUNICATION_ID.toString())).thenReturn(Optional.ofNullable(COMMUNICATION));

        StatusResponse statusResponse = communicationService.getStatusCommunication(COMMUNICATION_ID);

        assertNotNull(statusResponse);
        assertEquals(statusResponse.getStatus(),COMMUNICATION.getStatus());
    }

    @DisplayName("Should Getting Communication Failed")
    @Test
    void getCommunicationNotFound() {

        when(communicationRepository.findById(COMMUNICATION_ID.toString())).thenReturn(Optional.empty());

        assertThrows( ObjectNotFoundException.class, () -> communicationService.getStatusCommunication(COMMUNICATION_ID));
    }

    @DisplayName("Should Post Communication Successfully")
    @Test
    void postCommunicationSuccessfully() {

        CommunicationResponse communicationResponse = communicationService.postCommunication(COMMUNICATIONRQUEST);

        ArgumentCaptor<CommunicationDomain> captor = ArgumentCaptor
                .forClass(CommunicationDomain.class);
        verify(communicationRepository).save(captor.capture());

        CommunicationDomain communicationDomain = captor.getValue();

        assertNotNull(communicationResponse);
        assertNotNull(communicationDomain);
        assertEquals(communicationDomain.getId(), communicationResponse.getId());
    }

    @DisplayName("Should DELETE Communication Successfully")
    @Test
    void deleteCommunicationSuccessfully() {

        when(communicationRepository.findById(COMMUNICATION_ID.toString()))
                .thenReturn(Optional.ofNullable(COMMUNICATION));

        assertDoesNotThrow(() -> communicationService.deleteCommunication(COMMUNICATION_ID));

        ArgumentCaptor<CommunicationDomain> captor = ArgumentCaptor
                .forClass(CommunicationDomain.class);
        verify(communicationRepository).save(captor.capture());

        CommunicationDomain communicationDomain = captor.getValue();

        assertEquals(StatusEnum.CANCELLED, communicationDomain.getStatus());
    }

    @DisplayName("Should DELETE Communication already Cancelled")
    @Test
    void deleteCommunicationAlreadyCancelled() {

        when(communicationRepository.findById(COMMUNICATION_ID.toString()))
                .thenReturn(Optional.of(toCommunicationDomainWithStatusCancelled()));

        assertThrows( UnprocessableEntityException.class, () -> communicationService.deleteCommunication(COMMUNICATION_ID));
    }

    private static CommunicationDomain toCommunicationDomainWithStatusSent() {
        return CommunicationDomain.builder()
                .id(COMMUNICATION_ID.toString())
                .message("String")
                .deviceCommunication("String")
                .date(DATA)
                .time(TIME)
                .status(StatusEnum.SENT)
                .build();
    }

    private static CommunicationDomain toCommunicationDomainWithStatusCancelled() {
        return CommunicationDomain.builder()
                .id(COMMUNICATION_ID.toString())
                .message("String")
                .deviceCommunication("String")
                .date(DATA)
                .time(TIME)
                .status(StatusEnum.CANCELLED)
                .build();
    }

    private static CommunicationRequest toCommunicationRequest(){
        return CommunicationRequest.builder()
                .message("String")
                .recipient(Recipient.builder()
                        .contactTypeEnum(ContactTypeEnum.EMAIL)
                        .deviceCommunication("String")
                        .build())
                .dateTime(DateTime.builder()
                        .date(DATA)
                        .time(TIME)
                        .build())
                .build();
    }

}