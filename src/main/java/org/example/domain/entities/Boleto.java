package org.example.domain.entities;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class Boleto {
    private double valorPago;
    private LocalDateTime data;
    private String codigo;
}
