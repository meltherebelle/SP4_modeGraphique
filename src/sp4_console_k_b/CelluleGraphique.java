/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sp4_console_k_b;

import java.awt.Graphics;
import javax.swing.ImageIcon;
import javax.swing.JButton;

/**
 *
 * @author leaburriat
 */
//extension d'une celulle avec des propriétés graphiques - héritage de JButton
public class CelluleGraphique extends JButton {

    Cellule CelluleAssocie;
    ImageIcon img_vide = new javax.swing.ImageIcon(getClass().getResource("/images/celluleVide.png"));
    ImageIcon img_desint = new javax.swing.ImageIcon(getClass().getResource("/images/desintegrateur.png"));
    ImageIcon img_jetonJaune = new javax.swing.ImageIcon(getClass().getResource("/images/jetonJaune.png"));
    ImageIcon img_jetonRouge = new javax.swing.ImageIcon(getClass().getResource("/images/jetonRouge.png"));
    ImageIcon img_trouNoir = new javax.swing.ImageIcon(getClass().getResource("/images/trouNoir.png"));

    public CelluleGraphique(Cellule uneCellule) {
        CelluleAssocie = uneCellule;
    }

    //cette fonction permet de dessiner la cellule graphique
    @Override
    public void paintComponent(Graphics G) {
        super.paintComponent(G);
        if (CelluleAssocie.presenceTrouNoir() == true) {
            setIcon(img_trouNoir);
        } else if (CelluleAssocie.presenceDesintegrateur() == true) {
            setIcon(img_desint);
        } else {
            String couleur_jeton = CelluleAssocie.lireCouleurDuJeton();
            switch (couleur_jeton) {
                case "vide":
                    setIcon(img_vide);
                    break;
                case "Rouge":
                    setIcon(img_jetonRouge);
                    break;
                case "Jaune":
                    setIcon(img_jetonJaune);
                    break;
            }
        }
    }

}
