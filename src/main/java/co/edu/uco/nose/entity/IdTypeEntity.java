package co.edu.uco.nose.entity;

import java.util.UUID;

import co.edu.uco.nose.crosscuting.helper.TextHelper;

public class IdTypeEntity extends Entity{
	
	
	private String name;
	private String description;
	
	public IdTypeEntity() {
		super();
		setName(TextHelper.getDefault());
		setDescrption(TextHelper.getDefault());
	}
	

	public IdTypeEntity(final UUID id) {
		super();
		setName(TextHelper.getDefault());
		setDescrption(TextHelper.getDefault());
	}
	
	public IdTypeEntity(final UUID id,final String name) {
		super();
		this.name = name;
		this.description = TextHelper.getDefault();
		
	}

    public IdTypeEntity(UUID id, String name, String abbreviation) {

    }

    public String getName() {
		return name;
	}

	public void setName(final String name) {
		this.name = TextHelper.getDefaultWithTrim(name);
	}
	public String getDescrption() {
		return description;
	}

	public void setDescrption(final String descrption) {
		this.description = TextHelper.getDefaultWithTrim(descrption);
	}
}