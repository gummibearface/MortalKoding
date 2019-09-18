package com.mortalkoding;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;

import org.apache.commons.collections4.CollectionUtils;

import com.mortalkoding.exception.ResourceAllocationException;
import com.mortalkoding.model.ResourceBundle;

public abstract class AbstractMonsterFactory {

	Field field;
	List<AbstractMonster> monsters = new ArrayList<>();

	public AbstractMonsterFactory(Field field) {
		this.field = field;
	}

	public final void initiateConsumePhase() {
		System.out.println("Initiating consume phase for Factory type: " + this.getClass().getCanonicalName());
		ResourceBundle resourcesRequired = consumeResources();

		if (field.consumeResourceBundle(resourcesRequired)) {
			try {
				System.out.println("Consuming resources to produce monster for Factory type: " + this.getClass().getCanonicalName());
				AbstractMonster monster = produceMonster();
				monsters.add(monster);
			} catch (ResourceAllocationException e) {
				System.out.println("Monster being produced doesn't require enough resources. Cheater");
			}

		} else {
			System.out.println("Field doesn't have necessary resources to produce monster for Factory: "
					+ this.getClass().getCanonicalName());
		}

	}

	public final Collection<Integer> initiateAttackPhase() {
		List<Integer> attackValues = new ArrayList<>();
		for (AbstractMonster monster : monsters) {
			attackValues.add(monster.attack(field.terrainType));
		}

		return attackValues;
	}

	public final void takeAttacks(Collection<Integer> attacks) {
		System.out.println("Factory of type " + this.getClass().getCanonicalName() + " is taking their attacks");
		System.out.println("Monster count before attacks: " + monsters.size());
		for (Integer attackValue : attacks) {
			if (CollectionUtils.isEmpty(monsters)) {
				System.out.println("There are no monsters available to attack");
			} else {
				AbstractMonster damagedMonster;
				if (monsters.size() == 1) {
					damagedMonster = monsters.get(0);
				} else {
					Random rand = new Random();
					int randomIndex = rand.nextInt(monsters.size() - 1);
					damagedMonster = monsters.get(randomIndex);
				}
				boolean monsterKilled = damagedMonster.takeDamage(attackValue, field.terrainType);
				if (monsterKilled) {
					System.out.println("Monster has died in factory " + this.getClass().getCanonicalName());
					monsters.remove(damagedMonster);
				}
			}
		}

		System.out.println("Monster count after attacks: " + monsters.size());

	}

	// will return the created monster
	protected abstract AbstractMonster produceMonster() throws ResourceAllocationException;

	// Will return the resource bundle required to produce a monster
	protected abstract ResourceBundle consumeResources();

	// Consumes resources, produces monsters

	// CONSUME PHASE
	// Field Dependency
	// Health
	// Consume Resources() ---Will remove resources from the field with a method
	// that has validation on it
	// Produce Monster() --Will add a monster to your team
	// Sustain Monsters() --TODO

	// ATTACK PHASE
	// All monsters available in factory will attack
	// OR would allow for attacking other factories TODO

}
