import java.util.Random;
import java.util.Scanner;

public class MiniChatbot {
    private boolean sair;
    private Random random;

    public MiniChatbot() {
        this.sair = false;
        this.random = new Random();
    }

    public String responder(String mensagem) {
        mensagem = mensagem.toLowerCase();

        if (mensagem.contains("oi") || mensagem.contains("olá")) {
            return respostasAleatorias(new String[]{
                    "Olá! Como posso ajudar?",
                    "Oi! Tudo bem por aí?",
                    "Olá! Que bom falar com você!"
            });
        } else if (mensagem.contains("qual é o seu nome") || mensagem.contains("seu nome")) {
            return "Eu sou o MiniChatbot, seu assistente virtual!";
        } else if (mensagem.contains("como você está") || mensagem.contains("tudo bem")) {
            return respostasAleatorias(new String[]{
                    "Estou funcionando perfeitamente, obrigado!",
                    "Tudo ótimo! E você?",
                    "Sempre pronto para ajudar!"
            });
        } else if (mensagem.contains("clima") || mensagem.contains("tempo")) {
            return "Eu não sei prever o clima, mas recomendo checar um app de meteorologia!";
        } else if (mensagem.contains("programação") || mensagem.contains("codar")) {
            return "Programação é incrível! Posso ajudar com Java, Python ou lógica de programação.";
        } else if (mensagem.contains("feliz") || mensagem.contains("triste") || mensagem.contains("humor")) {
            return "Eu sempre estou de bom humor, pronto para ajudar!";
        } else if (mensagem.contains("ajuda") || mensagem.contains("comandos")) {
            return "Aqui estão alguns comandos que você pode tentar:\n"
                    + "- Diga 'Oi' para saudações\n"
                    + "- Pergunte meu nome\n"
                    + "- Pergunte sobre como estou\n"
                    + "- Fale sobre clima, programação ou humor\n"
                    + "- Digite 'sair' para encerrar.";
        } else if (mensagem.contains("sair")) {
            return "Você realmente quer sair? (sim/não)";
        } else if (mensagem.contains("sim") && sair) {
            this.sair = true;
            return "Tchau! Até a próxima.";
        } else if (mensagem.contains("não") && sair) {
            this.sair = false;
            return "Que bom que decidiu ficar! Como posso ajudar?";
        } else {
            return "Desculpe, não entendi sua pergunta. Pode reformular?";
        }
    }

    private String respostasAleatorias(String[] respostas) {
        int index = random.nextInt(respostas.length);
        return respostas[index];
    }

    public void iniciarConversa() {
        System.out.println("Olá! Eu sou o MiniChatbot. Como posso te ajudar hoje?");
        Scanner scanner = new Scanner(System.in);

        while (!sair) {
            System.out.print("Você: ");
            String entradaUsuario = scanner.nextLine();
            String resposta = responder(entradaUsuario);
            System.out.println("MiniChatbot: " + resposta);
        }

        scanner.close();
    }

    public static void main(String[] args) {
        MiniChatbot chatbot = new MiniChatbot();
        chatbot.iniciarConversa();
    }
}

