package model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;


public class ArquivoProduto {
    private FileWriter arqEscrita;
    private BufferedWriter escritor;

    private FileReader arqLeitor;
    private BufferedReader leitor;

    private List<Produto> listaProdutos;

    public String nomeArquivo;

    public ArquivoProduto(String nomeArquivo) {
        this.nomeArquivo = nomeArquivo;
        listaProdutos = new ArrayList<>();
    }

    public List<Produto> leArquivo() {
        listaProdutos.clear();

        try {
            arqLeitor = new FileReader(nomeArquivo, StandardCharsets.UTF_8);
            leitor = new BufferedReader(arqLeitor);
            leitor.readLine(); //descartar o cabeçalho

            String linha;

            while ((linha = leitor.readLine()) != null) {
                String[] campos = linha.split(";");

                int id = Integer.parseInt(campos[0]);
                String nome = campos[1];
                String categoria = campos[2];
                double preco = Double.parseDouble(campos[3]);
                int qtdEstoque = Integer.parseInt(campos[4]);

                Produto produtoArqu = new Produto(id, nome, categoria, preco, qtdEstoque);

                listaProdutos.add(produtoArqu);
            }
            leitor.close();
            arqLeitor.close();
        } catch (FileNotFoundException e) {
            System.out.println("Arquivo ainda não existe");

        } catch (IOException e) {
            e.printStackTrace();
        }

        return listaProdutos;
    }
    
    public void gravaArquivo(List <Produto> lista, String caminhoDestino) {
        try {
            arqEscrita = new FileWriter(caminhoDestino,StandardCharsets.UTF_8, false);
            escritor = new BufferedWriter(arqEscrita);

            escritor.write("id;nome;categoria;preco;estoque"); //cabeçalho
            escritor.newLine();

            for (Produto produto : lista) {

                escritor.write(
                         produto.getId()+ ";" +
                                produto.getNome() + ";" +
                                produto.getCategoria() + ";" +
                                String.format(Locale.US, "%.2f",produto.getPreco()) + ";" +
                                produto.getQtdEstoque()
                        );
                escritor.newLine();

            }
            escritor.close();
            arqEscrita.close();

            System.out.println("Lista salva no arquivo");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Produto> getListaProdutos() {
        return listaProdutos;
    }
}
