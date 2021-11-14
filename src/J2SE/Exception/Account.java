package J2SE.Exception;

import java.sql.SQLOutput;

public class Account {
    double balance;
    public Account(double balance){
        this.balance=balance;
    }
    public double getBalance(){
        return this.balance;
    }
    public void deposit(double amt){
        this.balance+=amt;
    }
    public void withDraw (double amt) throws overdraftException{
        if(this.balance<amt){
            throw new overdraftException("余额不足",amt-this.balance);
        }else{
            this.balance-=amt;
        }
    }

    public static void main(String[] args) {
        Account acc=new Account(1000);
        acc.deposit(1000);
        System.out.println(acc.getBalance());
        try{
            acc.withDraw(2001);
        }catch (overdraftException e){
            System.err.println("透支金额"+e.getDeficit());
            e.printStackTrace();
        }finally {
            System.out.println("交易完成，当前余额"+acc.getBalance());
        }
    }
}
