package Individuos;

public class Desenvolvedor extends Funcionario{
    private String linguagens;

    public Desenvolvedor() {}

    public Desenvolvedor(String nome, String matricula, String linguagens) {
        super(nome, matricula);
        this.linguagens = linguagens;
    }


    public String getLinguagens() {
        return linguagens;
    }
    public void setLinguagens(String linguagens) {
        this.linguagens = linguagens;
    }


    
    @Override
    public String toString() {
        return super.toString() + "\nLinguagens: " + linguagens;
    }
}
