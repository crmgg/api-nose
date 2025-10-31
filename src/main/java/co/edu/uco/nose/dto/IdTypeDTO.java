package co.edu.uco.nose.dto;

import co.edu.uco.nose.crosscuting.helper.TextHelper;
import co.edu.uco.nose.crosscuting.helper.UUIDHelper;
import co.edu.uco.nose.data.dao.RetrieveDAO;

import java.util.List;
import java.util.UUID;

public class IdTypeDTO extends DTO {

    private String name;

    public IdTypeDTO() {
        super(UUIDHelper.getUUIDHelper().getDefault());
        setName(TextHelper.getDefault());
    }

    public IdTypeDTO(final UUID id) {
        super(id);
        setName(TextHelper.getDefault());
    }

    public IdTypeDTO(final UUID id, final String nombre) {
        super(id);
        setName(nombre);
    }

    public String getName() {
        return name;
    }

    public void setName(String nombre) {
        this.name = TextHelper.getDefault(nombre);
    }

    public static IdTypeDTO createDefault() {
        return new IdTypeDTO();
    }


}