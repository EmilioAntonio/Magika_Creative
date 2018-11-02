package Game.Entities.Statics;

import Game.Items.Item;
import Game.Tiles.Tile;
import Resources.Images;
import Main.Handler;

import javax.sound.sampled.*;
import java.awt.*;
import java.io.File;


public class Halo extends StaticEntity {

	

	public Halo(Handler handler, float x, float y) {
		super(handler, x, y, Tile.TILEWIDTH, Tile.TILEHEIGHT);

		bounds.x=0;
		bounds.y=0;
		bounds.width = 64;
		bounds.height = 64;
		health=4;

		

	}

	@Override
	public void tick() {
		

	}

	@Override
	public void render(Graphics g) {
		renderLife(g);
		g.drawImage(Images.halo,(int)(x-handler.getGameCamera().getxOffset()),(int)(y-handler.getGameCamera().getyOffset()),width,height,null);

	}

	@Override
	public void die() {

		handler.getWorld().getItemManager().addItem(Item.haloItem.createNew((int)x + bounds.x,(int)y + bounds.y,1));

	}
}
