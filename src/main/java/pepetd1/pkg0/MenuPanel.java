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

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.Border;

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
    private JButton wave;
    private JLabel gold;
    private JLabel infTower;
    private JLabel asd;
    private JTextArea infoGold;
    private JTextArea infoTower;

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
        infoGold = new JTextArea(0,0);
        JScrollPane scrollPane = new JScrollPane( infoGold );
        scrollPane.setBackground(new Color(129,86,29));
        infoGold.setEditable(false);
        //infoGold.setLineWrap(true);
        infoTower = new JTextArea();
        infoTower.setEditable(false);
        infoTower.setPreferredSize(new Dimension(20,20));
        
        Border blackline;
    	blackline = BorderFactory.createLineBorder(Color.black);
    	
        Font fieldFont = new Font("Arial", Font.BOLD, 20);
        Font fieldFont2 = new Font("Arial", Font.BOLD, 15);
        infoGold.setFont(fieldFont);
        infoGold.setBackground(new Color(129,86,29));
        Border infoGoldborder =  BorderFactory.createLineBorder(new Color(129,86,29));
        infoGold.setBorder(infoGoldborder);
        scrollPane.setBorder(infoGoldborder);
        
        infTower.setFont(fieldFont2);
        infoTower.setBackground(Color.LIGHT_GRAY);
        
        ballistaButton = new JButton();
        fireButton = new JButton("Fire");
        iceButton = new JButton("Ice");
        teslaButton = new JButton("Tesla");
        delete = new JButton("DELETE");
        upgrade = new JButton("UPGRADE");
        wave = new JButton("WAVE");
        

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
        
        wave.setBackground(new Color(0, 190, 0));
        wave.setMargin(new Insets(0, 0, 0, 0));
        wave.setForeground(Color.WHITE);
        wave.setFocusPainted(false);
        wave.setFont(new Font("Verdana", Font.BOLD, 12));
        wave.setEnabled(false);
  
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
            wave.setEnabled(true);
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
            wave.setEnabled(true);
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
            wave.setEnabled(true);
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
            wave.setEnabled(true);
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
            wave.setEnabled(true);
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
            wave.setEnabled(true);
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
            upgrade.setEnabled(true);
            wave.setEnabled(false);
        }
    });
 
    	

    
	    JLabel infBallista = new JLabel(("<html><b>Cost: 130</b><br> <br><b>Upgrade cost: 50</b></html>"));
	    infBallista.setPreferredSize(new Dimension(100,100));
	    JLabel infFire =new JLabel(("<html><b>Cost: 130</b><br><br><b>Upgrade cost: 50</b></html>"));
	    JLabel infIce = new JLabel(("<html><b>Cost: 130</b><br><br><b>Upgrade cost: 50</b></html>"));
	    JLabel infTesla = new JLabel(("<html><b>Cost: 130</b><br><br><b>Upgrade cost: 50</b></html>"));
    
        Box box = Box.createVerticalBox(); // vertical box
        JLabel Empty = new JLabel("");
        Box boxB = Box.createHorizontalBox();
        Box boxF = Box.createHorizontalBox();
        Box boxI = Box.createHorizontalBox();
        Box boxT = Box.createHorizontalBox();
        Box boxBut = Box.createHorizontalBox();
        Box boxGold = Box.createHorizontalBox();
        Box boxinfoG = Box.createHorizontalBox();
        Box boxinfoT = Box.createHorizontalBox();
        Box boxinfT = Box.createHorizontalBox();
        
        boxB.setBorder(blackline);
        boxF.setBorder(blackline);
        boxI.setBorder(blackline);
        boxT.setBorder(blackline);

        box.add(boxB);
        box.add(Box.createRigidArea(new Dimension(0, 5)));
        box.add(boxF);
        box.add(Box.createRigidArea(new Dimension(0, 5)));
        box.add(boxI);
        box.add(Box.createRigidArea(new Dimension(0, 5)));
        box.add(boxT);
        box.add(Box.createRigidArea(new Dimension(0, 5)));
        box.add(boxBut);
        box.add(Box.createRigidArea(new Dimension(0, 5)));
        box.add(boxGold);
        box.add(boxinfoG);
        box.add(boxinfT);
        box.add(boxinfoT);
        
        boxB.add(ballistaButton);
        boxB.add(infBallista);
        
        boxF.add(fireButton);
        boxF.add(infFire);
        
        boxI.add(iceButton);
        boxI.add(infIce);
        
        boxT.add(teslaButton);
        boxT.add(infTesla);
        
        boxBut.add(delete);
        boxBut.add(upgrade);
        boxBut.add(wave);
        
        
        boxGold.add(scrollPane);
        boxGold.add(gold);
        boxGold.add(Box.createHorizontalGlue());
        
        //boxinfoG.add(infoGold);  
        //boxinfoG.add(Box.createHorizontalGlue());
        
        boxinfT.add(infTower);
        boxinfT.add(Box.createHorizontalGlue());
        boxinfoT.add(infoTower);
        boxinfoT.add(Box.createHorizontalGlue());
        

        
        super.add(box);
    }
    
    public void setGold(int g){
        this.infoGold.setText(Integer.toString(g));
    }
}
