package monitor;

import util.Conexao;
import java.io.IOException;
import com.rabbitmq.client.*;
import java.util.concurrent.TimeoutException;

public class EnviaRecebeAuditor {
    private final static String QUEUE1 = "auditorMonitor";
    private final static String QUEUE2 = "monitorAuditor";

    public void enviaAuditor(String mensagem){
        // Informações sobre a conexão com o sistema de filas
        ConnectionFactory factory = Conexao.getConnectionFactory();

        try (Connection connection = factory.newConnection()) {
            Channel channel = connection.createChannel();

            // Enviando mensagem
            channel.queueDeclare(QUEUE2, false, false, false, null);
            channel.basicPublish("", QUEUE2, null, mensagem.getBytes());
            System.out.println(" [>>] Sent: " + mensagem);
            Thread.sleep(2000);

            // Fechando canal e conexão
            channel.close();
        }catch (Exception e){
            System.err.println("Não foi possível criar conexão\n");
        }
    }

    public void recebeAuditor() throws java.io.IOException, TimeoutException {
        // Informações sobre a conexão com o sistema de filas
        ConnectionFactory factory = Conexao.getConnectionFactory();

        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();

        channel.queueDeclare(QUEUE1, false, false, false, null);
        //System.out.println(" [*] Aguardando mensagens. Para sair pressione CTRL+C");
        Consumer consumer = new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body)
                    throws IOException {
                String message = new String(body, "UTF-8");
                Principal.mensagemRecebida = message;
                if(message.equals("exit")){
                    System.exit(0);
                }else {
                    System.out.println(" [<<] Recv: " + message);
                }
            }
        };
        channel.basicConsume(QUEUE1, true, consumer);
    }
}
