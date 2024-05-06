package Individuos;

public class Desenvolvedor extends Funcionario{
    private String linguagens;
    private Gerente gerente;

    public Desenvolvedor() {}

    public Desenvolvedor(String nome, String matricula, String linguagens, Gerente gerente) {
        super(nome, matricula);
        this.linguagens = linguagens;
        this.gerente = gerente;
    }


    public String getLinguagens() {
        return linguagens;
    }
    public void setLinguagens(String linguagens) {
        this.linguagens = linguagens;
    }


    public Gerente getGerente() {
        return gerente;
    }

    public void setGerente(Gerente gerente) {
        this.gerente = gerente;
    }


    
    @Override
    public String toString() {
        return super.toString() + "\nLinguagens: " + linguagens;
    }

    @Override
    public String trabalhar() {
        return "\nO Desenvolvedor" + getNome()+ " esta estudando JAVA";
    }

    @Override
public String relatarProgresso() {
    if (getGerente() != null) {
        return "\nO Desenvolvedor " + getNome() + " está sendo gerenciado por " + getGerente().getNome();
    } else {
        return "\nO Desenvolvedor " + getNome() + " não tem gerente associado.";
    }
}


}
