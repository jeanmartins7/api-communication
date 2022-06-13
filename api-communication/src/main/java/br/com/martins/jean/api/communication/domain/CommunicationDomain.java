package br.com.martins.jean.api.communication.domain;


import br.com.martins.jean.api.communication.enumerators.ContactTypeEnum;
import br.com.martins.jean.api.communication.enumerators.StatusEnum;
import br.com.martins.jean.api.communication.interfaces.json.request.CommunicationRequest;
import br.com.martins.jean.api.communication.interfaces.json.response.StatusResponse;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tab_communications")
public class CommunicationDomain extends AuditDomain{

    @Id
    @Column(name = "tx_id_communication")
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @EqualsAndHashCode.Include
    private String id;

    @Column(name = "tx_message")
    private String message;

    @Column(name = "tx_contact_type")
    @Enumerated(EnumType.STRING)
    private ContactTypeEnum contactTypeEnum;

    @Column(name = "tx_device_communication")
    private String deviceCommunication;

    @Column(name = "tx_date")
    private LocalDate date;

    @Column(name = "tx_time")
    private LocalTime time;

    @Column(name = "tx_status")
    @Enumerated(EnumType.STRING)
    private StatusEnum status;

    public static CommunicationDomain toCommunicationDomain(CommunicationRequest communicationRequest){
        return CommunicationDomain.builder()
                .id(null)
                .message(communicationRequest.getMessage())
                .contactTypeEnum(communicationRequest.getRecipient().getContactTypeEnum())
                .deviceCommunication(communicationRequest.getRecipient().getDeviceCommunication())
                .date(communicationRequest.getDateTime().getDate())
                .time(communicationRequest.getDateTime().getTime())
                .status(StatusEnum.SEND)
                .build();
    }

    public static StatusResponse toStatusResponse(StatusEnum status){
        return StatusResponse.builder()
                .status(status)
                .build();
    }
}
