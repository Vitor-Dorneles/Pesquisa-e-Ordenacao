// Data: 13/08/2026
# Estrutura de Dados
A escolha da Estrutura é limitante quanto a escalabilidade
## Algoritmos
### Agitação - shake sort
um algoritmo parecido mas melhor que o bolha
```c++
void agitacao(List<> lista) {
        bool houveTroca;
        int tmp;
        int ini = 0;
        int fim = lista.Count;
        int qtdComparacoes = 0, qtdTrocas = 0; //avalia a complexidade ou o esforço
        do {
                houveTroca = false;
                for (int i = ini; i < fim - 1; i++)
                {
                        qtdComparacoes++;
                        if(lista[i] > lista[i+1]){
                                qtdTrocas ++;
                                houveTroca = true;
                                tmp = lista[i];
                                lista[i] = lista[i +1];
                                lista[i+1] = tmp;
                        }
                }
                if (!houveTroca) {
                        break;
                }
                fim--;

                houveTroca = false;
                
        }
}
```
# Organização MVC
Devemos organizar o código bolha e agitacao no modelo MVC
