package com.devsuperior.dslist.services;

import com.devsuperior.dslist.DTO.GameDTO;
import com.devsuperior.dslist.DTO.GameMinDTO;
import com.devsuperior.dslist.entities.Game;
import com.devsuperior.dslist.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


//registrar o componente no Spring (framework)
//Camada se serviço (Componente Intermediário) --> lógica do negócio:
// exemplo, registrar pedido: baixar e verificar o estoque, enviar email avisando, processar cartão de crédito etc.
@Service //anotação para registro
public class GameService {

    //injetando uma instância do GameRepository dentro do meu GameService
    @Autowired
    private GameRepository gameRepository;

    //Criando um metodo para buscar por ID
    //Garante que a operação com banco de dados vai obedecer aos principios das transações do ACID, ou seja, que seja ATOMICA, CONSISTENTE,ISOLADA E DURAVEL
    @Transactional(readOnly = true) //Do Spring, não do Jakarta//"Read Only" estou garantindo que não vou fazer nenhuma operação de escrita, ou seja, não vou bloquear meu BD para escirta
    public GameDTO findById(Long id){
        Game result = gameRepository.findById(id).get();
        return new GameDTO(result);
    }



    //Meu Service devolve uma lista desses objetos respeitando a arquitetura
    @Transactional(readOnly = true)
    public List<GameMinDTO> findAll(){
        //devolve uma lista de objetos
        List<Game> result = gameRepository.findAll();//função pronta do framework "findAll"
        //Convertendo cada objeto para "GameMinDTO"
        return result.stream().map(x -> new GameMinDTO(x)).toList();//permite operação com sequencia de dados
    }


}
