package com.projeto.A001.service;

import com.projeto.A001.model.Cliente;
import com.projeto.A001.repository.ClienteRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {
    @Autowired
    ClienteRepository clienteRepository;
    
    public Cliente criar(Cliente c){
        c.setId(null);
        clienteRepository.save(c);
        return c;
    }
    
    public List<Cliente> listarClientes(){
        return clienteRepository.findAll();
    }
    
    public Cliente buscaPorId(Integer id){
        return clienteRepository.findById(id).orElseThrow();
    }
    
    public void excluir(Integer id){
        Cliente cliente = buscaPorId(id);
        clienteRepository.deleteById(cliente.getId());
    }
    
    public Cliente atualizar(Integer id, Cliente c){
        Cliente clienteEncontrado = buscaPorId(id);
        
        clienteEncontrado.setNome(c.getNome());
        clienteEncontrado.setCpf(c.getCpf());
        clienteEncontrado.setNacionalidade(c.getNacionalidade());
        clienteEncontrado.setCep(c.getCep());
        clienteEncontrado.setRua(c.getRua());
        clienteEncontrado.setNumero(c.getNumero());
        clienteEncontrado.setComplemento(c.getComplemento());
        clienteEncontrado.setBairro(c.getBairro());
        clienteEncontrado.setCidade(c.getCidade());
        clienteEncontrado.setEstado(c.getEstado());
        clienteEncontrado.setTelefone(c.getTelefone());
        clienteEncontrado.setEmail(c.getEmail());
        
        clienteRepository.save(clienteEncontrado);
        
        return clienteEncontrado;
    }
}
