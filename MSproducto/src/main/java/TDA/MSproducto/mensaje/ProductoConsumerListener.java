package TDA.MSproducto.mensaje;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import TDA.MSproducto.dto.ProductoRequest;
import TDA.MSproducto.model.modeloProducto;
import TDA.MSproducto.services.IProductoService;

@Component
public class ProductoConsumerListener {
    @Value("${spring.kafka.template.default-topic}")
    String topicName;

    private Logger log = LoggerFactory.getLogger(ProductoConsumerListener.class);

    @Autowired
    IProductoService iProductoService;

    @Autowired
    KafkaTemplate<Integer, String> kafkaTemplate;
    @Autowired
    ObjectMapper objectMapper;

    @KafkaListener(topics = "${spring.kafka.template.default-topic}")
    public void OnMessage(ConsumerRecord<Integer, String> consumerRecord)
            throws JsonMappingException, JsonProcessingException {
        log.info("****************************************************************");
        log.info("ConsumerRecord : {}", consumerRecord.value());

        ObjectMapper objectMapper = new ObjectMapper();
        String jsonMessage = consumerRecord.value();
        ProductoRequest data = objectMapper.readValue(jsonMessage, ProductoRequest.class);

        modeloProducto model = new modeloProducto();

        model.setIdProducto(data.getIdProducto());
        model.setCostoCompra(data.getCostoCompra());
        model.setStock(data.getStock());

        log.info("Register Transaction {} ", data.getIdProducto());
        iProductoService.agregar(model);

        log.info("****************************************************************");
    }

    public void sendDepositEvent(modeloProducto ModeloProducto) throws JsonProcessingException {

        String value = objectMapper.writeValueAsString(ModeloProducto);
        kafkaTemplate.send(topicName, value);
    }

}
