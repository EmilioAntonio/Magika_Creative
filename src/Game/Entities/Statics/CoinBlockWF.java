package Game.Entities.Statics;

import Game.Items.Item;
import Game.Tiles.Tile;
import Resources.Images;
import Main.Handler;

import java.awt.*;

public class CoinBlockWF extends StaticEntity {

	

	public CoinBlockWF(Handler handler, float x, float y) {
		super(handler, x, y, Tile.TILEWIDTH, Tile.TILEHEIGHT);

		bounds.x=0;
		bounds.y=0;
		bounds.width = 64;
		bounds.height = 64;
		health=2;

		

	}

	@Override
	public void tick() {
		

	}

	@Override
	public void render(Graphics g) {
		renderLife(g);
		g.drawImage(Images.chestcoin,(int)(x-handler.getGameCamera().getxOffset()),(int)(y-handler.getGameCamera().getyOffset()),width,height,null);

	}

	@Override
	public void die() {

		handler.getWorld().getItemManager().addItem(Item.coinItem.createNew((int)x + bounds.x,(int)y + bounds.y,1));

		handler.getWorld().getItemManager().addItem(Item.fistItem.createNew((int)x + bounds.x,(int)y + bounds.y,1));

	}
}
