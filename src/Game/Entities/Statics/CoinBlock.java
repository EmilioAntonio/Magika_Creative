package Game.Entities.Statics;

import Game.Items.Item;
import Game.Tiles.Tile;
import Resources.Images;
import Main.Handler;

import javax.sound.sampled.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.Random;

public class CoinBlock extends StaticEntity {

	private File audioFile;
	private AudioInputStream audioStream;
	private AudioFormat format;
	private DataLine.Info info;
	private Clip audioClip;
	private Random randint;
	private int RNGR;

	public CoinBlock(Handler handler, float x, float y) {
		super(handler, x, y, Tile.TILEWIDTH, Tile.TILEHEIGHT);

		bounds.x=0;
		bounds.y=0;
		bounds.width = 64;
		bounds.height = 64;
		health=4;

		try {
			audioFile = new File("res/music/Pickaxe.wav");
			audioStream = AudioSystem.getAudioInputStream(audioFile);
			format = audioStream.getFormat();
			info = new DataLine.Info(Clip.class, format);
			audioClip = (Clip) AudioSystem.getLine(info);
			audioClip.open(audioStream);



		} catch (UnsupportedAudioFileException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (LineUnavailableException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void tick() {
		if(isBeinghurt()){
			audioClip.start();
		}
		if(!isBeinghurt() && !handler.getKeyManager().attbut){
			audioClip.stop();
		}
		if(!isActive()){
			audioClip.stop();

		}

	}

	@Override
	public void render(Graphics g) {
		renderLife(g);
		g.drawImage(Images.chestcoin,(int)(x-handler.getGameCamera().getxOffset()),(int)(y-handler.getGameCamera().getyOffset()),width,height,null);

	}

	@Override
	public void die() {
		randint=new Random();
		RNGR=randint.nextInt(1) + 1;
		System.out.println(RNGR);
		for(int i = 0; i < 2; i++){
			handler.getWorld().getItemManager().addItem(Item.coinItem.createNew((int)x + bounds.x,(int)y + bounds.y,1));
		}

	}
}
