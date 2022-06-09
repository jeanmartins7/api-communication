package br.com.martins.jean.api.communication.domain;


import br.com.martins.jean.api.communication.enumerators.ContactTypeEnum;
import br.com.martins.jean.api.communication.enumerators.StatusEnum;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CommunicationDomain)) return false;
        if (!super.equals(o)) return false;
        CommunicationDomain that = (CommunicationDomain) o;
        return getId().equals(that.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getId());
    }
}
