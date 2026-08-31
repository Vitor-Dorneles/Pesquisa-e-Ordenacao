package model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Principal {

    public static void main (String[] args){

        List<Produto> listaProduto = new ArrayList<>();
        LocalDate dateAtual = LocalDate.now();

        listaProduto.add(new Produto(1, "Pão de form Pullmann", dateAtual));
        listaProduto.add(new Produto(3, "Amendoim", dateAtual));
        listaProduto.add(new Produto(2, "Leite", dateAtual));

        listaProduto.sort((p1, p2) -> Integer.compare(p1.getCodigo(), p2.getCodigo()));
        //Collections.sort(listaProduto);

        for (Produto item : listaProduto){

            System.out.println(item);
        }
    }
}
