package TDA.MSproducto.dto;

import java.io.Serializable;

public class ProductoResponse implements Serializable{
    private static final long serialVersionUID = 1L;

    private final String listdo;

    

    public ProductoResponse(String listdo) {
        this.listdo = listdo;
    }



    public String getListdo() {
        return listdo;
    }
    
}
