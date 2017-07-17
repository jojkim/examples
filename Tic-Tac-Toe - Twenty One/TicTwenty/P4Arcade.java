//Main class for the project
public class P4Arcade{

	public static void main(String [] args){
		
		final MainMenu title = new MainMenu();

		javax.swing.SwingUtilities.invokeLater(new Runnable(){
			public void run(){
				title.buildMain();
			}
		});
	}
}
