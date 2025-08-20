package com.devsuperior.dslist.repositories;

import com.devsuperior.dslist.entities.Game;
import com.devsuperior.dslist.entities.GameList;
import org.springframework.data.jpa.repository.JpaRepository;

//objeto/componente de acesso a dados
//consulta com bd, deletar, inserir e outras operações
public interface GameListRepository extends JpaRepository<GameList, Long> {


}
