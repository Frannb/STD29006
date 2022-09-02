import javax.crypto.spec.PSource;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;

public class Servidor {
    private static String IP = "127.0.0.1";
    private static int porta = 54321;
    private static Armazenamento a = new Armazenamento();
    private static Questians q = new Questians();

    public static void main(String[] args){
        String[] d = new String[0];
        ArrayList<String> result = new ArrayList<>();
        boolean b = true;
        a.carregarDados();
        try {
            // recebendo nome do servidor por argumento de linha de comando
            if (args[0] != null){
                IP = args[0];
            }
            // recebendo porta do rmiregistry por argumento de linha de comando
            if (args[1] != null){
                porta = Integer.parseInt(args[1]);
            }
            try(ServerSocket socket = new ServerSocket(porta)){
                System.out.println("Aguardando por conexoes");
                try(Socket clientSocket = socket.accept()){
                    // Estabelecendo fluxos de entrada e saída
                    BufferedReader entrada = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                    DataOutputStream saida = new DataOutputStream(clientSocket.getOutputStream());
                    //Scanner teclado = new Scanner(System.in);

                    int i = 1, j = 1, k = 0;
                    while (b) {
                        // Realiza a autenticação, recebe a matricula e senha, faz a verificação na armazenamento em memória
                        // Também verifica se o aluno já iniciou o questionario, se sim, inicia a partir do item parado
                        if (i == 1) {
                            // Separa a matricula e senha vinda do Cliente.java
                            d = entrada.readLine().split("/");
                            for (Dados listDados : a.getAutenticacao()) {
                                if (listDados.getMatricula().equals(d[0]) && listDados.getSenha().equals(d[1])) {
                                    saida.writeBytes("OK\n");
                                    i++;
//                                    if (listDados.getRespondidas() > 0) {
//                                        System.out.println("aqui");
//                                        j = listDados.getRespondidas();
//                                    }
                                }else{
                                    saida.writeBytes("NOT\n");
                                }
                                break;
                            }
                        } else {
                            // Envia o questionario ao cliente, e adiciona a resposta e uma lista
                            if (j <= 5) {
                                String e = entrada.readLine();
                                saida.writeBytes(q.getQuestians(j) + "\n");
                                result.add(e);
                                j++;
                            }
                            if (j == 6) {
                                b = false;
                                result.remove(0);
                                String ent = entrada.readLine();
                                result.add(ent);
                            }
                        }
                    }
                    //System.out.println(result.get(k));
                    //System.out.println(result.size());
                    for (Dados listDados : a.getAutenticacao()) {
                        if (listDados.getMatricula().equals(d[0]) && listDados.getSenha().equals(d[1])) {
                            for (; k < result.size(); k++) {
                                if (q.getResults((k + 1)).equals(result.get(k))) {
                                    listDados.setAcertos(listDados.getAcertos() + 1);
                                    listDados.setRespondidas(listDados.getRespondidas() + 1);
                                } else {
                                    listDados.setRespondidas(listDados.getRespondidas() + 1);
                                }
                            }
                        }
                    }
                    for (Dados listDados : a.getAutenticacao()) {
                        if (listDados.getMatricula().equals(d[0]) && listDados.getSenha().equals(d[1])) {
                            saida.writeBytes("Voce acertou " + listDados.getAcertos() + " de " + listDados.getRespondidas() +
                                    " respondidas.");
                            break;
                        }
                    }

                }catch(Exception e){
                    System.exit(-1);
                }
            }catch(Exception e){
                System.exit(-1);
            }
        }catch(Exception e){
            System.exit(-1);
        }
    }
}
//                    for (; k < result.size(); k++){
//                        System.out.println(result.get(k));
//                        System.out.println(result.size());
//                        if(result.contains(q.getResults(k))) {
//                            System.out.println("aqui1");
//                            for (Dados listDados : a.getAutenticacao()) {
//                                System.out.println("aqui2");
//                                listDados.setRespondidas(result.size());
//                                System.out.println("aqui3");
//                                //System.out.println(listDados.getAcertos());
//                                if (listDados.getMatricula().equals(d[0]) && listDados.getSenha().equals(d[1])) {
//                                    System.out.println("aqui4");
//                                    listDados.addQuantAcertos();
//                                    break;
//                                }
//                            }
//                        }else {
//                            for (Dados listDados : a.getAutenticacao()) {
//                                System.out.println("aqui5");
//                                listDados.setRespondidas(result.size());
//                                break;
//                            }
//                        }
//                    }
//                    for (Dados listDados : a.getAutenticacao()) {
//                        System.out.println("aqui6");
//                        if (listDados.getMatricula().equals(d[0]) && listDados.getSenha().equals(d[1])) {
//                            System.out.println("aqui7");
//                            saida.writeBytes("Voce acertou " + (listDados.getAcertos()-1) + " de " + listDados.getRespondidas() +
//                                    " respondidas.\n");
//                            break;
//                        }
//                    }


//                        // lendo mensagem enviada pelo cliente
//                        System.out.println("Client: " + entrada.readLine());
//
//                        System.out.print("You: ");
//                        // enviando mensagem para o cliente
//                        saida.writeBytes(teclado.nextLine() + "\n");(teclado.nextLine() + "\n");


////////////////////////////////////

