public class UnidadeCurricular {

    private Aluno[] alunos;
    private int numAlunos;


    public UnidadeCurricular() {
        this.alunos = new Aluno[20];
        this.numAlunos = 0;
    }


    public Aluno[] getAlunos() { return alunos; }
    public void setAlunos(Aluno[] alunos) { this.alunos = alunos; }


    public void adicionarAluno(Aluno aluno) {
        for (int i = 0; i < numAlunos; i++) {
            if (alunos[i].getNumeroCartao() == aluno.getNumeroCartao()) {
                System.out.println("Erro: já existe um aluno com o número de cartão " + aluno.getNumeroCartao());
                return;
            }
        }
        if (numAlunos < alunos.length) {
            alunos[numAlunos] = aluno;
            numAlunos++;
            System.out.println("Aluno '" + aluno.getNome() + "' adicionado com sucesso.");
        } else {
            System.out.println("Erro: não há espaço para mais alunos.");
        }
    }


    public Aluno obterAluno(int numeroCartao) {
        for (int i = 0; i < numAlunos; i++) {
            if (alunos[i].getNumeroCartao() == numeroCartao) {
                return alunos[i];
            }
        }
        System.out.println("Aluno com número de cartão " + numeroCartao + " não encontrado.");
        return null;
    }


    public void listarAlunos() {
        if (numAlunos == 0) {
            System.out.println("Não existem alunos na unidade curricular.");
            return;
        }
        System.out.println("=== Lista de Alunos ===");
        for (int i = 0; i < numAlunos; i++) {
            System.out.println(alunos[i]);
            System.out.printf("  Média: %.2f | Melhor Nota: %.2f%n",
                    alunos[i].obterMedia(), alunos[i].obterMelhorNota());
        }
    }


    public Aluno obterAlunoMelhorMedia() {
        if (numAlunos == 0) {
            System.out.println("Não existem alunos na unidade curricular.");
            return null;
        }
        Aluno melhor = alunos[0];
        for (int i = 1; i < numAlunos; i++) {
            double mediaAtual = alunos[i].obterMedia();
            double mediaMelhor = melhor.obterMedia();
            if (mediaAtual > mediaMelhor) {
                melhor = alunos[i];
            } else if (mediaAtual == mediaMelhor) {
                if (alunos[i].getNumeroCartao() < melhor.getNumeroCartao()) {
                    melhor = alunos[i];
                }
            }
        }
        return melhor;
    }
}