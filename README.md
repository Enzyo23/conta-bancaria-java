# Conta Bancária em Java

Mini-projeto de estudo de **Programação Orientada a Objetos (POO)** em Java. Simula uma conta bancária simples, com depósito, saque e consulta de saldo.

## O que o projeto faz

- Cria uma conta com titular e saldo.
- Permite **depositar** um valor.
- Permite **sacar** um valor, mas só se houver saldo suficiente. Caso contrário, mostra "Saldo insuficiente" e não altera o saldo.
- Permite **consultar o saldo** por um método, já que o atributo é privado.

## Conceitos praticados

| Conceito | Onde aparece |
|---|---|
| Classe e objeto | `Conta` (a classe) e `minhaConta` (o objeto criado na `Main`) |
| Atributos | `titular` e `saldo` |
| Métodos | `deposito`, `sacar` e `getSaldo` |
| Decisão (`if`/`else`) | Regra do saque no método `sacar` |
| Encapsulamento | `saldo` é `private` e só é acessado pelos métodos da classe |

## Como o encapsulamento foi aplicado

O atributo `saldo` é privado: só os métodos da própria `Conta` mexem nele, para ninguém bagunçar o valor. Quem está fora da classe (como a `Main`) lê o saldo pelo método `getSaldo()`. Tentar usar `minhaConta.saldo` diretamente gera erro de compilação, e foi isso que o `private` passou a garantir.

## Estrutura

```
Main.java
├── class Conta   -> atributos e métodos da conta
└── class Main    -> método main, que cria a conta e testa as operações
```

## Exemplo de execução

Na `Main`, o teste faz:

1. Cria a conta do titular "Enzyo".
2. Deposita `100`.
3. Saca `30` (permitido).
4. Tenta sacar `500` (barrado, porque é maior que o saldo).
5. Mostra o saldo.

Saída esperada:

```
Saldo insuficiente
70.0
70.0
```

## Como executar

**Online (sem instalar nada):** cole o código em um compilador online de Java, como o [OnlineGDB](https://www.onlinegdb.com/online_java_compiler), e clique em **Run**.

**No computador (com o JDK instalado):**

```bash
javac Main.java
java Main
```

## Próximos passos

- [ ] Herança: criar a `ContaPoupanca` a partir da `Conta`.
- [ ] Polimorfismo e abstração.
- [ ] Guardar os atributos como `private` também no `titular`, com getter e setter.
- [ ] Validar valores negativos no depósito e no saque.

## Autor

Enzyo, estudante de Análise e Desenvolvimento de Sistemas (ADS) na Cruzeiro do Sul Virtual.
