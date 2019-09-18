package com.mortalkoding;

import com.mortalkoding.exception.ResourceAllocationException;
import com.mortalkoding.model.ResourceBundle;

public class GolemMonsterFactory extends AbstractMonsterFactory {

	public GolemMonsterFactory(Field field) {
		super(field);
	}

	@Override
	protected AbstractMonster produceMonster() throws ResourceAllocationException {
		AbstractMonster golem = new Golem();
		return golem;
	}

	@Override
	protected ResourceBundle consumeResources() {
		return Golem.getRequiredResources();
	}

}
