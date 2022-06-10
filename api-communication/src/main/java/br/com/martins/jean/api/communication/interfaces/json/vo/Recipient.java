package br.com.martins.jean.api.communication.interfaces.json.vo;

import br.com.martins.jean.api.communication.enumerators.ContactTypeEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.jetbrains.annotations.NotNull;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Recipient {

    @NotNull
    private ContactTypeEnum contactTypeEnum;
    @NotNull
    private String deviceCommunication;

}

