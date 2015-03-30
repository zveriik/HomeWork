package homowork2.solitaire;

import java.awt.*;

class CardPile {

	private Card firstCard;

	// coordinates of the card pile
	protected int x;
	protected int y;
    protected int length;

	CardPile(final int xl, final int yl) {
		x = xl;
		y = yl;
		firstCard = null;
        length = 0;
	}

	// the following are sometimes overridden

	public void addCard(final Card aCard) {
		aCard.link = firstCard;
		firstCard = aCard;
        length++;
	}

	public boolean canTake(final Card aCard) {
		return false;
	}

	public void display(final Graphics g) {
		g.setColor(Color.black);
		if (firstCard == null) {
			g.drawRect(x, y, Card.width, Card.height);
		} else {
			firstCard.draw(g, x, y);
		}
	}

	public boolean empty() {
		return firstCard == null;
	}

	public boolean includes(final int tx, final int ty) {
		return x <= tx && tx <= x + Card.width && y <= ty
				&& ty <= y + Card.height;
	}

	public Card pop() {
		Card result = null;
		if (firstCard != null) {
			result = firstCard;
			firstCard = firstCard.link;
		}
        length--;
		return result;
	}

	public void select(final int tx, final int ty) {
		// do nothing
	}

	public Card top() {
		return firstCard;
	}
}