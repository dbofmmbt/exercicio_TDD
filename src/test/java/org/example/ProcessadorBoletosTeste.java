package org.example;

import lombok.val;
import org.example.domain.entities.Boleto;
import org.example.domain.entities.Fatura;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class ProcessadorBoletosTest {
    private ProcessadorBoletos processador;
    private Fatura faturaExemplo;

    @BeforeEach
    void setUp() {
        processador = new ProcessadorBoletos();
        faturaExemplo = new Fatura("Eduardo", LocalDateTime.now(), 100.0);
    }

    @Test
    void faturaPaga() {
        val valores = new double[]{10.0, 60.0, 30.0};
        val boletos = getBoletos(valores);

        String resultado = processador.avaliaPagamentos(faturaExemplo, boletos);

        Assertions.assertEquals("PAGO", resultado);
    }

    @Test
    void faturaNaoPaga() {
        val valores = new double[]{10.0};
        val boletos = getBoletos(valores);

        String resultado = processador.avaliaPagamentos(faturaExemplo, boletos);

        Assertions.assertEquals("NAO_PAGO", resultado);
    }

    @Test
    void tabelaDeTestes() {
        val tabela = new Object[][]{
                {1500.0, new double[]{500.0, 400.0, 600.0}, "PAGO"},
                {1500.0, new double[]{1000.0, 500.0, 250.0}, "PAGO"},
                {2000.0, new double[]{500.0, 400.0}, "NAO_PAGO"}
        };

        for (Object[] entrada : tabela) {
            faturaExemplo.setValorTotal((Double) entrada[0]);
            val boletos = getBoletos((double[]) entrada[1]);

            Assertions.assertEquals(entrada[2], processador.avaliaPagamentos(faturaExemplo, boletos));
        }
    }

    private List<Boleto> getBoletos(double[] valores) {
        return Arrays.stream(valores).mapToObj(v -> new Boleto(v, LocalDateTime.now(), Double.toString(v))).collect(Collectors.toList());
    }
}