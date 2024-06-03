package com.projeto.A001.service;

import com.projeto.A001.model.Contrato;
import com.projeto.A001.repository.ContratoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContratoService {
    
    @Autowired
    ContratoRepository contratoRepository;
    
    public Contrato criar(Contrato c) {
        c.setId(null);
        contratoRepository.save(c);
        return c;
    }
    
    public List<Contrato> listarContratos() {
        return contratoRepository.findAll();
    }
    
    public Contrato buscaPorId(Integer id) {
        return contratoRepository.findById(id).orElseThrow();
    }
    
    public void excluir(Integer id) {
        Contrato contrato = buscaPorId(id);
        contratoRepository.deleteById(contrato.getId());
    }
    
    public Contrato atualizar(Integer id, Contrato c) {
        Contrato contratoEncontrado = buscaPorId(id);
        
        contratoEncontrado.setFormaPagamento(c.getFormaPagamento());
        contratoEncontrado.setDataInicio(c.getDataInicio());
        contratoEncontrado.setDataFinal(c.getDataFinal());
        
        contratoRepository.save(contratoEncontrado);
        
        return contratoEncontrado;
    }
}
