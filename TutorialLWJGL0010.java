import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
 
public class TutorialLWJGL0010 {
    public void start() {
        try {
            Display.setDisplayMode(new DisplayMode(800,600));
            Display.setTitle("CG[LWJGL0010] || The Display");
            Display.create();
        } catch (LWJGLException e) {
            e.printStackTrace();
            System.exit(0);
        }
         
        // init OpenGL here
         
        while (!Display.isCloseRequested()) {
             
            // render OpenGL here
             
            Display.update();
        }
         
        Display.destroy();
    }
     
    public static void main(String[] argv) {
        TutorialLWJGL0010 displayExample = new TutorialLWJGL0010();
        displayExample.start();
    }
}