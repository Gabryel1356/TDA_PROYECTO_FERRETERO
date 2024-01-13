package TDA.MSproducto.message;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import TDA.MSproducto.dto.ProductoRequest;
import TDA.MSproducto.model.modeloProducto;
import TDA.MSproducto.services.ProductoService;



@Component
public class ProductoConsumerListener {
     private Logger log = LoggerFactory.getLogger(ProductoConsumerListener.class);

    @Autowired
    ProductoService service;

    @KafkaListener(topics = "${spring.kafka.template.default-topic}")
    public void OnMessage(ConsumerRecord<Integer, String> consumerRecord)
            throws JsonMappingException, JsonProcessingException {
        log.info("****************************************************************");
        log.info("ConsumerRecord : {}", consumerRecord.value());

        ObjectMapper objectMapper = new ObjectMapper();
        String jsonMessage = consumerRecord.value();
        ProductoRequest data = objectMapper.readValue(jsonMessage, ProductoRequest.class);

        modeloProducto model = new modeloProducto();

        model.setIdproduct(data.getIdventa());
        model.setStock(data.getStock());


        log.info("se Registro el descuento de producto por venta {} ", data.getIdventa());
        service.agregar(model);

        log.info("****************************************************************");
    }
}
