package oop.ex;

public class Account {
    int balance = 0; //잔액

    void isblance(){
        System.out.println("현재 잔액"+ balance);
    }
    void deposit(int amoount){
        balance += amoount;
        System.out.println("계좌의 "+amoount+"원을 입금했습니다.");
        isblance();
    }
    void withdraw(int amoount){
        if(balance < amoount){
            System.out.println("잔액이 부족합니다.");
        }
        else{
            balance -= amoount;
            System.out.println("계좌의 "+amoount+"원을 출금했습니다.");
            isblance();
        }
    }
    void exit(){
        System.out.println("프로그램을 종료합니다.");
    }
}
