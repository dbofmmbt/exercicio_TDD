package org.example;

import lombok.val;
import org.example.domain.entities.Boleto;
import org.example.domain.entities.Fatura;

import java.util.List;

public class ProcessadorBoletos {
    public String avaliaPagamentos(Fatura fatura, List<Boleto> boletos) {
        val valorTotal = boletos.stream().mapToDouble(Boleto::getValorPago).sum();
        return valorTotal >= fatura.getValorTotal() ? "PAGO" : "NAO_PAGO";
    }
}
