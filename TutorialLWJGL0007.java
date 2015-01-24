import org.lwjgl.LWJGLException;
import org.lwjgl.Sys;
import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.GL11;
import org.lwjgl.util.glu.GLU;


public class TutorialLWJGL0007 {

	String windowTitle = "CG[LWJGL0007] || Rotasi";
	public boolean closeRequested = false;
	
	long lastFrameTime; // digunakan untuk menghitung delta
	float triangleAngle; // sudut rotasi untuk segi tiga
	float quadAngle; // sudut rotasi untuk segi empat
	
	public void run() {
		createWindow();
		getDelta();
		initializeGL();
		
		// main loop
		while (!closeRequested) {
			pollInput();
			updateLogic(getDelta());
			renderGL();
			Display.update();
		}
		
		cleanup();
	}
	
	private void initializeGL() {
		int width = Display.getDisplayMode().getWidth();
		int height = Display.getDisplayMode().getHeight();

		GL11.glViewport(0, 0, width, height); // Reset The Current Viewport
		GL11.glMatrixMode(GL11.GL_PROJECTION); // Select The Projection Matrix
		GL11.glLoadIdentity(); // Reset The Projection Matrix
		GLU.gluPerspective(45.0f, ((float) width / (float) height), 0.1f, 100.0f); // Calculate The Aspect Ratio Of The Window
		GL11.glMatrixMode(GL11.GL_MODELVIEW); // Select The Modelview Matrix
		GL11.glLoadIdentity(); // Reset The Modelview Matrix

		GL11.glShadeModel(GL11.GL_SMOOTH); // Enables Smooth Shading
		GL11.glClearColor(0.20392156862f, 0.59607843137f, 0.85882352941f, 0.0f);
		GL11.glClearDepth(1.0f); // Depth Buffer Setup
		GL11.glEnable(GL11.GL_DEPTH_TEST); // Enables Depth Testing
		GL11.glDepthFunc(GL11.GL_LEQUAL); // The Type Of Depth Test To Do
		GL11.glHint(GL11.GL_PERSPECTIVE_CORRECTION_HINT, GL11.GL_NICEST); // Really Nice Perspective Calculations
	}
	
	private void updateLogic(int delta) {
		triangleAngle += 0.1f * delta; // memperbesar variabel sudut rotasi triangleAngle
		quadAngle -= 0.15f * delta; // memperkecil variabel sudut rotasi quadAngle
	}
	
	private void renderGL() {
		GL11.glClear(GL11.GL_COLOR_BUFFER_BIT | GL11.GL_DEPTH_BUFFER_BIT); // Clear The Screen And The Depth Buffer		
		GL11.glLoadIdentity(); // Reset The View
		GL11.glTranslatef(-1.5f, 0.0f, -6.0f);
		GL11.glRotatef(triangleAngle, 0.0f, 1.0f, 0.0f); // Rotate The Triangle On The Y axis
		
		GL11.glBegin(GL11.GL_TRIANGLES); // Drawing Using Triangles
		GL11.glColor3f(231.0f/255.0f, 76.0f/255.0f, 60.0f/255.0f);
		GL11.glVertex3f(0.0f, 1.0f, 0.0f); // Top
		GL11.glColor3f(80.0f/255.0f, 46.0f/255.0f, 204.0f/255.0f);
		GL11.glVertex3f(-1.0f, -1.0f, 0.0f); // Bottom Left
		GL11.glColor3f(241.0f/255.0f, 196.0f/255.0f, 15.0f/255.0f);
		GL11.glVertex3f(1.0f, -1.0f, 0.0f); // Bottom Right
		GL11.glEnd(); // Finished Drawing The Triangle
		
		GL11.glLoadIdentity(); // Reset The Current Modelview Matrix
		
		//GL11.glTranslatef(3.0f, 0.0f, 0.0f); // Move Right 3 Units
		GL11.glTranslatef(1.5f, 0.0f, -6.0f); //
		GL11.glRotatef(quadAngle, 1.0f, 0.0f, 0.0f); // Rotate The Quad On The X axis
		
		GL11.glBegin(GL11.GL_QUADS); // Draw A Quad
		GL11.glColor3f(243.0f/255.0f, 156.0f/255.0f, 18.0f/255.0f);
		GL11.glVertex3f(-1.0f, 1.0f, 0.0f); // Top Left
		GL11.glColor3f(211.0f/255.0f, 84.0f/255.0f, 0.0f/255.0f);
		GL11.glVertex3f(1.0f, 1.0f, 0.0f); // Top Right
		GL11.glColor3f(192.0f/255.0f, 57.0f/255.0f, 43.0f/255.0f);
		GL11.glVertex3f(1.0f, -1.0f, 0.0f); // Bottom Right
		GL11.glColor3f(39.0f/255.0f, 174.0f/255.0f, 96.0f/255.0f);
		GL11.glVertex3f(-1.0f, -1.0f, 0.0f); // Bottom Left
		GL11.glEnd(); // Done Drawing The Quad
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
	
	/** 
	 * hitung berapa millisecon aplikasi dijalankan 
	 * 
	 * @return milliseconds passed since last frame 
	 */
	public int getDelta() {
	    long time = (Sys.getTime() * 1000) / Sys.getTimerResolution();
	    int delta = (int) (time - lastFrameTime);
	    lastFrameTime = time;	 
	    return delta;
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
		TutorialLWJGL0007 tutorial = new TutorialLWJGL0007();
		tutorial.run();
	}

}
