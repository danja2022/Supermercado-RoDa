package Model.bo;

import java.util.Date;

public class Cliente extends Pessoa {
   
    private int cpf;
    private int rg;
    private char sexo;
    private Date dtNascimento;

    public Cliente() {
        
    }

    public Cliente(int cpf, int rg, int sexo, Date dtNascimento, String nome, int id, String fone, String fone2, String email, Date dtCadastro, String complementoEndereco, String observacao, char status, Endereco endereco) {
        super(nome, id, fone, fone2, email, dtCadastro, complementoEndereco, observacao, status, endereco);
        this.cpf = cpf;
        this.rg = rg;
        this.sexo = (char) sexo;
        this.dtNascimento = dtNascimento;
    }

    public int getCpf() {
        return cpf;
    }

    public void setCpf(int cpf) {
        this.cpf = cpf;
    }

    public int getRg() {
        return rg;
    }

    public void setRg(int rg) {
        this.rg = rg;
    }

    public int getSexo() {
        return sexo;
    }

    public void setSexo(int sexo) {
        this.sexo = (char) sexo;
    }

    public Date getDtNascimento() {
        return dtNascimento;
    }

    public void setDtNascimento(Date dtNascimento) {
        this.dtNascimento = dtNascimento;
    }

    @Override
    public String toString() {
        return super.toString();
    }
     
}
