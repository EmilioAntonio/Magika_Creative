package Inputs;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyManager implements KeyListener {

	private boolean[] keys,justPressed,cantPress;
	public boolean up=false, down=false, left=false, right=false;
	public boolean up1=false, down1=false, left1=false, right1=false;
	public boolean attbut=false;
	public boolean fattbut=false;
	public boolean pbutt=false;
	public boolean hbutt = false;
	public boolean addbutt = false;
	public boolean telebutt = false;

	public boolean callbutt = false;
	public boolean interact = false;



	public KeyManager(){

		keys = new boolean[256];
		justPressed = new boolean[keys.length];
		cantPress = new boolean[keys.length];

	}

	public void tick(){
		for(int i =0; i < keys.length;i++){
			if(cantPress[i] && !keys[i]){
				cantPress[i]=false;

			}else if(justPressed[i]){
				cantPress[i]=true;
				justPressed[i] =false;
			}
			if(!cantPress[i] && keys[i]){
				justPressed[i]=true;
			}
		}

		up = keys[KeyEvent.VK_W];
		down = keys[KeyEvent.VK_S];
		left = keys[KeyEvent.VK_A];
		right = keys[KeyEvent.VK_D];
		
		up1 = keys[KeyEvent.VK_UP];
		down1 = keys[KeyEvent.VK_DOWN];
		left1 = keys[KeyEvent.VK_LEFT];
		right1 = keys[KeyEvent.VK_RIGHT];

		attbut = keys[KeyEvent.VK_E];
		fattbut = keys[KeyEvent.VK_C];
		pbutt = keys[KeyEvent.VK_ESCAPE];
		
		hbutt = keys[KeyEvent.VK_SHIFT];
		addbutt = keys[KeyEvent.VK_X];
		telebutt = keys[KeyEvent.VK_T];
		callbutt = keys[KeyEvent.VK_G];
		interact = keys[KeyEvent.VK_Z];

	}

	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() < 0 || e.getKeyCode() >= keys.length)
			return;
		keys[e.getKeyCode()] = true;
	}

	@Override
	public void keyReleased(KeyEvent e) {
		if(e.getKeyCode() < 0 || e.getKeyCode() >= keys.length)
			return;
		keys[e.getKeyCode()] = false;
	}

	@Override
	public void keyTyped(KeyEvent e) {

	}

	public boolean keyJustPressed(int keyCode){
		if(keyCode < 0 || keyCode >= keys.length)
			return false;
		return justPressed[keyCode];
	}

}
