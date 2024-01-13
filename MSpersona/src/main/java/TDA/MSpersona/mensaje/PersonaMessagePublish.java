package TDA.MSpersona.mensaje;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import TDA.MSpersona.model.modeloPersona;





@Component
public class PersonaMessagePublish {

    
    @Value("${spring.kafka.template.default-topic}")
    
    String topicName;

    @Autowired
    KafkaTemplate<Integer, String> kafkaTemplate;
    
    @Autowired
    ObjectMapper objectMapper;

    public void sendDepositEvent(modeloPersona modelpers) throws JsonProcessingException {

        String value = objectMapper.writeValueAsString(modelpers);
        kafkaTemplate.send(topicName, value);
    }
    

}
