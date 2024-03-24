package com.devlucasmart.parcela.service;

import com.devlucasmart.parcela.comum.exception.ValidacaoException;
import com.devlucasmart.parcela.dto.ClienteRequest;
import com.devlucasmart.parcela.dto.ClienteResponse;
import com.devlucasmart.parcela.model.ClienteModel;
import com.devlucasmart.parcela.repository.ClienteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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

    @Transactional
    public ClienteResponse save(ClienteRequest request) {
        validarEmail(request);
        var cliente = ClienteModel.builder()
                .nome(request.getNome())
                .email(request.getEmail())
                .telefone(request.getFone())
                .build();

        repository.save(cliente);
        return ClienteResponse.of(cliente);
    }

    @Transactional
    public ClienteResponse update(Long id, ClienteRequest request) {
        validarEmail(request);
        var cliente = repository.findById(id).orElseThrow(() -> new ValidacaoException("Cliente não encontrado"));

        cliente.setNome(request.getNome());
        cliente.setEmail(request.getEmail());
        cliente.setTelefone(request.getFone());

        repository.save(cliente);
        return ClienteResponse.of(cliente);
    }

    @Transactional
    public void delete(Long id) {
        repository.deleteById(id);
    }

    private void validarEmail(ClienteRequest request) {
        var clientesComMesmoEmail = repository.findByEmail(request.getEmail());

       var emailEmUsoPorOutroCliente = clientesComMesmoEmail.stream()
                .anyMatch(cliente -> !cliente.getNome().equals(request.getNome()));

        if (emailEmUsoPorOutroCliente) {
            throw new ValidacaoException("O e-mail está cadastrado para outro cliente.");
        }
    }
}
