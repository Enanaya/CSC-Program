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
	 * ������
	 */
	private String dirver;

	/**
	 * jdbc��url
	 */
	private String url;
	/**
	 * ���ݿ���û���
	 */
	private String user;
	/**
	 * ���ݿ������
	 */
	private String pwd;
	/**
	 * ����ʹ���ĸ����ݿ�
	 */
	private String usingDB;
	/**
	 * ��Ŀ��Դ��·��
	 */
	private String srcPath;
	/**
	 * ɨ������java��İ�,po=persistence object �־û�����
	 */
	private String poPackage;

	/**
	 * ��Ŀʹ�õĲ�ѯ���·������һ����
	 */
	private String queryClass;
	
	public String getQueryClass() {
		return queryClass;
	}

	public void setQueryClass(String queryClass) {
		this.queryClass = queryClass;
	}

	/**
	 * ���ӳ�����С������
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
	 * ���ӳ�����������
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
