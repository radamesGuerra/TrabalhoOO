package entidades;

import java.time.LocalDate;

public class Pagamento {
    private double valor;
    private LocalDate data;
    private String status; // Ex: PENDENTE, PAGO

    public Pagamento(double valor, LocalDate data) {
        this.valor = valor;
        this.data = data;
        this.status = "PENDENTE"; // Status padrão
    }

    // Getters e Setters
    public double getValor() { 
        return valor; 
    }

    public LocalDate getData() { 
        return data; 
    }

    public String getStatus() { 
        return status; 
    }

    public void setStatus(String status) { 
        this.status = status; 
    }
}