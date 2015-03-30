package homowork2.solitaire;

class DiscardPile extends SelectPile {

	DiscardPile(final int x, final int y) {
		super(x, y);
	}

	public void addCard(final Card aCard) {
		if (!aCard.isFaceUp()) {
			aCard.flip();
		}
		super.addCard(aCard);
	}

	public void select(final int tx, final int ty) {
		if (empty()) {
			return;
		}

        super.select(tx, ty);
	}
}