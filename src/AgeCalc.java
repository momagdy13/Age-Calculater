import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.Period;


public class AgeCalc {
    private JPanel AgeCalc;
    private JTextField day_text;
    private JTextField month_text;
    private JTextField year_Text;
    private JButton calc_b;
    private JLabel result_text;
    private JTextField year_text;


    public AgeCalc() {
        calc_b.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (day_text.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Please fill out day", "MESSAGE", JOptionPane.ERROR_MESSAGE);
                } else if (month_text.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Please fill out Month", "MESSAGE", JOptionPane.ERROR_MESSAGE);
                } else if (year_text.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Please fill out Year", "MESSAGE", JOptionPane.ERROR_MESSAGE);
                } else {
                    int day = Integer.parseInt(day_text.getText());
                    int month = Integer.parseInt(month_text.getText());
                    int year = Integer.parseInt(year_text.getText());

                    if (day < 0 || day > 31) {
                        JOptionPane.showMessageDialog(null, "Day can't be in minus or more than 31", "MESSAGE", JOptionPane.ERROR_MESSAGE);
                    } else if (month < 0 || month > 12) {
                        JOptionPane.showMessageDialog(null, "Month can't be in minus or more than 12", "MESSAGE", JOptionPane.ERROR_MESSAGE);
                    } else if (year < 0) {
                        JOptionPane.showMessageDialog(null, "Year can't be in minus", "MESSAGE", JOptionPane.ERROR_MESSAGE);
                    } else {
                        LocalDate birthDay = LocalDate.of(year, month, day);
                        LocalDate now = LocalDate.now();

                        int period = Period.between(birthDay, now).getYears();
                        result_text.setText(period + "");

                    }
                }
            }


        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("AgeCalc");
        frame.setContentPane(new AgeCalc().AgeCalc);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setSize(600, 400);
        frame.setVisible(true);
    }
}
