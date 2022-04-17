package org.example.domain.entities;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Boleto {
    private double valorPago;
    private LocalDateTime data;
    private String codigo;
}
