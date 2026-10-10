# poo-lista-03

## Questão 4

**Explique a diferença entre um array de tipos primitivos (`int[]`, `double[]`) e um array de objetos (`Aluno[]`, `Produto[]`) em Java.**

A diferença está no que cada posição do array guarda. Em um array de tipos primitivos, cada posição guarda o próprio valor (o número em si). Em um array de objetos, cada posição guarda apenas uma referência, que é o endereço de um objeto que fica em outro lugar da memória. Por isso, os valores iniciais também são diferentes: um `int[]` já nasce preenchido com `0` (`double[]` com `0.0`, `boolean[]` com `false`), enquanto um `Aluno[]` nasce com todas as posições `null`.

### a) Como a memória é alocada em cada caso?

Em Java, todo array é um objeto e fica no heap. A variável que aponta para ele (`int[] notas`, `Aluno[] alunos`) fica na stack e guarda a referência para o array.

- **Array de primitivos:** os valores ficam guardados dentro do próprio array, um ao lado do outro. Ao fazer `new int[5]`, o Java reserva espaço para 5 inteiros e já os inicializa com `0`.
- **Array de objetos:** o array guarda só as referências. Ao fazer `new Aluno[5]`, são criadas 5 posições vazias (`null`), e nenhum objeto `Aluno` existe ainda. Cada objeto precisa ser criado separadamente com `new Aluno(...)`, fica em outra região do heap, e o array apenas aponta para ele.

```java
int[] numeros = new int[3];        // [0, 0, 0]
Aluno[] alunos = new Aluno[3];     // [null, null, null]
alunos[0] = new Aluno("Ana", "2024001"); // agora a posição 0 aponta para um objeto
```

### b) Quais cuidados devem ser tomados ao acessar elementos de um array de objetos?

- **`NullPointerException`:** como as posições começam como `null`, chamar um método em uma posição que não foi instanciada (`alunos[1].getNome()`) gera esse erro. É preciso instanciar o objeto antes de usar ou verificar com `if (alunos[i] != null)`.
- **`ArrayIndexOutOfBoundsException`:** só existem índices de `0` até `length - 1`. Acessar fora desse intervalo gera erro (vale para qualquer array).
- **Cópia rasa:** copiar o array com `clone()` ou `Arrays.copyOf()` copia apenas as referências, então os dois arrays passam a apontar para os mesmos objetos. Alterar um objeto por um array também altera no outro.
- **Comparação de objetos:** `==` compara as referências, não o conteúdo dos objetos. Para comparar o conteúdo, deve-se usar `equals()`.
- **Tamanho fixo:** o array não cresce. É preciso controlar quantas posições foram realmente preenchidas (como a `Turma` faz com `quantidadeAlunos`) ao percorrer o array, para não acessar posições `null`.
