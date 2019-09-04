package com.mortalkoding;

import com.mortalkoding.enums.ResourceType;
import com.mortalkoding.enums.TerrainType;
import com.mortalkoding.exception.ResourceAllocationException;
import com.mortalkoding.model.ResourceBundle;

public class Golem extends AbstractMonster {

	public Golem() throws ResourceAllocationException {
		// strength weakness

		super("Golem", TerrainType.DESERT, TerrainType.WATER, 20, getRequiredResources());
	}

	int normalAttack() {
		return 5;
	}

	int advantagedAttack() {
		return 10;
	}

	public static ResourceBundle getRequiredResources() {
		ResourceBundle resourceBundle = new ResourceBundle();
		resourceBundle.addResourceCount(ResourceType.ADAMANTIUM, 5);
		resourceBundle.addResourceCount(ResourceType.CONCRETE, 5);
		resourceBundle.addResourceCount(ResourceType.URANIUM, 5);
		return resourceBundle;
	}
	
	
}
