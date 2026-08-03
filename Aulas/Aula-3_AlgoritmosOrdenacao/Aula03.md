// Data: 03/08/2026
## Padrão Arquitetural - Proj. Software
**MVC:** MODEL - VIEW - CONTROLLER
Na aula de hoje e a partir dela usaremos este modelo
é muito importante manter esse padrão, é como se fosse uma organização diferente para os arquivos
## Arquivo MVC Exemplo
Explicando como funciona a organização, é um projeto feito no netBeans que não trabalha com Banco ainda

1. Começamos pelo Model, é a primeira coisa a ser feita
2. Seguindo a regra a segunda coisa a ser feita é o CONTROLLER, (menus) é a operação do sistema

## Ordenação
### Conceitos e Fundamentos
Uma estrutura pode ser ordenada pelos seguintes critérios
#### 1. Utilização da memória
 - memória interna ou memória externa
      - memória interna é quando todos os dados a serem ordenados cabem na memória RAM(principal), é considerado memória externa quando os dados são maiores que a RAM disponível
#### 2. estabilidade
- estabilidade do algoritmo
      - Um algoritmo é considerado **estável** quando mantém a ordenação original de atributos com chaves iguais, e o processo de ordenação sempre garante a ordenação temporária da estrutura
          Ana    — nota 8
          Carlos — nota 7
          Bruno  — nota 8
          Depois de ordenar pela nota:
          Carlos — nota 7
          Ana    — nota 8
          Bruno  — nota 8
        **instável**: o processo de ordenação não garante a ordenação temporária da estrutura e, pode alterar a ordem relativa dos elementos que possuem chaves iguais.
#### 3. complexidade
A complexidade representa o esforço computacional necessário para executar um algoritmo, na ordenação podemos ver este esforço por:
1. qtd comparações
2. qtd trocas
3. deslocamentos
4. acessos à memória
5. chamadas recursivas
**Principais Complexidades:**
O(n) - Crescimento linear == menor complexidade
O(n log n) - Crescimento linearítmico
O(n²) -	Crescimento quadrático
O(d(n + k)) -	Depende da quantidade de dígitos e da base
O(n!) - crescimento fatorial == maior complexidade

#### 4. formação das porções ordenadas   
Durante a execução, alguns algoritmos formam regiões que já estão ordenadas, elas podem ser no:
1. início
2. final
3. nas duas extremidades
4. em Subsequências
5. por faixas de valores
6. por partições

### Conceitos chaves
**Eficácia vs Eficiência:** Eficaz é quando funciona, Eficiência é quando funciona melhor resolvendo o mesmo problema
**Qual o melhor algoritmo de Ordenação?** Não existe um definidamente melhor para todas as situações, a escolha depende das condições do problema. (Tamanho, ordenação atual, estabilidade, memória, tipo de dados)

### Atividade Fixação
1) pesquisar sobre os métodos de ordenação e categoriza-los em:
    - algoritmo de memória interna ou memória externa
      - ordenação interna: na RAM principal
      - ordenação externa: parte vai pra RAM a que está sendo ordenada, o restante fica no disco aguardando para ser ordenado 
    - estabilidade (estável ou instável)
    - complexidade
    - porções de ordenação

Pesquisar os seguintes métodos de ordenação:
- legenda: 
  - n: quantidade de elementos;
    k: quantidade de baldes ou valores possíveis;
    d: quantidade de dígitos ou posições da chave.
#### bolha (bubble sort)
compara elementos vizinhos trocando - os de posição quando estão na ordem incorreta
        - memória interna
        - estável
        - O(nˆ2)
        - porção ordenada: final

#### seleção (selection sort)
procura o menor elemento da parte não ordenada e insere na proxima posição da parte ordenada
        - memória interna
        - instável
        - O(nˆ2)
        - porção ordenada: início

#### inserção (inserction sort)
constrói uma proção ordenada no início da estrutura, cada novo elemento é retirado da parte não ordenada e inserido na posição correta da parte ordenada
        - memória interna
        - estável
        - O(nˆ2)
        - porção ordenada: início

#### pente (combsort)
parecido com o Bubble, compara elementos separados por uma distância maior(gap), a distância é reduzida até cehgar a 1
        - memória interna
        - instável
        - O(n²)
        - porção ordenada: não possui algo fixo, os valores podem ser movimentados em diferentes regiões do vetor
#### agitação (shakesort ou cocktailsort)
um bubble sort que percorre o vetor nos dois sentidos, **(-->):** nesta os maiores valores são levados para o final e **(<--):** nesta os menores valores são levados para o início
[menor] | parte não ordenada | [maior]
        - memória interna
        - estável
        - O(N²)
        - porção ordenada: início e final

#### shellsort
Generalização do Insertion sort, começa organizando os elementos que estão distantes uns dos outros e os intervalos são reduzidos até chegar a 1
        - Memória interna
        - Instável
        - depende do intervalo a ser ordenado
        - porção ordenada: Subsequências espalhadas pelo vetor

#### bucketsort
distribui os elementos em diferentes baldes de acordo com faixas de valores, depois cada balde é ordenado e assim os baldes são reunidos na ordem correta
        - Memória Interna
        - Estável condicionalmente
        - O(n+k) no caso médio
        - porção ordenada: faixas de valores
#### radix
ordena os valores analisando uma posição da chave por vez, por exemplo em diversos números centenários ele primeiro verá as unidades e ordenará, depois as dezenenas e etc
        - Memória interna
        - Estável
        - O(d(n+k))
        - porção ordenada:por quantidade de dígitos processados

#### heapsort
ordem crescente, é construída uma "árvore" onde o maior elemento fica na raiz.
        - Memória Interna
        - Instável
        - O(n log n)
        - final

#### mergesort
estratégia de divisão e conquista, dividi o vetor até formar partes com um elemento e intercala as partes, combinando elas de forma ordenada
        - Interna
        - Estável
        - O(n log n)
        - blocos distribuídos pelo vetor
#### quicksort
também utiliza divisão e conquista, ele escolhe um elemento (**pivô**) e separa os demais elementos em partições.
valores menores antes do pivô e maiores depois
        - Interna
        - Instável
        - O(n log n)
        - posições dos pivôs e partições