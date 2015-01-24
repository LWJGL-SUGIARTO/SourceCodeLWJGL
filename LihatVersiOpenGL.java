import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.GL11;

public class LihatVersiOpenGL {

	public void initGl()
	{
		try {
			Display.create();
			System.out.println("OpenGL version: " + GL11.glGetString(GL11.GL_VERSION));
			System.out.println("OpenGL renderer: " + GL11.glGetString(GL11.GL_RENDERER));
			System.out.println("OpenGL vendor: " + GL11.glGetString(GL11.GL_VENDOR));
		}
		catch (LWJGLException e) {
			System.out.println("error");
			e.printStackTrace();
			System.exit(-1);
		}
	}

	public static void main(String[] args) {
		LihatVersiOpenGL tv= new LihatVersiOpenGL();
		tv.initGl();
	}

}
