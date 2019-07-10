package com.mortalkoding;

import com.mortalkoding.exception.ResourceAllocationException;
import com.mortalkoding.model.ResourceBundle;

public class GolemMonsterFactory extends AbstractMonsterFactory {

	public GolemMonsterFactory(Field field) {
		super(field);
	}

	@Override
	protected AbstractMonster produceMonster() {
		AbstractMonster golem = null;
		try {
			golem = new Golem();
		} catch (ResourceAllocationException e) {
			System.out.println("Not enough resources");
		}
		
		return golem;
	}

	@Override
	protected ResourceBundle consumeResources() {
		return null;
	}

}
