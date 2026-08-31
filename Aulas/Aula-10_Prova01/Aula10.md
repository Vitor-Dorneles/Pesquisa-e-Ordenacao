// Data: 31/08/2026

## Tema Abordado
- Arquivo vindo de uma memoria secundaria para a memoria primaria vem em lista para ordenar

### Correção da prova:

1) Memória interna x Externa:

    - Memória interna não separa em blocos (mais velocidade).
    - Memória externa separa dos dados em "blocos"

2) Estável x Instável:

    - Na situação da prova, para o algorítimo ser considerado estável, deveria ordenar por nome e TAMBÉM por idade.
    
3) Comparable:
    
    - A resposta era:
        - Comparable
            - CompareTO
                - Return -1
                - Return +1

4) Qual método funciona melhor se a lista de entrada já estiver completamente ordenada?

    - Bolha ou inserção (N-1)

5) Agitação e pente:

    - O método de agitação dilui o problema dos elementos tartaruga, fazendo uma pré-ordenação.
    - O método pente aplica o "olhar a distância" diminuindo as comparações finais.

    