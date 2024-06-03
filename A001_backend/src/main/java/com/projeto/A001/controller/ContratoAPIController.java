package com.projeto.A001.controller;

import com.projeto.A001.model.Contrato;
import com.projeto.A001.service.ContratoService;
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
@RequestMapping("/contrato")
public class ContratoAPIController {
    @Autowired
    ContratoService contratoService;
    
    @PostMapping("/save")
    public ResponseEntity<Contrato> addContrato(@RequestBody Contrato c){
        var contratoSalvo = contratoService.criar(c);
        return new ResponseEntity<>(contratoSalvo, HttpStatus.CREATED);
    }
    
    @GetMapping("/listar")
    public ResponseEntity<List> listar(){
        List<Contrato> listagem = contratoService.listarContratos();
        return new ResponseEntity<>(listagem, HttpStatus.OK);
    }
    
    @GetMapping("/pesquisar/{id}")
    public ResponseEntity<Contrato> pesquisar(@PathVariable Integer id){
        Contrato contratoEncontrado = contratoService.buscaPorId(id);
        return new ResponseEntity<>(contratoEncontrado, HttpStatus.OK);
    }
    
    @DeleteMapping("/excluir/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id){
        contratoService.excluir(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    
    @PutMapping("/atualizar/{id}")
    public ResponseEntity<Contrato> editContrato(@PathVariable Integer id, @RequestBody Contrato c){
        var contratoEditado = contratoService.atualizar(id, c);
        return new ResponseEntity<>(contratoEditado, HttpStatus.OK);
    }  
    
}
