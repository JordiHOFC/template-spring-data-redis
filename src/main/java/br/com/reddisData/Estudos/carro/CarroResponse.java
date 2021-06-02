package br.com.reddisData.Estudos.carro;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CarroResponse {
    @JsonProperty
    private String id;
    @JsonProperty
    private String modelo;
    @JsonProperty
    private Integer ano;

    public CarroResponse(Carro carro) {
        this.id = carro.getId();
        this.modelo = carro.getModelo();
        this.ano = carro.getAno();
    }
}
