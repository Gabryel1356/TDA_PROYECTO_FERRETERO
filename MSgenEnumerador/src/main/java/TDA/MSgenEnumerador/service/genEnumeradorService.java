package TDA.MSgenEnumerador.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import TDA.MSgenEnumerador.dto.genEnumeradorRequestDto;
import TDA.MSgenEnumerador.mapper.genEnumeradorMapper;
import TDA.MSgenEnumerador.model.modeloGenEnumerador;
import TDA.MSgenEnumerador.repository.IgenEnumeradorRepository;

@CacheConfig(cacheNames = "genenum")
@Service
public class genEnumeradorService implements IgenEnumeradorService {

    @Autowired
    IgenEnumeradorRepository genEnumeradorRepository;

    @Override
    public List<genEnumeradorRequestDto> obtener() {
        List<modeloGenEnumerador> genEnumerador = genEnumeradorRepository.findAll();
        List<genEnumeradorRequestDto> rq = genEnumerador.stream().map(
                mpgenEnumerador -> genEnumeradorMapper.mapper.GenEnumeradorRequestdto(mpgenEnumerador))
                .collect(Collectors.toList());
        return rq;
    }

    @Override
    @Transactional
    public void agregar(genEnumeradorRequestDto genquest) {
        modeloGenEnumerador genEnumerador = genEnumeradorMapper.mapper.GenEnumeradorModel(genquest);
        if (genEnumerador != null) {
            genEnumeradorRepository.save(genEnumerador);
        }
    }

    @Override
    @Cacheable(cacheNames = { "genenum" }, key = "#idgenenum")
    public genEnumeradorRequestDto obtenerporid(int id) {
        modeloGenEnumerador genEnumerador = genEnumeradorRepository.findById(id).orElse(null);
        return genEnumeradorMapper.mapper.GenEnumeradorRequestdto(genEnumerador);
    }

}
