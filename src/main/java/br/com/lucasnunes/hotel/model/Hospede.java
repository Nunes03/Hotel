package br.com.lucasnunes.hotel.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * <h1>Classe referente ao {@link Hospede}</h1>
 *
 * <p>Guarda todos os atributos do
 * {@link Hospede}.</p>
 *
 * @author Lucas Nunes lucasnunes.ln365@gmail.com
 */
@Entity
public class Hospede {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String nome;
    private Integer documento;
    private Integer telefone;

    @OneToMany(mappedBy = "hospede")
    private List<CheckIn> checkIns = new ArrayList<>();

    public Hospede() {
    }

    public Integer getId() {return id;}

    public void setId(Integer id) {this.id = id;}

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getDocumento() {
        return documento;
    }

    public void setDocumento(Integer documento) {
        this.documento = documento;
    }

    public Integer getTelefone() {
        return telefone;
    }

    public void setTelefone(Integer telefone) {
        this.telefone = telefone;
    }

    public List<CheckIn> getCheckIns() {return checkIns;}

    public void setCheckIns(List<CheckIn> checkIns) {this.checkIns = checkIns;}

    @Override
    public String toString() {
        return "Hospede{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", documento=" + documento +
                ", telefone=" + telefone +
                ", checkIns=" + checkIns +
                '}';
    }
}
