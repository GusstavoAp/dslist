package com.devsuperior.dslist.services;

import com.devsuperior.dslist.DTO.GameMinDTO;
import com.devsuperior.dslist.entities.Game;
import com.devsuperior.dslist.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


//registrar o componente no Spring (framework)
@Service //anotação para registro
public class GameService {

    //injetando uma instância do GameRepository dentro do meu GameService
    @Autowired
    private GameRepository gameRepository;

    //Meu Service devolve uma lista desses objeto respeitando a arquitetura
    public List<GameMinDTO> findAll(){
        List<Game> result = gameRepository.findAll();
        return result.stream().map(x -> new GameMinDTO(x)).toList();//permite operação com sequencia de dados
    }
}
