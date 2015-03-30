package homeWorks.solitaire;

/**
 * Created by Aleksey_Zverkov on 3/30/2015.
 */
public class SelectPile extends CardPile {

    public SelectPile(int xl, int yl) {
        super(xl, yl);
    }

    @Override
    public void select(int tx, int ty) {

        Card topCard = pop();
        for (int i = 0; i < 4; i++) {
            if (Solitaire.suitPile[i].canTake(topCard)) {
                Solitaire.suitPile[i].addCard(topCard);
                return;
            }
        }
        for (int i = 0; i < 7; i++) {
            if (Solitaire.tableau[i].canTake(topCard)) {
                Solitaire.tableau[i].addCard(topCard);
                return;
            }
        }
        // nobody can use it, put it back on our list
        addCard(topCard);
    }
}
