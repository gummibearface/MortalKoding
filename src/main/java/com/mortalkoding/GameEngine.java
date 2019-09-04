package com.mortalkoding;

import com.mortalkoding.enums.TerrainType;
import com.mortalkoding.model.ResourceBundle;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.collections4.CollectionUtils;

public class GameEngine {

	static Collection<AbstractMonsterFactory> factories = new ArrayList<>();

	public static void main(String[] args) {
		System.out.println("Starting Game Engine");
		Field field = createField();
		//  ^  Maybe we can make this a random generator?
		createFactories(factories, field);
		
		startGame(field, factories);
	}

	private static void startGame(Field field, Collection<AbstractMonsterFactory> monsterFactories) {
		validateFactories(monsterFactories);
		consumePhase(monsterFactories);
		attackPhase(monsterFactories);
		
	}

	private static void attackPhase(Collection<AbstractMonsterFactory> monsterFactories) {
		Collection<Integer> attackValues = CollectionUtils.emptyCollection();
		for (AbstractMonsterFactory bob:monsterFactories){
			if (CollectionUtils.isNotEmpty(attackValues))
			{
				bob.takeAttacks(attackValues);
			}
			attackValues = bob.initiateAttackPhase();
			//TODO: Apply attack values to different factory
		}
		
	}

	private static void consumePhase(Collection<AbstractMonsterFactory> monsterFactories) {
		for (AbstractMonsterFactory bob:monsterFactories){
			bob.initiateConsumePhase();
		}
		
	}

	private static void validateFactories(Collection<AbstractMonsterFactory> monsterFactories) {
		if (CollectionUtils.isEmpty(monsterFactories) || monsterFactories.size() < 2)
		{
			System.out.println("ERROR!!!!!!!!! Must have multiple factories to play a game");
		} 
		
	}

	private static void createFactories(Collection<AbstractMonsterFactory> monsterFactories, Field field) {
		AbstractMonsterFactory factory = new GolemMonsterFactory(field);
		AbstractMonsterFactory factory2 = new GolemMonsterFactory(field);
		monsterFactories.add(factory);
		monsterFactories.add(factory2);
	}

	private static Field createField() {
		return new Field("Stadium", TerrainType.DESERT, new ResourceBundle());
	}

}
