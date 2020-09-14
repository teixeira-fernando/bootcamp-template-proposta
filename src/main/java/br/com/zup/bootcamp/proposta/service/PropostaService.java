package br.com.zup.bootcamp.proposta.service;

import br.com.zup.bootcamp.proposta.model.Proposta;
import br.com.zup.bootcamp.proposta.repository.PropostaRepository;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class PropostaService {

  private final PropostaRepository repository;

  public PropostaService(PropostaRepository repository) {
    this.repository = repository;
  }

  public Optional<Proposta> findById(Long id) {
    return repository.findById(id);
  }

  public Proposta createProposta(Proposta proposta) {
    return repository.save(proposta);
  }
}
