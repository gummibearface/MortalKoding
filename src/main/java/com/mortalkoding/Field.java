package com.mortalkoding;

import com.mortalkoding.enums.ResourceType;
import com.mortalkoding.enums.TerrainType;
import com.mortalkoding.model.ResourceBundle;

public class Field {

	protected String fieldName; // give it a name!
	protected TerrainType terrainType; // some kind of variance in lava, ocean,
										// rocky, lightning, something...
	protected ResourceBundle resourceBundle; // list of the available resources
												// of each type
	// maybe have the list of resources be read in from an XML document?
	// maybe have each different field be a different XML doc?

	public Field(String name, TerrainType terrain, ResourceBundle resources) {
		this.fieldName = name;
		this.terrainType = terrain;
		if (resources.getTotalNumberOfResources() < 150) {
			System.out.println("Resources allocated for field are too low (< 150), using Default Resources");
			this.resourceBundle = ResourceBundle.getDefaultResourceBundle();
		} else {
			this.resourceBundle = resources;
		}
	}

	// will return true if the resources required are available and will modify
	// the resource bundle
	// to remove them if possible.
	public boolean consumeResourceBundle(ResourceBundle resourcesRequired) {

		for (ResourceType type : ResourceType.values()) {
			if (resourceBundle.getNumberOfResourcesForType(type) < resourcesRequired
					.getNumberOfResourcesForType(type)) {
				return false;
			}
			try {
				System.out.println("Consume resource for type: " + type.toString() + " Count: "
						+ resourcesRequired.getNumberOfResourcesForType(type));
				resourceBundle.removeResourceCount(type, resourcesRequired.getNumberOfResourcesForType(type));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return true;
	}

}
