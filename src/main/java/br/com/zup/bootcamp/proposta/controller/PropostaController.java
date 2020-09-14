package br.com.zup.bootcamp.proposta.controller;

import br.com.zup.bootcamp.proposta.model.Proposta;
import br.com.zup.bootcamp.proposta.service.PropostaService;
import java.net.URI;
import java.net.URISyntaxException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PropostaController {

  private static final Logger logger = LogManager.getLogger(PropostaController.class);

  private final PropostaService service;

  public PropostaController(PropostaService service) {
    this.service = service;
  }

  @GetMapping("/proposta/{id}")
  public ResponseEntity<?> getProduct(@PathVariable("id") Long id) {

    return service
        .findById(id)
        .map(
            proposta -> {
              try {
                return ResponseEntity.ok()
                    .location(new URI("/product/" + proposta.getId()))
                    .body(proposta);
              } catch (URISyntaxException e) {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
              }
            })
        .orElse(ResponseEntity.notFound().build());
  }

  @PostMapping("/proposta")
  public ResponseEntity<Proposta> createProposta(@Validated @RequestBody Proposta proposta) {

    logger.info("Criando uma nova proposta correspondente ao: {}", proposta.getNome());

    // Create a new proposta
    Proposta newProposta = service.createProposta(proposta);

    try {
      // Build a created response
      return ResponseEntity.created(new URI("/proposta/" + newProposta.getId())).body(newProposta);
    } catch (Exception e) {
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }
  }
}
