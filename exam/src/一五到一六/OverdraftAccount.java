package 一五到一六;

public class OverdraftAccount extends AbstractAccount implements Account{

	@Override
	public void desopit(int amount) {
		// TODO Auto-generated method stub
		balance+=amount;
	}

	@Override
	public int getAccountNumber() {
		// TODO Auto-generated method stub
		return AccountNumber;
	}

	@Override
	public int getBalance() {
		// TODO Auto-generated method stub
		return balance;
	}

	@Override
	public int withdraw(int amount) {
		// TODO Auto-generated method stub
		if (amount>balance) {
			balance-=amount+10;
		}
		return amount;
	}

}
