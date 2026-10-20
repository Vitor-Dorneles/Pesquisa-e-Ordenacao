/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package servidor.model;

import java.util.HashMap;

/**
 * classe para sessoes de telefonia
 * @author vitor
 */
public class TabelaHash {
    /**
     * sessoes é um hashmap com chave celular e conteúdo sendo dados da sessao
     */
    
    public HashMap<String, Sessao> sessoes;
    
    public TabelaHash() {
        sessoes = new HashMap<>();
    }
}
