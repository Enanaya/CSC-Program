package strategy;

/**
 * @author 76500
 * ʵ�ֽ����ף������ͽ϶�ʱ�����ã���ά��
 */
public class TestStrategy {
	public double getPrice(String type,double price) {
		if (type.equals("��ͨ�ͻ�С����")) {
			System.out.println("�����ۣ�����");
			return price;
		}
		else  if(type.equals("��ͨ�ͻ�������")){
			 System.out.println("����");
			 return price*0.9;
		}else  if(type.equals("�Ͽͻ�С����")){
			 System.out.println("������");
			 return price*0.85;
		}else  if(type.equals("�Ͽͻ�������")){
			 System.out.println("����");
			 return price*0.8;
		}
		return price;
	}
}
