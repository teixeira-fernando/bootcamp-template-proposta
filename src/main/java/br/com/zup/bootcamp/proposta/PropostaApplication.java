package br.com.zup.bootcamp.proposta;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties
@EntityScan(basePackages = {"br.com.zup.bootcamp.proposta.model"}) // scan JPA entities
public class PropostaApplication {

  public static void main(String[] args) {
    SpringApplication.run(PropostaApplication.class, args);
  }
}
