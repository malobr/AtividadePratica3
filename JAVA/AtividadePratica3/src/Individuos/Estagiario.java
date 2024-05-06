package Individuos;

public class Estagiario extends Funcionario{
    private Float tempoDeEstagio;

    public Estagiario(){}

    public Estagiario(String nome, String matricula, Float tempoDeEstagio) {
        super(nome, matricula);
        this.tempoDeEstagio = tempoDeEstagio;
    }


    public Float getTempoDeEstagio() {
        return tempoDeEstagio;
    }
    public void setTempoDeEstagio(Float tempoDeEstagio) {
        this.tempoDeEstagio = tempoDeEstagio;
    }
    

    @Override
    public String toString() {
        return super.toString() + "\nTempo de Estagio: " + tempoDeEstagio;
    }
}
