package com.devsuperior.dslist.controllers;

import com.devsuperior.dslist.DTO.GameDTO;
import com.devsuperior.dslist.DTO.GameListDTO;
import com.devsuperior.dslist.DTO.GameMinDTO;
import com.devsuperior.dslist.services.GameListService;
import com.devsuperior.dslist.services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

//configurando a classe para ser um controlador
@RestController
@RequestMapping (value = "/lists")//mapear o recursos, exemplos, produtos, games etc
public class GameListController {

    @Autowired
    private GameListService gameListService;

    @GetMapping //metodo para obter a lista
    public List<GameListDTO> findAll(){
        List<GameListDTO> result = gameListService.findAll();
        return result;
    }

}
