import org.lwjgl.LWJGLException;
import org.lwjgl.Sys;
import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;


public class TutorialLWJGL00021 {

	String windowTitle = "CG[LWJGL0002] | Membuat Jendela OpenGL";
	public boolean closeRequested = false;
	
	public void run() {
		createWindow();
		initGL();
		
		// main loop
		while (!closeRequested) {
			pollInput();
			updateLogic();
			renderGL();
			Display.update();
		}
		
		cleanup();
	}
	
	private void initGL() {

	}
	
	private void updateLogic() {
		
	}
	
	private void renderGL() {

	}
	
	public void pollInput() {

		// scroll through key events
		while (Keyboard.next()) {
			if (Keyboard.getEventKeyState()) {
				if (Keyboard.getEventKey() == Keyboard.KEY_ESCAPE)
					closeRequested = true;
			}
		}
		
		if (Display.isCloseRequested()) {
			closeRequested = true;
		}
	}
	
	private void createWindow() {
		try {
			Display.setDisplayMode(new DisplayMode(640, 480));
			Display.setVSyncEnabled(true);
			Display.setTitle(windowTitle);
			Display.create();
		} catch (LWJGLException e) {
			Sys.alert("Error", "Initialization failed!\n\n" + e.getMessage());
			System.exit(0);
		}
	}
	
	private void cleanup() {
		Display.destroy();
	}
	
	public static void main(String[] args) {
		TutorialLWJGL00021 tutorial = new TutorialLWJGL00021();
		tutorial.run();
	}

}
