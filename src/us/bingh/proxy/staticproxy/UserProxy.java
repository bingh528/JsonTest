package us.bingh.proxy.staticproxy;

public class UserProxy implements Buy {
    private Buy buy;

    public void setProxy(Buy buy){
        this.buy = buy;
    }
    @Override
    public void buyHouse(long money) {
        long m = (long)(money*0.9);
        System.out.println("中介费 "+ (money-m)+" 钱 ");
        buy.buyHouse(m);
    }
}
