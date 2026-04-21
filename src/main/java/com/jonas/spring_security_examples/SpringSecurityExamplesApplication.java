package com.jonas.spring_security_examples;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.encrypt.BytesEncryptor;
import org.springframework.security.crypto.encrypt.Encryptors;
import org.springframework.security.crypto.encrypt.TextEncryptor;
import org.springframework.security.crypto.keygen.KeyGenerators;

@SpringBootApplication
public class SpringSecurityExamplesApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringSecurityExamplesApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner() {
		return args -> {
			String salt = KeyGenerators.string().generateKey();
			String password = "secret";
			String valueToEncrypt = "HELLO";

			BytesEncryptor e = Encryptors.stronger(password, salt);
			byte[] encrypted = e.encrypt(valueToEncrypt.getBytes());
			String encryptedString = new String(encrypted);
			String decrypted = new String(e.decrypt(encrypted));

			TextEncryptor te = Encryptors.text(password, salt);
			String encryptedText = te.encrypt(valueToEncrypt);
			String decryptedText = te.decrypt(encryptedText);
		};
	}

}
