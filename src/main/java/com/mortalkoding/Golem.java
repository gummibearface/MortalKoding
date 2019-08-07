package com.mortalkoding;

import com.mortalkoding.enums.TerrainType;
import com.mortalkoding.exception.ResourceAllocationException;
import com.mortalkoding.model.ResourceBundle;

public class Golem extends AbstractMonster {

	public Golem() throws ResourceAllocationException {
								//  strength 		weakness
		super("Golem", TerrainType.DESERT, TerrainType.WATER, 20, new ResourceBundle());
	}


	int normalAttack() {
		return 5;
	}

	int advantagedAttack() {
		return 10;
	}
}
