package TDA.MSgenEnumerador.model;

import java.io.Serializable;

import org.bson.codecs.pojo.annotations.BsonId;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter


@Document(collection = "genenum")
public class modeloGenEnumerador implements Serializable {

    @BsonId
    private String id;
    private int idgenenum;
    private int tipopersona;
    private int tipodocumento;
    private int sexo;

}