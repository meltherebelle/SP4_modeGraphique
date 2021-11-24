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
    
    public CelluleGraphique(Cellule uneCellule) {
        CelluleAssocie = uneCellule;
    }
    
    //cette fonction permet de dessiner la cellule graphique
    @Override 
    public void paintComponent (Graphics G) {
        super.paintComponent(G);
        setIcon(img_vide); //on attribue l'image celluleVide.png
    }
    
}
