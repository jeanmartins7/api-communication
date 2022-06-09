package br.com.martins.jean.api.communication.interfaces.json.vo;

import br.com.martins.jean.api.communication.enumerators.ContactType;
import org.jetbrains.annotations.NotNull;

public class Recipient {

    @NotNull
    private ContactType contactType;
    @NotNull
    private DeviceCommunication deviceCommunication;

}

