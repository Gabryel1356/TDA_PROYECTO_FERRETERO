package TDA.MSgenEnumerador.model;

import java.io.Serializable;

import org.bson.codecs.pojo.annotations.BsonId;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "genenum")
public class modeloGenEnumerador implements Serializable {

    @BsonId
    private String id;
    private int idgenenum;
    private int tipopersona;
    private int tipodocumento;
    private int sexo;

    public int getIdgenenum() {
        return idgenenum;
    }

    public void setIdgenenum(int idgenenum) {
        this.idgenenum = idgenenum;
    }

    public int getTipopersona() {
        return tipopersona;
    }

    public void setTipopersona(int tipopersona) {
        this.tipopersona = tipopersona;
    }

    public int getTipodocumento() {
        return tipodocumento;
    }

    public void setTipodocumento(int tipodocumento) {
        this.tipodocumento = tipodocumento;
    }

    public int getSexo() {
        return sexo;
    }

    public void setSexo(int sexo) {
        this.sexo = sexo;
    }

}