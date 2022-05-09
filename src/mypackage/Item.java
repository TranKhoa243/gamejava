package mypackage;

public class Item extends Sprite{
	
	public Item(int x, int y) {
		super(x, y);
		initItem();
	}

	private void initItem() {
		loadImage("Images/Item.png");
		getImageDimention();
	}
	
}
