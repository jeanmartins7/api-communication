package br.com.martins.jean.api.communication.interfaces.json.response;

import br.com.martins.jean.api.communication.enumerators.Status;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CommunicationResponse {

    private Status status;

}
