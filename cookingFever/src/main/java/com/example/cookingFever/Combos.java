package com.example.cookingFever;

public class Combos {
    private boolean bun, patty, tomato, lettuce, hotdogbun, hotdog, cola, frenchfry, cupcake, angryCustomer;

    private long orderTime;

    public Combos(boolean b, boolean p, boolean t, boolean l, boolean hdb, boolean hd, boolean c, boolean ff, boolean cc){
        bun = b;
        patty = p;
        tomato = t;
        lettuce = l;
        hotdogbun = hdb;
        hotdog = hd;
        cola = c;
        frenchfry = ff;
        cupcake = cc;
        angryCustomer = false;
    }

    public Combos(Combos c){
        bun = c.isBun();
        patty = c.isPatty();
        tomato = c.isTomato();
        lettuce = c.isLettuce();
        hotdogbun = c.isHotdogbun();
        hotdog = c.isHotdog();
        cola = c.isCola();
        frenchfry = c.isFrenchfry();
        cupcake = c.isCupcake();
    }

    public boolean isBun() {
        return bun;
    }

    public void setBun(boolean bun) {
        this.bun = bun;
    }

    public boolean isPatty() {
        return patty;
    }

    public void setPatty(boolean patty) {
        this.patty = patty;
    }

    public boolean isTomato() {
        return tomato;
    }

    public void setTomato(boolean tomato) {
        this.tomato = tomato;
    }

    public boolean isLettuce() {
        return lettuce;
    }

    public void setLettuce(boolean lettuce) {
        this.lettuce = lettuce;
    }

    public boolean isHotdogbun() {
        return hotdogbun;
    }

    public void setHotdogbun(boolean hotdogbun) {
        this.hotdogbun = hotdogbun;
    }

    public boolean isHotdog() {
        return hotdog;
    }

    public void setHotdog(boolean hotdog) {
        this.hotdog = hotdog;
    }

    public boolean isCola() {
        return cola;
    }

    public void setCola(boolean cola) {
        this.cola = cola;
    }

    public boolean isFrenchfry() {
        return frenchfry;
    }

    public void setFrenchfry(boolean frenchfry) {
        this.frenchfry = frenchfry;
    }

    public boolean isCupcake() {
        return cupcake;
    }

    public void setCupcake(boolean cupcake) {
        this.cupcake = cupcake;
    }

    public void setAngryCustomer(boolean a){
        angryCustomer = a;
    }

    public boolean isAngryCustomer(){
        return angryCustomer;
    }

    public long getOrderTime() {
        return orderTime;
    }

    public void startOrderTime() {
        this.orderTime = System.nanoTime();
    }

    public void stopOrderTime() {
        this.orderTime = -1;
    }

    public double orderTip(long now){
        double tip = (now - orderTime) / 1000000000.0;
        if(angryCustomer){
            tip = 4 * (7 - (Math.round(tip * 100.0) / 100.0));
        }
        else {
            tip = 2 * (16 - (Math.round(tip * 100.0) / 100.0));
        }
        return tip;
    }

    public String returnOrder(){
        String fullOrder = "";
        if(angryCustomer){
            fullOrder+= "ANGRY CUSTOMER:";
        }
        if(bun && patty && tomato && lettuce){
            fullOrder += "    Burger with tomato and lettuce";
        }

        else if(bun && patty && tomato){
            fullOrder += "    Burger with tomato";
        }

        else if (bun && patty && lettuce){
            fullOrder += "    Burger with lettuce";
        }

        else if(bun && patty){
            fullOrder += "    Burger";
        }

        if(cola){
            fullOrder += "    Cola";
        }
        if(frenchfry){
            fullOrder += "    French Fries";
        }
        if(hotdog && hotdogbun){
            fullOrder += "    Hotdog";
        }
        if(cupcake){
            fullOrder += "    Cupcake";
        }
        return fullOrder;
    }

    public double costOfOrder(double multiplier){
        double cost = 0;

        if(bun && patty && tomato && lettuce){
            cost += (15 * multiplier);
        }
        else if(bun && patty && tomato){
            cost += (9 * multiplier);
        }
        else if (bun && patty && lettuce){
            cost += (11 * multiplier);
        }
        else if(bun && patty){
            cost += (6 * multiplier);
        }

        if(hotdog && hotdogbun){
            cost += (10 * multiplier);
        }
        if(cupcake){
            cost += (40 * multiplier);
        }
        if(frenchfry){
            cost += (8 * multiplier);
        }
        if(cola){
            cost += (4 * multiplier);
        }
        return cost;
    }
}
