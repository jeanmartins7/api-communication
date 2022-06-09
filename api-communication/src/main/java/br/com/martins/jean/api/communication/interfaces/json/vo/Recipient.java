package br.com.martins.jean.api.communication.interfaces.json.vo;

import br.com.martins.jean.api.communication.enumerators.ContactTypeEnum;
import org.jetbrains.annotations.NotNull;

public class Recipient {

    @NotNull
    private ContactTypeEnum contactTypeEnum;
    @NotNull
    private DeviceCommunication deviceCommunication;

}

