// Conta Bancaria Java

class Conta {
    String titular; // nome do dono da conta.

    // privado: só os métodos da conta mexem no saldo, para ninguém bagunçar o valor
    // ("Encapsulamento")
    private double saldo;

    // soma valor recebido ao saldo da conta
    void deposito(double valor) {
        saldo = saldo + valor;
    }

    // tira o valor do saldo, mas só se houver dinheiro suficiente; senão avisa e
    // não mexe no saldo
    void sacar(double valor) {
        if (valor <= saldo) {
            saldo = saldo - valor;
        } else {
            System.out.println("Saldo insuficiente");

        }
    }

    // devolve o saldo, já que ele é privado e a Main não consegue ler direto
    double getSaldo() {
        return saldo;
    }

    // mostra na tela o tipo de conta; as filhas podem reescrever
    void exibirTipo() {
        System.out.println("Conta comum");
    }

}

// Conta poupança: herda tudo da Conta (titular, deposito, sacar, getSaldo) e
// acrescenta a taxa de rendimento
class ContaPoupanca extends Conta {
    // Guarda a taxa de rendimento da poupança, em porcentagem
    double taxaRendimento;

    // Pega o saldo, faz o cálculo com a porcentagem que é a taxa de rendimento, e o
    // resultado é depositado de volta ao saldo.
    void aplicarRendimento() {
        double rendimento = getSaldo() * taxaRendimento / 100;
        deposito(rendimento);
    }

    // Reescreve o exibirTipo do pai para mostrar que é uma poupança (polimorfismo)
    @Override
    void exibirTipo() {
        System.out.println("Conta poupança");
    }

}

public class Main {
    public static void main(String[] args) {
        Conta minhaConta = new Conta();
        minhaConta.titular = "Enzyo";
        minhaConta.deposito(100);
        minhaConta.sacar(30);
        minhaConta.sacar(500); // maior que o saldo, então deve ser barrado

        // Mesmo método, resultados diferente: cada classe responde do seu jeito
        minhaConta.exibirTipo();

        // Isso daria erro, porque o saldo é privado
        // minhaConta.saldo = 1000000;

        // o saldo é privado, então leio pelo getSaldo() em vez de minhaConta.saldo
        System.out.println(minhaConta.getSaldo());
        System.out.println(minhaConta.getSaldo());

        // A poupança usa deposito e getSaldo herdados da Conta, sem eu ter escrito nada
        // deles na ContaPoupanca
        ContaPoupanca poupanca = new ContaPoupanca();
        poupanca.deposito(200);
        poupanca.taxaRendimento = 10;
        poupanca.aplicarRendimento();
        poupanca.exibirTipo();
        System.out.println(poupanca.getSaldo());
    }
}