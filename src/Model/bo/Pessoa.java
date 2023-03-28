package Model.bo;

import java.util.Date;

public abstract class Pessoa {

    private String nome;
    private int id;
    private String fone;
    private String fone2;
    private String email;
    private String dtCadastro;
    private String complementoEndereco;
    private String observacao;
    private char status;
    private Endereco endereco; //endereco

    public Pessoa() {
    }

    public Pessoa(String nome, int id, String fone, String fone2, String email, String dtCadastro, String complementoEndereco, String observacao, char status, Endereco endereco) {
        this.nome = nome;
        this.id = id;
        this.fone = fone;
        this.fone2 = fone2;
        this.email = email;
        this.dtCadastro = dtCadastro;
        this.complementoEndereco = complementoEndereco;
        this.observacao = observacao;
        this.status = status;
        this.endereco = endereco;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFone() {
        return fone;
    }

    public void setFone(String fone) {
        this.fone = fone;
    }

    public String getFone2() {
        return fone2;
    }

    public void setFone2(String fone2) {
        this.fone2 = fone2;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDtCadastro() {
        return dtCadastro;
    }

    public void setDtCadastro(String dtCadastro) {
        this.dtCadastro = dtCadastro;
    }

    public String getComplementoEndereco() {
        return complementoEndereco;
    }

    public void setComplementoEndereco(String complementoEndereco) {
        this.complementoEndereco = complementoEndereco;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public char getStatus() {
        return status;
    }

    public void setStatus(char status) {
        this.status = status;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    @Override
    public String toString() {
        return this.getId() + ";" +this.getEmail();
    }
    
}
