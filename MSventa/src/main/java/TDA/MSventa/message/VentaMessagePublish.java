package TDA.MSventa.message;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import TDA.MSventa.model.ModeloVenta;

@Component
public class VentaMessagePublish {

    @Value("${spring.kafka.template.default-topic}")

    String topicName;

    @Autowired
    KafkaTemplate<Integer, String> kafkaTemplate;

    @Autowired
    ObjectMapper objectMapper;

    public void sendDepositEvent(ModeloVenta modelven) throws JsonProcessingException {

        String value = objectMapper.writeValueAsString(modelven);
        if (topicName != null) {
            kafkaTemplate.send(topicName, value);
        }

    }

}
