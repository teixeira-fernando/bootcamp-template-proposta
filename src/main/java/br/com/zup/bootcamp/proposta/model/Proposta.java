package br.com.zup.bootcamp.proposta.model;

import java.math.BigDecimal;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;
import org.springframework.util.Assert;

@Entity
public class Proposta {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @NotNull @NotBlank @CpfCnpj private String documento;
  @NotNull @NotBlank @Email private String email;
  @NotNull @NotBlank private String nome;
  @NotNull @NotBlank private String endereco;
  @NotNull @PositiveOrZero private BigDecimal salario;
  @NotNull @Enumerated(value = EnumType.STRING) private StatusProposta statusAvaliacao;

  public Proposta() {
    this.statusAvaliacao = StatusProposta.NAO_ELEGIVEL;
  }

  public Proposta(
      String documento, String email, String nome, String endereco, BigDecimal salario) {
    this.documento = documento;
    this.email = email;
    this.nome = nome;
    this.endereco = endereco;
    this.salario = salario;
    this.statusAvaliacao = StatusProposta.NAO_ELEGIVEL;
  }

  public Proposta(
      Long id, String documento, String email, String nome, String endereco, BigDecimal salario) {
    this.id = id;
    this.documento = documento;
    this.email = email;
    this.nome = nome;
    this.endereco = endereco;
    this.salario = salario;
    this.statusAvaliacao = StatusProposta.NAO_ELEGIVEL;
  }

  public Long getId() {
    return id;
  }

  public String getDocumento() {
    return documento;
  }

  public void setDocumento(String documento) {
    this.documento = documento;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public String getEndereco() {
    return endereco;
  }

  public void setEndereco(String endereco) {
    this.endereco = endereco;
  }

  public BigDecimal getSalario() {
    return salario;
  }

  public void setSalario(BigDecimal salario) {
    this.salario = salario;
  }

  public void atualizaStatus(StatusAnalise resultadoSolicitacao) {
    Assert.isTrue(this.statusAvaliacao.equals(StatusProposta.NAO_ELEGIVEL), "uma vez que a proposta é elegível não pode mais trocar");
    this.statusAvaliacao = resultadoSolicitacao == StatusAnalise.SEM_RESTRICAO ? StatusProposta.ELEGIVEL : StatusProposta.NAO_ELEGIVEL;
  }
}
