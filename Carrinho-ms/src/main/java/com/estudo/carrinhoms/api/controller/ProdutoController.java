package com.estudo.carrinhoms.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.estudo.carrinhoms.api.assembler.ProdutoAssembler;
import com.estudo.carrinhoms.api.assembler.ProdutoDisassembler;
import com.estudo.carrinhoms.api.dtos.ProdutoDtoForm;
import com.estudo.carrinhoms.api.dtos.ProdutoDtoList;
import com.estudo.carrinhoms.domain.Repository.ProdutoRepository;
import com.estudo.carrinhoms.domain.model.Produto;
import com.estudo.carrinhoms.domain.services.ProdutoService;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {
	
    @Autowired
    private ProdutoRepository produtoRepository;
    
    @Autowired
    private ProdutoService produtoService;
    
    @Autowired
    private ProdutoAssembler produtoAssembler;
    
    @Autowired
    private ProdutoDisassembler produtoDisassembler;
    
    @GetMapping
    public List<ProdutoDtoList> listar() {
        List<Produto> produtos = produtoRepository.findAll();
        
        return produtoAssembler.toCollectionModel(produtos);
    }
    
    @GetMapping("/{produtoId}")
    public ProdutoDtoList buscar(@PathVariable Long produtoId) {
        Produto produto = produtoService.buscarOuFalhar(produtoId);
        
        return produtoAssembler.toModel(produto);
    }
    
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public ProdutoDtoList salvar(@RequestBody ProdutoDtoForm produtoDtoForm) {
        Produto produto = produtoDisassembler.toEntity(produtoDtoForm);
        produto = produtoService.salvar(produto);
        
        return produtoAssembler.toModel(produto);
    }
    
    @PutMapping("/{produtoId}")
    public ProdutoDtoList atualizar(@PathVariable Long produtoId, @RequestBody ProdutoDtoForm produtoDtoForm) {
        Produto produto = produtoService.buscarOuFalhar(produtoId);
        produtoDisassembler.toModelEntity(produtoDtoForm, produto);
        produto = produtoService.salvar(produto);
        
        return produtoAssembler.toModel(produto);
    }
    
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{produtoId}")
    public void remover(@PathVariable Long produtoId) {
        produtoService.remover(produtoId);
    }
	
}
