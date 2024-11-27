import java.util.ArrayList;
import java.util.List;

public class CarteiraDigital {
    private double saldo;
    private List<String> historicoTransacoes;

    public CarteiraDigital() {
        this.saldo = 0.0;
        this.historicoTransacoes = new ArrayList<>();
    }

    public void adicionarSaldo(double valor) {
        if (valor > 0) {
            saldo += valor;
            historicoTransacoes.add("Adicionado: R$ " + String.format("%.2f", valor));
            System.out.println("Saldo adicionado com sucesso!");
        } else {
            System.out.println("O valor deve ser positivo.");
        }
    }

    public void realizarPagamento(double valor) {
        if (valor <= 0) {
            System.out.println("O valor deve ser positivo.");
        } else if (valor > saldo) {
            System.out.println("Saldo insuficiente para realizar o pagamento.");
        } else {
            saldo -= valor;
            historicoTransacoes.add("Pagamento: R$ " + String.format("%.2f", valor));
            System.out.println("Pagamento realizado com sucesso!");
        }
    }

    public double verificarSaldo() {
        return saldo;
    }

    public void exibirHistoricoTransacoes() {
        if (historicoTransacoes.isEmpty()) {
            System.out.println("Nenhuma transação realizada ainda.");
        } else {
            System.out.println("Histórico de Transações:");
            for (String transacao : historicoTransacoes) {
                System.out.println("- " + transacao);
            }
        }
    }
}

