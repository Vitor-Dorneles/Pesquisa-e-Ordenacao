package model.codigos;

import java.time.LocalDate;

public class Produto {
    
    String Descricao;
    int Codigo;
    LocalDate Data;

    
    @Override
    public String toString() {
        return "Produto [Descricao=" + Descricao + ", Codigo=" + Codigo + ", Data=" + Data + "]";
    }

    public Produto( int codigo, String descricao, LocalDate data) {
        Descricao = descricao;
        Codigo = codigo;
        Data = data;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((Descricao == null) ? 0 : Descricao.hashCode());
        result = prime * result + Codigo;
        result = prime * result + ((Data == null) ? 0 : Data.hashCode());
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
        Produto other = (Produto) obj;
        if (Descricao == null) {
            if (other.Descricao != null)
                return false;
        } else if (!Descricao.equals(other.Descricao))
            return false;
        if (Codigo != other.Codigo)
            return false;
        if (Data == null) {
            if (other.Data != null)
                return false;
        } else if (!Data.equals(other.Data))
            return false;
        return true;
    }

    public void setDescricao(String descricao) {
        Descricao = descricao;
    }
    public void setCodigo(int codigo) {
        Codigo = codigo;
    }
    public void setData(LocalDate data) {
        Data = data;
    }
    public String getDescricao() {
        return Descricao;
    }
    public int getCodigo() {
        return Codigo;
    }
    public LocalDate getData() {
        return Data;
    }

}
