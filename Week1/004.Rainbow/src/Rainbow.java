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

        float scale = (float) Math.PI;
        float resolution = 0.0001f;
        float radiusBinnen = 350;
        float radiusBuiten = radiusBinnen + 100.0f;
        float rainbowlimit = 0.0f;

        for(float i = 0.0f; i < 500.0f; i+=resolution) {

            float x1 = radiusBinnen * (float)Math.cos(i * scale);
            float y1 = radiusBinnen * (float)Math.sin(i * scale);
            float x2 = radiusBuiten * (float)Math.cos(i * scale);
            float y2 = radiusBuiten * (float)Math.sin(i * scale);

            graphics.setColor(Color.getHSBColor(i, 1, 1));
            graphics.drawLine((int) x1 ,(int) y1 ,(int) x2 ,(int) y2 );

            rainbowlimit++;
            if (isRainbow(rainbowlimit)){
                break;
            }
        }
    }

    private boolean isRainbow(float value){
        if (value == 10000){
            return true;
        }else return false;
    }

    public static void main(String[] args) {
        launch(Rainbow.class);
    }

}
