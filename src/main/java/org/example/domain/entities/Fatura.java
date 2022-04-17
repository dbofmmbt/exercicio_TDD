package org.example.domain.entities;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Fatura {
    private String nomeCliente;
    private LocalDateTime data;
    private double valorTotal;
}
