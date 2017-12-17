package composite;

/**
 * @author 76500
 * �������
 */
public interface Component {
	void operation();
}


/**
 * @author 76500
 * Ҷ�����
 */
interface Leaf extends Component{
	
}

/**
 * @author 76500
 * �������
 */
interface Composite extends Component{
	void add(Component c);
	void remove(Component c);
	Component getChild(int index);
}