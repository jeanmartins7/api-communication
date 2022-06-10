package br.com.martins.jean.api.communication.interfaces.json.request;

import br.com.martins.jean.api.communication.interfaces.json.vo.DateTime;
import br.com.martins.jean.api.communication.interfaces.json.vo.Recipient;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.jetbrains.annotations.NotNull;


@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommunicationRequest {

    @NotNull
    private String message;

    @NotNull
    private Recipient recipient;

    @NotNull
    private DateTime dateTime;

}
