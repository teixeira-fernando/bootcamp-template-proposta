package br.com.zup.bootcamp.proposta.dto;

import br.com.zup.bootcamp.proposta.model.StatusAnalise;

public class SolicitacaoAnaliseResponse {

  String documento;
  String nome;
  StatusAnalise resultadoSolicitacao;
  String idProposta;

  public SolicitacaoAnaliseResponse(){

  }

  public StatusAnalise getResultadoSolicitacao() {
    return resultadoSolicitacao;
  }

  public SolicitacaoAnaliseResponse(String documento, String nome, StatusAnalise resultadoSolicitacao){
    this.documento = documento;
    this.nome = nome;
    this.resultadoSolicitacao = resultadoSolicitacao;
  }

  public String getDocumento() {
    return documento;
  }

  public void setDocumento(String documento) {
    this.documento = documento;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public String getIdProposta() {
    return idProposta;
  }

  public void setIdProposta(String idProposta) {
    this.idProposta = idProposta;
  }
}
