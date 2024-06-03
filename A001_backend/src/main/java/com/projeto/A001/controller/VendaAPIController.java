package com.projeto.A001.controller;

import com.projeto.A001.model.Venda;
import com.projeto.A001.service.VendaService;
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
@RequestMapping("/venda")
public class VendaAPIController {
    @Autowired
    VendaService vendaService;
    
    @PostMapping("/save")
    public ResponseEntity<Venda> addVenda(@RequestBody Venda v){
        var vendaSalva = vendaService.criar(v);
        return new ResponseEntity<>(vendaSalva, HttpStatus.CREATED);
    }
    
    @GetMapping("/listar")
    public ResponseEntity<List> listar(){
        List<Venda> listagem = vendaService.listarVendas();
        return new ResponseEntity<>(listagem, HttpStatus.OK);
    }
    
    @GetMapping("/vendasporcliente/{idCliente}")
    public ResponseEntity<List> vendasPorCliente(@PathVariable Integer idCliente){
        List<Venda> vendasCliente = vendaService.listarVendasPorCliente(idCliente);
        return new ResponseEntity<>(vendasCliente, HttpStatus.OK);
    }
    
    @DeleteMapping("/excluir/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id){
        vendaService.excluir(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    
    @GetMapping("pesquisar/{id}")
    public ResponseEntity<Venda> pesquisar(@PathVariable Integer id){
        Venda vendaEncontrada = vendaService.buscaPorId(id);
        return new ResponseEntity<>(vendaEncontrada, HttpStatus.OK);
    }
    
    @PutMapping("/atualizar/{id}")
    public ResponseEntity<Venda> editVenda(@PathVariable Integer id, @RequestBody Venda v){
        var vendaEncontrada = vendaService.atualizar(id, v);
        return new ResponseEntity<>(vendaEncontrada, HttpStatus.OK);
    }
}
