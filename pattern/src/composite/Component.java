package composite;

/**
 * @author 76500
 * 抽象组件
 */
public interface Component {
	void operation();
}


/**
 * @author 76500
 * 叶子组件
 */
interface Leaf extends Component{
	
}

/**
 * @author 76500
 * 容器组件
 */
interface Composite extends Component{
	void add(Component c);
	void remove(Component c);
	Component getChild(int index);
}