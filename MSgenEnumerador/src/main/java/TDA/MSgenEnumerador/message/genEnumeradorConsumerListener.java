package TDA.MSgenEnumerador.message;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import TDA.MSgenEnumerador.dto.genEnumeradorRequest;
import TDA.MSgenEnumerador.model.modeloGenEnumerador;
import TDA.MSgenEnumerador.service.genEnumeradorService;




@Component
public class genEnumeradorConsumerListener {
     private Logger log = LoggerFactory.getLogger(genEnumeradorConsumerListener.class);

    @Autowired
    genEnumeradorService service;

    @KafkaListener(topics = "${spring.kafka.template.default-topic}")
    public void OnMessage(ConsumerRecord<Integer, String> consumerRecord)
            throws JsonMappingException, JsonProcessingException {
        log.info("****************************************************************");
        log.info("ConsumerRecord : {}", consumerRecord.value());

        ObjectMapper objectMapper = new ObjectMapper();
        String jsonMessage = consumerRecord.value();
        genEnumeradorRequest data = objectMapper.readValue(jsonMessage, genEnumeradorRequest.class);

        modeloGenEnumerador model = new modeloGenEnumerador();

        model.setIdgenenum(data.getIdgenenum());
        model.setSexo(data.getSexo());
        model.setTipodocumento(data.getTipodocumento());
        model.setTipopersona(data.getTipopersona());


        log.info("se Registro el descuento de producto por venta {} ", data.getIdgenenum());
        service.add(model);

        log.info("****************************************************************");
    }
}
