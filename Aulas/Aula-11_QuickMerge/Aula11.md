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
3 formas de escolher o pivo, o aleatório o primeiro e o menor
teremos um for comparando o ao lado esquerdo do pivo e um ao lado direito do pivo
é como se fosse um EDR de árvore, 
o quick ordena quando posiciona o pivo

## Qual o melhor?
Depende do tamanho e da pré-ordenaçâo


## Destilado


## Perguntas
?? Como a divisão do algoritmo merge influencia na sua complexidade em um caso pré ordenado e um não pré ordenado? :: Ele divide o vetor sempre pela metade, independente de estar ordenado ou não — a única condição é o tamanho ser maior que 1. Por isso a quantidade de comparações não muda com a ordem de entrada.

?? Como o merge funciona e intercala? :: A - Divide ao meio recursivamente até sobrar 1 elemento (caso-base) → [4,3,2,1] → [4,3] e [2,1] → [4] [3] [2] [1] || B - Sobe intercalando em duplas: compara os dois e o menor inicia o vetor de 2 → [4] vs [3] → [3,4] | [2] vs [1] → [1,2] || C - Sobe intercalando os vetores maiores: compara o elemento da frente de cada lado, o menor vai pro vetor novo e o índice daquele lado avança → [3,4] vs [1,2]: 3 vs 1 → 1 avança | 3 vs 2 → 2 avança || D - Quando um lado esvazia, copia o resto do outro direto, sem comparar → [1,2] esvaziou, copia [3,4] → resultado final [1,2,3,4]


