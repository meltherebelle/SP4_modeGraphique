/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package sp4_console_k_b;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author leaburriat
 */
public class fenetreDeJeu extends javax.swing.JFrame {

    Joueur[] ListeJoueurs = new Joueur[2];
    Joueur joueurCourant;
    Grille grilleJeu = new Grille();
    boolean finish=false;
    /**
     * Creates new form fenetreDeJeu
     */
    public fenetreDeJeu() {
        initComponents();
        panneau_info_joueur.setVisible(false);
        panneau_info_partie.setVisible(false);
        lbl_gameover.setVisible(false);

        //ajout des 42 cellules graphique sur le panneau grille
        for (int i = 5; i >= 0; i--) { //on ajoute en partant des lignes du haut
            for (int j = 0; j < 7; j++) {
                CelluleGraphique cellGraph = new CelluleGraphique(grilleJeu.CellulesJeu[i][j]);

                cellGraph.addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent evt) {

                        Cellule c = cellGraph.CelluleAssocie;
                        if (c.jetonCourant == null) {
                            return;
                        }

                        if (c.jetonCourant.Couleur == joueurCourant.Couleur) {
                            textemessage.setText("le joueur  " + joueurCourant.Nom + "   récupère un de ses jetons");
                            //Cellule jrecup= c.recupererjeton(); //attention a l'appel de la classe 
                            //--> en fonction de l'emplacement de la méthode recupererJeton
                            // la méthode recupererjeton() se situe dans la classe cellule masi elle est inactive       
                            Jeton jrecup = c.recupererJeton();
                            joueurCourant.ajouterJeton(jrecup);
                            c.supprimerJeton();
                            JoueurSuivant();

                        } else {
                            if (joueurCourant.nombreDesintegrateurs > 0) {
                                textemessage.setText("le joueur  " + joueurCourant.Nom + " désintégre un jeton");
                                c.supprimerJeton();
                                joueurCourant.utiliserDesintegrateur();
                                JoueurSuivant();
                            } else {
                                return;
                            }
                        }
                        grilleJeu.tasserGrille();
                        panneau_grille.repaint();
                        
                        lbl_j1_desint.setText(ListeJoueurs[0].nombreDesintegrateurs + "");
                        lbl_j2_desint.setText(ListeJoueurs[1].nombreDesintegrateurs + "");
                        
                        boolean vict_j1 = grilleJeu.etreGagnantePourJoueur(ListeJoueurs[0]);
                        boolean vict_j2 = grilleJeu.etreGagnantePourJoueur(ListeJoueurs[1]);
                        
                        if (vict_j1 && !vict_j2) {
                            textemessage.setText("Victoire de"+ ListeJoueurs[0].Nom);
                            panneau_grille.setVisible(false);
                            lbl_gameover.setVisible(true);
                            finish=true;
                        }
                        if (vict_j2 && !vict_j1) {
                            textemessage.setText("Victoire de"+ ListeJoueurs[1].Nom);
                            panneau_grille.setVisible(false);
                            lbl_gameover.setVisible(true);
                            finish=true;
                        }
                        
                        if (vict_j1 && vict_j2) {
                            if (joueurCourant == ListeJoueurs[0]) {
                                textemessage.setText("Victoire de " + ListeJoueurs[1].Nom + " (faute de jeu de l'autre joueur) :( ð");
                                panneau_grille.setVisible(false);
                                lbl_gameover.setVisible(true);
                                finish=true;
                            }
                            else {
                                textemessage.setText("Victoire de " + ListeJoueurs[0].Nom + " (faute de jeu de l'autre joueur) :( ð");
                                panneau_grille.setVisible(false);
                                lbl_gameover.setVisible(true);
                                finish=true;
                                
                            }
                            panneau_grille.repaint();
                            lbl_gameover.repaint();
                        }
                    }
                });
                
                panneau_grille.add(cellGraph);
            }
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        panneau_grille = new javax.swing.JPanel();
        panneau_creation_partie = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        nom_joueur_2 = new javax.swing.JTextField();
        nom_joueur_1 = new javax.swing.JTextField();
        btn_start = new javax.swing.JButton();
        panneau_info_joueur = new javax.swing.JPanel();
        lbl_j1_nom = new javax.swing.JLabel();
        lbl_j1_couleur = new javax.swing.JLabel();
        lbl_j1_desint = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        lbl_j2_nom = new javax.swing.JLabel();
        lbl_j2_couleur = new javax.swing.JLabel();
        lbl_j2_desint = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        panneau_info_partie = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        lbl_jcourant = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        textemessage = new javax.swing.JTextArea();
        btn_col_0 = new javax.swing.JButton();
        btn_col_6 = new javax.swing.JButton();
        btn_col_1 = new javax.swing.JButton();
        btn_col_2 = new javax.swing.JButton();
        btn_col_3 = new javax.swing.JButton();
        btn_col_4 = new javax.swing.JButton();
        btn_col_5 = new javax.swing.JButton();
        lbl_gameover = new javax.swing.JLabel();
        titleSP5 = new javax.swing.JLabel();
        lbl_welcome = new javax.swing.JLabel();

        jLabel3.setText("jLabel3");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(204, 204, 255));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panneau_grille.setBackground(new java.awt.Color(153, 167, 237));
        panneau_grille.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(0, 204, 255), new java.awt.Color(51, 102, 255), new java.awt.Color(0, 204, 255), new java.awt.Color(0, 102, 204)));
        panneau_grille.setLayout(new java.awt.GridLayout(6, 7));
        getContentPane().add(panneau_grille, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 86, 670, 560));

        panneau_creation_partie.setBackground(new java.awt.Color(123, 197, 194));
        panneau_creation_partie.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Silom", 3, 14)); // NOI18N
        jLabel1.setText("nom joueur 2 :");
        panneau_creation_partie.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 10, -1, -1));

        jLabel2.setFont(new java.awt.Font("Silom", 2, 14)); // NOI18N
        jLabel2.setText("nom joueur 1 : ");
        panneau_creation_partie.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        nom_joueur_2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nom_joueur_2ActionPerformed(evt);
            }
        });
        panneau_creation_partie.add(nom_joueur_2, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 30, 140, 30));

        nom_joueur_1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nom_joueur_1ActionPerformed(evt);
            }
        });
        panneau_creation_partie.add(nom_joueur_1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 140, 30));

        btn_start.setFont(new java.awt.Font("Silom", 0, 12)); // NOI18N
        btn_start.setText("Démarrer la partie");
        btn_start.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_startActionPerformed(evt);
            }
        });
        panneau_creation_partie.add(btn_start, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 70, 170, 30));

        getContentPane().add(panneau_creation_partie, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 90, 320, 110));

        panneau_info_joueur.setBackground(new java.awt.Color(204, 204, 255));
        panneau_info_joueur.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_j1_nom.setFont(new java.awt.Font("Silom", 0, 14)); // NOI18N
        lbl_j1_nom.setText("nom Joueur 1");
        panneau_info_joueur.add(lbl_j1_nom, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 50, 130, 20));

        lbl_j1_couleur.setFont(new java.awt.Font("Silom", 0, 14)); // NOI18N
        lbl_j1_couleur.setText("couleur joueur 1");
        panneau_info_joueur.add(lbl_j1_couleur, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 90, 140, 20));

        lbl_j1_desint.setFont(new java.awt.Font("Silom", 0, 14)); // NOI18N
        lbl_j1_desint.setText("nb désint joueur 1");
        panneau_info_joueur.add(lbl_j1_desint, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 120, 120, 20));

        jLabel9.setFont(new java.awt.Font("Silom", 2, 14)); // NOI18N
        jLabel9.setText("Joueur 1 :");
        panneau_info_joueur.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 130, 20));

        jLabel10.setFont(new java.awt.Font("Silom", 0, 14)); // NOI18N
        jLabel10.setText("couleur :");
        panneau_info_joueur.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 130, 20));

        jLabel11.setFont(new java.awt.Font("Silom", 0, 14)); // NOI18N
        jLabel11.setText("nb désintégrateurs :");
        panneau_info_joueur.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, 160, 20));

        jSeparator1.setBackground(new java.awt.Color(0, 0, 0));
        panneau_info_joueur.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, 300, -1));

        jLabel12.setFont(new java.awt.Font("Silom", 3, 14)); // NOI18N
        jLabel12.setText("Joueur 2 :");
        panneau_info_joueur.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 190, 130, 20));

        jLabel13.setFont(new java.awt.Font("Silom", 0, 14)); // NOI18N
        jLabel13.setText("couleur :");
        panneau_info_joueur.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 230, 130, 20));

        jLabel14.setFont(new java.awt.Font("Silom", 0, 14)); // NOI18N
        jLabel14.setText("nb désintégrateurs :");
        panneau_info_joueur.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 260, 160, 20));

        lbl_j2_nom.setFont(new java.awt.Font("Silom", 0, 14)); // NOI18N
        lbl_j2_nom.setText("nom Joueur 2");
        panneau_info_joueur.add(lbl_j2_nom, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 190, 130, 20));

        lbl_j2_couleur.setFont(new java.awt.Font("Silom", 0, 14)); // NOI18N
        lbl_j2_couleur.setText("couleur joueur 2");
        panneau_info_joueur.add(lbl_j2_couleur, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 230, 140, 20));

        lbl_j2_desint.setFont(new java.awt.Font("Silom", 0, 14)); // NOI18N
        lbl_j2_desint.setText("nb désint joueur 2");
        panneau_info_joueur.add(lbl_j2_desint, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 260, 120, 20));

        jLabel5.setFont(new java.awt.Font("Silom", 1, 18)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Infos Joueurs");
        panneau_info_joueur.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 10, 150, -1));

        getContentPane().add(panneau_info_joueur, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 210, 320, 300));

        panneau_info_partie.setBackground(new java.awt.Color(204, 204, 255));
        panneau_info_partie.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setFont(new java.awt.Font("Silom", 3, 18)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Infos Jeu");
        panneau_info_partie.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 0, 140, 40));

        jLabel15.setFont(new java.awt.Font("Silom", 2, 14)); // NOI18N
        jLabel15.setText("Joueur courant :");
        panneau_info_partie.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 130, 20));

        lbl_jcourant.setFont(new java.awt.Font("Silom", 0, 14)); // NOI18N
        lbl_jcourant.setText("nom J courant");
        panneau_info_partie.add(lbl_jcourant, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 40, 160, 20));

        textemessage.setColumns(20);
        textemessage.setFont(new java.awt.Font("Vampire Wars", 2, 14)); // NOI18N
        textemessage.setForeground(new java.awt.Color(255, 0, 0));
        textemessage.setLineWrap(true);
        textemessage.setRows(2);
        jScrollPane1.setViewportView(textemessage);

        panneau_info_partie.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 300, 50));

        getContentPane().add(panneau_info_partie, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 520, 320, 120));

        btn_col_0.setBackground(new java.awt.Color(204, 204, 255));
        btn_col_0.setFont(new java.awt.Font("Lucida Grande", 1, 14)); // NOI18N
        btn_col_0.setForeground(new java.awt.Color(153, 153, 255));
        btn_col_0.setText("1");
        btn_col_0.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_col_0ActionPerformed(evt);
            }
        });
        getContentPane().add(btn_col_0, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, -1, -1));

        btn_col_6.setBackground(new java.awt.Color(204, 204, 255));
        btn_col_6.setFont(new java.awt.Font("Lucida Grande", 1, 14)); // NOI18N
        btn_col_6.setForeground(new java.awt.Color(153, 153, 255));
        btn_col_6.setText("7");
        btn_col_6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_col_6ActionPerformed(evt);
            }
        });
        getContentPane().add(btn_col_6, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 50, -1, -1));

        btn_col_1.setBackground(new java.awt.Color(204, 204, 255));
        btn_col_1.setFont(new java.awt.Font("Lucida Grande", 1, 14)); // NOI18N
        btn_col_1.setForeground(new java.awt.Color(102, 102, 255));
        btn_col_1.setText("2");
        btn_col_1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_col_1ActionPerformed(evt);
            }
        });
        getContentPane().add(btn_col_1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 50, -1, -1));

        btn_col_2.setBackground(new java.awt.Color(204, 204, 255));
        btn_col_2.setFont(new java.awt.Font("Lucida Grande", 1, 14)); // NOI18N
        btn_col_2.setForeground(new java.awt.Color(153, 153, 255));
        btn_col_2.setText("3");
        btn_col_2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_col_2ActionPerformed(evt);
            }
        });
        getContentPane().add(btn_col_2, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 50, -1, -1));

        btn_col_3.setBackground(new java.awt.Color(204, 204, 255));
        btn_col_3.setFont(new java.awt.Font("Lucida Grande", 1, 14)); // NOI18N
        btn_col_3.setForeground(new java.awt.Color(153, 153, 255));
        btn_col_3.setText("4");
        btn_col_3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_col_3ActionPerformed(evt);
            }
        });
        getContentPane().add(btn_col_3, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 50, -1, -1));

        btn_col_4.setBackground(new java.awt.Color(204, 204, 255));
        btn_col_4.setFont(new java.awt.Font("Lucida Grande", 1, 14)); // NOI18N
        btn_col_4.setForeground(new java.awt.Color(153, 153, 255));
        btn_col_4.setText("5");
        btn_col_4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_col_4ActionPerformed(evt);
            }
        });
        getContentPane().add(btn_col_4, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 50, -1, -1));

        btn_col_5.setBackground(new java.awt.Color(204, 204, 255));
        btn_col_5.setFont(new java.awt.Font("Lucida Grande", 1, 14)); // NOI18N
        btn_col_5.setForeground(new java.awt.Color(153, 153, 255));
        btn_col_5.setText("6");
        btn_col_5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_col_5ActionPerformed(evt);
            }
        });
        getContentPane().add(btn_col_5, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 50, -1, -1));

        lbl_gameover.setFont(new java.awt.Font("Silom", 1, 36)); // NOI18N
        lbl_gameover.setForeground(new java.awt.Color(204, 0, 102));
        lbl_gameover.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_gameover.setText("Game Over :)");
        getContentPane().add(lbl_gameover, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 30, 330, 30));

        titleSP5.setFont(new java.awt.Font("Silom", 1, 24)); // NOI18N
        titleSP5.setForeground(new java.awt.Color(153, 153, 255));
        titleSP5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titleSP5.setText("Super Puissance 4");
        getContentPane().add(titleSP5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 680, 30));

        lbl_welcome.setFont(new java.awt.Font("Silom", 1, 24)); // NOI18N
        lbl_welcome.setForeground(new java.awt.Color(153, 153, 255));
        lbl_welcome.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_welcome.setText("Welcome in the game !");
        getContentPane().add(lbl_welcome, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 40, 330, 30));

        setBounds(0, 0, 1035, 690);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_startActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_startActionPerformed
        panneau_info_joueur.setVisible(true);
        panneau_info_partie.setVisible(true);
        lbl_gameover.setVisible(false);
        initialiserPartie();
        panneau_grille.repaint(); //on raffraichit l'affichage
        btn_start.setEnabled(false); 
        lbl_welcome.setVisible(false);
    }//GEN-LAST:event_btn_startActionPerformed

    private void nom_joueur_2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nom_joueur_2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nom_joueur_2ActionPerformed

    private void btn_col_2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_col_2ActionPerformed
        jouerDansColonne(2);
        if(finish==true){
            btn_col_2.setEnabled(false);
        }
        if (grilleJeu.colonneRemplie(2) == true) {
            btn_col_2.setEnabled(false);
        }
        JoueurSuivant();
    }//GEN-LAST:event_btn_col_2ActionPerformed

    private void nom_joueur_1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nom_joueur_1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nom_joueur_1ActionPerformed

    private void btn_col_0ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_col_0ActionPerformed
        // TODO add your handling code here:
        jouerDansColonne(0);
        if(finish==true){
            btn_col_0.setEnabled(false);
        }
        if (grilleJeu.colonneRemplie(0) == true) {
            btn_col_0.setEnabled(false);
        }
        JoueurSuivant();
    }//GEN-LAST:event_btn_col_0ActionPerformed

    private void btn_col_1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_col_1ActionPerformed
        // TODO add your handling code here:
        jouerDansColonne(1);
        if(finish==true){
            btn_col_1.setEnabled(false);
        }
        if (grilleJeu.colonneRemplie(1) == true) {
            btn_col_1.setEnabled(false);
        }
        JoueurSuivant();
    }//GEN-LAST:event_btn_col_1ActionPerformed

    private void btn_col_3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_col_3ActionPerformed
        // TODO add your handling code here:
        jouerDansColonne(3);
        if(finish==true){
            btn_col_3.setEnabled(false);
        }
        if (grilleJeu.colonneRemplie(3) == true) {
            btn_col_3.setEnabled(false);
        }
        JoueurSuivant();
    }//GEN-LAST:event_btn_col_3ActionPerformed

    private void btn_col_4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_col_4ActionPerformed
        // TODO add your handling code here:
        jouerDansColonne(4);
        if(finish==true){
            btn_col_4.setEnabled(false);
        }
        if (grilleJeu.colonneRemplie(4) == true) {
            btn_col_4.setEnabled(false);
        }
        JoueurSuivant();
    }//GEN-LAST:event_btn_col_4ActionPerformed

    private void btn_col_5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_col_5ActionPerformed
        // TODO add your handling code here:
        jouerDansColonne(5);
        if(finish==true){
            btn_col_5.setEnabled(false);
        }
        if (grilleJeu.colonneRemplie(5) == true) {
            btn_col_5.setEnabled(false);
        }
        JoueurSuivant();
    }//GEN-LAST:event_btn_col_5ActionPerformed

    private void btn_col_6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_col_6ActionPerformed
        // TODO add your handling code here:
        jouerDansColonne(6);
        if(finish==true){
            btn_col_6.setEnabled(false);
        }
        if (grilleJeu.colonneRemplie(6) == true) {
            btn_col_6.setEnabled(false);
        }
        JoueurSuivant();
    }//GEN-LAST:event_btn_col_6ActionPerformed

    public boolean jouerDansColonne(int indice_col) {
        
        boolean resultatAction;

        resultatAction = grilleJeu.ajouterJetonDansColonne(joueurCourant, indice_col);
        panneau_grille.repaint();
        lbl_j1_desint.setText(ListeJoueurs[0].nombreDesintegrateurs + "");
        lbl_j2_desint.setText(ListeJoueurs[1].nombreDesintegrateurs + "");

        boolean vict_j1 = grilleJeu.etreGagnantePourJoueur(ListeJoueurs[0]);
        boolean vict_j2 = grilleJeu.etreGagnantePourJoueur(ListeJoueurs[1]);

        if (vict_j1 && !vict_j2) {
            textemessage.setText("Victoire de " + ListeJoueurs[0].Nom);
            panneau_grille.setVisible(false);
            lbl_gameover.setVisible(true);
            finish=true;
        }
        if (vict_j2 && !vict_j1) {
            textemessage.setText("Victoire de " + ListeJoueurs[1].Nom);
            panneau_grille.setVisible(false);
            lbl_gameover.setVisible(true);
            finish=true;
        }

        if (vict_j1 && vict_j2) {
            if (joueurCourant == ListeJoueurs[0]) {
                textemessage.setText("Victoire de " + ListeJoueurs[1].Nom + " (faute de jeu de l'autre joueur)");
                panneau_grille.setVisible(false);
                lbl_gameover.setVisible(true);
                finish=true;
            } else {
                textemessage.setText("Victoire de " + ListeJoueurs[0].Nom + " (faute de jeu de l'autre joueur)");
                panneau_grille.setVisible(false);
                lbl_gameover.setVisible(true);
                finish=true;
            }
        }
        if (resultatAction == true) {
            return true;
        } else {
            return false;
        }

    }

    public void JoueurSuivant() {
        if (joueurCourant == ListeJoueurs[0]) {
            joueurCourant = ListeJoueurs[1];
        } else {
            joueurCourant = ListeJoueurs[0];
        }
        lbl_jcourant.setText(joueurCourant.Nom);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(fenetreDeJeu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(fenetreDeJeu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(fenetreDeJeu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(fenetreDeJeu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new fenetreDeJeu().setVisible(true);
            }
        });
    }

    public void initialiserPartie() {

        //affectation des noms aux joueurs
        String nomJoueur1 = nom_joueur_1.getText();
        Joueur joueur1 = new Joueur(nomJoueur1);

        String nomJoueur2 = nom_joueur_2.getText();
        Joueur joueur2 = new Joueur(nomJoueur2);

        //affectations des joueurs 1 & 2 au tableau de joueurs
        ListeJoueurs[0] = joueur1;
        ListeJoueurs[1] = joueur2;

        //attribution des couleurs aux joueurs
        attribuerCouleursAuxJoueurs();
        System.out.println(joueur1.Nom + " possède les jetons de couleur " + joueur1.Couleur);
        System.out.println(joueur2.Nom + " possède les jetons de couleur " + joueur2.Couleur);

        lbl_j1_nom.setText(nomJoueur1);
        lbl_j2_nom.setText(nomJoueur2);
        lbl_j1_couleur.setText(joueur1.Couleur);
        lbl_j2_couleur.setText(joueur2.Couleur);
        lbl_j1_desint.setText(joueur1.nombreDesintegrateurs + "");
        lbl_j2_desint.setText(joueur2.nombreDesintegrateurs + "");

        //creation des jetons & attribution des jetons correpondants aux joueurs
        for (int i = 0; i < 20; i++) {
            Jeton unJeton1 = new Jeton(joueur1.Couleur); //creation jetons joueur1
            joueur1.ajouterJeton(unJeton1);
            Jeton unJeton2 = new Jeton(joueur2.Couleur); //creation jetons joueur2
            joueur2.ajouterJeton(unJeton2);
        }

        //Définition aléatoire du joueur qui commence à jouer
        Random rand = new Random(); // définition aléatoire du joueur qui commence à jouer
        boolean premier;
        premier = rand.nextBoolean(); //affectation aléatoire du premier joueur
        if (premier == true) {
            System.out.println(joueur1.Nom + " commence à jouer. ");
            joueurCourant = joueur1; //affectation du joueur courant
        } else {
            System.out.println(joueur2.Nom + " commence à jouer. ");
            joueurCourant = joueur2; //affectation du joueur courant
        }
        lbl_jcourant.setText(joueurCourant.Nom);

        //placement des trous noirs (v.2)(aléatoire)
        Random obj = new Random();
        for (int a = 0; a < 5; a++) {
            int ligne = obj.nextInt(5);
            int col = obj.nextInt(6);
            while (grilleJeu.placerTrouNoir(ligne,col)==false){
                ligne=obj.nextInt(5);
                col=obj.nextInt(6);
            }
            grilleJeu.placerTrouNoir(ligne,col);
            if (a == 0 || a == 1) {
                grilleJeu.placerDesintegrateur(ligne, col);
            }
        }

        //placement des désintégrateurs (v.3)
        Random obj2 = new Random();
        for (int a = 0; a < 3; a++) {
            int ligne = obj2.nextInt(5);
            int col = obj2.nextInt(6);
            while (grilleJeu.placerDesintegrateur(ligne, col) == false) {
                ligne = obj2.nextInt(5);
                col = obj2.nextInt(6);
            }
            grilleJeu.placerDesintegrateur(ligne, col);

        }
        //on supprime l'affichage de la grille sur console
    }

    public void attribuerCouleursAuxJoueurs() {
        //creation tableau contenant les deux couleurs
        String uneCouleur[] = new String[2];
        uneCouleur[0] = "Jaune";
        uneCouleur[1] = "Rouge";
        //Tirage aléatoire d'une couleur de jeton
        Random rand = new Random();
        int i = rand.nextInt(2);
        ListeJoueurs[0].Couleur = uneCouleur[i]; //on attribue cette 1ere couleur aléatoire au joueur1
        int a;
        if (i == 0) {
            a = 1;
        } else {
            a = 0;
        }
        ListeJoueurs[1].Couleur = uneCouleur[a]; //on attribu l'autre couleur au joueur2
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_col_0;
    private javax.swing.JButton btn_col_1;
    private javax.swing.JButton btn_col_2;
    private javax.swing.JButton btn_col_3;
    private javax.swing.JButton btn_col_4;
    private javax.swing.JButton btn_col_5;
    private javax.swing.JButton btn_col_6;
    private javax.swing.JButton btn_start;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lbl_gameover;
    private javax.swing.JLabel lbl_j1_couleur;
    private javax.swing.JLabel lbl_j1_desint;
    private javax.swing.JLabel lbl_j1_nom;
    private javax.swing.JLabel lbl_j2_couleur;
    private javax.swing.JLabel lbl_j2_desint;
    private javax.swing.JLabel lbl_j2_nom;
    private javax.swing.JLabel lbl_jcourant;
    private javax.swing.JLabel lbl_welcome;
    private javax.swing.JTextField nom_joueur_1;
    private javax.swing.JTextField nom_joueur_2;
    private javax.swing.JPanel panneau_creation_partie;
    private javax.swing.JPanel panneau_grille;
    private javax.swing.JPanel panneau_info_joueur;
    private javax.swing.JPanel panneau_info_partie;
    private javax.swing.JTextArea textemessage;
    private javax.swing.JLabel titleSP5;
    // End of variables declaration//GEN-END:variables
}
