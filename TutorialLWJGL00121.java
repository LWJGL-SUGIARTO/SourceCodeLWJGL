import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import static org.lwjgl.opengl.GL11.*;
  
public class TutorialLWJGL00121 {
  
    public void start() {
        try {
        Display.setDisplayMode(new DisplayMode(800,600));
        Display.setTitle("CG[LWJGL0012] || Quad_static-import");
        Display.create();
    } catch (LWJGLException e) {
        e.printStackTrace();
        System.exit(0);
    }
  
    // init OpenGL
    glMatrixMode(GL_PROJECTION);
    glLoadIdentity();
    glOrtho(0, 800, 0, 600, 1, -1);
    glMatrixMode(GL_MODELVIEW);
  
    while (!Display.isCloseRequested()) {
        // Clear the screen and depth buffer
        glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);  
         
        // set the color of the quad (R,G,B,A)
        glColor3f(0.5f,0.5f,1.0f);
             
        // draw quad
        glBegin(GL_QUADS);
        glVertex2f(100,100);
        glVertex2f(100+200,100);
        glVertex2f(100+200,100+200);
        glVertex2f(100,100+200);
        glEnd();
  
        Display.update();
    }
  
    Display.destroy();
    }
  
    public static void main(String[] argv) {
    	TutorialLWJGL00121 quadExample = new TutorialLWJGL00121();
        quadExample.start();
    }
}