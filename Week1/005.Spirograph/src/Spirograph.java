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
        
        topBar.getChildren().add(v1 = new TextField("4.9"));
        topBar.getChildren().add(v2 = new TextField("1"));
        topBar.getChildren().add(v3 = new TextField("6.4"));
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


        float resolution = 0.001f;
        int scale = 35;


        for (float i = 0; i < 20; i+=resolution) {
            float x1 = formulaX(i);
            float x2 = x1 + resolution;
            float y1 = formulaY(i);
            float y2 = y1 + resolution;

            graphics.setColor(Color.getHSBColor(i, 1, 1));
            graphics.draw(new Line2D.Double(x1*scale,y1*scale,x2*scale,y2*scale));

        }

    }

    private float formulaX(float x){
        double parameter1 = Double.parseDouble(v1.getText());
        double parameter2 = Double.parseDouble(v2.getText());
        double parameter3 = Double.parseDouble(v3.getText());
        double parameter4 = Double.parseDouble(v4.getText());

       return (float)parameter1 * (float)Math.cos(parameter2 * x) + (float) parameter3  * (float)Math.cos(parameter4 * x);
    }

    private float formulaY(float y)
    {
        double parameter1 = Double.parseDouble(v1.getText());
        double parameter2 = Double.parseDouble(v2.getText());
        double parameter3 = Double.parseDouble(v3.getText());
        double parameter4 = Double.parseDouble(v4.getText());

        return ((float) parameter1 * (float)Math.sin(parameter2 * y)) + ((float) parameter3  * (float)Math.sin(parameter4 * y));
    }
    
    
    public static void main(String[] args) {
        launch(Spirograph.class);
    }

}
