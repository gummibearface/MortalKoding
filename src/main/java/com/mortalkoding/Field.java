package com.mortalkoding;

import com.mortalkoding.enums.TerrainType;
import com.mortalkoding.model.ResourceBundle;

public class Field {
	
	protected String fieldName;	// give it a name!
	protected TerrainType terrainType; // some kind of variance in lava, ocean, rocky, lightning, something...
	protected ResourceBundle resourceBundle; // list of the available resources of each type
	// maybe have the list of resources be read in from an XML document?
	// maybe have each different field be a different XML doc?

	
	
	public Field(String name, TerrainType terrain, ResourceBundle resources) {
		this.fieldName = name;
		this.terrainType = terrain;
		this.resourceBundle = resources;
	}


	//will return true if the resources required are available and will modify the resource bundle
	//to remove them if possible. 
	public boolean consumeResourceBundle(ResourceBundle resourcesRequired) {
		
		return false;
	}
	
	
	

}
