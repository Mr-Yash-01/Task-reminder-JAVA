import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Timer;
import java.util.TimerTask;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;
import java.io.File;

//eye-30min
//water-40min
//phy-60min

public class miniproject {
    public static void main(String[] args) {

//        DECLARATION
//        -----------

        LocalTime o1 = LocalTime.now();
        DateTimeFormatter dtf1 = DateTimeFormatter.ofPattern("HH:mm:ss");
        virtualtimer t0 = new virtualtimer();


//        MAIN STUFF
//        ----------

        JOptionPane.showMessageDialog(null,"HEALTHY PROGRAMMER\n     to start press ok!!");
        JOptionPane.showMessageDialog(null,"It's "+o1.format(dtf1)+" now!!");
        char c='w';
        int e=90;

        t0.run1(5);
        t0.run1(10, c);
        t0.run1(15, e);


    }
}
class virtualtimer{
    Timer timer1 = new Timer();

    public void run1(int seconds) {
        timer1.schedule(new eyeex(), seconds * 1000);
    }
    public void run1(int seconds,char m) {
        timer1.schedule(new drinkwater(), seconds * 1000);
    }
    public void run1(int seconds,int y) {
        timer1.schedule(new phyex(), seconds * 1000);
    }
}


class eyeex extends TimerTask{


    musicstuff musicobj = new musicstuff();
    String filepath="ound.wav";

    public void run() {

        musicobj.eyeExMusic(filepath);

    }
}


class drinkwater extends TimerTask{

    String filepath="ound.wav";
    musicstuff musicobj = new musicstuff();

    public void run() {

        musicobj.drinkWaterMusic(filepath);

    }
}
class phyex extends TimerTask{

    String filepath="ound.wav";
    musicstuff musicobj = new musicstuff();

    public void run() {

        musicobj.phyExMusic(filepath);

    }
}



class musicstuff {

    LocalTime o2 = LocalTime.now();
    virtualtimer t0 = new virtualtimer();
    static int count=0;
    DateTimeFormatter dtf2 = DateTimeFormatter.ofPattern("HH:mm:ss");
    void eyeExMusic(String musicLocation) {
        try {
            File musicPath = new File(musicLocation);
            if (musicPath.exists()) {
                AudioInputStream audioInput = AudioSystem.getAudioInputStream(musicPath);
                Clip clip = AudioSystem.getClip();
                clip.open(audioInput);
                clip.start();
                clip.loop(Clip.LOOP_CONTINUOUSLY);
                String t1 = "Healthy Programmer";
                JOptionPane.showMessageDialog(null, "Plzz distract your eyes.....\n       It's "+o2.format(dtf2)+" now!!",t1,1);
                clip.stop();
            } else {
                System.out.println("cant find file");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        if(count==1||count==4||count==7||count==10||count==13){
            count++;
            t0.run1(10, 'c');
        }
    }

    void drinkWaterMusic(String musicLocation) {
        try {
            File musicPath = new File(musicLocation);
            if (musicPath.exists()) {
                AudioInputStream audioInput = AudioSystem.getAudioInputStream(musicPath);
                Clip clip = AudioSystem.getClip();
                clip.open(audioInput);
                clip.start();
                clip.loop(Clip.LOOP_CONTINUOUSLY);
                String t1="Healthy Programmer";
                JOptionPane.showMessageDialog(null, "plzz drink some water.....\n      It's "+o2.format(dtf2)+" now!!",t1,1);
                clip.stop();
            } else {
                System.out.println("cant find file");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        if (count==2||count==5||count==8||count==11||count==14){
            count++;
            t0.run1(15,1);
        }
    }

    void phyExMusic(String musicLocation) {

        try {
            File musicPath = new File(musicLocation);
            if (musicPath.exists()) {
                AudioInputStream audioInput = AudioSystem.getAudioInputStream(musicPath);
                Clip clip = AudioSystem.getClip();
                clip.open(audioInput);
                clip.start();
                clip.loop(Clip.LOOP_CONTINUOUSLY);
                String t1="Healthy Programmer";
                JOptionPane.showMessageDialog(null, "time to relax.....\n      It's "+o2.format(dtf2)+" now!!",t1,1);
                clip.stop();
            } else {
                System.out.println("cant find file");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        if(count==0||count==3||count==6||count==9||count==12){
            count++;
            t0.run1(5);
        }
        if(count==15){
            System.out.println("Made by Shraddha-21DCS070");
        }
    }
}