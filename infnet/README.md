# Primeira Entrega:
## LISTA 1:

Implemente um projeto JAVA de uma Loja virtual ACME que vende downloads de músicas, videos e imagens.

Classes de modelo 
Produto [String nome, Path file, BigDecimal Preco]
Cliente [String Nome]
Assinatura [BigDecimal mensalidade, begin, end (Optional) Cliente] Obs: Crie 2 construtores, um com o "end" e outro sem. 

Quando um usuário realiza uma nova compra um "Pagamento" é utilizado para representá-la.

Pagamento [List<Produtos>, dataCompra, Cliente]

1 - Crie uma Classe com um método main para criar alguns produtos, clientes e pagamentos. Crie Pagamentos com:  a data de hoje, ontem e um do mês passado.

2 - Ordene e imprima os pagamentos pela data de compra.

3 - Calcule e Imprima a soma dos valores de um pagamento com optional e recebendo um Double diretamente.

4 -  Calcule o Valor de todos os pagamentos da Lista de pagamentos.

5 - Imprima a quantidade de cada Produto vendido.

6 - Crie um Mapa de <Cliente, List<Produto> , onde Cliente pode ser o nome do cliente. 

7 - Qual cliente gastou mais?

8 - Quanto foi faturado em um determinado mês?

9 - Crie 3 assinaturas com assinaturas de 99.98 reais, sendo 2 deles com assinaturas encerradas.

10 - Imprima o tempo em meses de alguma assinatura ainda ativa.

11 - Imprima o tempo de meses entre o start e end de todas assinaturas. Não utilize IFs para assinaturas sem end Time.

12 - Calcule o valor pago em cada assinatura até o momento. 

13 - Após finalizar faça o Pull do seu projeto para o GITHub colocando o nome do Grupo no Arquivo README

## LISTA 2:
### (Fazer commit em uma branch separada)

Seguindo os padrões de Cleancode e solid:

- Refatore o seu código para deixá-lo orientado a objetos.
- Crie 3 tipos de assinatura, anual, semestral e trimestral.
- Crie um método para calcular uma taxa para cada assinatura.
Obs. Imagine que esse método rodará todo último dia do mes.
- Anual -> Isento da taxa.
- Semestral -> 3% do valor total da assinatura até o presente momento.
- Trimestral -> 5% do valor total da assinatura até o presente momento.
- Crie um atributo para controlar assinaturas com atraso de pagamento.
- Crie um mecanismo para validar clientes que tentarem fazer compras com assinatura em atraso e não deixá-los comprar.
- Rode o seu código no SonarQube.
- Se possuir problemas corrija-os... Se não, parabéns.
- Coloque os prints do SonarQube dentro de uma pasta chamada sonar na raiz do seu projeto.

**Versione seu novo código em outro repositório ```ou``` uma branch diferente da tarefa anterior.**


# Segunda Entrega
- Identificar os Bad Smells e aplicar os princípios de Clean Code enquanto refatorar o código existente.
- (Fazer junto com a Lista 2 da primeira entrega)

**Resolução:**
- *Número de Issues:* 19 (Antes da Review);
- *Número de Issues:* 3 (Após da Review);
As issues que permanecem são:
*De usar System.out.println* --> O Sonar entende que queremos usar o out.err;

*E 2 de baixo impacto que são apenas para indicar Deprecated Code.*
totalAssinatura = totalAssinatura.add(montante).setScale(2, BigDecimal.ROUND_HALF_EVEN).

**As evidências encontram-se no pacote: Infnet-Java-Clean-Code/infnet/sonar**

# Terceira Entrega
- Implementar de forma simples 2 Patterns criacionais, 1 Pattern estrutural e 1 Pattern comportamental.

### Sobre o problema a ser resolvido com o Pattern:
- Para o terceiro exercício, utilizamos o Abstract Factory Pattern.

**Problema:** Definir um padrão para a escolha de diferentes Drivers de Navegadores, mas, que possuem as mesmas ações e comportamentos.
A ideia é que possamos criar e controlar esses Drivers de Navegadores, todos da mesma forma.

**O que desejamos:** Criar uma ou mais instâncias de Driver e controlar suas ações de forma independente, mas, que eu possa
criar, iniciar e finalizar os serviços de Driver também.

**A solução encontra-se no pacote: Infnet-Java-Clean-Code/Java_Studies/src/br/com/pattern**

# ... . ... . ... . ... . ... . ... . ...
### Forma de Envio no Moodle:
- Assim que terminar, salve o seu arquivo PDF e poste no Moodle.
- Utilize o seu nome para nomear o arquivo, identificando também a disciplina no seguinte formato: ```nomedoaluno_nomedadisciplina_pd.PDF```.

### Equipe:
- Bruno Apostólico Silva
- Ivana Batista Marinho
- Luiz Fernando de Oliveira Braz Silva
- Matheus William dos Santos Loose
- Niky Palleta Moura Lima
- Patrick Neri de Oliveira

### Repositórios do Professor:
- https://github.com/leoinfnet/exercicios-java-8 (Lista 1 e Lista 2)
- https://github.com/leoinfnet/refactoring-starting-point
- https://github.com/leoinfnet/locadora-refactoring