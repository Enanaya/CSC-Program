package composite;

public class Client {
	public static void main(String[] args) {
		AbstractFile f2,f3,f4;
		Folder f1;
		f1=new Folder("�ҵ��ղ�");
		f2=new ImageFIle("��ͷ");
		f3=new TextFIle("����");
		
		Folder f11=new Folder("��Ӱ");
		f4=new ImageFIle("����̬");
		f1.add(f2);
		f1.add(f3);
		f11.add(f4);
		f1.add(f11);
		f1.killVirus();
	}
	
}
