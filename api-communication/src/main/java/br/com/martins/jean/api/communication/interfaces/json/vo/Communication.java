package br.com.martins.jean.api.communication.interfaces.json.vo;

import lombok.Data;

public class Communication {

    private String email;

    private Phone whatsapp;

    private Phone sms;

    private String push;

    @Data
    public static class Phone {

        private String countryCode;

        private String areaCode;

        private String number;
    }
}
