package Individuos;

public class Estagiario extends Funcionario{
    private Float horasDeTrabalho;
    private String supervisor;

    public Estagiario(){}

    public Estagiario(String nome, String matricula, Float horasDeTrabalho, String supervisor) {
        super(nome, matricula);
        this.horasDeTrabalho = horasDeTrabalho;
        this.supervisor = supervisor;
    }


    public Float getHorasDeTrabalho() {
        return horasDeTrabalho;
    }
    public void setHorasDeTrabalho(Float horasDeTrabalho) {
        this.horasDeTrabalho = horasDeTrabalho;
    }
    

    public String getSupervisor() {
        return supervisor;
    }

    public void setSupervisor(String supervisor) {
        this.supervisor = supervisor;
    }
    @Override
    public String toString() {
        System.out.println("\n--ESTAGIARIO--");
        return super.toString() + "\nHoras de Trabalho: " + horasDeTrabalho + "\nSupervisor: " + supervisor;
    }


    @Override
    public String trabalhar() {
        return "\nO estagiario " + getNome() + " esta aprendendo a trabalhar!";
    }

    @Override
    public String relatarProgresso() {
        return "\nO estagiario " + getNome() + " esta indo bem no trabalho, sob a supervisao do " + supervisor + "\n----------";
    }


}
