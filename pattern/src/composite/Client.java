package composite;

public class Client {
	public static void main(String[] args) {
		AbstractFile f2,f3,f4;
		Folder f1;
		f1=new Folder("我的收藏");
		f2=new ImageFIle("大头");
		f3=new TextFIle("黄书");
		
		Folder f11=new Folder("电影");
		f4=new ImageFIle("死变态");
		f1.add(f2);
		f1.add(f3);
		f11.add(f4);
		f1.add(f11);
		f1.killVirus();
	}
	
}
