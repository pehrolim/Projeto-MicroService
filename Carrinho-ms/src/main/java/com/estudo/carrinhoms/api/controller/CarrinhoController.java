package com.estudo.carrinhoms.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.estudo.carrinhoms.api.assembler.CarrinhoAssembler;
import com.estudo.carrinhoms.api.assembler.CarrinhoDisassembler;
import com.estudo.carrinhoms.api.dtos.CarrinhoDtoForm;
import com.estudo.carrinhoms.api.dtos.CarrinhoDtoList;
import com.estudo.carrinhoms.domain.Repository.CarrinhoRepository;
import com.estudo.carrinhoms.domain.model.Carrinho;
import com.estudo.carrinhoms.domain.services.CarrinhoService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/carrinhos")
public class CarrinhoController {
	
    @Autowired
    private CarrinhoRepository carrinhoRepository;
    
    @Autowired
    private CarrinhoService carrinhoService;
    
    @Autowired
    private CarrinhoAssembler carrinhoAssembler;
    
    @Autowired
    private CarrinhoDisassembler carrinhoDisassembler;
    
    @GetMapping
    public List<CarrinhoDtoList> listar() {
        List<Carrinho> carrinhos = carrinhoRepository.findAll();
        
        return carrinhoAssembler.toCollectionModel(carrinhos);
    }
    
    @GetMapping("/{carrinhoId}")
    public CarrinhoDtoList buscar(@PathVariable Long carrinhoId) {
        Carrinho carrinho = carrinhoService.buscarOuFalhar(carrinhoId);
        
        return carrinhoAssembler.toModel(carrinho);
    }
    
    @PostMapping
    public CarrinhoDtoList salvar(@RequestBody @Valid CarrinhoDtoForm carrinhoDtoForm) {
        Carrinho carrinho = carrinhoDisassembler.toEntity(carrinhoDtoForm);
        carrinho = carrinhoService.salvar(carrinho);
        
        return carrinhoAssembler.toModel(carrinho);
    }
    
    @PutMapping("/{carrinhoId}/confirmado")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void alterarStatusConfirmado(@PathVariable Long carrinhoId) {
        carrinhoService.alterarStatusConfirmado(carrinhoId);
    }

    @PutMapping("/{carrinhoId}/cancelado")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void alterarStatusCancelado(@PathVariable Long carrinhoId) {
        carrinhoService.alterarStatusCancelado(carrinhoId);
    }
	
}
