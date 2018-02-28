package 一五到一六;

public class FreeAccount extends AbstractAccount {

	

	@Override
	public int withdraw(int amount) {
		// TODO Auto-generated method stub
		if (amount>balance) {
			return 0;
		}
		else {
			return amount;
		}
	}

}
