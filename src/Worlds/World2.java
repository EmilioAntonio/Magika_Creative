package Worlds;

import Game.Entities.Creatures.Player;
import Game.Entities.Creatures.SkelyEnemy;
import Game.Entities.Statics.CoinBlock;
import Game.Entities.Statics.Rock;
import Game.Entities.Statics.Tree;
import Main.Handler;

public class World2 extends BaseWorld {
	
	private Handler handler;
	private Player player;

	public World2(Handler handler, String path, Player player) {
		super(handler, path, player);
		this.handler = handler;
		this.player = player;
		
		for(int i=0; i<20; i++)
		{
			entityManager.addEntity(new SkelyEnemy(handler, 800 + 35*(i%40), 500 + 60*(i/15)));
		}
	
		 	entityManager.addEntity(new Tree(handler, 250, 250));
	        entityManager.addEntity(new Rock(handler, 5000, 450));
	        entityManager.addEntity(new Tree(handler, 700, 276));
	        entityManager.addEntity(new Rock(handler, 684, 1470));
	        entityManager.addEntity(new Tree(handler, 765, 888));
	        entityManager.addEntity(new Rock(handler, 1000, 1345));
	        entityManager.addEntity(new Tree(handler, 1300, 700));
	        entityManager.addEntity(new Rock(handler, 999, 83));
	        entityManager.addEntity(new CoinBlock(handler, 830, 1475));
	        
	}

}
