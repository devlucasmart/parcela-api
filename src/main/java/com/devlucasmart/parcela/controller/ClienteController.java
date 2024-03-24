package com.devlucasmart.parcela.controller;

import com.devlucasmart.parcela.dto.ClienteRequest;
import com.devlucasmart.parcela.dto.ClienteResponse;
import com.devlucasmart.parcela.service.ClienteService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
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

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("clientes")
public class ClienteController {
   private final ClienteService service;

    @GetMapping
    public List<ClienteResponse> findAll() {
        return service.findAll();
    }

    @GetMapping("nome")
    public List<ClienteResponse> findByNome(@Valid @RequestBody ClienteRequest request) {
        return service.findByNome(request);
    }

    @GetMapping("{clienteId}")
    public ClienteResponse findById(@PathVariable Long clienteId) {
       return service.findById(clienteId);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public ClienteResponse save(@Valid @RequestBody ClienteRequest request) {
        return service.save(request);
    }

    @PutMapping("{clienteId}")
    public ClienteResponse update(@Valid @PathVariable Long clienteId, @RequestBody ClienteRequest request) {
       return service.update(clienteId, request);
    }

    @DeleteMapping("{clienteId}")
    public void delete(@PathVariable Long clienteId) {
        service.delete(clienteId);
    }
}
