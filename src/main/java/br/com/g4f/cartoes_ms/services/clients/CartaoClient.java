package br.com.g4f.cartoes_ms.services.clients;

import br.com.g4f.cartoes_ms.dtos.CartaoDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class CartaoClient {

    private final WebClient webClient;

    @Autowired
    public CartaoClient(WebClient.Builder webClient) {
        this.webClient = webClient.baseUrl("http://localhost:88/api/v1/cartoes").build();
    }

    public Mono<CartaoDto> getCard(Long id) {
        return this.webClient.post()
                .uri("/{id}",id)
                .contentType(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(CartaoDto.class)
                .doOnError(e->{
                    throw new RuntimeException("Aconteceu um erro na requisição");
                });
    }
}
