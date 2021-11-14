package J2SE.Exception;

public class checkingAccount extends Account{
    private double overdraftProtection;
    public checkingAccount(double balance){
        super(balance);
    }
    public checkingAccount(double balance,double protect){
        super(balance);
        this.overdraftProtection=protect;
    }
    public void withdraw(double amt) throws overdraftException{
        if(amt>this.balance+overdraftProtection){
            double deficit=amt-(this.balance+overdraftProtection);
            throw new overdraftException("透支额度超标",deficit);
        }
        this.balance-=amt;
    }

    public static void main(String[] args) {
        //开户存了1000块，拥有500的透支额度
        checkingAccount a = new checkingAccount(1000, 500);
        //存了1000
        a.deposit(1000);
        //查询余额
        System.out.println(a.getBalance());
        try {
            a.withDraw(600);
            System.out.println(a.getBalance());
            a.withDraw(600);
            System.out.println(a.getBalance());
            a.withDraw(600);
            System.out.println(a.getBalance());
            a.withDraw(600);
            System.out.println(a.getBalance());
            a.withDraw(600);
            System.out.println(a.getBalance());
        } catch (overdraftException e) {
            System.err.println("透支超额:"+e.getDeficit());
            e.printStackTrace();
        }
    }
}
