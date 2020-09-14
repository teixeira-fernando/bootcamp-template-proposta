package br.com.zup.bootcamp.proposta.model;

import java.math.BigDecimal;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;

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

  public Proposta() {}

  public Proposta(
      String documento, String email, String nome, String endereco, BigDecimal salario) {
    this.documento = documento;
    this.email = email;
    this.nome = nome;
    this.endereco = endereco;
    this.salario = salario;
  }

  public Proposta(
      Long id, String documento, String email, String nome, String endereco, BigDecimal salario) {
    this.id = id;
    this.documento = documento;
    this.email = email;
    this.nome = nome;
    this.endereco = endereco;
    this.salario = salario;
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
}
