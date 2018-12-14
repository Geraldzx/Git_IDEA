package test;

public class proxy implements subject {
    private subject proxy;

    public proxy() {
        this.proxy = new realSuject();
    }

    @Override
    public void repuest() {
        this.before();
        this.proxy.repuest();
        this.after();
    }

    private  void before(){
        System.out.println("开始：");
    }
    private void after(){
        System.out.println("结束：");
    }
}
