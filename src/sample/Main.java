package sample;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.text.Font;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main extends Application {
    Stage window;
    Scene scene;
    Text textField;
    String randomLetter;
    String randomLatin;
    String randomVehicle;
    File txt;
    Scanner scan;
    ArrayList<String> data;
    Random rand;
    String[] simpleArray;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage){

        //Window Details

        window = primaryStage;
        window.setTitle("Tesla Lunch Break");
        window.setResizable(false);

        //Layout
        VBox mainMenu = new VBox(3);

        //Components
        Label lblHeader = new Label("Elon Knows Your Babe Best");
        Button btnGen = new Button("Generate");
        textField = new Text();

        //Styling
        btnGen.setFont(new Font("Helvetica", 20));
        mainMenu.setSpacing(50);
        lblHeader.setFont(new Font("Helvetica", 30));
        mainMenu.setFillWidth(false);
        mainMenu.maxWidth(80);
        mainMenu.setAlignment(Pos.CENTER);
        textField.setStyle(
                "-fx-font-size : 30;" +
                "-fx-text-alignment: center;"
        );

        //Children
        mainMenu.getChildren().addAll(lblHeader, btnGen, textField);

        //Actions
        btnGen.setOnAction(ActionEvent -> {
            try {
                randomLetter();
                randomLatin();
                randomVehicle();
            } catch (FileNotFoundException e){
                e.printStackTrace();
            }
            textField.setText(randomLetter + " " + randomLatin + " " + randomVehicle);
        });

        scene = new Scene(mainMenu, 500, 400);
        window.setScene(scene);
        window.show();

    }

    private void randomLetter() throws FileNotFoundException {
        txt = new File("C:\\Users\\user-pc\\Documents\\Programming\\java\\Musk Machine\\src\\sample\\letters.txt");
        scan = new Scanner(txt);
        data= new ArrayList<String>();
        while (scan.hasNextLine()){
            data.add(scan.nextLine());
        }
        simpleArray = data.toArray(new String[]{});
        rand = new Random();
        randomLetter = data.get(rand.nextInt(data.size()));
    }

    private void randomLatin() throws FileNotFoundException {
        txt = new File("C:\\Users\\user-pc\\Documents\\Programming\\java\\Musk Machine\\src\\sample\\jets.txt");
        scan = new Scanner(txt);
        data= new ArrayList<>();
        while (scan.hasNext()) {
            String[] tokens = scan.nextLine().split(" ");
            String last = tokens[tokens.length - 1];
            last = last.replaceAll("\\s+", "");
            data.add(last);
        }
        simpleArray = data.toArray(new String[]{});
        rand = new Random();
        randomLatin = data.get(rand.nextInt(data.size()));
    }

    private void randomVehicle() throws FileNotFoundException {
        txt = new File("C:\\Users\\user-pc\\Documents\\Programming\\java\\Musk Machine\\src\\sample\\jets.txt");
        scan = new Scanner(txt);
        data= new ArrayList<>();
        while (scan.hasNext()) {
            String[] tokens = scan.nextLine().split(" ");
            String last = tokens[tokens.length - 1];
            last = last.replaceAll("\\s+", "");
            data.add(last);
        }
        simpleArray = data.toArray(new String[]{});
        rand = new Random();
        randomVehicle = data.get(rand.nextInt(data.size()));
    }
}
