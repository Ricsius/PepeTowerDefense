/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pepetd1.pkg0;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

/**
 *
 * @author Andras
 */
public class MenuPanel extends JPanel{
    
    private JButton ballistaButton;
    private JButton fireButton;
    private JButton iceButton;
    private JButton teslaButton;
    private JButton delete;
    private JButton upgrade;
    private JLabel gold;
    private JLabel infTower;
    private JLabel asd;
    private JTextField infoGold;
    private JTextField infoTower;

    private GameEngine engine;
    
    public MenuPanel(GameEngine gameEngine){
        super();
        
        this.setLayout(new GridBagLayout());
        

        this.engine = gameEngine;
        this.setBackground(new Color(129, 86, 29));
        ImageIcon goldImage = new ImageIcon("data/gold.png");
        gold = new JLabel(goldImage);
        infTower = new JLabel("Information: ");
        asd = new JLabel(" ");
        infoGold = new JTextField(1);
        infoGold.setEditable(false);
        infoGold.setPreferredSize(new Dimension(1,20));
        infoTower = new JTextField(3);
        infoTower.setEditable(false);
        infoTower.setPreferredSize(new Dimension(1,20));
        
        ballistaButton = new JButton();
        fireButton = new JButton("Fire");
        iceButton = new JButton("Ice");
        teslaButton = new JButton("Tesla");
        delete = new JButton("DELETE");
        upgrade = new JButton("UPGRADE");
        

        Image ballistaImage = new ImageIcon("data/ballista.png").getImage();
        ballistaButton.setIcon(new ImageIcon(ballistaImage));
        ballistaButton.setText("Ballista");
        ballistaButton.setVerticalTextPosition(SwingConstants.BOTTOM);
        ballistaButton.setHorizontalTextPosition(SwingConstants.CENTER);
        ballistaButton.setMargin(new Insets(0, 0, 0, 0));
        ballistaButton.setBackground(new Color(129, 86, 29));
        ballistaButton.setForeground(Color.WHITE);
        ballistaButton.setFocusPainted(false);
        ballistaButton.setFont(new Font("Courier", Font.BOLD, 12));
        
        Image fireImage = new ImageIcon("data/fire.png").getImage();
        fireButton.setIcon(new ImageIcon(fireImage));
        fireButton.setText("Fire");
        fireButton.setVerticalTextPosition(SwingConstants.BOTTOM);
        fireButton.setHorizontalTextPosition(SwingConstants.CENTER);
        fireButton.setMargin(new Insets(0, 0, 0, 0));
        fireButton.setBackground(new Color(129, 86, 29));
        fireButton.setForeground(Color.WHITE);
        fireButton.setFocusPainted(false);
        fireButton.setFont(new Font("Courier", Font.BOLD, 12));
                
        Image iceImage = new ImageIcon("data/ice.png").getImage();
        iceButton.setIcon(new ImageIcon(iceImage));
        iceButton.setText("Ice");
        iceButton.setVerticalTextPosition(SwingConstants.BOTTOM);
        iceButton.setHorizontalTextPosition(SwingConstants.CENTER);
        iceButton.setMargin(new Insets(0, 0, 0, 0));
        iceButton.setBackground(new Color(129, 86, 29));
        iceButton.setForeground(Color.WHITE);
        iceButton.setFocusPainted(false);
        iceButton.setFont(new Font("Courier", Font.BOLD, 12));
        
                
        Image teslaImage = new ImageIcon("data/tesla.png").getImage();
        teslaButton.setIcon(new ImageIcon(teslaImage));
        teslaButton.setText("Tesla");
        teslaButton.setVerticalTextPosition(SwingConstants.BOTTOM);
        teslaButton.setHorizontalTextPosition(SwingConstants.CENTER);
        teslaButton.setMargin(new Insets(0, 0, 0, 0));
        teslaButton.setBackground(new Color(129, 86, 29));
        teslaButton.setForeground(Color.WHITE);
        teslaButton.setFocusPainted(false);
        teslaButton.setFont(new Font("Courier", Font.BOLD, 12));
        
        delete.setBackground(new Color(204, 0, 0));
        delete.setMargin(new Insets(0, 0, 0, 0));
        delete.setForeground(Color.WHITE);
        delete.setFocusPainted(false);
        delete.setFont(new Font("Verdana", Font.BOLD, 12));
        delete.setEnabled(false);
        
        upgrade.setBackground(new Color(0, 0, 204));
        upgrade.setMargin(new Insets(0, 0, 0, 0));
        upgrade.setForeground(Color.WHITE);
        upgrade.setFocusPainted(false);
        upgrade.setFont(new Font("Verdana", Font.BOLD, 12));
        upgrade.setEnabled(false);
  
    ballistaButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            engine.setBallista();
            ballistaButton.setEnabled(false);
            
            fireButton.setEnabled(true);
            iceButton.setEnabled(true);
            teslaButton.setEnabled(true);
            delete.setEnabled(true);
            upgrade.setEnabled(true);
        }
    });
    
    fireButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            engine.setFire();
            ballistaButton.setEnabled(true);
            fireButton.setEnabled(false);
            iceButton.setEnabled(true);
            teslaButton.setEnabled(true);
            delete.setEnabled(true);
            upgrade.setEnabled(true);
        }
    });
    
    iceButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            engine.setIce();
            ballistaButton.setEnabled(true);
            fireButton.setEnabled(true);
            iceButton.setEnabled(false);
            teslaButton.setEnabled(true);
            delete.setEnabled(true);
            upgrade.setEnabled(true);
        }
    });
    
    teslaButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            engine.setTesla();
            ballistaButton.setEnabled(true);
            fireButton.setEnabled(true);
            iceButton.setEnabled(true);
            teslaButton.setEnabled(false);
            delete.setEnabled(true);
            upgrade.setEnabled(true);
        }
    });
    
    delete.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            engine.setDelete();
            ballistaButton.setEnabled(true);
            fireButton.setEnabled(true);
            iceButton.setEnabled(true);
            teslaButton.setEnabled(true);
            delete.setEnabled(false);
            upgrade.setEnabled(true);
        }
    });
        
    upgrade.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            engine.setUpgrade();
            ballistaButton.setEnabled(true);
            fireButton.setEnabled(true);
            iceButton.setEnabled(true);
            teslaButton.setEnabled(true);
            delete.setEnabled(true);
            upgrade.setEnabled(false);
        }
    });
    
        /*super.add(ballistaButton);
        super.add(fireButton);
        super.add(iceButton);
        super.add(teslaButton);
        super.add(delete);
        super.add(upgrade);
        super.add(gold);
        super.add(infoGold);
        super.add(asd);*/

        //this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        Box box = Box.createVerticalBox();   // vertical box
        box.add(ballistaButton);
        box.add(fireButton);
        box.add(iceButton);
        box.add(teslaButton);
        box.add(delete);
        box.add(upgrade);
        box.add(gold);
        box.add(infoGold);
        box.add(infTower);
        box.add(infoTower);
        super.add(box);
    }
    
    public void setGold(int g){
        this.infoGold.setText(Integer.toString(g));
    }
}
