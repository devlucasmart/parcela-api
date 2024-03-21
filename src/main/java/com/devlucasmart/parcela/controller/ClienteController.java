package com.devlucasmart.parcela.controller;

import com.devlucasmart.parcela.model.ClienteModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("clientes")
public class ClienteController {

    @GetMapping
    public List<ClienteModel> findAll() {
        var cliente1 =ClienteModel
                .builder()
                .id(1L)
                .nome("Lucas Martins")
                .email("lucas.martins@gmail.com")
                .telefone("4343443434")
                .build();
        return Arrays.asList(cliente1);
    }
}
