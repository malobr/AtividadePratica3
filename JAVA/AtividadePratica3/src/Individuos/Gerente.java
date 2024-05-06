package Individuos;

public class Gerente extends Funcionario{
    private String projetos;

    public Gerente() {}

    public Gerente(String nome, String matricula, String projetos) {
        super(nome, matricula);
        this.projetos = projetos;
    }


    public String getProjetos() {
        return projetos;
    }
    public void setProjetos(String projetos) {
        this.projetos = projetos;
    }


    @Override
    public String toString() {
        return super.toString() + "\nProjetos: " + projetos;
    }
}
