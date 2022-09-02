package auditor;


import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import util.Conexao;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class EnviaJogadores {

    private static final String EXCHANGE_NAME = "logsJogares";

    public void enviaMensagemJogadores(String mensagem) throws IOException, TimeoutException {
        // Informações sobre a conexão com o sistema de filas
        ConnectionFactory factory = Conexao.getConnectionFactory();

        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();

        channel.exchangeDeclare(EXCHANGE_NAME, "fanout");

        channel.basicPublish(EXCHANGE_NAME, "", null, mensagem.getBytes("UTF-8"));
        //System.out.println(" [>>] Sent '" + mensagem + "'");

        channel.close();
        connection.close();
    }
}