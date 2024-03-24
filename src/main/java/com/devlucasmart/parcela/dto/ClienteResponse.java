package com.devlucasmart.parcela.dto;

import com.devlucasmart.parcela.model.ClienteModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

import java.util.List;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClienteResponse {
    private String nome;
    private String email;
    private String telefone;
    public static ClienteResponse of(ClienteModel cliente) {
        var clienteResponse = new ClienteResponse();
        BeanUtils.copyProperties(cliente, clienteResponse);
        return clienteResponse;
    }

    public static List<ClienteResponse> of(List<ClienteModel> clientes) {
        return clientes.stream()
                .map(ClienteResponse::of)
                .collect(Collectors.toList());
    }
}
