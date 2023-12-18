package com.webclientpractice.controller;

        import org.springframework.web.bind.annotation.GetMapping;
        import org.springframework.web.bind.annotation.RestController;
        import org.springframework.web.reactive.function.client.WebClient;

@RestController
public class InfoController {
    private WebClient webClient = WebClient.builder()
            .baseUrl("http://localhost:8090")
            .build();

    @GetMapping("/api/info")
    public InfoDto info(){

        InfoDto dto = new InfoDto();
        dto.setInfo("testMember");
        return webClient.post()
                .uri("/member")
                .bodyValue(dto)
                .retrieve()
                .bodyToMono(InfoDto.class)
                .block();
    }
}