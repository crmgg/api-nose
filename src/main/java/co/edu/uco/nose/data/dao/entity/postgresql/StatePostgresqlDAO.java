package co.edu.uco.nose.data.dao.entity.postgresql;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import co.edu.uco.nose.crosscuting.exception.NoseException;
import co.edu.uco.nose.crosscuting.helper.SqlConnectionHelper;
import co.edu.uco.nose.crosscuting.helper.UUIDHelper;
import co.edu.uco.nose.crosscuting.messagescatalog.MessagesEnum;
import co.edu.uco.nose.data.dao.entity.StateDAO;
import co.edu.uco.nose.entity.CountryEntity;
import co.edu.uco.nose.entity.StateEntity;

public final class StatePostgresqlDAO extends SqlConnection implements StateDAO {

    public StatePostgresqlDAO(final Connection connection) {
        super(connection);
    }

    private void mapResultSetToState(final java.sql.ResultSet resultSet, final StateEntity entity) {
        try {
            var country = new CountryEntity();
            country.setId(UUIDHelper.getUUIDHelper().getFromString(resultSet.getString("idPais")));
            country.setName(resultSet.getString("nombrePais"));

            entity.setId(UUIDHelper.getUUIDHelper().getFromString(resultSet.getString("idDepartamento")));
            entity.setName(resultSet.getString("nombreDepartamento"));
            entity.setCountry(country);

        } catch (final SQLException exception) {
            var userMessage = MessagesEnum.USER_ERROR_SQL_MAPPING_STATE.getContent();
            var technicalMessage = MessagesEnum.TECHNICAL_ERROR_SQL_MAPPING_STATE.getContent();
            throw NoseException.create(exception, userMessage, technicalMessage);
        }
    }

    @Override
    public List<StateEntity> findAll() {
        SqlConnectionHelper.ensureConnectionIsNotNull(getConnection());
        final List<StateEntity> states = new ArrayList<>();
        final var sql = new StringBuilder();
        sql.append("SELECT d.id AS idDepartamento, d.nombre AS nombreDepartamento, ");
        sql.append("p.id AS idPais, p.nombre AS nombrePais ");
        sql.append("FROM Departamento d ");
        sql.append("INNER JOIN Pais p ON d.pais = p.id ");

        try (var preparedStatement = getConnection().prepareStatement(sql.toString());
             var resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                var state = new StateEntity();
                mapResultSetToState(resultSet, state);
                states.add(state);
            }
        } catch (final SQLException exception) {
            var userMessage = MessagesEnum.USER_ERROR_SQL_EXECUTING_FIND_ALL_STATE.getContent();
            var technicalMessage = MessagesEnum.TECHNICAL_ERROR_SQL_EXECUTING_FIND_ALL_STATE.getContent();
            throw NoseException.create(exception, userMessage, technicalMessage);

        } catch (final Exception exception) {
            var userMessage = MessagesEnum.USER_ERROR_SQL_UNEXPECTED_ERROR_FIND_ALL_STATE.getContent();
            var technicalMessage = MessagesEnum.TECHNICAL_ERROR_SQL_UNEXPECTED_ERROR_FIND_ALL_STATE.getContent();
            throw NoseException.create(exception, userMessage, technicalMessage);
        }
        return states;
    }

    @Override
    public List<StateEntity> findByFilter(final StateEntity filterEntity) {
        SqlConnectionHelper.ensureConnectionIsNotNull(getConnection());
        final List<StateEntity> states = new ArrayList<>();
        final var sql = new StringBuilder();
        final var parameters = new ArrayList<Object>();

        sql.append("SELECT d.id AS idDepartamento, d.nombre AS nombreDepartamento, ");
        sql.append("p.id AS idPais, p.nombre AS nombrePais ");
        sql.append("FROM Departamento d ");
        sql.append("INNER JOIN Pais p ON d.pais = p.id ");
        sql.append("WHERE 1=1 ");

        // Construcción dinámica del WHERE
        final UUID defaultUuid = UUIDHelper.getUUIDHelper().getDefault();
        if (filterEntity.getId() != null && !defaultUuid.equals(filterEntity.getId())) {
            sql.append("AND d.id = ? ");
            parameters.add(filterEntity.getId());
        }
        if (filterEntity.getName() != null && !filterEntity.getName().trim().isEmpty()) {
            sql.append("AND d.nombre LIKE ? ");
            parameters.add("%" + filterEntity.getName().trim() + "%");
        }
        // Filtro por el ID del país
        if (filterEntity.getCountry() != null && filterEntity.getCountry().getId() != null && !defaultUuid.equals(filterEntity.getCountry().getId())) {
            sql.append("AND p.id = ? ");
            parameters.add(filterEntity.getCountry().getId());
        }

        try (var preparedStatement = getConnection().prepareStatement(sql.toString())) {
            for (int i = 0; i < parameters.size(); i++) {
                preparedStatement.setObject(i + 1, parameters.get(i));
            }
            try (var resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    var state = new StateEntity();
                    mapResultSetToState(resultSet, state);
                    states.add(state);
                }
            }
        } catch (final SQLException exception) {
            var userMessage = MessagesEnum.USER_ERROR_SQL_EXECUTING_FIND_BY_FILTER_STATE.getContent();
            var technicalMessage = MessagesEnum.TECHNICAL_ERROR_SQL_EXECUTING_FIND_BY_FILTER_STATE.getContent();
            throw NoseException.create(exception, userMessage, technicalMessage);

        } catch (final Exception exception) {
            var userMessage = MessagesEnum.USER_ERROR_SQL_UNEXPECTED_ERROR_FIND_BY_FILTER_STATE.getContent();
            var technicalMessage = MessagesEnum.TECHNICAL_ERROR_SQL_UNEXPECTED_ERROR_FIND_BY_FILTER_STATE.getContent();
            throw NoseException.create(exception, userMessage, technicalMessage);
        }
        return states;
    }

    @Override
    public StateEntity findById(final UUID id) {
        SqlConnectionHelper.ensureConnectionIsNotNull(getConnection());
        StateEntity state = null;
        final var sql = new StringBuilder();
        sql.append("SELECT d.id AS idDepartamento, d.nombre AS nombreDepartamento, ");
        sql.append("p.id AS idPais, p.nombre AS nombrePais ");
        sql.append("FROM Departamento d ");
        sql.append("INNER JOIN Pais p ON d.pais = p.id ");
        sql.append("WHERE d.id = ? ");

        try (var preparedStatement = getConnection().prepareStatement(sql.toString())) {
            preparedStatement.setObject(1, id);
            try (var resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    state = new StateEntity();
                    mapResultSetToState(resultSet, state);
                }
            }
        } catch (final SQLException exception) {
            var userMessage = MessagesEnum.USER_ERROR_SQL_EXECUTING_FIND_BY_ID_STATE.getContent();
            var technicalMessage = MessagesEnum.TECHNICAL_ERROR_SQL_EXECUTING_FIND_BY_ID_STATE.getContent();
            throw NoseException.create(exception, userMessage, technicalMessage);

        } catch (final Exception exception) {
            var userMessage = MessagesEnum.USER_ERROR_SQL_UNEXPECTED_ERROR_FIND_BY_ID_STATE.getContent();
            var technicalMessage = MessagesEnum.TECHNICAL_ERROR_SQL_UNEXPECTED_ERROR_FIND_BY_ID_STATE.getContent();
            throw NoseException.create(exception, userMessage, technicalMessage);
        }
        return state;
    }
}