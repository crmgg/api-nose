package co.edu.uco.nose.entity;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

import co.edu.uco.nose.crosscuting.helper.TextHelper;

public class UserEntity extends Entity {

    private String firstName;
    private String secondName;
    private String firstLastName;
    private String secondLastName;
    private String identification;
    private CityEntity residenceCity;
    private IdTypeEntity idType;
    private String email;
    private String phoneNumber;
    private boolean emailConfirmed;
    private boolean phoneNumberConfirmed;

    public UserEntity(UUID id, String idType, String firstname, String secondname, String firstlastname, String secondlastname, String email, String phone, String username, String password, boolean emailconfirmation, boolean phoneconfirmation) {
        super();
        setFirstName(TextHelper.getDefault());
        setSecondName(TextHelper.getDefault());
        setFirstLastName(TextHelper.getDefault());
        setSecondLastName(TextHelper.getDefault());
        setIdentification(TextHelper.getDefault());
        setResidenceCity(new CityEntity());
        setIdType(new IdTypeEntity());
        setEmail(TextHelper.getDefault());
        setPhoneNumber(TextHelper.getDefault());
        setEmailConfirmed(false);
        setPhoneNumberConfirmed(false);
    }

    public UserEntity(final UUID id) {
        super();
        setFirstName(TextHelper.getDefault());
        setSecondName(TextHelper.getDefault());
        setFirstLastName(TextHelper.getDefault());
        setSecondLastName(TextHelper.getDefault());
        setIdentification(TextHelper.getDefault());
        setResidenceCity(new CityEntity());
        setIdType(new IdTypeEntity());
        setEmail(TextHelper.getDefault());
        setPhoneNumber(TextHelper.getDefault());
        setEmailConfirmed(false);
        setPhoneNumberConfirmed(false);
    }

    public UserEntity(UUID id, String idType, String name, String firstlastname, String secondlastname, String email, String phone, String username, String password, boolean emailconfirmation, boolean phoneconfirmation, boolean accountstate) {
        super();
    }

    public UserEntity(UUID id, String idType, String name, String firstlastname, String secondlastname, String email, String phone, String username, String password, boolean emailconfirmation, boolean phoneconfirmation) {
    }

    public static UserEntity buildFromResultSet(final ResultSet resultSet) throws SQLException, SQLException {
        return new UserEntity(
                (UUID) resultSet.getObject("id"),
                resultSet.getString("idType"),
                resultSet.getString("firstname"),
                resultSet.getString("secondname"),
                resultSet.getString("firstlastname"),
                resultSet.getString("secondlastname"),
                resultSet.getString("email"),
                resultSet.getString("phone"),
                resultSet.getString("username"),
                resultSet.getString("password"),
                resultSet.getBoolean("emailconfirmation"),
                resultSet.getBoolean("phoneconfirmation")
        );
    }


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getFirstLastName() {
        return firstLastName;
    }

    public void setFirstLastName(String firstLastName) {
        this.firstLastName = firstLastName;
    }

    public String getSecondLastName() {
        return secondLastName;
    }

    public void setSecondLastName(String secondLastName) {
        this.secondLastName = secondLastName;
    }

    public String getIdentification() {
        return identification = identification;
    }

    public void setIdentification(String identification) {
        this.identification = identification;
    }

    public CityEntity getResidenceCity() {
        return residenceCity;
    }

    public void setResidenceCity(CityEntity residenceCity) {
        this.residenceCity = residenceCity;
    }

    public IdTypeEntity getIdType() {
        return idType;
    }

    public void setIdType(IdTypeEntity idType) {
        this.idType = idType;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
        setEmailConfirmed(false);
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public boolean isEmailConfirmed() {
        return emailConfirmed;
    }

    public void setEmailConfirmed(boolean emailConfirmed) {
        this.emailConfirmed = emailConfirmed;
    }

    public boolean isPhoneNumberConfirmed() {
        return phoneNumberConfirmed;
    }

    public void setPhoneNumberConfirmed(boolean mobileNumberConfirmed) {
        this.phoneNumberConfirmed = mobileNumberConfirmed;
    }
}
