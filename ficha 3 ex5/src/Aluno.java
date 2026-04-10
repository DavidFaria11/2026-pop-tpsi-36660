public class Aluno implements Comparable<Aluno> {
    private String primeiroNome;
    private String ultimoNome;
    private int idade;

    public Aluno(String primeiroNome, String ultimoNome, int idade) {
        this.primeiroNome = primeiroNome;
        this.ultimoNome = ultimoNome;
        this.idade = idade;
    }


    public String getPrimeiroNome() {
        return primeiroNome;
    }

    public void setPrimeiroNome(String primeiroNome) {
        this.primeiroNome = primeiroNome;
    }

    public String getUltimoNome() {
        return ultimoNome;
    }

    public void setUltimoNome(String ultimoNome) {
        this.ultimoNome = ultimoNome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }


    @Override
    public int compareTo(Aluno outro) {
        return this.idade - outro.idade;
    }

    @Override
    public String toString() {
        return primeiroNome + " " + ultimoNome + " (idade: " + idade + ")";
    }
}