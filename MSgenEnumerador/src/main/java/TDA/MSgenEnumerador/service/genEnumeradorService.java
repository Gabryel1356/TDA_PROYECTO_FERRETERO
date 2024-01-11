package TDA.MSgenEnumerador.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import TDA.MSgenEnumerador.model.modeloGenEnumerador;
import TDA.MSgenEnumerador.repository.IgenEnumeradorRepository;

@CacheConfig(cacheNames = "genenum")
@Service
public class genEnumeradorService implements IgenEnumeradorService {

    Logger logger = LoggerFactory.getLogger(genEnumeradorService.class);

    @Autowired
    IgenEnumeradorRepository genEnumeradorRepository;

    @Override
    public modeloGenEnumerador add(modeloGenEnumerador genenum) {
        return genEnumeradorRepository.save(genenum);
    }

    @Override
    @Cacheable(cacheNames = { "genenum" }, key = "#idgenenum")
    public List<modeloGenEnumerador> findById(Integer idgenenum) {
        logger.info("SERVICE: Get Find By idgenenum: {}", idgenenum);
        return (List<modeloGenEnumerador>) genEnumeradorRepository.findById(idgenenum);
    }

    @Override
    public Iterable<modeloGenEnumerador> findAll() {
        return genEnumeradorRepository.findAll();
    }

}
