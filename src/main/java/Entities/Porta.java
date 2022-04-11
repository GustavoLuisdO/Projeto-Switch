package Entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Porta implements Serializable
{
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idPorta;

    //@OneToOne(cascade=CascadeType.ALL) // esse parâmetro na anotação @OneToOne você esta informando para hibernate que toda vez que você salvar um switch você vai salvar/atualizar
    @Column(name = "fk_idSwitch", nullable = false)
    private int idSwitch;

    @Column(nullable = false)
    private int numeroPorta;

    @Column(nullable = false, columnDefinition="text")
    private String numeroIP; // [0-9]{3}{.}[0-9]{3}{.}[0-9]{3}{.}[0-9]{3}

    // construtor
    public Porta() {}

    public Porta(int idSwitch, int numeroPorta, String numeroIP) {
        this.idPorta = null;
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

    public int getIdSwitch() {
        return idSwitch;
    }

    public void setIdSwitch(int idSwitch) {
        this.idSwitch = idSwitch;
    }

    public int getNumeroPorta() {
        return numeroPorta;
    }

    public void setNumeroPorta(int numeroPorta) {
        this.numeroPorta = numeroPorta;
    }

    public String getNumeroIP() {
        return numeroIP;
    }

    public void setNumeroIP(String numeroIP) {
        this.numeroIP = numeroIP;
    }
}