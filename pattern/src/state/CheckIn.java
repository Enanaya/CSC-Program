package state;

/**
 * @author 76500
 * 空闲状态
 */
public class CheckIn implements State{

	@Override
	public void handle() {
		// TODO Auto-generated method stub
		System.out.println("房间已入住");
	}
	
}
