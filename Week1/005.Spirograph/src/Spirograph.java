import java.awt.*;
import java.awt.geom.*;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.jfree.fx.FXGraphics2D;

public class Spirograph extends Application {
    private TextField v1;
    private TextField v2;
    private TextField v3;
    private TextField v4;
    
    @Override
    public void start(Stage primaryStage) throws Exception {
        Canvas canvas = new Canvas(1920, 1080);
       
        VBox mainBox = new VBox();
        HBox topBar = new HBox();
        mainBox.getChildren().add(topBar);
        mainBox.getChildren().add(new Group(canvas));
        
        topBar.getChildren().add(v1 = new TextField("300"));
        topBar.getChildren().add(v2 = new TextField("1"));
        topBar.getChildren().add(v3 = new TextField("300"));
        topBar.getChildren().add(v4 = new TextField("10"));
                
        v1.textProperty().addListener(e -> draw(new FXGraphics2D(canvas.getGraphicsContext2D())));
        v2.textProperty().addListener(e -> draw(new FXGraphics2D(canvas.getGraphicsContext2D())));
        v3.textProperty().addListener(e -> draw(new FXGraphics2D(canvas.getGraphicsContext2D())));
        v4.textProperty().addListener(e -> draw(new FXGraphics2D(canvas.getGraphicsContext2D())));
        
        draw(new FXGraphics2D(canvas.getGraphicsContext2D()));
        primaryStage.setScene(new Scene(mainBox));
        primaryStage.setTitle("Spirograph");
        primaryStage.show();
    }
    
    
    public void draw(FXGraphics2D graphics) {
        //you can use Double.parseDouble(v1.getText()) to get a double value from the first textfield
        //feel free to add more textfields or other controls if needed, but beware that swing components might clash in naming

        graphics.translate(960, 540);
        graphics.scale(1,-1);
        float resolution = 0.01f;
        float scale = 50f;

        for (float i = 0; i < 1500; i+=resolution) {
            float x1 = formulaX(i);
            float x2 = x1 + resolution;
            float y1 = formulaY(i);
            float y2 = y1 + resolution;

            graphics.setColor(Color.getHSBColor(i, 1, 1));
            graphics.draw(new Line2D.Float(x1*scale,y1*scale,x2*scale,y2*scale));
        }
    }

    private float formulaX(float x){

       return 4.0f * (float)Math.cos(6.7 * x) + 4.6f  * (float)Math.cos(2.5 * x);
    }

    private float formulaY(float y)
    {
        return 4.0f * (float)Math.cos(8.7 * y) + 4.6f  * (float)Math.cos(8.5 * y);
    }
    
    
    public static void main(String[] args) {
        launch(Spirograph.class);
    }

}
