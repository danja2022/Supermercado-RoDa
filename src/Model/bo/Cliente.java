package Model.bo;

import java.util.Date;

public class Cliente extends Pessoa {
   
    private String cpf;
    private String rg;  //string
    private char sexo;
    private String dtNascimento;

    public Cliente() {
        
    }

    public Cliente(String cpf, String rg, int sexo, String dtNascimento, String nome, int id, String fone, String fone2, String email, Date dtCadastro, String complementoEndereco, String observacao, char status, String endereco) {
        super(nome, id, fone, fone2, email, dtCadastro, complementoEndereco, observacao, status, endereco);
        this.cpf = cpf;
        this.rg = rg;
        this.sexo = (char) sexo;
        this.dtNascimento = dtNascimento;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public int getSexo() {
        return sexo;
    }

    public void setSexo(int sexo) {
        this.sexo = (char) sexo;
    }

    public String getDtNascimento() {
        return dtNascimento;
    }

    public void setDtNascimento(String dtNascimento) {
        this.dtNascimento = dtNascimento;
    }

    
    @Override
    public String toString() {
        return super.toString();
    }
     
}
