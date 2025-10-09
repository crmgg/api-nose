package co.edu.uco.nose.data.dao.entity.postgresql;

import java.sql.Connection;
import java.util.List;
import java.util.UUID;

import co.edu.uco.nose.data.dao.entity.CountryDAO;
import co.edu.uco.nose.data.dao.entity.*;

public final class CountryPostgresqlDAO extends SqlConnection implements CountryDAO{

    CountryPostgresqlDAO(Connection connection2) {
        super(connection2);
    }

    @Override
	public List<IdTypeDAO> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<IdTypeDAO> findByFilter(IdTypeDAO filterEntity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IdTypeDAO findById(UUID id) {
		// TODO Auto-generated method stub
		return null;
	}
	

}
