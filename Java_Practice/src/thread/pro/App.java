package thread.pro;

public class App {
	public static void main(String[] args) {
		
		//共同资源 movie
		Movie movie=new Movie();
		Player player=new Player(movie);
		Watcher watcher=new Watcher(movie);
		
		new Thread(player).start();
		new Thread(watcher).start();
	}
}
