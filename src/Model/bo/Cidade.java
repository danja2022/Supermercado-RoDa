
package Model.bo;


public class Cidade {
    private int id;
    private String descricao;

    public Cidade() {
    }

    public Cidade(int id, String descricao) {
        this.id = id;
        this.descricao = descricao;
    }

    public int getCidade() {
        return id;
    }

    public void setCidade(int cidade) {
        this.id = cidade;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
    public String toString(){
        return this.getCidade()+ ";" + this.getDescricao();
                
    }
    
}
