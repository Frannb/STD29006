package receptor;
import java.io.IOException;
import com.rabbitmq.client.*;
import util.Conexao;

public class Receptor {
    private static final String EXCHANGE_NAME = "logsJogares";
    public static void main(String[] argv) throws Exception {
        // Informações sobre a conexão com o sistema de filas
        ConnectionFactory factory = Conexao.getConnectionFactory();

        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();

        channel.exchangeDeclare(EXCHANGE_NAME, "fanout");
        String queueName = channel.queueDeclare().getQueue();
        channel.queueBind(queueName, EXCHANGE_NAME, "");

        System.out.println(" [**] Aguardando mensagens. Para sair pressione CTRL+C");

        Consumer consumer = new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope,
                                       AMQP.BasicProperties properties, byte[] body) throws IOException {
                String message = new String(body, "UTF-8");
                if(message.equals("exit")){
                    System.exit(0);
                }else {
                    System.out.println(" [<<] Recv: " + message);
                }
            }
        };
        channel.basicConsume(queueName, true, consumer);
    }
}