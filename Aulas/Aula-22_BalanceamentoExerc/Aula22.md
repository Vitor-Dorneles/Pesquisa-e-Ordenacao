// Data: 09/11/2026
revisão da última aula

tudo visto anteriormente é em RAM

## Calcular Altura 
fb = altura(subArvore->esquerda) - altura(subArvore->direita)
         20  [Alt: 2] (fb: -2)
           \
            30  [Alt: 1] (fb: -1)
              \
               50  [Alt: 0] (fb: 0)
nó folha 50 é zerado pois não tem filhos,
usamos a altura dele para calcular o 30
Cálculo do fb: (-1, o lado vazio tem um valor fixo de -1) - (0, altura da direita) = -1
20 =  (-1) - (-1) = -2
