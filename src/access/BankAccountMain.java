package access;

public class BankAccountMain {
    public static void main(String[] args) {
        BankAccount bankAccount = new BankAccount();
        bankAccount.deposit(10000);
        bankAccount.withdraw(2000);
        System.out.println("balance = " + bankAccount.getBalance());
    }
}
/*
* private
* balance: 데이터 필드는 외부에 직접 노출하지 않는다. BankAccount가 제공하는 메서드를 통해서만 접근 가능
* isAmountValid(): 입력 금액을 검증하는 기능은 내부에서만 필요한 기능이다. 따라서 private을 사용했다.
*
* public
* deposit():입금
* withdraw():출금
* getBalance():잔고 */