package br.com.reddisData.Estudos.carro;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class CarroRequest {
    @JsonProperty
    @NotBlank
    private String modelo;
    @NotNull
    @JsonProperty
    @Min(value = 1990)
    private Integer ano;

    public CarroRequest(String modelo, Integer ano) {
        this.modelo = modelo;
        this.ano = ano;
    }

    public Carro paraCarro(){
        return new Carro(modelo,ano);
    }
}
