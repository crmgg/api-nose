package co.edu.uco.nose.data.dao.entity.postgresql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

import co.edu.uco.nose.crosscuting.exception.NoseException;
import co.edu.uco.nose.crosscuting.helper.SqlConnectionHelper;
import co.edu.uco.nose.crosscuting.helper.UUIDHelper;
import co.edu.uco.nose.crosscuting.messagescatalog.MessagesEnum;
import co.edu.uco.nose.data.dao.entity.SqlConnection;
import co.edu.uco.nose.data.dao.entity.UserDAO;
import co.edu.uco.nose.entity.CityEntity;
import co.edu.uco.nose.entity.CountryEntity;
import co.edu.uco.nose.entity.IdTypeEntity;
import co.edu.uco.nose.entity.StateEntity;
import co.edu.uco.nose.entity.UserEntity;

public final class UserPostgresqlDAO extends SqlConnection implements UserDAO {



    @Override
    public void create(final UserEntity entity) {

        SqlConnectionHelper.ensureTransactionIsStarted(getConnection());

        final var sql=new StringBuilder();
        sql.append("INSERT INTO User(id, idType, phoneNumber, firstName, secondName, firstLastName, secondLastName, residenceCity, email, phoneNumber, emailConfirmed, mobileNumberConfirmed) ");
        sql.append("VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");

        try (var preparedStatement=this.getConnection().prepareStatement(sql.toString())){
            preparedStatement.setObject(1, entity.getId());
            preparedStatement.setObject(2, entity.getIdType().getId());
            preparedStatement.setString(3, entity.getPhoneNumber());
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
        } catch (final Exception exception) {
            var userMessage= "No se pudo crear el usuario";
            var technicalMessage= "Se ha presentado un error inesperado al intentar crear el usuario en la base de datos. Por favor verifique la traza completa del error";
            throw NoseException.create(exception, userMessage, technicalMessage);
        } catch (final Throwable exception) {
            var userMessage= "No se pudo crear el usuario";
            var technicalMessage= "Se ha presentado un error critico al intentar crear el usuario en la base de datos. Por favor verifique la traza completa del error";
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
        final String sql = "SELECT id, identitydocument, name, firstlastname, secondlastname, email, phone, username, password, emailconfirmation, phoneconfirmation, accountstate FROM users WHERE id = ?";

        try (final PreparedStatement preparedStatement = getConnection().prepareStatement(sql)) {

            preparedStatement.setObject(1, id);
            final ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                return new UserEntity(
                        (UUID) resultSet.getObject("id"),
                        resultSet.getString("identitydocument"),
                        resultSet.getString("name"),
                        resultSet.getString("firstlastname"),
                        resultSet.getString("secondlastname"),
                        resultSet.getString("email"),
                        resultSet.getString("phone"),
                        resultSet.getString("username"),
                        resultSet.getString("password"),
                        resultSet.getBoolean("emailconfirmation"),
                        resultSet.getBoolean("phoneconfirmation"),
                        resultSet.getBoolean("accountstate")
                );
            } else {
                return null;
            }

        } catch (SQLException exception) {
            throw new NoseException(
                    MessagesEnum.USER_ERROR_FIND_BY_ID_SQL.getContent(),
                    MessagesEnum.TECHNICAL_ERROR_FIND_BY_ID_SQL.getContent(),
                    exception
            );
        } catch (Exception exception) {
            throw new NoseException(
                    MessagesEnum.USER_ERROR_FIND_BY_ID_UNEXPECTED.getContent(),
                    MessagesEnum.TECHNICAL_ERROR_FIND_BY_ID_UNEXPECTED.getContent(),
                    (SQLException) exception
            );
        } catch (Throwable exception) {
            throw new NoseException(
                    MessagesEnum.USER_ERROR_FIND_BY_ID_CRITICAL.getContent(),
                    MessagesEnum.TECHNICAL_ERROR_FIND_BY_ID_CRITICAL.getContent(),
                    (SQLException) exception
            );
        }
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