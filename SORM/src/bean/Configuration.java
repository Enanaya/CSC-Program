package bean;

/**
 * @author 76500
 *
 */
/**
 * @author 76500
 *
 */
public class Configuration {

	/**
	 * 驱动类
	 */
	private String dirver;

	/**
	 * jdbc的url
	 */
	private String url;
	/**
	 * 数据库的用户名
	 */
	private String user;
	/**
	 * 数据库的密码
	 */
	private String pwd;
	/**
	 * 正在使用哪个数据库
	 */
	private String usingDB;
	/**
	 * 项目的源码路径
	 */
	private String srcPath;
	/**
	 * 扫描生成java类的包,po=persistence object 持久化对象
	 */
	private String poPackage;

	/**
	 * 项目使用的查询类的路径是哪一个类
	 */
	private String queryClass;
	
	public String getQueryClass() {
		return queryClass;
	}

	public void setQueryClass(String queryClass) {
		this.queryClass = queryClass;
	}

	/**
	 * 连接池中最小的数量
	 */
	private int poolMinSize;
	
	public int getPoolMinSize() {
		return poolMinSize;
	}

	public void setPoolMinSize(int poolMinSize) {
		this.poolMinSize = poolMinSize;
	}

	public int getPoolMaxSize() {
		return poolMaxSize;
	}

	public void setPoolMaxSize(int poolMaxSize) {
		this.poolMaxSize = poolMaxSize;
	}

	/**
	 * 连接池中最大的数量
	 */
	private int poolMaxSize;
	
	
	
	public Configuration(String dirver, String url, String user, String pwd, String usingDB, String srcPath,
			String poPackage) {
		super();
		this.dirver = dirver;
		this.url = url;
		this.user = user;
		this.pwd = pwd;
		this.usingDB = usingDB;
		this.srcPath = srcPath;
		this.poPackage = poPackage;
	}

	public Configuration() {
		super();
	}

	public String getDirver() {
		return dirver;
	}

	public void setDirver(String dirver) {
		this.dirver = dirver;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getUsingDB() {
		return usingDB;
	}

	public void setUsingDB(String usingDB) {
		this.usingDB = usingDB;
	}

	public String getSrcPath() {
		return srcPath;
	}

	public void setSrcPath(String srcPath) {
		this.srcPath = srcPath;
	}

	public String getPoPackage() {
		return poPackage;
	}

	public void setPoPackage(String poPackage) {
		this.poPackage = poPackage;
	}
}
