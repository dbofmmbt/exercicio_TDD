package org.example;

import org.example.domain.entities.Boleto;
import org.example.domain.entities.Fatura;

import java.util.List;

public class ProcessadorBoletos {
    public String avaliaPagamentos(Fatura fatura, List<Boleto> boletos) {
        return "PAGO";
    }
}
