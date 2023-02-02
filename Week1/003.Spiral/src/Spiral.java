import java.awt.*;
import java.awt.geom.*;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.stage.Stage;
import org.jfree.fx.FXGraphics2D;

public class Spiral extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        Canvas canvas = new Canvas(1920, 1080);
        draw(new FXGraphics2D(canvas.getGraphicsContext2D()));
        primaryStage.setScene(new Scene(new Group(canvas)));
        primaryStage.setTitle("Spiral");
        primaryStage.show();
    }
    
    
    public void draw(FXGraphics2D graphics) {

        graphics.translate(960, 540);
        graphics.scale(1, -1);

        float resolution = 0.001f;
        float scale = 10;

        for (float i = 0; i < 1000; i+=resolution) {
            float x1 = formulaX(i);
            float x2 = x1 + resolution;
            float y1 = formulaY(i);
            float y2 = y1 + resolution;

            graphics.draw(new Line2D.Double(x1* scale, y1* scale,x2*scale, y2*scale ));
        }

    }
    
    
    public static void main(String[] args) {
        launch(Spiral.class);
    }

    private float formulaX(float x){

        float n = 0.25f;
        return n * x * (float)Math.cos(x);
    }

    private float formulaY(float y){
        float n = 0.25f;
        return n * y * (float)Math.sin(y);
    }

}
