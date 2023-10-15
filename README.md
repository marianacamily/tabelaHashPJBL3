# Tabela Hash -PJBL3
Trabalho da disciplina de Estrutura de Dados, feito por Beatriz Petry, Julia Engels e Mariana Camily, cursando o 4° período de Engenharia de Software na PUCPR. O trabalho é baseado em uma implementação de uma tabela Hash, com o tratamento de colisões, tendo como base as funções de inserção, busca e remoção, que serão recuperadas percorrendo uma lista que irá corresponder cada função dada pela tabela hash.

# Tratamento de Colisão
Uma colisão em uma tabela hash ocorre quando dois ou mais elementos têm o mesmo valor de função de dispersão (ou "hash"). Isso significa que eles são mapeados para a mesma posição na tabela hash. Neste caso, iremos utilizar 2 maneiras de tratar essas colisões, sendo elas: Encadeamento (Chaining): Cada slot da tabela hash contém uma lista encadeada de elementos que têm o mesmo valor de hash. Sondagem Quadrática (Quadratic Probing): Semelhante à sondagem linear, mas a função de sondagem utiliza uma função quadrática para calcular a próxima posição de inserção.
