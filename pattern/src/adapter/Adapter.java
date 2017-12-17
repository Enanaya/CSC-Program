package adapter;

/**
 * @author 76500
 * 适配器本身
 */
public class Adapter extends Adaptee implements Target{

	//与adaptee关联起来 1.继承 缺点，单继承，不能用于其他类
	
	@Override
	public void handleRqe() {
		// TODO Auto-generated method stub
		super.request();
	} 
	
}
