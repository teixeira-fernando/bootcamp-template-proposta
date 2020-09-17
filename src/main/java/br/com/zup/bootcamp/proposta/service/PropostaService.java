package br.com.zup.bootcamp.proposta.service;

import br.com.zup.bootcamp.proposta.controller.AnaliseCartaoClient;
import br.com.zup.bootcamp.proposta.dto.SolicitacaoAnaliseRequest;
import br.com.zup.bootcamp.proposta.dto.SolicitacaoAnaliseResponse;
import br.com.zup.bootcamp.proposta.model.Proposta;
import br.com.zup.bootcamp.proposta.model.StatusAnalise;
import br.com.zup.bootcamp.proposta.repository.PropostaRepository;
import java.util.Optional;
import javax.persistence.EntityNotFoundException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PropostaService {

  private PropostaRepository repository;

  private static final Logger logger = LogManager.getLogger(PropostaService.class);

  @Autowired
  private AnaliseCartaoClient client;

  public PropostaService(PropostaRepository repository) {
    this.repository = repository;
  }

  public Optional<Proposta> findById(Long id) {
    return repository.findById(id);
  }

  public Proposta createProposta(Proposta proposta) {
    if (repository.findByDocumento(proposta.getDocumento()).isPresent()) {
      throw new EntityNotFoundException();
    }
    Proposta savedProposta = repository.save(proposta);

    SolicitacaoAnaliseResponse analise = client.solicitaAnalise(new SolicitacaoAnaliseRequest(savedProposta.getDocumento(), savedProposta.getNome(), savedProposta.getId().toString()));
    //foi criado como não elegivel. Então checamos para ver se precisamos mudar esse estado ou não
    if (analise.getResultadoSolicitacao() == StatusAnalise.SEM_RESTRICAO) {
      proposta.atualizaStatus(analise.getResultadoSolicitacao());
      //atauliza o status no banco
      repository.save(savedProposta);
    }

    logger.info("Retorno da analise:"+ analise.getResultadoSolicitacao().name());

    return savedProposta;
  }
}
