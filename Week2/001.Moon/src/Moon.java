import java.awt.*;
import java.awt.geom.*;

import javafx.application.Application;

import static javafx.application.Application.launch;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import org.jfree.fx.FXGraphics2D;
import org.jfree.fx.ResizableCanvas;

public class Moon extends Application {
    private ResizableCanvas canvas;

    @Override
    public void start(Stage primaryStage) throws Exception
    {
        BorderPane mainPane = new BorderPane();
        canvas = new ResizableCanvas(g -> draw(g), mainPane);
        mainPane.setCenter(canvas);
        primaryStage.setScene(new Scene(mainPane));
        primaryStage.setTitle("Moon");
        primaryStage.show();
        draw(new FXGraphics2D(canvas.getGraphicsContext2D()));
    }


    public void draw(FXGraphics2D graphics)
    {
        graphics.setTransform(new AffineTransform());
        graphics.setBackground(Color.white);
        graphics.clearRect(0, 0, (int) canvas.getWidth(), (int) canvas.getHeight());
//background
        GeneralPath path = new GeneralPath();
        path.moveTo(10,10);
        path.lineTo(600,10);
        path.lineTo(600,600);
        path.lineTo(10,600);
        path.lineTo(10,10);

        //moon
        Area a = new Area(new Ellipse2D.Double(60,50,300,300));
        Area b = new Area(new Ellipse2D.Double(140,60,300,300));

        Area subtract = new Area(b);
        subtract.subtract(a);

        Area intersect = new Area(a);
        intersect.intersect(b);

        graphics.setColor(Color.black);
        graphics.fill(path);
        graphics.fill(a);
        graphics.fill(intersect);

        graphics.setColor(Color.yellow);
        graphics.fill(subtract);
    }


    public static void main(String[] args)
    {
        launch(Moon.class);
    }

}
