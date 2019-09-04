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
			System.out.println("Monster being produced doesn't require enough resources. Cheater");
		}
		
		return golem;
	}

	@Override
	protected ResourceBundle consumeResources() {
		return null;
	}

}
