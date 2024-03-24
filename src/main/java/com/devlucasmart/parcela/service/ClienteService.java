package com.devlucasmart.parcela.service;

import com.devlucasmart.parcela.comum.exception.ValidacaoException;
import com.devlucasmart.parcela.dto.ClienteRequest;
import com.devlucasmart.parcela.dto.ClienteResponse;
import com.devlucasmart.parcela.model.ClienteModel;
import com.devlucasmart.parcela.repository.ClienteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ClienteService {
    private final ClienteRepository repository;

    public List<ClienteResponse> findAll() {
        return ClienteResponse.of(repository.findAll());
    }

    public List<ClienteResponse> findByNome(ClienteRequest request) {
        return ClienteResponse.of(repository.findByNome(request.getNome()));
    }

    public ClienteResponse findById(Long id) {
        var cliente = repository.findById(id).orElseThrow(() -> new ValidacaoException("Cliente não encontrado"));
        return ClienteResponse.of(cliente);
    }

    public ClienteResponse save(ClienteRequest request) {
        var cliente = ClienteModel.builder()
                .nome(request.getNome())
                .email(request.getEmail())
                .telefone(request.getFone())
                .build();

        repository.save(cliente);
        return ClienteResponse.of(cliente);
    }

    public ClienteResponse update(Long id, ClienteRequest request) {
        var cliente = repository.findById(id).orElseThrow(() -> new ValidacaoException("Cliente não encontrado"));

        cliente.setNome(request.getNome());
        cliente.setEmail(request.getEmail());
        cliente.setTelefone(request.getFone());

        repository.save(cliente);
        return ClienteResponse.of(cliente);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
