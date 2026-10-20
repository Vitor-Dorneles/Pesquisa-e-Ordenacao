// Data: 14/10/2026
**O que é:** técnica que calcula onde guardar o elemento; para buscar, calcula de novo e vai direto lá. Busca em O(1) na média (O(n) no pior caso)

- Quem calcula é a **função hash**: chave entra, posição sai (ex.: `k % tamanho`).
- Mesma chave → sempre a mesma posição.
- Não compara elemento por elemento, como a busca sequencial ou a binária.
- Também chamada de **espalhamento**: a função espalha os elementos pelo vetor.
- Uso real: o SO aplica hash sobre um campo do arquivo (em geral o identificador) para decidir onde gravá-lo no disco.

A tabela hash não fica ordenada; ela serve para guardar e buscar

- A posição vem da função, não da ordem: com `k % 10`, o 19 vai para a posição 9 e o 20 para a 0.
- Por isso não dá para listar em ordem nem buscar "entre 10 e 20".

Não acesso por posição (não tem `get(i)` como a lista): a posição existe, mas quem decide é a função hash

**HashMap x HashSet** (Java, `java.util`)

Map == dicionário
Set == conjunto (sem repetição)

- `HashMap`: guarda **chave → valor** (`put`, `get`). Chave não repete; valor pode repetir.
- `HashSet`: guarda só o **elemento** (`add`, `contains`). Não deixa entrar repetido.
- Os dois usam `hashCode()` para achar a posição e `equals()` para ver se é igual.

**Hash com objetos** (`HashObjetos.java`)

- Para o `HashSet` barrar `Aluno` repetido, a classe precisa sobrescrever `hashCode()` e `equals()`. Sem isso, o repetido entra.
- Hash igual ≠ objeto igual: `Aluno(1, "Alexandre")` e `Aluno(1, "Davi")` têm o mesmo hash, mas nomes diferentes, então os dois entram.
- `String` diferencia maiúsculas: "Davi" e "davi" são elementos diferentes.

**Colisão**

- Acontece quando **chaves diferentes** caem na mesma posição. É o que leva ao O(n) no pior caso.
- **Endereçamento aberto** (tabela hash **fechada**): usa só o vetor; se a posição está ocupada, procura outra livre. Tem o limite do tamanho do vetor.
- **Lista encadeada** (tabela hash **aberta**): cada posição guarda uma lista com todos que caíram ali. O limite é só a memória.
- Tabela grande espalha melhor e diminui as colisões.



## Destilado


## Perguntas
?? O que é colisão em Hash e por que acontece : Acontece quando chaves diferentes caem na mesma posição, 

## Erro que cometi
