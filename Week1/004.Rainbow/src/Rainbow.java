import java.awt.*;
import java.awt.geom.*;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.stage.Stage;
import org.jfree.fx.FXGraphics2D;

public class Rainbow extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        Canvas canvas = new Canvas(1920, 1080);
        draw(new FXGraphics2D(canvas.getGraphicsContext2D()));
        primaryStage.setScene(new Scene(new Group(canvas)));
        primaryStage.setTitle("Rainbow");
        primaryStage.show();
    }
    
    
    public void draw(FXGraphics2D graphics) {
        graphics.translate(960,540);
        graphics.scale(1,-1);

        int scale = 1;

        float radiusBinnen = 300;
        float radiusBuiten = radiusBinnen + 10;

        for(float i = 0; i < 500; i++) {

            float x1 = radiusBinnen * (float)Math.cos(i);
            float y1 = radiusBinnen * (float)Math.sin(i);
            float x2 = radiusBuiten * (float)Math.cos(i);
            float y2 = radiusBuiten * (float)Math.sin(i);

            graphics.setColor(Color.getHSBColor(i/500.0f, 1, 1));
            graphics.draw(new Line2D.Float(x1,y1,x2,y2));
        }
    }
    
    
    
    public static void main(String[] args) {
        launch(Rainbow.class);
    }

}
