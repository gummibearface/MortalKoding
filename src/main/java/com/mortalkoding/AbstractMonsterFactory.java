package com.mortalkoding;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.mortalkoding.model.ResourceBundle;

public abstract class AbstractMonsterFactory {
	
	Field field;
	Collection<AbstractMonster> monsters = new ArrayList<>();
	
	
	public AbstractMonsterFactory(Field field)
	{
		this.field = field;
	}
	
	public final void initiateConsumePhase()
	{
		System.out.println("Initiating consume phase for Factory type: " + this.getClass().getCanonicalName());
		ResourceBundle resourcesRequired = consumeResources();
		
		if (field.consumeResourceBundle(resourcesRequired))
		{
			monsters.add(produceMonster());
		} else
		{
			System.out.println("Field doesn't have necessary resources to produce monster for Factory: " + this.getClass().getCanonicalName());
		}
		
	}
	
	public final Collection<Integer> initiateAttackPhase()
	{
		List<Integer> attackValues = new ArrayList<>();
		for(AbstractMonster monster : monsters)
		{
			attackValues.add(monster.attack(field.terrainType));
		}
		
		return attackValues;
	}

	//will return the created monster
	protected abstract AbstractMonster produceMonster();

	//Will return the resource bundle required to produce a monster
	protected abstract ResourceBundle consumeResources();
	
	
	
	// Consumes resources, produces monsters
	
	
	//CONSUME PHASE
	//Field Dependency
	//Health
	//Consume Resources() ---Will remove resources from the field with a method that has validation on it
	//Produce Monster() --Will add a monster to your team
	//Sustain Monsters() --TODO
	
	//ATTACK PHASE
	//All monsters available in factory will attack
	//OR would allow for attacking other factories TODO
	
	

}
