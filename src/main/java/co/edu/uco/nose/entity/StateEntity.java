package co.edu.uco.nose.entity;

import java.util.UUID;

import co.edu.uco.nose.crosscuting.helper.TextHelper;

public class StateEntity extends Entity{
	
	
	private String name;
	
	public StateEntity() {
		super();
		setName(TextHelper.getDefault());
	}
	

	public StateEntity(final UUID id) {
		super();
		setName(TextHelper.getDefault());
	}
	
	public StateEntity(final UUID id,final String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(final String name) {
		this.name = TextHelper.getDefaultWithTrim(name);
	}

}
