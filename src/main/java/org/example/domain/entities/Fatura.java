package org.example.domain.entities;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class Fatura {
    private String nomeCliente;
    private LocalDateTime data;
    private double valorTotal;
}
