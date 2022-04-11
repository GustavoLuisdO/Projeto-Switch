package Entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Switch implements Serializable
{
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idSwitch;

    @Column(nullable = false)
    private String nomeSwitch;

    @Column(nullable = false)
    private int quantidadePortas;

    // construtor
    public Switch() {}

    public Switch(String nomeSwitch, int quantidadePortas) {
        this.idSwitch = null;
        this.nomeSwitch = nomeSwitch;
        this.quantidadePortas = quantidadePortas;
    }

    // toString
    @Override
    public String toString() {
        return "Switch{" +
                "idSwitch=" + idSwitch +
                ", nomeSwitch='" + nomeSwitch + '\'' +
                ", quantidadePortas=" + quantidadePortas +
                '}';
    }

    // getters and setters
    public int getIdSwitch() {
        return idSwitch;
    }

    public void setIdSwitch(int idSwitch) {
        this.idSwitch = idSwitch;
    }

    public String getNomeSwitch() {
        return nomeSwitch;
    }

    public void setNomeSwitch(String nomeSwitch) {
        this.nomeSwitch = nomeSwitch;
    }

    public int getQuantidadePortas() {
        return quantidadePortas;
    }

    public void setQuantidadePortas(int quantidadePortas) {
        this.quantidadePortas = quantidadePortas;
    }
}