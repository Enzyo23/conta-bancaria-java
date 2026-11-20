// Conta Bancaria Java

class Conta
{
    String titular; // nome do dono da conta.
    
    // privado: só os métodos da conta mexem no saldo, para ninguém bagunçar o valor ("Encapsulamento")
    private double saldo; 
    
    // soma valor recebido ao saldo da conta
    void deposito(double valor)
    {
        saldo = saldo + valor;
    }
    
    //tira o valor do saldo, mas só se houver dinheiro suficiente; senão avisa e não mexe no saldo
    void sacar(double valor)
    {
        if (valor <= saldo)
        {
            saldo = saldo - valor; 
        }
        else
        {
            System.out.println("Saldo insuficiente");
            
        }
    }
    // devolve o saldo, já que ele é privado e a Main não consegue ler direto
    double getSaldo()
    {
        return saldo;
    }
}

public class Main
{
    public static void main(String[] args)
    {
        Conta minhaConta = new Conta();
        minhaConta.titular = "Enzyo";
        minhaConta.deposito(100);
        minhaConta.sacar(30);
        minhaConta.sacar(500); // maior que o saldo, então deve ser barrado
        
        //minhaConta.saldo = 1000000;
        
        // o saldo é privado, então leio pelo getSaldo() em vez de minhaConta.saldo
        System.out.println(minhaConta.getSaldo()); 
        System.out.println(minhaConta.getSaldo());
        
        /*System.out.println(minhaConta.saldo); Assim gera erro ,"O Atributo fica privado e o acesso é só pelos métodos, 
                                                        para ninguém bagunçar o saldo ("Encapsulamento")
        System.out.println(minhaConta.saldo);*/
    }
}