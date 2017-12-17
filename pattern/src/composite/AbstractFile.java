package composite;

import java.awt.List;
import java.util.ArrayList;

/**
 * @author 76500 ���󹹽�
 */
public interface AbstractFile {
	void killVirus();
}


/**
 * @author 76500
 * Ҷ��
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
	System.out.println("--ͼ��"+name+"�����в�ɱ");	
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
	System.out.println("--�ı�"+name+"�����в�ɱ");	
	}
}


class Folder implements AbstractFile{

	private String name;
	//����������������ű������¹������ӽڵ�
	private ArrayList<AbstractFile> list= new ArrayList<AbstractFile>();
	
	public Folder(String name) {
		super();
		this.name = name;
	}
	@Override
	public void killVirus() {
		// TODO Auto-generated method stub
		System.out.println("--�ļ���:"+name+"��ɱ");
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