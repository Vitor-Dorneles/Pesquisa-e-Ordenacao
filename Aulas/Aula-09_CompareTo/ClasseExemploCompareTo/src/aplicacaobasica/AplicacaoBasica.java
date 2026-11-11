/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package aplicacaobasica;

import java.util.ArrayList;

/**
 *
 * @author vitor
 */
public class AplicacaoBasica {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ArrayList<Pessoa> lista = new ArrayList<>();
        
        Pessoa p =new Pessoa("Maria" , 20);
        
        lista.add(p);
        
        p = new Pessoa("Maria", 19);
        
        if(!lista.contains(p)) {
            lista.add(p);
        }
        
        System.out.println(lista);
        
        lista.add(new Pessoa("Gabriel", 20));
        lista.add(new Pessoa("João", 21));
        lista.add(new Pessoa("Gabriel", 21));
        lista.add(new Pessoa("João", 22));
        
    }
    
}
