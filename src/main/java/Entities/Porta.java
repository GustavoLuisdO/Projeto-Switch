package Entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
public class Porta implements Serializable
{
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idPorta;

    @OneToOne(cascade=CascadeType.ALL) // esse parâmetro na anotação @OneToOne você esta informando para hibernate que toda vez que você salvar um switch você vai salvar/atualizar
    @JoinColumn(name = "fk_idSwitch", nullable = false)
    private Switch idSwitch;

    @Column(nullable = false)
    private int numeroPorta;

    @Column(nullable = false)
    private int numeroIP; // [0-9]{3}{.}[0-9]{3}{.}[0-9]{3}{.}[0-9]{3}

    // construtor
    public Porta() {}

    public Porta(Integer idPorta, Switch idSwitch, int numeroPorta, int numeroIP) {
        this.idPorta = idPorta;
        this.idSwitch = idSwitch;
        this.numeroPorta = numeroPorta;
        this.numeroIP = numeroIP;
    }

    // toString
    @Override
    public String toString() {
        return "Porta{" +
                "idPorta=" + idPorta +
                ", idSwitch=" + idSwitch +
                ", numeroPorta=" + numeroPorta +
                ", numeroIP=" + numeroIP +
                '}';
    }

    // getters and setters
    public int getIdPorta() {
        return idPorta;
    }

    public void setIdPorta(int idPorta) {
        this.idPorta = idPorta;
    }

    public Switch getIdSwitch() {
        return idSwitch;
    }

    public void setIdSwitch(Switch idSwitch) {
        this.idSwitch = idSwitch;
    }

    public int getNumeroPorta() {
        return numeroPorta;
    }

    public void setNumeroPorta(int numeroPorta) {
        this.numeroPorta = numeroPorta;
    }

    public int getNumeroIP() {
        return numeroIP;
    }

    public void setNumeroIP(int numeroIP) {
        this.numeroIP = numeroIP;
    }
}