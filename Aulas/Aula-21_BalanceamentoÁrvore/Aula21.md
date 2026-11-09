// Data: 05/11/2026
## Por que balancear
Balanceamento ou equilíbrio em Árvores Binárias de Pesquisa (ordenadas)
- **Justificativa/Motivo:** guardar para localizar depois, o melhor é árvore, serve para acelerar as buscas, ou seja, diminuir o número de comparações
  - O custo da busca é a altura da árvore: balanceada ≈ `log n` comparações; degenerada (inserção já ordenada) vira lista, `n` comparações.

## Técnicas: AVL e DSW
Há duas técnicas:
- **AVL:** faz o balanceamento ao inserir (melhor abordagem), ou seja, garante que a árvore esteja a menos profunda e mais balanceada possível
  - Corrige a cada operação (inserção e também remoção), então a árvore nunca chega a ficar desbalanceada.
- **DSW:** faz o balanceamento em uma árvore totalmente desbalanceada
  - Balanceia a árvore inteira de uma vez, depois de pronta: vira uma "espinha" (lista só à direita) e depois é dobrada com rotações à esquerda.

## Fator de balanceamento
Na estrutura de uma árvore AVL ou DSW há um novo atributo:
- **fb ou fe:** fator de balanceamento ou fator de equilíbrio
- `fb = altura(subArvore->esquerda) - altura(subArvore->direita)`
  - fb positivo: esquerda mais alta; fb negativo: direita mais alta.

Um nó, quando entra na árvore, tem fator de balanceamento 0
- Entra sempre como folha: as duas subárvores vazias têm a mesma altura.

**Situação de desbalanceamento/desequilíbrio:** `fb == -2` ou `fb == 2` — é aí que precisamos balancear
- O nó a girar é o primeiro ancestral com ±2 subindo a partir do nó inserido.

## Rotações
Há somente dois métodos de rotação/giro:
- Rodar/girar para a **esquerda** → quando -2
- Rodar/girar para a **direita** → quando +2

Há dois tipos de balanceamento:
- **Rotação/giro simples:** um giro no nodo pai desbalanceado
  - `pai == -2` e `filho == -1`
  - `pai == +2` e `filho == +1`
  - Quando os dois têm sinais iguais, temos uma rotação simples
  - Puxamos o pai com valor 2 para o lado (esquerda ou direita) e transformamos o filho ±1 em raiz
    - Sinais iguais = o peso está "em linha reta" (direita-direita ou esquerda-esquerda): um giro endireita.
- **Rotação/giro duplo:** um giro no nodo filho e outro giro no nodo pai desbalanceado
  O pai vira filho e o filho vira raiz
  - É uma rotação simples ×2 (duas na sequência)
  - Primeiro rodamos o filho, para o lado que seja (+, -)
  - `pai == -2` e `filho == +1`
    - Filho para a direita, depois pai para a esquerda.
  - `pai == +2` e `filho == -1`
    - Filho para a esquerda, depois pai para a direita.
  - Sinais opostos = peso em "zigue-zague": o 1º giro transforma no caso simples, o 2º resolve.

## Código
```c
Arvore *rodarEsquerda(Arvore *r) {
    Arvore *novoPai;
    Arvore *tmp;

    novoPai = r->dir;
    tmp = novoPai->esq;
    novoPai->esq = r;

    r->dir = tmp;

    return novoPai;
}

Arvore *rodarDireita(Arvore *r) {
    Arvore *novoPai;
    Arvore *tmp;

    novoPai = r->esq;
    tmp = novoPai->dir;
    novoPai->dir = r;

    r->esq = tmp;

    return novoPai;
}
```
- `tmp` guarda a subárvore do meio: ela troca de dono (de `novoPai` para `r`) e continua em ordem, porque fica entre os dois valores.
- A função devolve a nova raiz da subárvore: quem chama precisa religar o ponteiro (`r = rodarEsquerda(r);` ou `pai->dir = ...`).
- Depois do giro, o fb de `r` e de `novoPai` precisa ser recalculado.
