
package controller;

import model.TabelaHash;


/**
 *
 * @author laboratorio
 */
public class Encurtador {
        
    public static String encurtar (String linkOriginal, TabelaHash tabela){
        String DOMINIO = "localhost";
        String hashGerado = "" + (linkOriginal.hashCode() & 0x7fffffff);
        
        tabela.links.put(hashGerado, linkOriginal);
        return DOMINIO + "/" + hashGerado; //link encurtado
    }
    
    public static String buscarLinkEncurtado(String linkEncurtado, TabelaHash tabela) {
        String dadosLink[];
        dadosLink = linkEncurtado.split("/");
        String hashObtido = dadosLink [dadosLink.length -1];
        
        String resposta = tabela.links.get(hashObtido);
        if (resposta == null) {
            resposta = "vazio o link";
        }
        return resposta;
    }
}
