package com.devlucasmart.parcela.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ClienteRequest {
    @NotBlank(message = "O campo nome é obrigatorio")
    @Size(max = 60)
    private String nome;
    @NotBlank(message = "O campo nome é obrigatorio")
    @Size(max = 255)
    @Email
    private String email;
    @NotBlank(message = "O campo nome é obrigatorio")
    @Size(max = 20)
    private String fone;
}
