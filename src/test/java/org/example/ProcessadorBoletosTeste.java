package org.example;

import lombok.val;
import org.example.domain.entities.Boleto;
import org.example.domain.entities.Fatura;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.stream.Collectors;

class ProcessadorBoletosTeste {
    private ProcessadorBoletos processador;

    @BeforeEach
    void setUp() {
        processador = new ProcessadorBoletos();
    }

    @Test
    void fluxoNormal() {
        val fatura = new Fatura("Eduardo", LocalDateTime.now(), 100.0);

        val valores = new double[]{10.0, 60.0, 30.0};
        val boletos = Arrays.stream(valores).mapToObj(v -> new Boleto(v, LocalDateTime.now(), Double.toString(v))).collect(Collectors.toList());

        String resultado = processador.avaliaPagamentos(fatura, boletos);

        Assertions.assertEquals("PAGO", resultado);
    }
}