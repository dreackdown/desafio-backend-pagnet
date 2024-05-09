package dev.hugofaria.backend.repository;

import dev.hugofaria.backend.entity.Transacao;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TransacaoRepository extends CrudRepository<Transacao, Long> {

    List<Transacao> findAllByOrderByNomeDaLojaAscIdDesc();
}