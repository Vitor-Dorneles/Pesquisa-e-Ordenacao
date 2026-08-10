// Data: 10/08/2026
## Algoritmos
### Bolha - 2 Repetições
1º) While
2º) for
- Simples == **Memória RAM**
- O(N²) == **Parte ordenada está no final da Estrutura**
- Estável
- O maior valor a cada passada é levado até o final da estrutura por exemplo == 100 40 20 50 10, o 100 de 1 a 1 vai ser levado ao lugar do 10, cada comparação e troca de lugar é contabilizada
#### Código
``` java 
void bolha (List<int>Lista){
        int auxiliar;
        boolean houveTroca;
        int i;
        do{
                houveTroca = false;
                for(i=0; i < lista.Size() -1; i++){
                        if(lista[i] > lista[i+1]){
                                houveTroca = true;
                                auxiliar = lista[i];
                                lista[i] = lista[i+1];
                                lista[i+1] = auxiliar;
                        }
                }
        }
}
```
### Seleção - 2 Repetições
1º) for
2º) for
- Simples == Memória RAM
- O(n²) == Parte ordenada está no início da estrutura
- instável
- A cada célula do vetor, ao avançar, se seleciona (ou laça) o menor valor para aquela posição
#### Código
```java
void selecao(List<int> lista){
        int posMenor, auxiliar;
        int i, j;

        for(i=0; i<lista.Size()-1; i++){
                posMenor = 1;
                for(j= i+1;j<lista.Size(); j++){
                        if(lista[j]<lista[posMenor]){
                                posMenor=j;
                        }
                }
                if(i!=posMenor)
                //bloco de troca
                aux = lista[i];
                lista[i]=lista[posMenor];
                lista[posMenor] = tmp;
        }
}
```
### Inserção - 2 Repetições
1º) for
2º) for
- Simples == Memória RAM
- O(N²) == parte ordenada está no início da estrutura, esse 2 corresponde ao número de "for"
- Estável 
- Cada valor da porção da direita da estrutura é inserido na sua posição correta na porção esquerda
#### Código
```java
void insercao(List<int> lista){
        int aux, i , j;
        for(i=1; i<lista.Size(); i++){
                aux=lista[i];
                for(j=i-1; j>=0; j--){
                        if(aux<lista[j]){
                                lista[j+1] = lista[j];
                        } else break;
                }
                lista[j+1] = aux;
        }
}
 ```


# Organização desses Códigos
Seguindo o MVC
## Model
Utilidades.java
popularLista(...)
## View
ListaView.java
exibirLista(...)
exibirTempo(...)
## Controller
ListaController.java
listaBolha
listaSelecao
listaInsercao
popular lista Bolha -- 5.000
popular lista Selecao -- 5.000
popular lista Insercao -- 5.000

nome.bolha(listaBolha)
nome.selecao(listaSelecao)
nome.insercao(listaInsercao)

## Organizar os códigos anteriores conforme o modelo MVC
teremos uma classe "Ordenação"
Ordenação.bolha(listaBolha)
Ordenação.selecao(listaSelecao)
Ordenação.insercao(listaInsercao)

onde essa classe deve ficar?
