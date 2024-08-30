package com.springboot_esencial_mensajes.busca;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootApplication
public class BuscaApplication {

	private static final String QUEUE_NAME = "busca-personas";
	private static final String EXCHANGE_NAME = "servicios";

	@Bean
	public Queue queue() {
		return new Queue(QUEUE_NAME, false);
	}

	@Bean
	public TopicExchange exchange() {
		return new TopicExchange(EXCHANGE_NAME);
	}

	@Bean
	public Binding Binding(Queue queue, TopicExchange topicExchange) {

		return BindingBuilder.bind(queue).to(topicExchange)
				.with("reuniones.busca.personas");

	}

	@Bean
    public ObjectMapper objectMapper() {
        return new ObjectMapper();
    }

	public static void main(String[] args) {
		SpringApplication.run(BuscaApplication.class, args);
	}

}
