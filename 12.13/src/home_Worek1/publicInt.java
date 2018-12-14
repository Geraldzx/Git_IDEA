package home_Worek1;

public class publicInt {
    Integer in = 10;

    public Integer getIn() {
        return in;
    }

    public void setIn(Integer in) {
        this.in = in;
    }

    public publicInt() {
    }

    //加一
    public void add(){
        while(true){
            this.in++;
            System.out.println(Thread.currentThread().getName()+"加一");
        }
    }

    //加一
    public void deduct(){
        while(true){
            this.in--;
            System.out.println(Thread.currentThread().getName()+"减一");
        }
    }
}
