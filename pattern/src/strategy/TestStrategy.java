package strategy;

/**
 * @author 76500
 * 实现较容易，但类型较多时，难用，难维护
 */
public class TestStrategy {
	public double getPrice(String type,double price) {
		if (type.equals("普通客户小批量")) {
			System.out.println("不打折，廉价");
			return price;
		}
		else  if(type.equals("普通客户大批量")){
			 System.out.println("九折");
			 return price*0.9;
		}else  if(type.equals("老客户小批量")){
			 System.out.println("八五折");
			 return price*0.85;
		}else  if(type.equals("老客户大批量")){
			 System.out.println("八折");
			 return price*0.8;
		}
		return price;
	}
}
