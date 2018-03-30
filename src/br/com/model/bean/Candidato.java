package br.com.model.bean;

/**
 *
 * @author paulo
 */
public class Candidato {
    
    private int id;
    private String nome;
    private int numero;
    private Partido partido;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public Partido getPartido() {
        return partido;
    }

    public void setPartido(Partido partido) {
        this.partido = partido;
    }

    public Candidato() {
    }

    public Candidato(int id, String nome, int numero, Partido partido) {
        this.id = id;
        this.nome = nome;
        this.numero = numero;
        this.partido = partido;
    }
    
    
}
