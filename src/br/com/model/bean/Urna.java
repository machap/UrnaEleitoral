package br.com.model.bean;

import java.util.Date;

/**
 *
 * @author paulo
 */
public class Urna {
    
    private int id;
    private Date dataHora;
    private Candidato candidato;
    private Eleitor eleitor;
    private int voto;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDataHora() {
        return dataHora;
    }

    public void setDataHora(Date dataHora) {
        this.dataHora = dataHora;
    }

    public Candidato getCandidato() {
        return candidato;
    }

    public void setCandidato(Candidato candidato) {
        this.candidato = candidato;
    }

    public Eleitor getEleitor() {
        return eleitor;
    }

    public void setEleitor(Eleitor eleitor) {
        this.eleitor = eleitor;
    }

    public int getVoto() {
        return voto;
    }

    public void setVoto(int voto) {
        this.voto = voto;
    }

    public Urna() {
    }

    public Urna(int id, Date dataHora, Candidato candidato, Eleitor eleitor, int voto) {
        this.id = id;
        this.dataHora = dataHora;
        this.candidato = candidato;
        this.eleitor = eleitor;
        this.voto = voto;
    }
    
    
}
