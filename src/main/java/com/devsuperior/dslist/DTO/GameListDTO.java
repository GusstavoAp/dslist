package com.devsuperior.dslist.DTO;

import com.devsuperior.dslist.entities.GameList;

public class GameListDTO {

    private Long id;
    private String name;

    public GameListDTO(){
    }

    public GameListDTO(GameList entity) {
        //Posso usar get ou o BeanUtils.copyProperties, da na mesma
        id = entity.getId();
        name = entity.getName();
    }

    //gerando somente getters
    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
