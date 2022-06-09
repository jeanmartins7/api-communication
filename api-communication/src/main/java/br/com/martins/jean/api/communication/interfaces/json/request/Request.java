package br.com.martins.jean.api.communication.interfaces.json.request;

import br.com.martins.jean.api.communication.interfaces.json.vo.DateTime;
import br.com.martins.jean.api.communication.interfaces.json.vo.Recipient;
import org.jetbrains.annotations.NotNull;

public class Request {

    @NotNull
    private String message;

    @NotNull
    private Recipient recipient;

    @NotNull
    private DateTime dateTime;

}
