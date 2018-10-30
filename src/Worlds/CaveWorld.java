package Worlds;
import Game.Entities.Creatures.Player;
import Game.Entities.Creatures.*;
import Game.Entities.Statics.CoinBlock;
import Game.Entities.Statics.Door;
import Game.Entities.Statics.Rock;
import Game.Entities.Statics.Tree;
import Main.Handler;

/**
 * Created by Elemental on 2/10/2017.
 */
public class CaveWorld extends BaseWorld{
    private Handler handler;
    private Player player;
    private BaseWorld world2;

    public CaveWorld(Handler handler, String path, Player player) {
        super(handler,path,player);
        this.handler = handler;
        this.player=player;
        
        world2 = new World2(handler,"res/Maps/BossMap.map",player);
        
        entityManager.addEntity(new Door(handler, 800, 0, world2));
        entityManager.addEntity(new Rock(handler, 100, 450));
        entityManager.addEntity(new Rock(handler, 684, 1370));
        entityManager.addEntity(new Rock(handler, 88, 1345));
        entityManager.addEntity(new Rock(handler, 700, 83));
        entityManager.addEntity(new OpSkely(handler, 1250, 500));
        entityManager.addEntity(new CoinBlock(handler, 555, 1050));
        entityManager.addEntity(new CoinBlock(handler, 1250, 600));
        
        
        for(int i=0; i<5; i++)
        {
        	entityManager.addEntity(new SkelyEnemy(handler, 800 + 35*(i%40), 500 + 60*(i/15)));
        }
        

    }


}