package com.example.ex3.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity(name = "Pedido")
@Table(name = "tb_pedido")
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "data_pedido")
    private LocalDateTime data;

    @Column(name = "valor_total")
    private BigDecimal valorTotal;

    @Column(name = "status_pedido")
    private String status;


    public Long getId() {
        return id;
    }

    public LocalDateTime getData() {
        return data;
    }

    public BigDecimal getValorTotal() {
        return valorTotal;
    }

    public String getStatus() {
        return status;
    }


    public void setId(Long id) {
        this.id = id;
    }

    public void setData(LocalDateTime data) {
        this.data = data;
    }

    public void setValorTotal(BigDecimal valorTotal) {
        this.valorTotal = valorTotal;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
