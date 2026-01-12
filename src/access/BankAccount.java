package access;
//캡슐화: 데이터와 해당 데이터를 처리하는 메서드를 하나로 묶어서 외부에서의 접근을 제한하는 것.
public class BankAccount {

    private int balance;

    public BankAccount() {
        balance = 0;
    }

    //public 메서드: deposit
    public void deposit(int amount) {
        if(isAmountValid(amount)) {
            balance += amount;
        }else {
            System.out.println("유효하지 않는 금액입니다.");
        }
    }
    //public 메서드 withdraw
    public void withdraw(int amount) {
        if(isAmountValid(amount) && balance - amount >= 0 ) {
            balance -= amount;
        }
        else{
            System.out.println("유효하지 않은 금액이거나 잔액이 부족합니다.");
        }
    }
    //private 메서드: isAmountValid
    private boolean isAmountValid(int amount) {
        //금액이 0보다 커야함
        return amount > 0;
    }
    //public 메서드 :getBalance
    public  int getBalance() {
        return balance;
    }

}
