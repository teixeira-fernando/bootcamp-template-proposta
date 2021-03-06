package br.com.zup.bootcamp.proposta.dto;

public class SolicitacaoAnaliseRequest {
  String documento;
  String nome;
  String idProposta;

  public SolicitacaoAnaliseRequest(String documento, String nome, String idProposta) {
    this.documento = documento;
    this.nome = nome;
    this.idProposta = idProposta;
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
