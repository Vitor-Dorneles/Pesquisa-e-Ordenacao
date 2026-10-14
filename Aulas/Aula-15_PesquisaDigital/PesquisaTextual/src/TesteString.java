public class TesteString {

    // O string comum não suporta muitos caracteres, por isso temos novos tipos de String
    public static void main(String[] args) {
        String sFrase = "Alexandre de oliveira";
        String palavra = "andre";
        int tamanhoPalavra = palavra.length();
        StringBuffer sbFrase = new StringBuffer("Alexandre de oliveira");
        StringBuilder sbuilderFrase = new StringBuilder("Alexandre de oliveira");

        System.out.println(sFrase.contains("andre"));
        System.out.println(sFrase.indexOf("andre"));
        //System.out.println(sbFrase.);
        
        //ex
        for (int i = 0; i + tamanhoPalavra < sFrase.length(); i++) {
            if (palavra.equalsIgnoreCase(sFrase.substring(i, i + tamanhoPalavra))) {
                System.out.println("encontrei ... \n");
            }
         }
    }
}