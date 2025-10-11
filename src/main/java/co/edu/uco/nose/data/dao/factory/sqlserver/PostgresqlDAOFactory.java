package co.edu.uco.nose.data.dao.factory.sqlserver;

import co.edu.uco.nose.crosscuting.exception.NoseException;
import co.edu.uco.nose.data.dao.entity.CityDAO;
import co.edu.uco.nose.data.dao.entity.CountryDAO;
import co.edu.uco.nose.data.dao.entity.IdTypeDAO;
import co.edu.uco.nose.data.dao.entity.StateDAO;
import co.edu.uco.nose.data.dao.entity.UserDAO;
import co.edu.uco.nose.data.dao.entity.postgresql.*;
import co.edu.uco.nose.data.dao.factory.DAOFactory;

import java.sql.DriverManager;

public final class PostgresqlDAOFactory extends DAOFactory{

    @Override
    protected void openConnection() {

        try{
            this.connection = DriverManager.getConnection("");
        } catch (final Exception exception) {
            var userMessage= "";
            var technicalMessage= "";
            throw NoseException.create(exception, userMessage, technicalMessage);

        } catch (final Throwable exception) {
            var userMessage= "";
            var technicalMessage= "";
            throw NoseException.create(exception, userMessage, technicalMessage);
        }
    }



    @Override
    public CityDAO getCityDAO() {
        // TODO Auto-generated method stub
        return new CityPostgresqlDAO(connection);
    }

    @Override
    public CountryDAO getCountryDAO() {
        // TODO Auto-generated method stub
        return new CountryPostgresqlDAO(connection);
    }

    @Override
    public IdTypeDAO getIdTypeDAO() {
        // TODO Auto-generated method stub
        return new IdTypePostgresqlDAO(connection);
    }

    @Override
    public StateDAO getStateDAO() {
        // TODO Auto-generated method stub
        return new StatePostgresqlDAO(connection);
    }

    @Override
    public UserDAO getUserDAO() {
        // TODO Auto-generated method stub
        return new UserPostgresqlDAO(connection);
    }




}