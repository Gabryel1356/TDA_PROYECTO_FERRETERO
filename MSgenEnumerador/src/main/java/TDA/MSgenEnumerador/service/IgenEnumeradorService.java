package TDA.MSgenEnumerador.service;

import TDA.MSgenEnumerador.model.modeloGenEnumerador;

public interface IgenEnumeradorService {
    public modeloGenEnumerador add(modeloGenEnumerador genenum);

    public Iterable<modeloGenEnumerador> findById(Integer idgenenum);

    public Iterable<modeloGenEnumerador> findAll();
}
