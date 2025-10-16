package co.edu.uco.nose.entity;

import java.util.UUID;

import co.edu.uco.nose.crosscuting.helper.TextHelper;

public class CountryEntity extends Entity{
	
	private String name;
	
	public CountryEntity() {
		super();
		setName(TextHelper.getDefault());
	}
	

	public CountryEntity(final UUID id) {
		super();
		setName(TextHelper.getDefault());
	}
	
	public CountryEntity(final UUID id,final String name) {
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
