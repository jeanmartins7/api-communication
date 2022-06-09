package br.com.martins.jean.api.communication.interfaces.json.vo;

import org.jetbrains.annotations.NotNull;

import java.time.LocalDate;
import java.time.LocalTime;

public class DateTime {

    @NotNull
    private LocalDate date;
    @NotNull
    private LocalTime time;
}
