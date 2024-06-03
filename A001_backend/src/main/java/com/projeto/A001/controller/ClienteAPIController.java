package com.projeto.A001.controller;

import com.projeto.A001.model.Cliente;
import com.projeto.A001.service.ClienteService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cliente")
public class ClienteAPIController {
    @Autowired
    ClienteService clienteService;
    
    @PostMapping("/save")
    public ResponseEntity<Cliente> addCliente(@RequestBody Cliente c){
        var clienteSalvo = clienteService.criar(c);
        return new ResponseEntity<>(clienteSalvo, HttpStatus.CREATED);  
    }
    
    @GetMapping("/listar")
    public ResponseEntity<List> listar(){
        List<Cliente> listagem = clienteService.listarClientes();
        return new ResponseEntity<>(listagem, HttpStatus.OK);
    }
    
    @DeleteMapping("/excluir/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id){
        clienteService.excluir(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    
    @GetMapping("/pesquisar/{id}")
    public ResponseEntity<Cliente> pesquisar(@PathVariable Integer id){
        Cliente clienteEncontrado = clienteService.buscaPorId(id);
        return new ResponseEntity<>(clienteEncontrado, HttpStatus.OK);
    }
    
    @PutMapping("/atualizar/{id}")
    public ResponseEntity<Cliente> editCliente(@PathVariable Integer id, @RequestBody Cliente c){
        var clienteEditado = clienteService.atualizar(id, c);
        return new ResponseEntity<>(clienteEditado, HttpStatus.OK);
    }
}
