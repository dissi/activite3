package activite_2;

/**
 *
 * Implementation d'une grille.
 */
public class GrilleImpl implements Grille {

    /**
     * Grille de sudoku.
     */
    private final char[][] grille;

    /**
     * Constructeur.
     *
     * @param uneGrille Grille de sudoku
     */
    public GrilleImpl(final char[][] uneGrille) {
        this.grille = uneGrille;
    }

    /**
     * Accesseur de la propriété grille.
     *
     * @return char[][] grille
     */
    public final char[][] getGrille() {
        return grille;
    }

    /**
     * @return largeur/hauteur de la grille.
     */
    @Override
    public final int getDimension() {
        return this.getGrille().length;
    }

    /**
     *
     * Affecte une valeur dans la grille.
     *
     * @param x position x dans la grille
     * @param y position y dans la grille
     * @param value valeur a mettre dans la case
     * @throw IllegalArgumentException si x ou y sont hors bornes (0-8)
     * @throw IllegalArgumentException si la valeur est interdite aux vues des
     * autres valeurs de la grille
     * @throw IllegalArgumentException si value n'est pas un caractere autorise
     * ('1',...,'9')
     */
    @Override
    public final void setValue(final int x, final int y, final char value) {
        if (this.possible(x, y, value)) {
            String illegalArgMsg = "Valeur interdite aux vues des autres "
                    + "valeurs de la grille";
//          Parcourir la ligne x et véfifier si la valeur existe déjà.
            for (int j = 0; j < this.getDimension(); j++) {
                if (this.grille[x][j] == value) {
                    throw new IllegalArgumentException(illegalArgMsg);
                }
            }
//          Parcourir la colonne y et véfifier si la valeur existe déjà
            for (int i = 0; i < this.getDimension(); i++) {
                if (this.grille[i][y] == value) {
                    throw new IllegalArgumentException(illegalArgMsg);
                }
            }

//          Parcourir la box et véfifier si la valeur existe déjà.
//          tailleBloc = 3 ou 4 selon la dimension du jeu
            int tailleBloc = (int) Math.sqrt(this.getDimension());
            int i = (x / tailleBloc) * tailleBloc;
            int j = (y / tailleBloc) * tailleBloc;

            for (int r = 0; r < tailleBloc; r++) {
                for (int c = 0; c < tailleBloc; c++) {
                    if (this.grille[i + r][j + c] == value) {
                        throw new IllegalArgumentException(illegalArgMsg);
                    }
                }
            }
//          A donc passé tous les controles avec succès.
            this.grille[x][y] = value;
        }
    }

    /**
     * Recupere une valeur de la grille.
     *
     * @param x position x dans la grille
     * @param y position y dans la grille
     * @return valeur dans la case x,y
     * @throw IllegalArgumentException si x ou y sont hors bornes (0-8)
     */
    @Override
    public final char getValue(final int x, final int y) {
//      si x ou y sont hors bornes (0-8).
        if (x < 0 || x >= this.getDimension()
                || y < 0 || y >= this.getDimension()) {
            throw new IllegalArgumentException("Ligne ou colonne hors borne");
        }
        return this.grille[x][y];
    }

  

}
