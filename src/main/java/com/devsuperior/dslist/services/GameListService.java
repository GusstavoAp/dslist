package com.devsuperior.dslist.services;

import com.devsuperior.dslist.DTO.GameDTO;
import com.devsuperior.dslist.DTO.GameListDTO;
import com.devsuperior.dslist.DTO.GameMinDTO;
import com.devsuperior.dslist.entities.Game;
import com.devsuperior.dslist.entities.GameList;
import com.devsuperior.dslist.projections.GameMinProjection;
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

    @Autowired
    private GameRepository gameRepository;

    //Meu Service devolve uma lista desses objetos respeitando a arquitetura
    @Transactional(readOnly = true)
    public List<GameListDTO> findAll(){
        //devolve uma lista de objetos
        List<GameList> result = gameListRepository.findAll();//função pronta do framework "findAll"
        return result.stream().map(x -> new GameListDTO(x)).toList();//permite operação com sequencia de dados
    }

    //tudo isso ocorre numa transação vai executar TUDO
    @Transactional
    public void move(Long listId, int sourceIndex, int destinationIndex){
        List<GameMinProjection> list = gameRepository.searchByList(listId);

        GameMinProjection obj = list.remove(sourceIndex);
        list.add(destinationIndex, obj);

        int min = sourceIndex < destinationIndex ? sourceIndex: destinationIndex;
        int max = sourceIndex < destinationIndex ? destinationIndex : sourceIndex;

        for (int i = min; i <= max ; i++) {
            gameListRepository.updateBelongingPosition(listId, list.get(i).getId(), i);
        }
    }


}
