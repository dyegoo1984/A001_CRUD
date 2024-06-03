package com.projeto.A001.repository;

import com.projeto.A001.model.Venda;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VendaRepository extends JpaRepository<Venda, Integer>{
   
    List<Venda> findByClienteId(Integer idCliente);
}
