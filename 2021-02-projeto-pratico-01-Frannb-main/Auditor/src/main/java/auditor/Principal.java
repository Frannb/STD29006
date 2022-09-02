package auditor;

public class Principal{
    public static String msgRecebidaMonitor;

    public static void main(String[] args) throws Exception {
        //Classe responsavel pela comunicação com os jogadores
        EnviaJogadores comJogadores = new EnviaJogadores();

        //Gera o mapa para o monitor e pega as coordenadas
        Jogo jogo = new Jogo();
        String coordenadasJogo = jogo.getGeraMapa().toString();

        //Classe responsavel pela comunicação com o monitor
        EnviaRecebeMonitor comunicacao = new EnviaRecebeMonitor();

        //Envia o mapa para o monitor assim que iniciar a partida
        comunicacao.enviaMonitor(coordenadasJogo);

        System.out.println(" [**] Aguardando mensagens. Para sair pressione CTRL+C");

        while(true) {
            boolean verifica;
            comunicacao.recebeMonitor();

            //Fica recebendo as mensagem vindas do monitor;
            if(msgRecebidaMonitor == null){
                verifica = false;
            }else {
                verifica = true;
            }

            while (verifica) {
                if (msgRecebidaMonitor.contains("Controle")) {
                    //Envia a mensagem recebida do monitor para os jogadores
                    //Caso seja uma mensagem de controle
                    comJogadores.enviaMensagemJogadores(msgRecebidaMonitor);
                } else if ((jogo.getPointJ1() + jogo.getPointJ2()) < 3) {
                    if (msgRecebidaMonitor.contains("Captura")) {
                        //Caso contenha um mensagem de captura, isso quer dizer
                        //que alguma bandeira foi capturada
                        comJogadores.enviaMensagemJogadores(msgRecebidaMonitor);
                        if (msgRecebidaMonitor.contains("1")) {
                            jogo.setPointJ1(jogo.getPointJ1() + 1);
                        } else if (msgRecebidaMonitor.contains("2")) {
                            jogo.setPointJ2(jogo.getPointJ2() + 1);
                        }
                    }
                }
                if ((jogo.getPointJ1() + jogo.getPointJ2()) == 3) {
                    comJogadores.enviaMensagemJogadores(jogo.toString());
                    comunicacao.enviaMonitor(jogo.toString());
                    comunicacao.enviaMonitor("exit");
                    comJogadores.enviaMensagemJogadores("exit");
                    //Finaliza a partida
                    System.exit(0);
                }
                msgRecebidaMonitor = null;
                verifica = false;
            }
        }
    }
}