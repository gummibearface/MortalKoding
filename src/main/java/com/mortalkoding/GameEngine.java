package com.mortalkoding;

import com.mortalkoding.enums.TerrainType;
import com.mortalkoding.model.ResourceBundle;

import java.util.ArrayList;
import java.util.Collection;

public class GameEngine {

	public GameEngine() {
		
	}

	public static void main(String[] args) {
	Collection<AbstractMonsterFactory> monsterFactories = new ArrayList<>();
		Field field = new Field("Stadium", TerrainType.DESERT, new ResourceBundle());
		//  ^  Maybe we can make this a random generator?
		AbstractMonsterFactory factory = new GolemMonsterFactory(field);
		monsterFactories.add(factory);
		
		for (AbstractMonsterFactory bob:monsterFactories){
			bob.initiateConsumePhase();
		}
	}

}
