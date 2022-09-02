package auditor;

import com.rabbitmq.client.*;
import util.Conexao;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.concurrent.TimeoutException;

public class EnviaRecebeMonitor{
    private final static String QUEUE1 = "auditorMonitor";
    private final static String QUEUE2 = "monitorAuditor";

    public void enviaMonitor(String mensagem) {
        // Informações sobre a conexão com o sistema de filas
        ConnectionFactory factory = Conexao.getConnectionFactory();

        try (Connection connection = factory.newConnection()) {
            Channel channel = connection.createChannel();

            // Enviando mensagem
            channel.queueDeclare(QUEUE1, false, false, false, null);
            channel.basicPublish("", QUEUE1, null, mensagem.getBytes());
            System.out.println(" [>>] Sent: " + mensagem);

            // Fechando canal e conexão
            channel.close();
        }catch (Exception e){
            System.err.println("Não foi possível criar conexão\n");
        }
    }

    public void recebeMonitor() throws IOException, TimeoutException {
        // Informações sobre a conexão com o sistema de filas
        ConnectionFactory factory = Conexao.getConnectionFactory();

        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();

        channel.queueDeclare(QUEUE2, false, false, false, null);
        //System.out.println(" [*] Aguardando mensagens. Para sair pressione CTRL+C");
        Consumer consumer = new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws UnsupportedEncodingException {
                String message = new String(body, "UTF-8");
                Principal.msgRecebidaMonitor = message;
                System.out.println(" [<<] Recv: " + message);
            }
        };
        channel.basicConsume(QUEUE2, true, consumer);
    }
}
