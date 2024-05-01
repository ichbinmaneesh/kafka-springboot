package com.tutorial.kafka;

import org.apache.kafka.clients.admin.Admin;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Properties;

@SpringBootApplication
public class KafkaSpringbootApplication {

	public static void main(String[] args) {
		SpringApplication.run(KafkaSpringbootApplication.class, args);

		var props = new Properties();
		props.put("bootstrap.servers","ample-bedbug-14600-us1-kafka.upstash.io:9092");
		props.put("sasl.mechanism", "SCRAM-SHA-512");
		props.put("security.protocol", "SASL_SSL");
		props.put("sasl.jaas.config", "org.apache.kafka.common.security.scram.ScramLoginModule required " +
				"username=\"YW1wbGUtYmVkYnVnLTE0NjAwJBg0L3h30pxxk9AxBGeLOjndiXJvxwbnwbR0p1M\" " +
				"password=\"YTdmOGUwNGEtNGY2Yy00MjVlLThiNzAtMzRmNzNiMWIxOTdh\";");

        try (var admin = Admin.create(props)) {
        }
	}

}
