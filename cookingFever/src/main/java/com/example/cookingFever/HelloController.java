package com.example.cookingFever;

import javafx.animation.AnimationTimer;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javax.swing.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Iterator;

public class HelloController {

    @FXML
    private ImageView logoIMG, level1, level2, level3, level4, level5, star1, star2, star3,
            level1star1, level1star2, level1star3, level2star1, level2star2, level2star3, level3star1, level3star2, level3star3, level4star1, level4star2, level4star3, level5star1, level5star2, level5star3;

    @FXML
    private AnchorPane levelscreen, ruleScreen, startscreen, level1Screen, upgradeScreen, menu1, menu2, menu3, menu4, menu5, endScreen;

    @FXML
    private ListView ordersList, currentOrderList;

    @FXML
    private Button bunButton, pattyButton, tomatoButton, lettuceButton, sausageButton, hotdogbunButton, cupcakeButton, frenchfryButton, colaButton,
            level1Button, level2Button, level3Button, level4Button, level5Button, nextButton, playAgainButton,
            tomatoUpgradeB, lettuceUpgradeB, fryUpgradeB, bunUpgradeB, pattyUpgradeB, furnitureUpgradeB, TVupgradeB, multiplierUpgradeB;

    @FXML
    FileInputStream b;

    @FXML
    Image blue;

    @FXML
    Label bunCooking, bunReady, bunNone, pattyCooking, pattyReady, pattyNone, tomatoCooking, tomatoReady, tomatoNone, lettuceCooking, lettuceReady, lettuceNone, sausageCooking, sausageReady, sausageNone, hotdogbunCooking, hotdogbunReady, hotdogbunNone, friesCooking, friesReady, friesNone, colaCooking, colaReady, colaNone, cupcakeCooking, cupcakeReady, cupcakeNone,
            lostC, servedC, levelLabel, profitLabel, servedLabel, lostLabel, levelFailed, balanceLabel, tipLabel, totalLabel, noMoneyLabel, playLevelLabel;

    @FXML
    Button colaAdd, frenchfryAdd, cupcakeAdd, hotdogbunAdd, sausageAdd, bunAdd, pattyAdd, tomatoAdd, lettuceAdd;

    private boolean playedLevel1, playedLevel2, playedLevel3, playedLevel4, playedLevel5;
    private int currentLevel, count;
    private int customersLost = 0;
    private int customersServed = 0;
    private double totalMoney = 1000;
    private double levelMoney = 0;
    private double levelProfit = 0;
    private double levelTips = 0;
    private double multiplier = 1.0;
    private int tomatoUpgrade = 0;
    private int lettuceUpgrade = 0;
    private int bunUpgrade = 0;
    private int pattyUpgrade = 0;
    private int fryUpgrade = 0;
    private double customerWaitF = 0;
    private double customerWaitTV = 0;
    private int multiplierprice = 600;
    private int fryUpgradeprice = 200;
    private int tomatoUpgradeprice = 250;
    private int lettuceUpgradeprice = 250;
    private int bunUpgradeprice = 300;
    private int pattyUpgradeprice = 400;
    private int customerWaitFprice = 500;
    private int customerWaitTVprice = 1000;
    private long level1Time = -1, level2Time = -1, level3Time = -1, level4Time = -1, level5Time = -1, pattyTime = -1, tomatoTime = -1, lettuceTime = -1, colaTime = -1, hotdogTime = -1, hotdogbunTime = -1, bunsTime = -1, friesTime = -1, cupcakeTime = -1, n;
    ArrayList <Combos> menuCombos = new ArrayList();
    ArrayList <Combos> currentOrders = new ArrayList();
    ArrayList <String> currentPlate = new ArrayList();
    Combos plate = new Combos(false, false, false, false, false, false, false, false, false);

    @FXML
    protected void setBackground() {
        try {
            b = new FileInputStream("src/main/resources/pics/blue.jpg");

            blue = new Image(b);
        }
        catch(FileNotFoundException e) {
            e.printStackTrace();
        }

        ordersList.setCellFactory(param -> new ListCell<Combos>() {
            @Override
            protected void updateItem(Combos item, boolean empty) {
                super.updateItem(item, empty);

                if (empty || item == null || item.returnOrder() == null) {
                    setText(null);
                } else {
                    setText(item.returnOrder());
                }
            }
        });
        ordersList.setStyle("-fx-font-size: 14px; -fx-font-family: 'SketchFlow Print'; -fx-control-inner-background: e3d3dc;");

        currentOrderList.setCellFactory(param -> new ListCell<String>() {
            @Override
            protected void updateItem(String item, boolean empty) {
                super.updateItem(item, empty);

                if (empty || item == null || item == null) {
                    setText(null);
                } else {
                    setText(item);
                }
            }
        });

        //level 1 orders
        menuCombos.add(new Combos(true, true, false, false, false, false, false, false, false));
        menuCombos.add(new Combos(true, true, false, false, false, false, true, false, false));
        menuCombos.add(new Combos(false, false, false, false, false, false, false, true, false));
        menuCombos.add(new Combos(false, false, false, false, false, false, true, true, false));
        menuCombos.add(new Combos(false, false, false, false, false, false, true, false, false));

        //level 2 orders
        menuCombos.add(new Combos(true, true, true, false, false, false, true, false, false));
        menuCombos.add(new Combos(true, true, false, false, false, false, true, true, false));
        menuCombos.add(new Combos(true, true, true, false, false, false, false, true, false));
        menuCombos.add(new Combos(true, true, false, false, false, false, false, true, false));
        menuCombos.add(new Combos(true, true, true, false, false, false, false, false, false));

        //level 3 orders
        menuCombos.add(new Combos(true, true, true, true, false, false, false, false, false));
        menuCombos.add(new Combos(true, true, true, true, false, false, false, true, false));
        menuCombos.add(new Combos(true, true, false, true, false, false, true, false, false));
        menuCombos.add(new Combos(true, true, true, true, false, false, true, true, false));
        menuCombos.add(new Combos(true, true, true, false, false, false, true, true, false));

        //level 4 orders
        menuCombos.add(new Combos(true, true, false, false, true, true, false, false, false));
        menuCombos.add(new Combos(true, true, true, false, true, true, true, false, false));
        menuCombos.add(new Combos(false, false, false, false, true, true, false, true, false));
        menuCombos.add(new Combos(true, true, true, true, false, false, true, false, false));
        menuCombos.add(new Combos(false, false, false, false, true, true, false, false, false));

        //level 5 orders
        menuCombos.add(new Combos(true, true, false, false, false, false, false, false, true));
        menuCombos.add(new Combos(true, true, true, true, false, false, false, true, true));
        menuCombos.add(new Combos(true, true, true, false, true, true, false, true, false));
        menuCombos.add(new Combos(false, false, false, false, true, true, true, false, true));
        menuCombos.add(new Combos(false, false, false, false, false, false, false, true, true));
    }

    @FXML
    protected void startGame() {
        startscreen.setVisible(false);
        levelscreen.setVisible(true);
        level1Screen.setVisible(false);
        ruleScreen.setVisible(false);
        endScreen.setVisible(false);
        upgradeScreen.setVisible(false);
        balanceLabel.setVisible(true);
        noMoneyLabel.setVisible(false);
        changeBalance(0);

        currentLevel = 0;

        clearScreen();
        level1.setImage(blue);
        level2.setImage(blue);
        level3.setImage(blue);
        level4.setImage(blue);
        level5.setImage(blue);
    }

    @FXML
    protected void howtoplay(){
        startscreen.setVisible(false);
        level1Screen.setVisible(false);
        levelscreen.setVisible(false);
        ruleScreen.setVisible(true);
        endScreen.setVisible(false);
        upgradeScreen.setVisible(false);
        noMoneyLabel.setVisible(false);
        changeBalance(0);

        clearScreen();
    }

    @FXML
    protected void mainScreen(){
        startscreen.setVisible(true);
        levelscreen.setVisible(false);
        level1Screen.setVisible(false);
        ruleScreen.setVisible(false);
        endScreen.setVisible(false);
        upgradeScreen.setVisible(false);
        noMoneyLabel.setVisible(false);
        changeBalance(0);

        currentLevel = 0;

        clearScreen();
    }

    @FXML
    protected void upgradeScreen(){
        startscreen.setVisible(false);
        level1Screen.setVisible(false);
        levelscreen.setVisible(false);
        ruleScreen.setVisible(false);
        endScreen.setVisible(false);
        upgradeScreen.setVisible(true);
        balanceLabel.setVisible(true);
        noMoneyLabel.setVisible(false);
        changeBalance(0);

        clearScreen();
    }

    @FXML
    protected void playAgain(){
        endScreen.setVisible(false);

        if(currentLevel == 1){
            startLevel1();
            System.out.println("1");
        }

        else if(currentLevel == 2){
            startLevel2();
            System.out.println("2");
        }

        else if(currentLevel == 3){
            startLevel3();
            System.out.println("3");
        }

        else if(currentLevel == 4){
            startLevel4();
            System.out.println("4");
        }

        else if(currentLevel == 5){
            startLevel5();
            System.out.println("5");
        }
    }

    @FXML
    protected void nextLevel() {
        endScreen.setVisible(false);

        if (currentLevel == 1) {
            startLevel2();
        }

        else if (currentLevel == 2) {
            startLevel3();
        }

        else if (currentLevel == 3) {
            startLevel4();
        }

        else if (currentLevel == 4) {
            startLevel5();
        }
    }

    @FXML
    protected void startLevel1(){
        currentLevel = 1;

        endScreen.setVisible(false);
        level1Screen.setVisible(true);
        balanceLabel.setVisible(true);
        noMoneyLabel.setVisible(false);
        playLevelLabel.setText("Level 1");

        clearScreen();
        menu1.setVisible(true);
        pattyNone.setVisible(true);
        bunNone.setVisible(true);
        colaNone.setVisible(true);
        friesNone.setVisible(true);

        pattyButton.setDisable(false);
        bunButton.setDisable(false);
        tomatoButton.setDisable(true);
        lettuceButton.setDisable(true);
        sausageButton.setDisable(true);
        hotdogbunButton.setDisable(true);
        cupcakeButton.setDisable(true);
        frenchfryButton.setDisable(false);
        colaButton.setDisable(false);

        level1Time = System.nanoTime();
        start();
    }

    @FXML
    public void startLevel2(){
        currentLevel = 2;

        level1Screen.setVisible(true);
        endScreen.setVisible(false);
        balanceLabel.setVisible(true);
        noMoneyLabel.setVisible(false);
        playLevelLabel.setText("Level 2");

        clearScreen();
        menu2.setVisible(true);
        pattyNone.setVisible(true);
        bunNone.setVisible(true);
        colaNone.setVisible(true);
        friesNone.setVisible(true);
        tomatoNone.setVisible(true);

        pattyButton.setDisable(false);
        bunButton.setDisable(false);
        tomatoButton.setDisable(false);
        lettuceButton.setDisable(true);
        sausageButton.setDisable(true);
        hotdogbunButton.setDisable(true);
        cupcakeButton.setDisable(true);
        frenchfryButton.setDisable(false);
        colaButton.setDisable(false);

        level2Time = System.nanoTime();
    }

    @FXML
    protected void startLevel3(){
        if(playedLevel2){
            currentLevel = 3;

            level1Screen.setVisible(true);
            endScreen.setVisible(false);
            balanceLabel.setVisible(true);
            noMoneyLabel.setVisible(false);
            playLevelLabel.setText("Level 3");

            clearScreen();
            menu3.setVisible(true);
            pattyNone.setVisible(true);
            bunNone.setVisible(true);
            colaNone.setVisible(true);
            friesNone.setVisible(true);
            tomatoNone.setVisible(true);
            lettuceNone.setVisible(true);

            pattyButton.setDisable(false);
            bunButton.setDisable(false);
            tomatoButton.setDisable(false);
            lettuceButton.setDisable(false);
            sausageButton.setDisable(true);
            hotdogbunButton.setDisable(true);
            cupcakeButton.setDisable(true);
            frenchfryButton.setDisable(false);
            colaButton.setDisable(false);

            level3Time = System.nanoTime();
        }
    }

    @FXML
    protected void startLevel4(){
        if(playedLevel3){
            currentLevel = 4;

            level1Screen.setVisible(true);
            endScreen.setVisible(false);
            balanceLabel.setVisible(true);
            noMoneyLabel.setVisible(false);
            playLevelLabel.setText("Level 4");

            clearScreen();
            menu4.setVisible(true);
            bunNone.setVisible(true);
            pattyNone.setVisible(true);
            colaNone.setVisible(true);
            hotdogbunNone.setVisible(true);
            sausageNone.setVisible(true);
            friesNone.setVisible(true);
            tomatoNone.setVisible(true);
            lettuceNone.setVisible(true);

            pattyButton.setDisable(false);
            bunButton.setDisable(false);
            tomatoButton.setDisable(false);
            lettuceButton.setDisable(false);
            sausageButton.setDisable(false);
            hotdogbunButton.setDisable(false);
            cupcakeButton.setDisable(true);
            frenchfryButton.setDisable(false);
            colaButton.setDisable(false);

            level4Time = System.nanoTime();
        }
    }

    @FXML
    protected void startLevel5(){
        if(playedLevel4){
            currentLevel = 5;

            endScreen.setVisible(false);
            level1Screen.setVisible(true);
            balanceLabel.setVisible(true);
            noMoneyLabel.setVisible(false);
            playLevelLabel.setText("Level 5");

            clearScreen();
            menu5.setVisible(true);
            pattyNone.setVisible(true);
            bunNone.setVisible(true);
            colaNone.setVisible(true);
            cupcakeNone.setVisible(true);
            hotdogbunNone.setVisible(true);
            sausageNone.setVisible(true);
            friesNone.setVisible(true);
            tomatoNone.setVisible(true);
            lettuceNone.setVisible(true);
            pattyButton.setDisable(false);

            bunButton.setDisable(false);
            tomatoButton.setDisable(false);
            lettuceButton.setDisable(false);
            sausageButton.setDisable(false);
            hotdogbunButton.setDisable(false);
            cupcakeButton.setDisable(false);
            frenchfryButton.setDisable(false);
            colaButton.setDisable(false);

            level5Time = System.nanoTime();
        }
    }

    public void start() {
        new AnimationTimer() {
            @Override
            public void handle(long now) {
                n = now;
                if(currentLevel == 1){
                    if(level1Time > 0){
                        if(now - level1Time > 4000000000.0) {
                            level1Time = 0;
                            level1Time = System.nanoTime();
                            count++;
                            if (count <= 5) {
                                int rand = (int) (Math.random() * 5);
                                currentOrders.add(new Combos(menuCombos.get(rand)));
                                currentOrders.get(currentOrders.size() - 1).startOrderTime();
                                if(Math.random() < .20) {
                                    currentOrders.get(currentOrders.size() - 1).setAngryCustomer(true);
                                }
                                setOrdersList();
                                ordersList.setStyle("-fx-font-size: 14px; -fx-font-family: 'SketchFlow Print'; -fx-control-inner-background: e3d3dc;");
                            }
                            if(count >= 8){
                                endOfLevel();
                                count = 0;
                                level1Time = -1;
                                customersLost = 0;
                                customersServed = 0;
                                levelMoney = 0;
                            }
                        }
                        if(currentOrders.size() > 0) {
                            for(Iterator<Combos> it = currentOrders.iterator(); it.hasNext();) {
                                Combos c = it.next();
                                //got help from internet to solve ConcurrentModificationException error
                                if ((now - c.getOrderTime() > (10000000000.0 + (customerWaitF * 500000000.0) + (customerWaitTV * 1000000000.0))) || (c.isAngryCustomer() && now - c.getOrderTime() > 7000000000.0)){
                                    customersLost++;
                                    it.remove();
                                    setOrdersList();
                                    lostC.setText("Customers Lost: " + customersLost);
                                }
                            }
                        }
                    }
                }
                if(currentLevel == 2){
                    if(level2Time > 0){
                        if(now - level2Time > 4100000000.0) {
                            level2Time = 0;
                            level2Time = System.nanoTime();
                            count++;
                            if(count <= 6) {
                                int rand = 5 + (int)(Math.random() * 5);
                                currentOrders.add(new Combos(menuCombos.get(rand)));
                                currentOrders.get(currentOrders.size() - 1).startOrderTime();
                                if(Math.random() < .20) {
                                    currentOrders.get(currentOrders.size() - 1).setAngryCustomer(true);
                                }
                                setOrdersList();
                                ordersList.setStyle("-fx-font-size: 14px; -fx-font-family: 'SketchFlow Print'; -fx-control-inner-background: e3d3dc;");
                            }
                            if(count >= 10){
                                endOfLevel();
                                count = 0;
                                level2Time = -1;
                                customersLost = 0;
                                customersServed = 0;
                                levelMoney = 0;
                            }
                        }
                        if(currentOrders.size() > 0) {
                            for(Iterator<Combos> it = currentOrders.iterator(); it.hasNext();) {
                                Combos c = it.next();
                                //got help from internet to solve ConcurrentModificationException error
                                if ((now - c.getOrderTime() > (12000000000.0 + (customerWaitF * 500000000.0) + (customerWaitTV * 1000000000.0))) || (c.isAngryCustomer() && now - c.getOrderTime() > 7000000000.0)){
                                    customersLost++;
                                    it.remove();
                                    setOrdersList();
                                    lostC.setText("Customers Lost: " + customersLost);
                                }
                            }
                        }
                    }
                }
                if(currentLevel == 3){
                    if(level3Time > 0){
                        if(now - level3Time > (4200000000.0)) {
                            level3Time = 0;
                            level3Time = System.nanoTime();
                            count++;
                            if(count <= 6) {
                                int rand = 10 + (int)(Math.random() * 5);
                                currentOrders.add(new Combos(menuCombos.get(rand)));
                                currentOrders.get(currentOrders.size() - 1).startOrderTime();
                                if(Math.random() < .20) {
                                    currentOrders.get(currentOrders.size() - 1).setAngryCustomer(true);
                                }
                                setOrdersList();
                                ordersList.setStyle("-fx-font-size: 14px; -fx-font-family: 'SketchFlow Print'; -fx-control-inner-background: e3d3dc;");
                            }
                            if(count >= 13){
                                endOfLevel();
                                count = 0;
                                level3Time = -1;
                                customersLost = 0;
                                customersServed = 0;
                                levelMoney = 0;
                            }
                        }
                        if(currentOrders.size() > 0) {
                            for(Iterator<Combos> it = currentOrders.iterator(); it.hasNext();) {
                                Combos c = it.next();
                                //got help from internet to solve ConcurrentModificationException error
                                if ((now - c.getOrderTime() > (15000000000.0 + (customerWaitF * 500000000.0) + (customerWaitTV * 1000000000.0))) || (c.isAngryCustomer() && now - c.getOrderTime() > 8000000000.0)){
                                    customersLost++;
                                    it.remove();
                                    setOrdersList();
                                    lostC.setText("Customers Lost: " + customersLost);
                                }
                            }
                        }
                    }
                }
                if(currentLevel == 4){
                    if(level4Time > 0){
                        if(now - level4Time > 4300000000.0) {
                            level4Time = 0;
                            level4Time = System.nanoTime();
                            count++;
                            if(count <= 7) {
                                int rand =  15 + (int)(Math.random() * 5);
                                currentOrders.add(new Combos(menuCombos.get(rand)));
                                currentOrders.get(currentOrders.size() - 1).startOrderTime();
                                if(Math.random() < .20) {
                                    currentOrders.get(currentOrders.size() - 1).setAngryCustomer(true);
                                }
                                setOrdersList();
                                ordersList.setStyle("-fx-font-size: 14px; -fx-font-family: 'SketchFlow Print'; -fx-control-inner-background: e3d3dc;");
                            }
                            if(count >= 11){
                                endOfLevel();
                                count = 0;
                                level4Time = -1;
                                customersLost = 0;
                                customersServed = 0;
                                levelMoney = 0;
                            }
                        }
                        if(currentOrders.size() > 0) {
                            for(Iterator<Combos> it = currentOrders.iterator(); it.hasNext();) {
                                Combos c = it.next();
                                //got help from internet to solve ConcurrentModificationException error
                                if ((now - c.getOrderTime() > (17000000000.0 + (customerWaitF * 500000000.0) + (customerWaitTV * 1000000000.0))) || (c.isAngryCustomer() && now - c.getOrderTime() > 9000000000.0)){
                                    customersLost++;
                                    it.remove();
                                    setOrdersList();
                                    lostC.setText("Customers Lost: " + customersLost);
                                }
                            }
                        }
                    }
                }
                if(currentLevel == 5){
                    if(level5Time > 0){
                        if(now - level5Time > 4400000000.0) {
                            level5Time = 0;
                            level5Time = System.nanoTime();
                            count++;
                            if(count <= 8) {
                                int rand =  20 + (int)(Math.random() * 5);;
                                currentOrders.add(new Combos(menuCombos.get(rand)));
                                currentOrders.get(currentOrders.size() - 1).startOrderTime();
                                if(Math.random() < .20) {
                                    currentOrders.get(currentOrders.size() - 1).setAngryCustomer(true);
                                }
                                setOrdersList();
                                ordersList.setStyle("-fx-font-size: 14px; -fx-font-family: 'SketchFlow Print'; -fx-control-inner-background: e3d3dc;");
                            }
                            if(count >= 12){
                                endOfLevel();
                                count = 0;
                                level5Time = -1;
                                customersLost = 0;
                                customersServed = 0;
                                levelMoney = 0;
                            }
                        }
                        if(currentOrders.size() > 0) {
                            for(Iterator<Combos> it = currentOrders.iterator(); it.hasNext();) {
                                Combos c = it.next();
                                //got help from internet to solve ConcurrentModificationException error
                                if ((now - c.getOrderTime() > (18000000000.0 + (customerWaitF * 500000000.0) + (customerWaitTV * 1000000000.0))) || (c.isAngryCustomer() && now - c.getOrderTime() > 10000000000.0)){
                                    customersLost++;
                                    it.remove();
                                    setOrdersList();
                                    lostC.setText("Customers Lost: " + customersLost);
                                }
                            }
                        }
                    }
                }

                if(pattyTime > 0){
                    if(now - pattyTime > (1500000000.0 - (pattyUpgrade * 400000000.0))) {
                        pattyTime = -1;

                        pattyAdd.setVisible(true);
                        pattyCooking.setVisible(false);
                        pattyNone.setVisible(false);
                        pattyReady.setVisible(true);
                    }
                }

                if(bunsTime > 0){
                    if(now - bunsTime > (1000000000.0 - (bunUpgrade * 200000000.0))) {
                        bunsTime = -1;

                        bunAdd.setVisible(true);
                        bunCooking.setVisible(false);
                        bunNone.setVisible(false);
                        bunReady.setVisible(true);
                    }
                }

                if(tomatoTime > 0){
                    if(now - tomatoTime > (1500000000.0 - (tomatoUpgrade * 200000000.0))) {
                        tomatoTime = -1;

                        tomatoAdd.setVisible(true);
                        tomatoCooking.setVisible(false);
                        tomatoNone.setVisible(false);
                        tomatoReady.setVisible(true);
                    }
                }

                if(lettuceTime > 0){
                    if(now - lettuceTime > (1500000000.0 - (lettuceUpgrade * 200000000.0))) {
                        lettuceTime = -1;

                        lettuceAdd.setVisible(true);
                        lettuceCooking.setVisible(false);
                        lettuceNone.setVisible(false);
                        lettuceReady.setVisible(true);
                    }
                }

                if(colaTime > 0){
                    if(now - colaTime > 2500000000.0) {
                        colaTime = -1;

                        colaAdd.setVisible(true);
                        colaCooking.setVisible(false);
                        colaNone.setVisible(false);
                        colaReady.setVisible(true);
                    }
                }

                if(friesTime > 0){
                    if(now - friesTime > (3000000000.0 - (fryUpgrade * 300000000.0))) {
                        friesTime = -1;

                        frenchfryAdd.setVisible(true);
                        friesCooking.setVisible(false);
                        friesNone.setVisible(false);
                        friesReady.setVisible(true);
                    }
                }

                if(hotdogbunTime > 0){
                    if(now - hotdogbunTime > (1500000000.0 - (bunUpgrade * 200000000.0))) {
                        hotdogbunTime = -1;

                        hotdogbunAdd.setVisible(true);
                        hotdogbunCooking.setVisible(false);
                        hotdogbunNone.setVisible(false);
                        hotdogbunReady.setVisible(true);
                    }
                }

                if(hotdogTime > 0){
                    if(now - hotdogTime > (2000000000.0 - (pattyUpgrade * 400000000.0))) {
                        hotdogTime = -1;

                        sausageAdd.setVisible(true);
                        sausageCooking.setVisible(false);
                        sausageNone.setVisible(false);
                        sausageReady.setVisible(true);
                    }
                }

                if(cupcakeTime > 0){
                    if(now - cupcakeTime > 6000000000.0) {
                        cupcakeTime = -1;

                        cupcakeAdd.setVisible(true);
                        cupcakeCooking.setVisible(false);
                        cupcakeNone.setVisible(false);
                        cupcakeReady.setVisible(true);
                    }
                }

            }
        }.start();
    }

    @FXML
    public void checkOrder(MouseEvent x){
        if(currentOrders.size() > 0){
            Combos c = (Combos) ordersList.getSelectionModel().getSelectedItem();
            if(plate.isBun() == c.isBun() && plate.isPatty() == c.isPatty() && plate.isTomato() == c.isTomato() && plate.isLettuce() == c.isLettuce() &&
                plate.isFrenchfry() == c.isFrenchfry() && plate.isCola() == c.isCola() && plate.isCupcake() == c.isCupcake() && plate.isHotdog() == c.isHotdog() && plate.isHotdogbun() == c.isHotdogbun()) {

                double tip = (Math.round(currentOrders.get(ordersList.getSelectionModel().getSelectedIndex()).orderTip(n) * 100.0) / 100.0);
                levelTips += (Math.round(tip * 100.0) / 100.0);
                levelMoney += (Math.round((currentOrders.get(ordersList.getSelectionModel().getSelectedIndex()).costOfOrder(multiplier)) * 100.0) / 100.0);
                customersServed++;
                currentPlate.clear();
                servedC.setText("Customers Served: " + customersServed);
                changeBalance(currentOrders.get(ordersList.getSelectionModel().getSelectedIndex()).costOfOrder(multiplier) + tip);
                currentOrders.get(ordersList.getSelectionModel().getSelectedIndex()).stopOrderTime();
                currentOrders.remove(ordersList.getSelectionModel().getSelectedIndex());
                setOrdersList();
                plate.setBun(false);
                plate.setPatty(false);
                plate.setTomato(false);
                plate.setLettuce(false);
                plate.setHotdog(false);
                plate.setHotdogbun(false);
                plate.setFrenchfry(false);
                plate.setCola(false);
                plate.setCupcake(false);
            }
        }
    }

    public void pattyClick() {
        pattyTime = System.nanoTime();
        pattyCooking.setVisible(true);
        pattyNone.setVisible(false);
        pattyReady.setVisible(false);
    }

    public void bunClick() {
        bunsTime = System.nanoTime();
        bunCooking.setVisible(true);
        bunNone.setVisible(false);
        bunReady.setVisible(false);
    }

    public void lettuceClick() {
        lettuceTime = System.nanoTime();
        lettuceCooking.setVisible(true);
        lettuceNone.setVisible(false);
        lettuceReady.setVisible(false);
    }

    public void tomatoClick() {
        tomatoTime = System.nanoTime();
        tomatoCooking.setVisible(true);
        tomatoNone.setVisible(false);
        tomatoReady.setVisible(false);
    }

    public void hotdogbunClick() {
        hotdogbunTime = System.nanoTime();
        hotdogbunCooking.setVisible(true);
        hotdogbunNone.setVisible(false);
        hotdogbunReady.setVisible(false);
    }

    public void sausageClick() {
        hotdogTime = System.nanoTime();
        sausageCooking.setVisible(true);
        sausageNone.setVisible(false);
        sausageReady.setVisible(false);
    }

    public void cupcakeClick() {
        cupcakeTime = System.nanoTime();
        cupcakeCooking.setVisible(true);
        cupcakeNone.setVisible(false);
        cupcakeReady.setVisible(false);
    }

    public void frenchfryClick() {
        friesTime = System.nanoTime();
        friesCooking.setVisible(true);
        friesNone.setVisible(false);
        friesReady.setVisible(false);
    }

    public void colaClick() {
        colaTime = System.nanoTime();
        colaCooking.setVisible(true);
        colaNone.setVisible(false);
        colaReady.setVisible(false);
    }

    public void addLettuce(){
        plate.setLettuce(true);

        lettuceAdd.setVisible(false);
        lettuceCooking.setVisible(false);
        lettuceNone.setVisible(true);
        lettuceReady.setVisible(false);
        currentPlate.add("Lettuce");
        setOrdersList();
    }

    public void addTomato(){
        plate.setTomato(true);

        tomatoAdd.setVisible(false);
        tomatoCooking.setVisible(false);
        tomatoNone.setVisible(true);
        tomatoReady.setVisible(false);
        currentPlate.add("Tomato");
        setOrdersList();
    }

    public void addPatty(){
        plate.setPatty(true);

        pattyAdd.setVisible(false);
        pattyCooking.setVisible(false);
        pattyNone.setVisible(true);
        pattyReady.setVisible(false);
        currentPlate.add("Patty");
        setOrdersList();
    }

    public void addBun(){
        plate.setBun(true);

        bunAdd.setVisible(false);
        bunCooking.setVisible(false);
        bunNone.setVisible(true);
        bunReady.setVisible(false);
        currentPlate.add("Bun");
        setOrdersList();
    }

    public void addSausage(){
        plate.setHotdog(true);

        sausageAdd.setVisible(false);
        sausageCooking.setVisible(false);
        sausageNone.setVisible(true);
        sausageReady.setVisible(false);
        currentPlate.add("Sausage");
        setOrdersList();
    }

    public void addHotdogbun(){
        plate.setHotdogbun(true);

        hotdogbunAdd.setVisible(false);
        hotdogbunCooking.setVisible(false);
        hotdogbunNone.setVisible(true);
        hotdogbunReady.setVisible(false);
        currentPlate.add("Hotdog Bun");
        setOrdersList();
    }

    public void addFrenchfry(){
        plate.setFrenchfry(true);

        frenchfryAdd.setVisible(false);
        friesCooking.setVisible(false);
        friesNone.setVisible(true);
        friesReady.setVisible(false);
        currentPlate.add("French Fries");
        setOrdersList();
    }

    public void addCupcake(){
        plate.setCupcake(true);

        cupcakeAdd.setVisible(false);
        cupcakeCooking.setVisible(false);
        cupcakeNone.setVisible(true);
        cupcakeReady.setVisible(false);
        currentPlate.add("Cupcake");
        setOrdersList();
    }

    public void addCola(){
        plate.setCola(true);

        colaAdd.setVisible(false);
        colaCooking.setVisible(false);
        colaNone.setVisible(true);
        colaReady.setVisible(false);
        currentPlate.add("Cola");
        setOrdersList();
    }

    public void setOrdersList(){
        ordersList.getItems().clear();
        ordersList.getItems().addAll(currentOrders);

        currentOrderList.getItems().clear();
        currentOrderList.getItems().addAll(currentPlate);
        currentOrderList.setStyle("-fx-font-size: 12px; -fx-font-family: 'SketchFlow Print'; -fx-control-inner-background: #bfb0ba;");
    }

    public void clearScreen(){
        bunReady.setVisible(false);
        bunAdd.setVisible(false);
        bunCooking.setVisible(false);
        bunNone.setVisible(false);
        colaReady.setVisible(false);
        colaAdd.setVisible(false);
        colaCooking.setVisible(false);
        colaNone.setVisible(false);
        colaReady.setVisible(false);
        cupcakeAdd.setVisible(false);
        cupcakeCooking.setVisible(false);
        cupcakeNone.setVisible(false);
        cupcakeReady.setVisible(false);
        frenchfryAdd.setVisible(false);
        friesCooking.setVisible(false);
        friesNone.setVisible(false);
        friesReady.setVisible(false);
        hotdogbunAdd.setVisible(false);
        hotdogbunCooking.setVisible(false);
        hotdogbunNone.setVisible(false);
        hotdogbunReady.setVisible(false);
        lettuceAdd.setVisible(false);
        lettuceCooking.setVisible(false);
        lettuceNone.setVisible(false);
        lettuceReady.setVisible(false);
        tomatoAdd.setVisible(false);
        tomatoCooking.setVisible(false);
        tomatoNone.setVisible(false);
        tomatoReady.setVisible(false);
        pattyAdd.setVisible(false);
        pattyCooking.setVisible(false);
        pattyNone.setVisible(false);
        pattyReady.setVisible(false);
        sausageAdd.setVisible(false);
        sausageCooking.setVisible(false);
        sausageNone.setVisible(false);
        sausageReady.setVisible(false);
        menu1.setVisible(false);
        menu2.setVisible(false);
        menu3.setVisible(false);
        menu4.setVisible(false);
        menu5.setVisible(false);
        lostC.setText("Customers Lost: " + customersLost);
        servedC.setText("Customers Served: " + customersServed);
    }

    public void changeBalance(double m){
        totalMoney += (Math.round(m * 100.0) / 100.0);
        balanceLabel.setText("Money Balance: $" + (Math.round(totalMoney * 100.0) / 100.0));

        if(currentLevel != 0) {
            levelProfit = levelTips + levelMoney;
        }
    }

    @FXML
    protected void pauseGame(){
        String[] buttons = { "Resume", "Restart Level", "Main Menu"};
        int returnValue = JOptionPane.showOptionDialog(null, "Paused", "Paused",
                JOptionPane.INFORMATION_MESSAGE, 0, null, buttons, buttons[0]);

        if(returnValue == 1){
            playAgain();
        }
        else if(returnValue == 2){
            startGame();
        }
    }

    @FXML
    protected void discardOrder(){
        plate.setBun(false);
        plate.setPatty(false);
        plate.setTomato(false);
        plate.setLettuce(false);
        plate.setHotdog(false);
        plate.setHotdogbun(false);
        plate.setFrenchfry(false);
        plate.setCola(false);
        plate.setCupcake(false);
        currentPlate.clear();
        setOrdersList();
    }

    public void endOfLevel(){
        star1.setVisible(false);
        star2.setVisible(false);
        star3.setVisible(false);
        currentOrders.clear();
        currentPlate.clear();
        currentOrderList.getItems().clear();
        ordersList.getItems().clear();
        plate.setBun(false);
        plate.setPatty(false);
        plate.setTomato(false);
        plate.setLettuce(false);
        plate.setHotdog(false);
        plate.setHotdogbun(false);
        plate.setFrenchfry(false);
        plate.setCola(false);
        plate.setCupcake(false);
        endScreen.setVisible(true);
        levelscreen.setVisible(false);
        startscreen.setVisible(false);
        level1Screen.setVisible(false);

        lostLabel.setText(String.valueOf(customersLost));
        servedLabel.setText(String.valueOf(customersServed));
        profitLabel.setText("$" + (Math.round(levelMoney * 100.0) / 100.0));
        tipLabel.setText("$" + (Math.round(levelTips * 100.0) / 100.0));
        totalLabel.setText("$" + (Math.round(levelProfit * 100.0) / 100.0));

        levelTips = 0;
        levelMoney = 0;
        customersServed = 0;
        customersLost = 0;
        clearScreen();

        if(currentLevel == 1){
            levelLabel.setText("Level 1");
            if(levelProfit >= 65){
                star1.setVisible(true);
                star2.setVisible(true);
                star3.setVisible(true);
                level1star1.setVisible(true);
                level1star2.setVisible(true);
                level1star3.setVisible(true);
                levelFailed.setVisible(false);
                playedLevel1 = true;
                level2Button.setDisable(false);
                nextButton.setDisable(false);
            }
            else if(levelProfit >= 50){
                star1.setVisible(true);
                star2.setVisible(true);
                star3.setVisible(false);
                level1star1.setVisible(true);
                level1star2.setVisible(true);
                levelFailed.setVisible(false);
                playedLevel1 = true;
                level2Button.setDisable(false);
                nextButton.setDisable(false);
            }
            else if(levelProfit >= 40){
                star1.setVisible(true);
                star2.setVisible(false);
                star3.setVisible(false);
                level1star1.setVisible(true);
                levelFailed.setVisible(false);
                playedLevel1 = true;
                level2Button.setDisable(false);
                nextButton.setDisable(false);
            }
            else if(levelProfit < 40){
                levelFailed.setVisible(true);
                nextButton.setDisable(true);
            }
        }
        else if(currentLevel == 2){
            levelLabel.setText("Level 2");
            if(levelProfit >= 80){
                star1.setVisible(true);
                star2.setVisible(true);
                star3.setVisible(true);
                level2star1.setVisible(true);
                level2star2.setVisible(true);
                level2star3.setVisible(true);
                levelFailed.setVisible(false);
                playedLevel2 = true;
                level3Button.setDisable(false);
                nextButton.setDisable(false);
            }
            else if(levelProfit >= 60){
                star1.setVisible(true);
                star2.setVisible(true);
                star3.setVisible(false);
                level2star1.setVisible(true);
                level2star2.setVisible(true);
                levelFailed.setVisible(false);
                playedLevel2 = true;
                level3Button.setDisable(false);
                nextButton.setDisable(false);
            }
            else if(levelProfit >= 45){
                star1.setVisible(true);
                star2.setVisible(false);
                star3.setVisible(false);
                level2star1.setVisible(true);
                levelFailed.setVisible(false);
                playedLevel2 = true;
                level3Button.setDisable(false);
                nextButton.setDisable(false);
            }
            else if(levelProfit < 45){
                levelFailed.setVisible(true);
                nextButton.setDisable(true);
            }
        }
        else if(currentLevel == 3){
            levelLabel.setText("Level 3");
            if(levelProfit >= 100){
                star1.setVisible(true);
                star2.setVisible(true);
                star3.setVisible(true);
                level3star1.setVisible(true);
                level3star2.setVisible(true);
                level3star3.setVisible(true);
                levelFailed.setVisible(false);
                playedLevel3 = true;
                level4Button.setDisable(false);
                nextButton.setDisable(false);
            }
            else if(levelProfit >= 80){
                star1.setVisible(true);
                star2.setVisible(true);
                star3.setVisible(false);
                level3star1.setVisible(true);
                level3star2.setVisible(true);
                levelFailed.setVisible(false);
                playedLevel3 = true;
                level4Button.setDisable(false);
                nextButton.setDisable(false);
            }
            else if(levelProfit >= 60){
                star1.setVisible(true);
                star2.setVisible(false);
                star3.setVisible(false);
                level3star1.setVisible(true);
                playedLevel3 = true;
                level4Button.setDisable(false);
                nextButton.setDisable(false);
            }
            else if(levelProfit < 60){
                levelFailed.setVisible(true);
                nextButton.setDisable(true);
            }
        }
        else if(currentLevel == 4){
            levelLabel.setText("Level 4");
            if(levelProfit >= 120){
                star1.setVisible(true);
                star2.setVisible(true);
                star3.setVisible(true);
                level4star1.setVisible(true);
                level4star2.setVisible(true);
                level4star3.setVisible(true);
                levelFailed.setVisible(false);
                playedLevel4 = true;
                level5Button.setDisable(false);
                nextButton.setDisable(false);
            }
            else if(levelProfit >= 90){
                star1.setVisible(true);
                star2.setVisible(true);
                star3.setVisible(false);
                level4star1.setVisible(true);
                level4star2.setVisible(true);
                levelFailed.setVisible(false);
                playedLevel4 = true;
                level5Button.setDisable(false);
                nextButton.setDisable(false);
            }
            else if(levelProfit >= 75){
                star1.setVisible(true);
                star2.setVisible(false);
                star3.setVisible(false);
                level4star1.setVisible(true);
                levelFailed.setVisible(false);
                playedLevel4 = true;
                level5Button.setDisable(false);
                nextButton.setDisable(false);
            }
            else if(levelProfit < 75){
                levelFailed.setVisible(true);
                nextButton.setDisable(true);
            }
        }
        else if(currentLevel == 5){
            levelLabel.setText("Level 5");
            nextButton.setDisable(true);

            if(levelProfit >= 175){
                star1.setVisible(true);
                star2.setVisible(true);
                star3.setVisible(true);
                level5star1.setVisible(true);
                level5star2.setVisible(true);
                level5star3.setVisible(true);
                levelFailed.setVisible(false);
                playedLevel5 = true;
            }
            else if(levelProfit >= 150){
                star1.setVisible(true);
                star2.setVisible(true);
                star3.setVisible(false);
                level5star1.setVisible(true);
                level5star2.setVisible(true);
                levelFailed.setVisible(false);
                playedLevel5 = true;
            }
            else if(levelProfit >= 120){
                star1.setVisible(true);
                star2.setVisible(false);
                star3.setVisible(false);
                level5star1.setVisible(true);
                levelFailed.setVisible(false);
                playedLevel5 = true;
            }
            else if(levelProfit < 120){
                levelFailed.setVisible(true);
            }
        }
        levelProfit = 0;
    }

    @FXML
    protected void tomatoUpgrade(){
        if(tomatoUpgrade < 3 && totalMoney >= tomatoUpgradeprice){
            tomatoUpgrade++;
            changeBalance(-tomatoUpgradeprice);
        }
        else if (totalMoney < tomatoUpgradeprice){
            noMoneyLabel.setVisible(true);
        }

        if(tomatoUpgrade >= 3){
            tomatoUpgradeB.setDisable(true);
            tomatoUpgradeB.setText("MAX upgrades reached");
        }
        else {
            tomatoUpgradeprice = 3 * tomatoUpgradeprice;
            tomatoUpgradeB.setText("$" + tomatoUpgradeprice + "   Upgrade Count: " + tomatoUpgrade);
        }
    }

    @FXML
    protected void lettuceUpgrade(){
        if(lettuceUpgrade < 3 && totalMoney >= lettuceUpgradeprice){
            lettuceUpgrade++;
            changeBalance(-lettuceUpgradeprice);
        }
        else if(totalMoney < lettuceUpgradeprice){
            noMoneyLabel.setVisible(true);
        }

        if(lettuceUpgrade >= 3){
            lettuceUpgradeB.setDisable(true);
            lettuceUpgradeB.setText("MAX upgrades reached");
        }
        else {
            lettuceUpgradeprice *= 3;
            lettuceUpgradeB.setText("$" + lettuceUpgradeprice + "   Upgrade Count: " + lettuceUpgrade);
        }
    }

    @FXML
    protected void bunUpgrade(){
        if(bunUpgrade < 3 && totalMoney >= bunUpgradeprice){
            bunUpgrade++;
            changeBalance(-bunUpgradeprice);
        }
        else if(totalMoney < bunUpgradeprice){
            noMoneyLabel.setVisible(true);
        }

        if(bunUpgrade >= 3){
            bunUpgradeB.setDisable(true);
            bunUpgradeB.setText("MAX upgrades reached");
        }
        else {
            bunUpgradeprice *= 3;
            bunUpgradeB.setText("$" + bunUpgradeprice + "   Upgrade Count: " + bunUpgrade);
        }
    }

    @FXML
    protected void pattyUpgrade(){
        if(pattyUpgrade < 3 && totalMoney >= pattyUpgradeprice) {
            pattyUpgrade++;
            changeBalance(-pattyUpgradeprice);
        }
        else if(totalMoney < bunUpgradeprice){
            noMoneyLabel.setVisible(true);
        }

        if(pattyUpgrade >= 3){
            pattyUpgradeB.setDisable(true);
            pattyUpgradeB.setText("MAX upgrades reached");
        }
        else {
            pattyUpgradeprice *= 3;
            pattyUpgradeB.setText("$" + pattyUpgradeprice + "   Upgrade Count: " + pattyUpgrade);
        }
    }

    @FXML
    protected void fryUpgrade(){
        if(fryUpgrade < 3 && totalMoney >= fryUpgradeprice) {
            fryUpgrade++;
            changeBalance(-fryUpgradeprice);
        }
        else if(totalMoney < fryUpgradeprice){
            noMoneyLabel.setVisible(true);
        }

        if(fryUpgrade >= 3){
            fryUpgradeB.setDisable(true);
            fryUpgradeB.setText("MAX upgrades reached");
        }
        else {
            fryUpgradeprice *= 4;
            fryUpgradeB.setText("$" + fryUpgradeprice + "   Upgrade Count: " + fryUpgrade);
        }
    }

    @FXML
    protected void furnitureUpgrade(){
        if(customerWaitF < 3 && totalMoney >= customerWaitFprice) {
            customerWaitF += 1;
            changeBalance(-customerWaitF);
        }
        else if(totalMoney < customerWaitFprice){
            noMoneyLabel.setVisible(true);
        }

        if(customerWaitF >= 3){
            furnitureUpgradeB.setDisable(true);
            furnitureUpgradeB.setText("MAX upgrades reached");
        }
        else {
            customerWaitFprice *= 3;
            furnitureUpgradeB.setText("$" + customerWaitFprice + "   Upgrade Count: " + customerWaitF);
        }
    }

    @FXML
    protected void tvUpgrade(){
        if(customerWaitTV < 2 && totalMoney >= customerWaitTVprice) {
            customerWaitTV += 1;
            changeBalance(-customerWaitTV);
        }
        else if(totalMoney < customerWaitTVprice){
            noMoneyLabel.setVisible(true);
        }

        if(customerWaitTV >= 3){
            TVupgradeB.setDisable(true);
            TVupgradeB.setText("MAX upgrades reached");
        }
        else {
            customerWaitTVprice *= 4;
            TVupgradeB.setText("$" + customerWaitTVprice + "   Upgrade Count: " + customerWaitTV);
        }
    }

    @FXML
    protected void multiplier(){
        if(totalMoney >= multiplierprice) {
            multiplier += 0.1;
            multiplierprice *= 2;
            changeBalance(-multiplierprice);
        }
        else if(totalMoney < multiplierprice){
            noMoneyLabel.setVisible(true);
        }
        multiplierUpgradeB.setText("$" + multiplierprice + "   Multiplier: " + multiplier);
    }
}