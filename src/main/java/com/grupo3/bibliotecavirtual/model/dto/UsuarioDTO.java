package com.grupo3.bibliotecavirtual.model.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UsuarioDTO {

    private Long id;
    private String email;
    private String password;
    private Long rolId;
    private Long perfilId;
}
