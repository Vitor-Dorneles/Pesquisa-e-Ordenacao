// Data: 03/09/2026
## O que foi visto hoje
Algoritmos Quick e merge
vendo também sobre o melhor e pior caso

## Merge
Baseado em árvore de recursão, cada divisão vira um nó(um só). O merge sempre divide no meio (divisão homogênea), descendo até chegar em 1 elemento — aí a divisão para.
A ordenação ocorre na volta da recursão (intercalação), não na descida.
Pegamos o índice da frente de cada vetor provisório e comparamos: o menor avança pro vetor final, e o índice do lado que perdeu também avança. O vetor original não muda de tamanho — o índice é que anda pra frente nele.

Ex: [1,2] e [3,4] → comparo 1 com 3, o 1 avança; comparo 2 com 3, o 2 avança;
o lado esquerdo esvaziou, então copio o resto do outro lado (3,4) direto, sem
comparar — resultado [1,2,3,4]. Essa regra do lado esvaziar vale sempre, não
só nesse exemplo.


## Quick
No quick escolhemos um pivô, o Objetivo de uma passada não é ordenar o vetor, é só garantir que tudo menor que o pivo fica a esquerda dele, e tudo maior a direita, depois disso por consequencia temos o pivô ordenado
Funciona com recursividade também, 
etapas
1. pivô escolhido = último(lista.size()-1) ou primeiro elemento
2. Um índice "i" inicia com valor sentinela(-1) e marca até onde tudo for menor que o pivô escolhido, i terminará com o mesmo valor do indice do pivo
3. "j" percorre o vetor do início(0) até o indice antes do pivô
4. quando "j" (vetor[j]) for menor que o pivo o indice "i" avança
5. se encontrar um elemento menor que o pivo faz a troca entre os elementos,entre vetor[i] e vetor[j], elemento menor que o pivo vai para a posição que i representará, e o valor de lá vai para a posição do menor
6. j encerra no indice anterior ao pivo, quando ele encerrar nós pegamos i e incrementamos (i+1), trocamos o pivo pelo indice que o i assumir, e assim o pivo estará ordenado

O desbalanceamento ocorre quando o pivô distoa muito da maioria dos elementos, sobrando assim a maioria a esquerda ou a direita dele

### Condição de parada
Depois de ordenar o pivô, analisamos os dois subvetores ao redor dele: o lado esquerdo (índices início até o índice anterior ao pivô) e o lado direito (índice seguinte ao pivô até fim).
Para saber se um lado precisa ser particionado de novo, calculamos seu tamanho com fim - início + 1.
A condição de parada é **início < fim**: se for verdadeira, o subvetor tem mais de um elemento, e o Quick chama a si mesmo recursivamente para particionar esse lado. Se início >= fim, o subvetor tem 0 ou 1 elemento — já está no caso-base, ordenado por definição, e a recursão para ali.

## Qual o melhor?
Depende do tamanho e da pré-ordenaçâo


## Destilado


## Perguntas
?? Como a divisão do algoritmo merge influencia na sua complexidade em um caso pré ordenado e um não pré ordenado? :: Ele divide o vetor sempre pela metade, independente de estar ordenado ou não — a única condição é o tamanho ser maior que 1. Por isso a quantidade de comparações não muda com a ordem de entrada.

?? Como o merge funciona e intercala? :: A - Divide ao meio recursivamente até sobrar 1 elemento (caso-base) → [4,3,2,1] → [4,3] e [2,1] → [4] [3] [2] [1] || B - Sobe intercalando em duplas: compara os dois e o menor inicia o vetor de 2 → [4] vs [3] → [3,4] | [2] vs [1] → [1,2] || C - Sobe intercalando os vetores maiores: compara o elemento da frente de cada lado, o menor vai pro vetor novo e o índice daquele lado avança → [3,4] vs [1,2]: 3 vs 1 → 1 avança | 3 vs 2 → 2 avança || D - Quando um lado esvazia, copia o resto do outro direto, sem comparar → [1,2] esvaziou, copia [3,4] → resultado final [1,2,3,4]

?? Como o quicksort garante que o vetor seja ordenado, se cada particionamento só posiciona um único elemento (o pivô)? :: Porque o algoritmo se aplica recursivamente aos dois subvetores ao redor do pivô (esquerda e direita), cada chamada posicionando um novo pivô, até que os subvetores cheguem a 0 ou 1 elemento(tamanho) (início >= fim) — nesse ponto já estão ordenados por definição, e a recursão para.
