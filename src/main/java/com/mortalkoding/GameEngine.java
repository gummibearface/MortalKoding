package com.mortalkoding;

import java.util.ArrayList;
import java.util.Collection;

import com.mortalkoding.enums.TerrainType;
import com.mortalkoding.model.ResourceBundle;

public class GameEngine {

	public GameEngine() {
		
	}

	public static void main(String[] args) {
	Collection<AbstractMonsterFactory> monsterFactories = new ArrayList<>();
		Field field = new Field("Stadium", TerrainType.DESERT, new ResourceBundle());
		AbstractMonsterFactory factory = new GolemMonsterFactory(field);
		monsterFactories.add(factory);
		
		for (AbstractMonsterFactory bob:monsterFactories){
			bob.initiateConsumePhase();
		}
	}

}
