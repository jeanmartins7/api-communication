package br.com.martins.jean.api.communication.interfaces.json.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.jetbrains.annotations.NotNull;

import java.time.LocalDate;
import java.time.LocalTime;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DateTime {

    @NotNull
    private LocalDate date;
    @NotNull
    private LocalTime time;
}
