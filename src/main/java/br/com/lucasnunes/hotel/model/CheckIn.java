package br.com.lucasnunes.hotel.model;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * <h1>Classe referente ao {@link CheckIn}</h1>
 *
 * <p>Guarda os atributos do {@link CheckIn}</p>
 *
 * @author Lucas Nunes lucasnunes.ln365@gmail.com
 */
@Entity
@Table(name = "check_in")
public class CheckIn {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private LocalDateTime dataEntrada;
    private LocalDateTime dataSaida;
    private Boolean adicionalVeiculo;

    @ManyToOne
    @JoinColumn(name = "hospede_id")
    private Hospede hospede;

    public CheckIn(){
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDateTime getDataEntrada() {
        return dataEntrada;
    }

    public void setDataEntrada(LocalDateTime dataEntrada) {
        this.dataEntrada = dataEntrada;
    }

    public LocalDateTime getDataSaida() {
        return dataSaida;
    }

    public void setDataSaida(LocalDateTime dataSaida) {
        this.dataSaida = dataSaida;
    }

    public Boolean getAdicionalVeiculo() {
        return adicionalVeiculo;
    }

    public void setAdicionalVeiculo(Boolean adicionalVeiculo) {
        this.adicionalVeiculo = adicionalVeiculo;
    }

    public Hospede getHospede() {
        return hospede;
    }

    public void setHospede(Hospede hospede) {
        this.hospede = hospede;
    }

    @Override
    public String toString() {
        return "CheckIn{" +
                "id=" + id +
                ", dataEntrada=" + dataEntrada +
                ", dataSaida=" + dataSaida +
                ", adicionalVeiculo=" + adicionalVeiculo +
                ", hospede=" + hospede +
                '}';
    }
}
