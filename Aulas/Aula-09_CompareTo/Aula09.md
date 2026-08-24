# Aula 09 — Compare To
// Data: 24/08/2026
Hoje utilizaremos o apache netBeans,
iremos digitar 5 e 6 nomes com idades diferentes e ordenar por idade
Vamos utilizar o Hashcode e a interface Compareble, para usar o método compareTo

## CompareTo
comparação de elementos
1º elemento nagativo significa que ele é menor que o primeiro
maior ele é maior que o segundo
0 são equivalentes

?? Assim que montarmos uma classe o que deve ser feito? :: Métodos de comparação por padrão, ToString, get e set

?? Para que serve o compareTo :: é algo para comparação padrao que serve como comparação em casos que temos de ordenar lista de objetos, implementamos a interface Compareble
 
como ordenar lista de objetos, sugestão do sor, deixar pronto o CompareTo com regra de ordenação padrão
claro que podemos ordenar sem método próprio, ai seria usando as Expressões lambda do sort padrão, muito mais difícil de dar manutenção e fugindo de uma organização
serve mais para algo temporário