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

public class YingYang extends Application {
    private ResizableCanvas canvas;

    @Override
    public void start(Stage primaryStage) throws Exception
    {
        BorderPane mainPane = new BorderPane();
        canvas = new ResizableCanvas(g -> draw(g), mainPane);
        mainPane.setCenter(canvas);
        primaryStage.setScene(new Scene(mainPane));
        primaryStage.setTitle("Ying Yang");
        primaryStage.show();
        draw(new FXGraphics2D(canvas.getGraphicsContext2D()));
    }


    public void draw(FXGraphics2D graphics)
    {
        graphics.setTransform(new AffineTransform());
        graphics.setBackground(Color.white);
        graphics.clearRect(0, 0, (int) canvas.getWidth(), (int) canvas.getHeight());

        Area rectangle = new Area(new Rectangle2D.Double(325, 0, 400, 600));

        Area a = new Area(new Ellipse2D.Double(75,0,500,500));
        Area intersect = new Area(rectangle);
        intersect.intersect(a);

        Area c = new Area(new Ellipse2D.Double(200,0, 250,250));
        Area d = new Area(new Ellipse2D.Double(200,250, 250,250));
        Area e = new Area(new Ellipse2D.Double(300,90, 50,50));
        Area f = new Area(new Ellipse2D.Double(300,370, 50,50));


        graphics.setColor(Color.black);
        graphics.fill(d);
        graphics.fill(intersect);

        graphics.setColor(Color.white);
        graphics.fill(c);
        graphics.fill(f);

        graphics.setColor(Color.black);
        graphics.fill(e);
        graphics.draw(a);
    }


    public static void main(String[] args)
    {
        launch(YingYang.class);
    }

}
