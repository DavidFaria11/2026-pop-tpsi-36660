public class Aluno {

    private String nome;
    private String cidade;
    private String email;
    private int idade;
    private int numeroCartao;
    private double[] notas;
    private int numNotas;


    public Aluno() {
        this.notas = new double[5];
        this.numNotas = 0;
    }


    public Aluno(String nome, String cidade, String email, int idade, int numeroCartao) {
        this.nome = nome;
        this.cidade = cidade;
        this.email = email;
        this.idade = idade;
        this.numeroCartao = numeroCartao;
        this.notas = new double[5];
        this.numNotas = 0;
    }


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public int getNumeroCartao() {
        return numeroCartao;
    }

    public void setNumeroCartao(int numeroCartao) {
        this.numeroCartao = numeroCartao;
    }

    public double[] getNotas() {
        return notas;
    }

    public void setNotas(double[] notas) {
        this.notas = notas;
    }


    @Override
    public String toString() {
        return "Aluno{" +
                "Nome='" + nome + '\'' +
                ", Cidade='" + cidade + '\'' +
                ", Email='" + email + '\'' +
                ", Idade=" + idade +
                ", NumeroCartao=" + numeroCartao +
                '}';
    }


    public void addNota(double nota) {
        if (numNotas < notas.length) {
            notas[numNotas] = nota;
            numNotas++;
        } else {
            System.out.println("Não é possível adicionar mais notas. Limite atingido.");
        }
    }


    public double obterMedia() {
        if (numNotas == 0) {
            return 0;
        }
        double soma = 0;
        for (int i = 0; i < numNotas; i++) {
            soma += notas[i];
        }
        return soma / numNotas;
    }


    public double obterMelhorNota() {
        if (numNotas == 0) {
            return 0;
        }
        double melhor = notas[0];
        for (int i = 1; i < numNotas; i++) {
            if (notas[i] > melhor) {
                melhor = notas[i];
            }
        }
        return melhor;
    }
}