package com.projeto.A001.service;

import com.projeto.A001.model.Venda;
import com.projeto.A001.repository.VendaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VendaService {
    
    @Autowired
    VendaRepository vendaRepository;
    
    public Venda criar(Venda v){
        v.setId(null);
        vendaRepository.save(v);
        return v;
    }
    
    public List<Venda> listarVendas() {
        return vendaRepository.findAll();
    }
    
    public List<Venda> listarVendasPorCliente(Integer idCliente) {
        return vendaRepository.findByClienteId(idCliente);
    }
    
    public Venda buscaPorId(Integer id) {
        return vendaRepository.findById(id).orElseThrow();
    }
    
    public void excluir(Integer id) {
        Venda venda = buscaPorId(id);
        vendaRepository.deleteById(venda.getId());
    }
    
    public Venda atualizar(Integer id, Venda v) {
        Venda vendaEncontrada = buscaPorId(id);
        
        vendaEncontrada.setDescrição(v.getDescrição());
        vendaEncontrada.setServiço(v.getServiço());
        vendaEncontrada.setValor(v.getValor());
        
        vendaRepository.save(vendaEncontrada);
        
        return vendaEncontrada;
    }
}
