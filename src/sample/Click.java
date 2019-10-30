package sample;

import javafx.scene.effect.Glow;
import javafx.scene.effect.InnerShadow;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import java.io.File;
import java.net.MalformedURLException;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;

public class Click
{
    private  boolean SoundCheck;
    private  MediaPlayer SoundPlayer;

    public Click()
    {
        SoundCheck = false;
        try
        {
            File audioFile = new File("ClickSound.mp3");
            Media Sound = new Media(audioFile.toURI().toURL().toString());
            SoundPlayer = new MediaPlayer(Sound);
            SoundPlayer.setStartTime(new Duration(1000));
            SoundPlayer.setStopTime(new Duration((1100)));
            SoundPlayer.setOnEndOfMedia(() -> SoundPlayer.stop());
         }
        catch (MalformedURLException e)
        { System.out.println("No Audio File Found"); }
    }

    private void PlayClickSound() {SoundPlayer.play();}

    public void Glow(MouseEvent mouseEvent)
    {
        if (!SoundCheck){ PlayClickSound(); SoundCheck = true;}
        ImageView I = (ImageView) mouseEvent.getSource();
        Glow G = new Glow(0.75);
        I.setEffect(G);
    }

    public void RemoveGlow(MouseEvent mouseEvent)
    {
        ImageView I = (ImageView) mouseEvent.getSource();
        InnerShadow IS= new InnerShadow();
        IS.setChoke(0.5);
        IS.setHeight(30.0);
        IS.setRadius(10.0);
        IS.setWidth(30.0);
        I.setEffect(IS);
        SoundCheck = false;
    }
}
