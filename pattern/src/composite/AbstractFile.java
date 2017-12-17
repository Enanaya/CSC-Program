package composite;

import java.awt.List;
import java.util.ArrayList;

/**
 * @author 76500 抽象构建
 */
public interface AbstractFile {
	void killVirus();
}


/**
 * @author 76500
 * 叶子
 */
class ImageFIle implements AbstractFile{
	private String name;
	
	public ImageFIle(String name) {
		super();
		this.name = name;
	}

	@Override
	public void killVirus() {
		// TODO Auto-generated method stub
	System.out.println("--图像"+name+"，进行查杀");	
	}
}


class TextFIle implements AbstractFile{
	private String name;
	
	public TextFIle(String name) {
		super();
		this.name = name;
	}

	@Override
	public void killVirus() {
		// TODO Auto-generated method stub
	System.out.println("--文本"+name+"，进行查杀");	
	}
}


class Folder implements AbstractFile{

	private String name;
	//定义容器，用来存放本容器下构建的子节点
	private ArrayList<AbstractFile> list= new ArrayList<AbstractFile>();
	
	public Folder(String name) {
		super();
		this.name = name;
	}
	@Override
	public void killVirus() {
		// TODO Auto-generated method stub
		System.out.println("--文件夹:"+name+"查杀");
		for (AbstractFile abstractFile : list) {
			abstractFile.killVirus();
		}
	}
	
	public void add(AbstractFile file) {
		list.add(file);
	}
	
	public void remove(AbstractFile file) {
		list.remove(file);
	}

	public AbstractFile getChild(int index) {
		return list.get(index);
	}
}