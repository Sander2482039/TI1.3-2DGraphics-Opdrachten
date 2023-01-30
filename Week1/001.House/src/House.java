import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.stage.Stage;
import org.jfree.fx.FXGraphics2D;

import java.awt.geom.Line2D;

public class House extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        Canvas canvas = new Canvas(1920, 1080);
        draw(new FXGraphics2D(canvas.getGraphicsContext2D()));
        primaryStage.setScene(new Scene(new Group(canvas)));
        primaryStage.setTitle("House");
        primaryStage.show();
    }


    public void draw(FXGraphics2D graphics) {
            //basis huis
            graphics.draw(new Line2D.Double(920, 100, 720, 300));
            graphics.draw(new Line2D.Double(920, 100, 1120, 300));
            graphics.draw(new Line2D.Double(1120,300,1120,600));
            graphics.draw(new Line2D.Double(720,300,720,600));
            graphics.draw(new Line2D.Double(720,600,1120,600));
            //deur
            graphics.draw(new Line2D.Double(770,600,770,475));
            graphics.draw(new Line2D.Double(850,600,850,475));
            graphics.draw(new Line2D.Double(770,475,850,475));
            //raam
            graphics.draw(new Line2D.Double(920,575,1100,575));
            graphics.draw(new Line2D.Double(920,460,1100,460));
            graphics.draw(new Line2D.Double(920,575,920,460));
            graphics.draw(new Line2D.Double(1100,575,1100,460));

    }



    public static void main(String[] args) {
        launch(House.class);
    }

}
