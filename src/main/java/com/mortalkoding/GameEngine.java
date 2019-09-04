package com.mortalkoding;

import com.mortalkoding.enums.TerrainType;
import com.mortalkoding.model.ResourceBundle;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.collections4.CollectionUtils;

public class GameEngine {

	public GameEngine() {
		
	}

	public static void main(String[] args) {
		System.out.println("Starting Game Engine");
		Collection<AbstractMonsterFactory> monsterFactories = new ArrayList<>();
		Field field = createField();
		//  ^  Maybe we can make this a random generator?
		createFactories(monsterFactories, field);
		
		startGame(field, monsterFactories);
	}

	private static void startGame(Field field, Collection<AbstractMonsterFactory> monsterFactories) {
		validateFactories(monsterFactories);
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
