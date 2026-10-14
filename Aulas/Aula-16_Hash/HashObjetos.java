import java.util.HashSet;
import java.util.Set;

class Aluno {
    int matricula;
    String nome;

    public Aluno(int matricula, String nome) {
        this.matricula = matricula;
        this.nome = nome;
    }
    

    @Override
    public String toString() {
        return "Aluno [matricula=" + matricula + ", nome=" + nome + "]";
    }


    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + matricula;
        return result;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Aluno other = (Aluno) obj;
        if (matricula != other.matricula)
            return false;
        if (nome == null) {
            if (other.nome != null)
                return false;
        } else if (!nome.equals(other.nome))
            return false;
        return true;
    }
}
public class HashObjetos {
    public static void main(String[] args) {
        HashSet<Aluno> tabelaHashAluno = new HashSet<>();

        tabelaHashAluno.add(new Aluno(1, "Alexandre"));
        tabelaHashAluno.add(new Aluno(2, "Davi"));
        tabelaHashAluno.add(new Aluno(3, "Hermes"));
        tabelaHashAluno.add(new Aluno(1, "Alexandre"));
        tabelaHashAluno.add(new Aluno(1, "Davi"));

        for (Aluno a : tabelaHashAluno) {
            System.out.println(a);
        }

        //HashSet só barra duplicados porque Aluno sobrescreve hashCode() e equals()



    }
}
