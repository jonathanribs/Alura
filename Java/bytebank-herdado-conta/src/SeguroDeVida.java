public class SeguroDeVida implements Tributavel{

    private String nome;

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public double getValorImposto(){
        return 42;
    }
}
