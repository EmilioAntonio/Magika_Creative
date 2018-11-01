package Worlds;


import Game.Entities.Creatures.*;
import Game.Entities.Statics.*;
import Main.Handler;

public class World2 extends BaseWorld {
	
	private Handler handler;
	private Player player;

	public World2(Handler handler, String path, Player player) {
		super(handler, path, player);
		this.handler = handler;
		this.player = player;
		
		entityManager.addEntity(new BossSkely(handler, 800, 800));
		
		entityManager.addEntity(new Heart(handler,800, 600));
		
	}

}
