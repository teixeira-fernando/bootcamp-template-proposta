package br.com.zup.bootcamp.proposta.repository;

import br.com.zup.bootcamp.proposta.model.Proposta;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PropostaRepository extends JpaRepository<Proposta, Long> {

  @Query(value = "SELECT * FROM proposta WHERE documento = ?1", nativeQuery = true)
  // @Query("select p from proposta p where p.documento = ?1")
  public Optional<Proposta> findByDocumento(String documento);
}
