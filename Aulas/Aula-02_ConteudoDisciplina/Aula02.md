// Data: 30/07/2026
## Conceitos Iniciais PO
- ordenar: organizar uma estrutura (lista ou vetor) a partir de um ou mais índices ou chaves
  - por que ordenar? **Para otimizar a busca ou pesquisa**
- Pesquisar/search/find: Localizar ou buscar um dado dentro de uma estrutura via alguma chave
- recuperação/retrieve: localizar ou buscar dados com **relevância**                    
- complexidade de um algoritmo: é o esforço computacional de um algoritmo
  - alta complexidade: mais esforço
  - baixa complexidade: menos esforço
- estabilidade:o quanto a estrutura é desordenada até chegar na ordenação
- instabilidade: os melhores algoritmos são instáveis

**Relevância:** Dados além da pesquisa, como rei do futebol trazer pelé


### **Notação Big O:**
em um caso onde os dados estão "crescendo exponencialmente", cortamos os dados pela metade com "boas perguntas"
**Algoritmos:** 
- O(n!) - fatorial: maior complexidade        ^
- O(n^x) - exponencial, bubble sort /bolha    |
  - é um método estável pois não desorganiza  |
  - o vetor                                   |
- O(log n + n)  comb Sort/ pente              |  quanto mais pra cima maior a complexidade
  - Instável, os melhores algoritmos são      |
  - isntáveis                                 | 
- O(h) - linear:                              |
- O(log n) - logaritmo: menor complexidade    |


## O que veremos na disciplina
Search/ find = buscar| localizar| Pesquisar

## CRUD
- Create
- retrieve // **search**
- Update
- Delete

## Como medir a complexidade  (teremos uma disciplina referente a isso)
### **Ordenação:** 
  qtd de comparações + qtd de trocas
comparações são: 
 - adjacente: if(lista[i]> lista[i+1]) {

 }  
trocas são:
 - em um caso adjacente:
  if(lista[i]> lista[i+1]) {
    //precia de uma variável auxiliar
    aux=lista[i]
    lista[i]=lista[i+1]
    lista[i+1]= aux
    //isso é uma troca
 }
### **Pesquisa**
apenas a quantidade de comparações
