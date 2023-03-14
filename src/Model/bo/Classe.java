package Model.bo;



public class Classe {
    
    private int id;
    private String descricao;
    

    public Classe() {
    }

    public Classe(int id, String descricao) {
        this.id = id;
        this.descricao = descricao;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return getDescricao()+ ";" + getId();
    } 

   



}
