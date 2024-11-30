package br.com.g4f.cartoes_ms.dtos;

import java.util.List;

public record ErrorDto(
        List<String> message
) {

}
