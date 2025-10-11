package co.edu.uco.nose.data.dao.entity.postgresql;

import java.sql.Connection;
import java.util.List;
import java.util.UUID;

import co.edu.uco.nose.data.dao.entity.*;
import co.edu.uco.nose.dto.IdTypeDTO;
import co.edu.uco.nose.entity.IdTypeEntity;

public final class IdTypePostgresqlDAO extends SqlConnection implements IdTypeDAO {

    public IdTypePostgresqlDAO(Connection connection) {
        super(connection);
    }

    @Override
	public List<IdTypeEntity> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<IdTypeEntity> findByFilter(IdTypeEntity filterEntity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IdTypeEntity findById(UUID id) {
		// TODO Auto-generated method stub
		return null;
	}

}
