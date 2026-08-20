// Data: 20/08/2026
# Algoritmo Pente
Parecido com o bolha, mas compara elementos separados por uma **distância (gap)**, não só vizinhos. Isso resolve o problema das "tartarugas" do bolha (valores pequenos perto do fim que demoram várias passagens pra chegar no início).

- gap inicial = tamanho da lista
- a cada passagem: `gap = gap / 1.3` (fator de encolhimento, valor empírico ótimo)
- gap nunca menor que 1

**Quando parar?** precisa que o gap seja 1 **e** que uma passagem inteira com gap=1 não tenha feito troca (igual critério de parada do bolha).

- memória interna
- **instável** (compara elementos distantes, pode trocar a ordem relativa de chaves iguais)
- pior caso O(n²), mas na prática bem mais rápido que o bolha
- porção ordenada: não tem região fixa 

```java
void pente(List<int> lista){
    int i, temp, gap = lista.size();
    boolean houveTroca;

    do{
        gap = (int)gap/1.3;
        if(gap<1) gap=1;
        houveTroca= false;
        for(i=0; i + gap < lista.size(); i++){
            if(lista[i] > lista[i + gap]){
                houveTroca = true;
                temp = lista[i];
                lista[i] = lista[i + gap];
                lista[ i + gap] = temp;
            }
        }
    } while (gap > 1 || houveTroca);
}
```