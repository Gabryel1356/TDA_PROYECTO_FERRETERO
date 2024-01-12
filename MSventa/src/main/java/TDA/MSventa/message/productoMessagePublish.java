package TDA.MSventa.message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import TDA.MSventa.model.modeloVenta;



@Component
public class productoMessagePublish {

    
    @Value("${spring.kafka.template.default-topic}")
    
    String topicName;

    @Autowired
    KafkaTemplate<Integer, String> kafkaTemplate;
    
    @Autowired
    ObjectMapper objectMapper;

    public void sendDepositEvent(modeloVenta modelven) throws JsonProcessingException {

        String value = objectMapper.writeValueAsString(modelven);
        kafkaTemplate.send(topicName, value);
    }
    

}
