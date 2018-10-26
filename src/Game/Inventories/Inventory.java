package Game.Inventories;

import Game.Items.Item;
import Game.SpellCast.FireBallSpell;
import Resources.Images;
import UI.UIInventory;
import UI.UIManager;
import Main.Handler;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

/**
 * Created by Elemental on 1/3/2017.
 */
public class Inventory {

    private Handler handler;
    private boolean active = false;
    private UIManager uiManager;
    private ArrayList<Item> inventoryItems;

    public Inventory(Handler handler){

        this.handler=handler;
        inventoryItems = new ArrayList<>();

        uiManager = new UIManager(handler);

        uiManager.addObjects(new UIInventory(0,0, 329, 265, Images.inventory,() -> {
        }));
    }

    public void tick() {

        for(Item i : inventoryItems){
            if(i.getCount()==0){
                inventoryItems.remove(inventoryItems.indexOf(i));
                return;
            }
        }

        if(handler.getKeyManager().keyJustPressed(KeyEvent.VK_Q)){
            active=!active;
            handler.getWorld().getEntityManager().getPlayer().getSpellGUI().setActive(false);

        }

        if(!active){
            return;
        }

        handler.getMouseManager().setUimanager(uiManager);
        uiManager.tick();



    }

    public void render(Graphics g) {

        if(!active){
            uiManager.isActive(uiManager.getObjects(),false);
            return;
        }



        uiManager.isActive(uiManager.getObjects(),true);
        uiManager.Render(g);
        g.setColor(Color.white);
        renderItems(g);


    }

    //Inventory Methods
    private void renderItems(Graphics g) {

    	int row = 60;  

		

		for(int i = 0; i < inventoryItems.size(); i++) {
			if(i < 5) {
				g.drawImage(inventoryItems.get(i).getTexture(), 25+(row*i), 24, inventoryItems.get(i).getWidth(), inventoryItems.get(i).getHeight(), null);
				g.drawString(String.valueOf(inventoryItems.get(i).getCount()), 25+33+(row*i),25+35);
			}else if(i < 10) {
				g.drawImage(inventoryItems.get(i).getTexture(), 25+(row*(i-5)), 24+row, inventoryItems.get(i).getWidth(), inventoryItems.get(i).getHeight(), null);
				g.drawString(String.valueOf(inventoryItems.get(i).getCount()), 25+33+(row*(i-5)),25+35+row);	
			}else if(i < 15) {
				g.drawImage(inventoryItems.get(i).getTexture(), 25+(row*(i-10)), 24+(row*2), inventoryItems.get(i).getWidth(), inventoryItems.get(i).getHeight(), null);
				g.drawString(String.valueOf(inventoryItems.get(i).getCount()), 25+33+(row*(i-10)),25+35+(row*2));	
			}else if(i < 20) {
				g.drawImage(inventoryItems.get(i).getTexture(), 25+(row*(i-15)), 24+(row*3), inventoryItems.get(i).getWidth(), inventoryItems.get(i).getHeight(), null);
				g.drawString(String.valueOf(inventoryItems.get(i).getCount()), 25+33+(row*(i-15)),25+35+(row*3));	
			}

}

    }

    public void addItem(Item item){
        for(Item i : inventoryItems){
            if(i.getId() == item.getId()){
                i.setCount(i.getCount()+item.getCount());
                return;
            }
        }
        if(item.getId()==2){
            handler.getWorld().getEntityManager().getPlayer().getSpellGUI().addSpell(new FireBallSpell(handler));
        }
        inventoryItems.add(item);

    }

    //GET SET
    public Handler getHandler() {
        return handler;
    }

    public void setHandler(Handler handler) {
        this.handler = handler;
    }

    public ArrayList<Item> getInventoryItems(){
        return inventoryItems;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
    
    public boolean containsItem(Item item){    	
    	
    	for(Item i : getInventoryItems())
    	{
    		if(i.getName().equals(item));
    			return true;
       	}
   		return false;
   	}
    
    public void removeItem(Item item)
    {
    	boolean remove = false;
    	for(Item i : getInventoryItems())
    	{
    		i.setCount(i.getCount()-item.getCount());
    		remove = true;
       	}
    	
    	if(remove)
    	{
    		System.out.println("culo");
    		inventoryItems.remove(item);
    	}
    }
}
