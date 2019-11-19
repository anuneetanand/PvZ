package sample;


import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.DragEvent;
import javafx.scene.input.MouseEvent;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import javafx.fxml.FXML;
import javafx.scene.input.TransferMode;


public class GameController extends Click
{

    public ImageView abc;

    @FXML
    public void Pause(MouseEvent mouseEvent) throws IOException { Main.setRoot_PauseMenu(); }

    public void HandleDragOver(DragEvent dragEvent)
    {
        if (dragEvent.getDragboard().hasFiles()){
            dragEvent.acceptTransferModes(TransferMode.ANY);
        }
    }

    public void HandleDropped(DragEvent dragEvent) throws FileNotFoundException {
        List<File> files = dragEvent.getDragboard().getFiles();
        Image I = new Image(new FileInputStream(files.get(0)));
        abc.setImage(I);
    }
}
