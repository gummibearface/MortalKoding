package com.mortalkoding;

import com.mortalkoding.enums.TerrainType;
import com.mortalkoding.exception.ResourceAllocationException;
import com.mortalkoding.model.ResourceBundle;

public class Golem extends AbstractMonster {

	public Golem() throws ResourceAllocationException {
		super("Golem", TerrainType.DESERT, TerrainType.WATER, 20, new ResourceBundle());
	}

	@Override
	int normalAttack() {
		return 5;
	}

	@Override
	int advantagedAttack() {
		return 10;
	}

}
