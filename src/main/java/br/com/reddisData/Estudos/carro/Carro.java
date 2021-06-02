package br.com.reddisData.Estudos.carro;

import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

@RedisHash("carro")
public class Carro {
    @Id
    private String id;
    private String modelo;
    private Integer ano;

    public Carro(String modelo, Integer ano) {
        this.modelo = modelo;
        this.ano = ano;
    }

    public String getModelo() {
        return modelo;
    }

    public Integer getAno() {
        return ano;
    }

    @Override
    public String toString() {
        return "Carro{" +
                "id='" + id + '\'' +
                ", modelo='" + modelo + '\'' +
                ", ano=" + ano +
                '}';
    }

    public String getId() {
        return id;
    }


}
