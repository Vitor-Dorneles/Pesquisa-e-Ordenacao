import java.util.HashSet;

public class HashSimples {
    
    public static void main(String[] args) {
        HashSet<String> tabelaHash = new HashSet<>();

        tabelaHash.add("Alexandre");
        tabelaHash.add("Hermes");
        tabelaHash.add("Davi");
        tabelaHash.add("alan");
        tabelaHash.add("Alexandre");
        tabelaHash.add("davi");

        for (String item : tabelaHash) {
            System.out.println(item + " ->" + item.hashCode());
        }
    }    
}