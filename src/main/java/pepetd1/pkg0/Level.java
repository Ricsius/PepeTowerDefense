/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pepetd1.pkg0;

import java.awt.Graphics;
import java.awt.Image;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.ImageIcon;

/**
 *
 * @author Hege
 */
public class Level {
    private final int LINE_WIDTH = 50;
    private final int LINE_HEIGHT = 50;
    private final int SPS_WIDTH = 80;
    private final int SPS_HEIGHT = 40;
    private final int TOWER_WIDTH = 80;
    private final int TOWER_HEIGHT = 120;
    private final int PEPE_WIDTH = 50;
    private final int PEPE_HEIGHT = 50;
    private MenuPanel menu;
    private final int TOWER_COST = 130;
    private final int BTOWER_COST = 50;
    private final int FTOWER_COST = 130;
    private final int ITOWER_COST = 100;
    private final int TTOWER_COST = 150;
    
    int playerMoney;
    
    ArrayList<Line> lineBlocks;
    ArrayList<StructurePlacementSpot> structurePlacementSpots;
    ArrayList<Tower> towers;
    private boolean isTowerBuilt;
    //StructurePlacementSpot trash;
    ArrayList<Pepe> pepes;
    ArrayList<TowerBullet> towerBullets;
    
    ArrayList<Integer> movementY;
    ArrayList<Integer> movementX;
    
    /**
     * Konstruktor
     * @param levelPath
     * @throws IOException 
     */
    public Level(String levelPath, String levelPath2, String levelPath3) throws IOException {
        loadLevel(levelPath);
        loadPepeMovement(levelPath3);
        loadPepes(levelPath2);
        playerMoney = 350;
        this.isTowerBuilt = false;
        this.towerBullets = new ArrayList<TowerBullet>();
        this.menu = null;
    }
    
    public boolean getIsTowerBuilt(){
        return this.isTowerBuilt;
    }
    
    public void setIsTowerBuilt(boolean newBoolean){
        this.isTowerBuilt = newBoolean;
    }
    
   /*public void follow(){
        for(int i = 0; i < towerBullets.size(); i++){
            towerBullets.get(i).followTarget();
            if(towerBullets.get(i).meet(towerBullets.get(i).getTarget())){
                towerBullets.get(i).getTarget().takeDamage(towerBullets.get(i).getDamage());
                towerBullets.remove(i);
            }
        }
        //for(TowerBullet towerBullet : towerBullets){
            //towerBullet.followTarget();
            //if(towerBullet.meet(towerBullet.getTarget())){
            //    towerBullets.remove(this);
            //}
        //}
        
    }  */ 
    
    public void towerShoot(){
        for(Tower tower : towers){
            TowerBullet tmp = tower.shoot();
            if(tmp != null){
                towerBullets.add(tmp);
            }
        }
    }
    
    public void inRange(Pepe target){
        for(Tower tower : towers){
                if(tower.meet(target)){            
                    if(target.isAlive()){
                        if(!tower.targetQueue.contains(target)){
                            tower.targetQueue.add(target);
                            System.out.println("Pepe added");
                        }    
                    }else{
                        if(tower.targetQueue.contains(target)){
                            tower.targetQueue.remove(target);
                            //this.addMoney(target.getMoneyReward());
                            System.out.println(this.playerMoney);
                            //System.out.println("Pepe removed");
                        }
                    }
                }else{
                    if(tower.targetQueue.contains(target)){
                        tower.targetQueue.remove(target);
                        //System.out.println("Pepe removed");
                    }
                }
        }
    }
    /**
     * Betölti a pályát
     * @param levelPath
     * @throws FileNotFoundException
     * @throws IOException 
     */
    public void loadLevel(String levelPath) throws FileNotFoundException, IOException {
        BufferedReader br = new BufferedReader(new FileReader(levelPath));
        lineBlocks = new ArrayList<>();
        structurePlacementSpots = new ArrayList<>();
        towers = new ArrayList<>();
        //trash = null;

        int y = 0;
        String line;
        while ((line = br.readLine()) != null) {
            int x = 0;
            for (char type : line.toCharArray()) {
                if (Character.isDigit(type)) {
                    
                    if(type == '1'){
                        Image image = new ImageIcon("data/line.png").getImage();
                        lineBlocks.add(new Line(x * LINE_WIDTH, y * LINE_HEIGHT, LINE_WIDTH, LINE_HEIGHT, image));
                    }
                    if(type == '2'){
                        Image image = new ImageIcon("data/tower-base.png").getImage();
                        structurePlacementSpots.add(new StructurePlacementSpot(x * SPS_WIDTH, y * SPS_HEIGHT, image));
                    }
                }
                x++;
            }
            y++;
        }
    }
    
    public void loadPepeMovement(String levelPath)throws FileNotFoundException, IOException {
        BufferedReader br = new BufferedReader(new FileReader(levelPath));
        int size = 0;
        String line;
        movementY = new ArrayList<Integer>();
        movementX = new ArrayList<Integer>();
        
        while ((line = br.readLine()) != null) {
            String[] tmp = line.split(" ");
            movementY.add(Integer.parseInt(tmp[0]));
            movementX.add(Integer.parseInt(tmp[1]));
            size++;
        }
        
        for(int k = 0; k < size; k++){
            System.out.print(movementY.get(k));
            System.out.print(" ");
            System.out.print(movementX.get(k));
            System.out.print('\n');
        }
    }
    

    public void loadPepes(String levelPath) throws FileNotFoundException, IOException {
        BufferedReader br = new BufferedReader(new FileReader(levelPath));
        pepes = new ArrayList<Pepe>();
        int current_height = -150;
        int x = 700;
        //int y = 0;
        String line;
        while ((line = br.readLine()) != null) {
            //int x = 0;
            for (char type : line.toCharArray()) {
                System.out.println(type);
                if(type == 'n'){
                    Image image = new ImageIcon("data/basic.png").getImage();
                    NakedPepe nakedPepe = new NakedPepe(x, current_height, PEPE_WIDTH, PEPE_HEIGHT, image);
                    nakedPepe.updatePic("data/basicPepe2.png", 70, 90);
                    pepes.add(nakedPepe);
                    current_height -= PEPE_HEIGHT * 3 / 2;
                    
                }
                if(type == 't'){
                    Image image = new ImageIcon("data/tank.png").getImage();
                    TankPepe tankPepe = new TankPepe(x, current_height, PEPE_WIDTH, PEPE_HEIGHT, image);
                    pepes.add(tankPepe);
                    current_height -= PEPE_HEIGHT * 3 / 2;;
                }
                if(type == 'w'){
                    Image image = new ImageIcon("data/wizard.png").getImage();
                    WizardPepe wizardPepe = new WizardPepe(x, current_height, PEPE_WIDTH, PEPE_HEIGHT, image);
                    pepes.add(wizardPepe);
                    current_height -= PEPE_HEIGHT * 3 / 2;;
                }
                if(type == 's'){
                    Image image = new ImageIcon("data/sonicpepe.png").getImage();
                    SonicPepe sonicPepe = new SonicPepe(x, current_height, PEPE_WIDTH, PEPE_HEIGHT, image);
                    pepes.add(sonicPepe);
                    current_height -= PEPE_HEIGHT * 3 / 2;;
                }
                if(type == 'r'){
                    Image image = new ImageIcon("data/ricardo.png").getImage();
                    RicardoPepe ricardoPepe = new RicardoPepe(x, current_height, PEPE_WIDTH, PEPE_HEIGHT, image);
                    pepes.add(ricardoPepe);
                    current_height -= PEPE_HEIGHT * 3 / 2;;
                }
                //x++;
            }
            //y++;
            
        }
        setPepePath(movementX, movementY);
    }
        
    public void setPepePath(ArrayList<Integer> movementX, ArrayList<Integer> movementY){
        for(Pepe pepe : pepes){
            pepe.setMovements(movementX, movementY); 
        }
    }
    
    
    /**
     * Kirajzolja a Basket, Ranger, Obstacle tömböt a pályára
     * @param g 
     */
    public void draw(Graphics g) {
        for(Line lineBlock : lineBlocks) {
            lineBlock.draw(g);
        }
        for(StructurePlacementSpot structurePlacementSpot : structurePlacementSpots){
            structurePlacementSpot.draw(g);
        }
        for(Tower tower : towers){
            tower.draw(g);
        }
        if(!towerBullets.isEmpty()){
            for(TowerBullet towerBullet : towerBullets){
                towerBullet.draw(g);
            }
        }
        
        /*for(int i=0; i<nakedPepes.size(); i++){
            if(nakedPepes.get(i).isAlive()){
                nakedPepes.get(i).draw(g);
            }else{
                nakedPepes.remove(i);
            }
        }*/
        
        for(Pepe pepe : pepes){
            if(pepe.isAlive()){
                pepe.draw(g);
            }
        }
        
    }
    
    public StructurePlacementSpot clickedInPlacementSpot(int x, int y, int cost){ //MŰKÖDIK, CSAK NEM REPAINTEL
        StructurePlacementSpot tempSpot = null;
        boolean ret = false;
        
        if(this.playerMoney >= cost){ //megnézi itt is, hogy van-e elég pénz :))))) ez tuti meg kell jobban oldani
            for (int i = 0; i < structurePlacementSpots.size(); i++)
            {
                if(structurePlacementSpots.get(i).inside(x, y)){
                    tempSpot = structurePlacementSpots.get(i);
                    //return spot;
                    structurePlacementSpots.remove(tempSpot);
                    ret = true;  
                }
            }
        }
        System.out.println(ret);
        return tempSpot;
    }
    
    public Tower clickedInTower(int x, int y){ //MŰKÖDIK, CSAK NEM REPAINTEL
        Tower tempTower = null;
        boolean ret = false;
        
        for (int i = 0; i < towers.size(); i++)
        {
            if(towers.get(i).inside(x, y) && playerMoney >= 100){
                tempTower = towers.get(i);
                //return spot;
                //towers.remove(tempTower);
                ret = true;  
            }
        }
        System.out.println(ret);
        return tempTower;
    }
    
    
    //ezeket meg lehet oldani sokkal szebben
    //az enumokkal például, és akkor elég egy createTower(toronyEnum)
    /*public Tower createTower(int x, int y){
        Image image = new ImageIcon("data/tower.png").getImage();
        Tower t = new Tower(x, y, TOWER_WIDTH, TOWER_HEIGHT, image, 0, 1);
        setIsTowerBuilt(true);
        towers.add(t);
        return t;
    }*/
    
    public Tower createIceTower(int x, int y){
            Image image = new ImageIcon("data/towerIce.png").getImage();
            IceTower t = new IceTower(x, y, image);
            setIsTowerBuilt(true);
            towers.add(t);
            //this.playerMoney = playerMoney - TOWER_COST;
            return t;   
    }
    
    public Tower createFireTower(int x, int y){
            Image image = new ImageIcon("data/towerFire.png").getImage();
            FireTower t = new FireTower(x, y, image);
            setIsTowerBuilt(true);
            towers.add(t);
            //this.playerMoney = playerMoney - TOWER_COST;
            return t;   
    }
    
    public Tower createBallistaTower(int x, int y){
            Image image = new ImageIcon("data/towerBallista.png").getImage();
            BallistaTower t;
            t = new BallistaTower(x, y, image);
            setIsTowerBuilt(true);
            towers.add(t);
            //this.playerMoney = playerMoney - TOWER_COST;
            return t;   
    }
    
    public Tower createTeslaTower(int x, int y){
            Image image = new ImageIcon("data/towerTesla.png").getImage();
            TeslaTower t = new TeslaTower(x, y, image);
            setIsTowerBuilt(true);
            towers.add(t);
            //this.playerMoney = playerMoney - TOWER_COST;
            return t;   
    }
    
    public StructurePlacementSpot deleteTower(Tower t){
        //
            towers.remove(t);
        //
        Image image = new ImageIcon("data/tower-base.png").getImage();
        StructurePlacementSpot s;
        s = new StructurePlacementSpot(t.getX(), t.getY()+80, image);
        setIsTowerBuilt(false);
        structurePlacementSpots.add(s);
        //this.playerMoney = playerMoney + TOWER_COST/2;
        return s;
    }
    
    public int getMoney(){
        return this.playerMoney;
    }
    
    public void cutMoney(int m){
        this.playerMoney -= m;
    }
    
    public void addMoney(int m){
        this.playerMoney += m;
    }
    
    //tesztelshez kellenek
    
    public ArrayList getTowers() {
    	return this.towers;
    }
    
    public ArrayList getPepes() {
    	return this.pepes;
    }
    
    public ArrayList getBullets() {
    	return this.towerBullets;
    }
    
    public ArrayList getSpots() {
    	return this.structurePlacementSpots;
    }
}
