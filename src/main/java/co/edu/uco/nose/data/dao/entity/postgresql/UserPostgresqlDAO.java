package co.edu.uco.nose.data.dao.entity.postgresql;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

import co.edu.uco.nose.crosscuting.exception.NoseException;
import co.edu.uco.nose.crosscuting.helper.SqlConnectionHelper;
import co.edu.uco.nose.data.dao.entity.SqlConnection;
import co.edu.uco.nose.data.dao.entity.UserDAO;
import co.edu.uco.nose.entity.UserEntity;

public final class UserPostgresqlDAO extends SqlConnection implements UserDAO {


    @Override
    public void create(final UserEntity entity) {

        SqlConnectionHelper.ensureTransactionIsStarted(getConnection());

        final var sql=new StringBuilder();
        sql.append("INSERT INTO User(id, tipoIdentificacion, numeroIdentificacion, primerNombre, segundoNombre, primerApellido, segundoApellido, ) ");
        sql.append("VALUES(?, ?, ?, ?, ?, ?, ?)");

        try (var preparedStatement=this.getConnection().prepareStatement(sql.toString())){

            preparedStatement.setObject(1, entity.getId());
            preparedStatement.setObject(2, entity.getIdType().getId());
            preparedStatement.setString(3, entity.getIdentification());
            preparedStatement.setString(4, entity.getFirstName());
            preparedStatement.setString(5, entity.getSecondName());
            preparedStatement.setString(6, entity.getFirstLastName());
            preparedStatement.setString(7, entity.getSecondLastName());
            preparedStatement.setObject(8, entity.getResidenceCity().getId());
            preparedStatement.setString(9, entity.getEmail());
            preparedStatement.setString(10, entity.getPhoneNumber());
            preparedStatement.setBoolean(11, entity.isEmailConfirmed());
            preparedStatement.setBoolean(12, entity.isMobileNumberConfirmed());

            preparedStatement.executeUpdate();

        } catch (final SQLException exception) {
            var userMessage= "No se pudo crear el usuario";
            var technicalMessage= "Se ha presentado un error al intentar crear el usuario en la base de datos. Por favor verifique la traza completa del error";
            throw NoseException.create(exception, userMessage, technicalMessage);
        }catch (final Exception exception) {
            var userMessage= "Se ha presentado un problema INESPERADO";
            var technicalMessage= "Se ha presentado un error al intentar crear el usuario en la base de datos. Por favor verifique la traza completa del error";
            throw NoseException.create(exception, userMessage, technicalMessage);
        }
    }

    public UserPostgresqlDAO(Connection connection) {
        super(connection);
        // TODO Auto-generated constructor stub
    }


    @Override
    public List<UserEntity> findAll() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<UserEntity> findByFilter(UserEntity filterEntity) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public UserEntity findById(UUID id) {
        // TODO Auto-generated method stub
        return null;
    }
    @Override
    public void update(UserEntity entity) {
        SqlConnectionHelper.ensureTransactionIsStarted(getConnection());
        final var sql = new StringBuilder();
        sql.append("UPDATE User SET idType = ?, phoneNumber = ?, firstName = ?, secondName = ?, firstLastName = ?, secondLastName = ?, residenceCity = ?, email = ?, phoneNumber = ?, emailConfirmed = ?, mobileNumberConfirmed = ? WHERE id = ?");
        try (var preparedStatement = this.getConnection().prepareStatement(sql.toString())) {
            preparedStatement.setObject(1, entity.getIdType().getId());
            preparedStatement.setString(2, entity.getPhoneNumber());
            preparedStatement.setString(3, entity.getFirstName());
            preparedStatement.setString(4, entity.getSecondName());
            preparedStatement.setString(5, entity.getFirstLastName());
            preparedStatement.setString(6, entity.getSecondLastName());
            preparedStatement.setObject(7, entity.getResidenceCity().getId());
            preparedStatement.setString(8, entity.getEmail());
            preparedStatement.setString(9, entity.getPhoneNumber());
            preparedStatement.setBoolean(10, entity.isEmailConfirmed());
            preparedStatement.setBoolean(11, entity.isMobileNumberConfirmed());
            preparedStatement.setObject(12, entity.getId());
            preparedStatement.executeUpdate();
        } catch (final SQLException exception) {
            var userMessage = "No se pudo actualizar el usuario";
            var technicalMessage = "Se ha presentado un error al intentar actualizar el usuario en la base de datos. Por favor verifique la traza completa del error";
            throw NoseException.create(exception, userMessage, technicalMessage);
        } catch (final Exception exception) {
            var userMessage = "No se pudo actualizar el usuario";
            var technicalMessage = "Se ha presentado un error inesperado al intentar actualizar el usuario en la base de datos. Por favor verifique la traza completa del error";
            throw NoseException.create(exception, userMessage, technicalMessage);
        } catch (final Throwable exception) {
            var userMessage = "No se pudo actualizar el usuario";
            var technicalMessage = "Se ha presentado un error critico al intentar actualizar el usuario en la base de datos. Por favor verifique la traza completa del error";
            throw NoseException.create(exception, userMessage, technicalMessage);
        }
    }

    @Override
    public void delete(UUID id) {
        SqlConnectionHelper.ensureTransactionIsStarted(getConnection());
        final var sql = new StringBuilder();
        sql.append("DELETE FROM User WHERE id = ?");
        try (var preparedStatement = this.getConnection().prepareStatement(sql.toString())) {
            preparedStatement.setObject(1, id);
            preparedStatement.executeUpdate();
        } catch (final SQLException exception) {
            var userMessage = "No se pudo eliminar el usuario";
            var technicalMessage = "Se ha presentado un error al intentar eliminar el usuario en la base de datos. Por favor verifique la traza completa del error";
            throw NoseException.create(exception, userMessage, technicalMessage);
        } catch (final Exception exception) {
            var userMessage = "No se pudo eliminar el usuario";
            var technicalMessage = "Se ha presentado un error inesperado al intentar eliminar el usuario en la base de datos. Por favor verifique la traza completa del error";
            throw NoseException.create(exception, userMessage, technicalMessage);
        } catch (final Throwable exception) {
            var userMessage = "No se pudo eliminar el usuario";
            var technicalMessage = "Se ha presentado un error critico al intentar eliminar el usuario en la base de datos. Por favor verifique la traza completa del error";
            throw NoseException.create(exception, userMessage, technicalMessage);
        }
    }

}