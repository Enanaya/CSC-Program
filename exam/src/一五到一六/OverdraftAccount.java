package 一五到一六;

public class OverdraftAccount extends AbstractAccount {

	
	@Override
	public int withdraw(int amount) {
		// TODO Auto-generated method stub
		if (amount>balance) {
			balance-=amount+10;
		}
		return amount;
	}

}
