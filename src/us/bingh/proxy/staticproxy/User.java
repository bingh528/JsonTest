package us.bingh.proxy.staticproxy;

public class User implements Buy {
    @Override
    public void buyHouse(long money) {
        System.out.println("花钱用了"+money+" 钱 ");
    }
}
