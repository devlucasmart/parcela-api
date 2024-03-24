package com.devlucasmart.parcela.repository;

import com.devlucasmart.parcela.model.ClienteModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClienteRepository extends JpaRepository<ClienteModel, Long> {

    List<ClienteModel> findByNome(String nome);
}
