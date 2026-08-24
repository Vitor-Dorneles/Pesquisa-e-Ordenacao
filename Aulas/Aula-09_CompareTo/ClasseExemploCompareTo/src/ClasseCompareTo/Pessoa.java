/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aplicacaobasica;

import java.util.Objects;

/**
 *
 * @author vitor
 */
public class Pessoa implements Comparable <Pessoa>{
    String nome;
    int idade;
    
    /**
     * Construtor para nome e idade
     * @param nome
     * @param idade 
     */
    public Pessoa(String nome, int idade) {
        nome=this.nome;
        idade=this.idade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + Objects.hashCode(this.nome);
        hash = 29 * hash + this.idade;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Pessoa other = (Pessoa) obj;
        if (this.idade != other.idade) {
            return false;
        }
        return Objects.equals(this.nome, other.nome);
    }

    @Override
    public int compareTo(Pessoa t) {
        int resultadoNome = this.nome.compareTo(t.getNome());
        if (resultadoNome != 0) {
            return resultadoNome;
        }
       return Integer.compare(this.idade, t.getIdade());
    }
    
    
}
