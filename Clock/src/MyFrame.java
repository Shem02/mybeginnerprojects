import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class MyFrame extends JFrame{

Calendar calendar;
SimpleDateFormat timeFormat;
    SimpleDateFormat dayFormat;
    SimpleDateFormat dateFormat;
JLabel timeLabel;
    JLabel dayLabel;
    JLabel dateLabel;
    String time;
    String day;
    String date;

    MyFrame() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("DIGITAL CLOCK");
        this.setLayout(new FlowLayout());
        this.setSize(350,200);
        this.setResizable(true);

        timeFormat =new SimpleDateFormat("hh:mm:ss a" );
        dayFormat =new SimpleDateFormat("EEEE" );
        dateFormat =new SimpleDateFormat("MMMM dd, yyyy" );


        timeLabel = new JLabel();
        timeLabel.setFont(new Font("Comic San MS",Font.PLAIN, 50));
        timeLabel.setForeground(new Color(0x00FF00));
        timeLabel.setBackground(Color.BLACK);
        timeLabel.setOpaque(true);

        dayLabel = new JLabel();
        dayLabel.setFont(new Font("Century Schoolbook",Font.PLAIN,35));
        dayLabel.setForeground(Color.BLUE);
        dayLabel.setBackground(Color.BLACK);
        timeLabel.setOpaque(true);

        dateLabel = new JLabel();
        dateLabel.setFont(new Font("Century Schoolbook",Font.PLAIN,25));


        this.add(timeLabel);
        this.add(dayLabel);
        this.add(dateLabel);
        this.setVisible(true);

        setTime();
    }

    private void setTime () {
        while (true) {
            time = timeFormat.format(Calendar.getInstance().getTime());
            timeLabel.setText(time);

            day = dayFormat.format(Calendar.getInstance().getTime());
            dayLabel.setText(day);

            date = dateFormat.format(Calendar.getInstance().getTime());
            dateLabel.setText(date);


            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }
    }




}
