

public class Questians {
    public String getQuestians(int questao) {
        String r = null;
        switch (questao) {
            case 1:
                r = "Questao 1 - Analise as opcoes abaixo, e indique qual das opcoes e a verdadeira. " +
                        "Qual area de armazenamento e confiavel e adequada a demanda? " +
                        "a) O RAD, pois possui facilidade no armazenamento e nao utiliza redundancia. " +
                        "b) O LVM, pois permite aumentar a area de armazenamento e mesmo que ocorra falha, os dados nao serao perdidos. " +
                        "c) O RAID, pois oferece seguranca e confiabilidade por meio da adicao de redundancia. " +
                        "d) O VML, pois utiliza metade do seu volume como backup.";
                break;
            case 2:
                r = "Questao 2 - Analise as opcoes abaixo, e indique qual das opcoes e a verdadeira. " +
                        "Qual topologia suporta melhor um aumento de carga? " +
                        "a) Centralizada " +
                        "b) Distribuida " +
                        "c) Descentralizada " +
                        "d) P2P nao estruturadas";
                break;
            case 3:
                r = "Questao 3 - Analise as opcoes abaixo, e indique qual das opcoes e a verdadeira. " +
                        "Qual modelo oferece servicos de hospedagem, implementacao de hardware e software, que e usado para prover aplicacoes por meio da Internet? " +
                        "a) SaaS " +
                        "b) PaaS " +
                        "c) IaaS " +
                        "d) HaaS ";
                break;
            case 4:
                r = "Questao 4 - Analise as opcoes abaixo, e indique qual das opcoes e a verdadeira. " +
                        "Quais os tipos de comunicacao o Middleware proporcionado ? " +
                        "a) Impersistente, Sincronismo e Fluxo " +
                        "b) Persistencia, Dessincronizado e Fluxo " +
                        "c) Impersistente, Dessincronizado e Fluxo " +
                        "d) Persistencia, Sincronismo e Fluxo ";
                break;
            case 5:
                r = "Questao 5 - Analise as opcoes abaixo, e indique qual das opcoes e a verdadeira. " +
                        "Em uma comunicacao confiavel cliente-servidor, um processo e considerado falho quando ocorre: " +
                        "a) Omissao de recepcao, Omissao de envio, Omissao de retransmissao e Arbitraria. " +
                        "b) Omissao de recepcao, Omissao de envio, Omissao de retransmissao e Omissao confirmacao. " +
                        "c) Omissao de recepcao, Omissao de envio, Parada (ou queda) e Arbitraria. " +
                        "d) Nenhuma das opcoes. ";
                break;
            case 6:
                break;
            default:
                System.out.println("Opção inválida!");
                System.exit(-1);
                break;
        }
        return r;
    }

    public String getResults(int questao){
        String r = null;
        switch (questao) {
            case 1:
                r = "c";
                break;
            case 2:
                r = "b";
                break;
            case 3:
                r = "b";
                break;
            case 4:
                r = "d";
                break;
            case 5:
                r = "c";
                break;
            case 0:
                r = " ";
                break;
            default:
                System.out.println("Opção inválida!");
                System.exit(-1);
                break;
        }
        return r;
    }

}
