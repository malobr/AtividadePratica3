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
        System.out.println("\n--DESENVOLVEDOR--");
        return super.toString() + "\nLinguagens: " + linguagens;
    }

    @Override
    public String trabalhar() {
        return "\nO Desenvolvedor " + getNome()+ " esta estudando " + linguagens;
    }

    @Override
    public String relatarProgresso() {
        return "\nO Desenvolvedor " + getNome() + " esta desenvolvendo muitos projetos.." + "\n----------";
    }


}
