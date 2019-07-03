package com.mortalkoding;
import java.util.Arrays;
import java.util.Collection;

import com.mortalkoding.enums.TerrainType;
import com.mortalkoding.model.ResourceBundle;

public abstract class Field {
	
	protected String fieldName;	// give it a name!
	protected TerrainType terrainType; // some kind of variance in lava, ocean, rocky, lightning, something...
	protected ResourceBundle resourceBundle; // list of the available resources of each type
	// maybe have the list of resources be read in from an XML document?
	// maybe have each different field be a different XML doc?
	
	protected Collection<AbstractMonsterFactory> monsterFactories;
	
	
	public Field(String name, TerrainType terrain, ResourceBundle resources, AbstractMonsterFactory... factories) {
		this.fieldName = name;
		this.terrainType = terrain;
		this.resourceBundle = resources;
		Arrays.asList(factories).stream().forEach(factory -> monsterFactories.add(factory));;
	}


	//will return true if the resources required are available and will modify the resource bundle
	//to remove them if possible. 
	public boolean consumeResourceBundle(ResourceBundle resourcesRequired) {
		
		return false;
	}
	
	
	

}
