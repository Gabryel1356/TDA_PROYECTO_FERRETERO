package TDA.MSgenEnumerador.service;


import java.util.List;

import TDA.MSgenEnumerador.dto.genEnumeradorRequestDto;


public interface IgenEnumeradorService {

    public void agregar(genEnumeradorRequestDto genenum);

    public  genEnumeradorRequestDto obtenerporid(int id);

    public List<genEnumeradorRequestDto> obtener();
  
}
