package com.devlucasmart.parcela.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ClienteRequest {
    private String nome;
    private String email;
    private String fone;
}
