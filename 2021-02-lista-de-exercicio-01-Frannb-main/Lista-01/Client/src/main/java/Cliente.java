import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.DataOutputStream;
import java.io.PrintStream;
import java.net.Socket;
import java.util.PrimitiveIterator;
import java.util.Scanner;

public class Cliente {
    private static String IP = "127.0.0.1";
    private static int porta = 54321;
    private static String matricula, senha;

    public static boolean menu(){
        Scanner t = new Scanner(System.in);
        System.out.print("========================================\n" +
                "Olá, seja bem-vindo!\n" +
                "Para continuar, digite suas credenciais.\n" +
                "Digite sua matricula: ");
        matricula = t.nextLine();
        System.out.print("Digite sua senha: ");
        senha = t.nextLine();
        System.out.println("========================================\n");
        return true;
    }

    public static void main(String[] args) {
        boolean autenticacao = false;
        try {
            // recebendo nome do servidor por argumento de linha de comando
            if (args[0] != null) {
                IP = args[0];
            }
            // recebendo porta do rmiregistry por argumento de linha de comando
            if (args[1] != null) {
                porta = Integer.parseInt(args[1]);
            }
            try(Socket conexao = new Socket(IP, porta)){
                System.out.println("Conectado! " + conexao);

                /* Estabelece fluxos de entrada e saida */
                DataOutputStream saida = new DataOutputStream(conexao.getOutputStream());
                BufferedReader entrada = new BufferedReader(new InputStreamReader(conexao.getInputStream()));
                Scanner teclado = new Scanner(System.in);

                int i = 1;
                int j = 1;
                if(i == 1) {
                    if (menu()) {
                        saida.writeBytes( matricula + "/" + senha + "\n");
                        if (entrada.readLine().contains("OK")){
                            System.out.println("Atenticação realizada!\n");
                            autenticacao = true;
                            saida.writeBytes("OK\n");
                        } else {
                            System.out.print("Credenciais incorretas! Tente novamente\n");
                            conexao.close();
                            System.exit(-1);
                        }
                    }
                }
                while (j <= 6) {
                    if (autenticacao) {
                        System.out.println("Server: " + entrada.readLine());
                        if (j < 6) {
                            System.out.print("Resposta: ");
                            // enviando mensagem para o cliente
                            saida.writeBytes(teclado.nextLine() + "\n");

                            saida.flush();
                        }else {
                            System.out.println("\nConexão finalizada!");
                        }
                        j++;
                    }
                }
            }catch(Exception e){
                System.exit(-1);
            }

        }catch(Exception e){
            System.exit(-1);
        }

    }
}