package com.mortalkoding;

import com.mortalkoding.enums.ResourceType;
import com.mortalkoding.enums.TerrainType;
import com.mortalkoding.exception.ResourceAllocationException;
import com.mortalkoding.model.ResourceBundle;

public abstract class AbstractMonster {
	//    ===    FIELDS   ===     //
	//Strength//ENUM VALUES
	//Weakness--One of both or neither
	//HP
	//name
	//attack
	//Resource Bundle
	
	protected final TerrainType strengthTerrain;
	protected final TerrainType weaknessTerrain;
	protected final String name;
	protected Integer currentHitPoints;
	protected ResourceBundle resourcesRequired;
	
	public AbstractMonster(String name, TerrainType strength, TerrainType weakness,
		Integer initialHitpoints, ResourceBundle resourceBundle) throws ResourceAllocationException	{
		this.strengthTerrain = strength;
		this.weaknessTerrain = weakness;
		this.currentHitPoints = initialHitpoints;
		this.resourcesRequired = resourceBundle;
		this.name = name;
		if (resourcesRequired.getTotalNumberOfResources() < 15) {
			throw new ResourceAllocationException();
		}
	}
	
	public final int attack(TerrainType fieldTerrain) {
		if(fieldTerrain.equals(strengthTerrain)) {
			return advantagedAttack();
		}
		else {
			return normalAttack();
		}
	}
	
	/**
	 * Takes a damage amount and terrain type and tells you whether the mosnter has died. 
	 * 
	 * @param damageAmount
	 * @param fieldTerrain
	 * @return true iff monster is dead
	 */
	public final boolean takeDamage(Integer damageAmount, TerrainType fieldTerrain) {
		if(fieldTerrain.equals(weaknessTerrain))
		{
			damageAmount *= 2;
		}
		boolean isDead = currentHitPoints <= damageAmount;
		if (!isDead)
		{
			currentHitPoints -= damageAmount;
		}
		return isDead;
	}

	//METHODs
	//return int Attack(FieldType passed in to know about advantage/disadvantage)
	//Monster decay TODO
	//return boolean isDead TakeDamage(int damageTaken, FieldType)

	abstract int normalAttack();
	
	abstract int advantagedAttack();
	


}
