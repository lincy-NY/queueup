package xyz.lincy.queueup;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.socket.config.annotation.EnableWebSocket;

@EnableWebSocket
@SpringBootApplication
public class QueueupApplication {

	public static void main(String[] args) {
		SpringApplication.run(QueueupApplication.class, args);
	}

}
