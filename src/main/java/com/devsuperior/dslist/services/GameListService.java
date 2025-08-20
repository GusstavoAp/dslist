package com.devsuperior.dslist.services;

import com.devsuperior.dslist.DTO.GameDTO;
import com.devsuperior.dslist.DTO.GameListDTO;
import com.devsuperior.dslist.DTO.GameMinDTO;
import com.devsuperior.dslist.entities.Game;
import com.devsuperior.dslist.entities.GameList;
import com.devsuperior.dslist.repositories.GameListRepository;
import com.devsuperior.dslist.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


//registrar o componente no Spring (framework)
//Camada se serviço (Componente Intermediário) --> lógica do negócio:
// exemplo, registrar pedido: baixar e verificar o estoque, enviar email avisando, processar cartão de crédito etc.
@Service //anotação para registro
public class GameListService {

    //injetando uma instância do GameRepository dentro do meu GameService
    @Autowired
    private GameListRepository gameListRepository;

    //Meu Service devolve uma lista desses objetos respeitando a arquitetura
    @Transactional(readOnly = true)
    public List<GameListDTO> findAll(){
        //devolve uma lista de objetos
        List<GameList> result = gameListRepository.findAll();//função pronta do framework "findAll"
        return result.stream().map(x -> new GameListDTO(x)).toList();//permite operação com sequencia de dados
    }


}
