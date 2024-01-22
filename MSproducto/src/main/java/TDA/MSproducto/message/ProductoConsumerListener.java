package TDA.MSproducto.message;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import TDA.MSproducto.dto.ProductoRequestDto;
import TDA.MSproducto.model.modeloProducto;
import TDA.MSproducto.services.ProductoService;
import lombok.extern.log4j.Log4j2;


@Log4j2
@Component
public class ProductoConsumerListener {
   

    @Autowired
    ProductoService service;

    @KafkaListener(topics = "${spring.kafka.template.default-topic}")
    public void OnMessage(ConsumerRecord<Integer, String> consumerRecord)
            throws JsonMappingException, JsonProcessingException {
        log.info("****************************************************************");
        log.info("ConsumerRecord : {}", consumerRecord.value());

        ObjectMapper objectMapper = new ObjectMapper();
        String jsonMessage = consumerRecord.value();
        modeloProducto data = objectMapper.readValue(jsonMessage, modeloProducto.class);
        
        ProductoRequestDto model = new ProductoRequestDto();

        model.setIdproduct(data.getIdproduct());
        model.setStock(data.getStock());


        log.info("se Registro el descuento de producto por venta {} ", data.getIdproduct());
        service.agregar(model);

        log.info("****************************************************************");
    }
}
