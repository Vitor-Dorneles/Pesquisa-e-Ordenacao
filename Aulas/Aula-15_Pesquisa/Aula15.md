// Data: 01/10/2026
Começamos a ver de pesquisa

# Pesquisa
    - dependente de ordenação
    - quando a estrutura está desordenada
- exemplo em java com 1000 numeros aleatorios
  
## Pesquisa Binária
a estrutura precisa estar ordenada
Professor falando sobre pesquisar descartando pela motade, como operação BIG O
falou sobre o index off, que informa o numero contido, diferente do contains, que informa que temos

```java
public static boolean pesquisaBinaria(int numero, ArrayList<Integer> lista) {
    int ini = 0;
    int fim = lista.size()-1;
    int meio;
    long qtdComparacoes = 0;

    do {
        meio = (int)(ini+fim)/2;
        qtdComparacoes ++;
        if(numero == lista.get(meio)) {
            return true;
        }
        if (numero < lista.get(meio)) {
            fim = meio -1;
        } else {
            ini = meio + 1;
        }
    } while (ini <= fim);
    sout("Quantidade de comparações: " + qtdComparacoes);
    return false;
}
```
