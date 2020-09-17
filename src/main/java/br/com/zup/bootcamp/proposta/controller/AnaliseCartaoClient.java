package br.com.zup.bootcamp.proposta.controller;

import br.com.zup.bootcamp.proposta.dto.SolicitacaoAnaliseRequest;
import br.com.zup.bootcamp.proposta.dto.SolicitacaoAnaliseResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(url = "${analisecartao.url}", name = "analise-service")
public interface AnaliseCartaoClient {

  @RequestMapping(method = RequestMethod.POST, value = "/solicitacao")
  SolicitacaoAnaliseResponse solicitaAnalise(SolicitacaoAnaliseRequest analiseRequest);

}
