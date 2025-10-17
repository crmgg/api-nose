package co.edu.uco.nose.entity;

import java.util.UUID;

import co.edu.uco.nose.crosscuting.helper.TextHelper;

public class CityEntity extends Entity {

    private String name;
    private StateEntity state;

    public CityEntity() {
        super();
        setName(TextHelper.getDefault());
        this.state = new StateEntity();
    }

    public CityEntity(final UUID id) {
        super();
        setName(TextHelper.getDefault());
        this.state = new StateEntity();
    }

    public CityEntity(final UUID id, final String name) {
        super();
        setName(name);
        this.state = new StateEntity();
    }

    public CityEntity(final UUID id, final String name, final StateEntity state) {
        super();
        setName(name);
        setState(state);
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = TextHelper.getDefaultWithTrim(name);
    }

    public StateEntity getState() {
        return state;
    }

    public void setState(final StateEntity state) {
        this.state = state == null ? new StateEntity() : state;
    }
}
