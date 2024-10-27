import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FocusTimer {
    private JFrame frame;
    private JLabel timeLabel;
    private JButton startButton;
    private Timer timer;

    private int workDuration = 25 * 60; // 25 minutos
    private int restDuration = 5 * 60;  // 5 minutos
    private int currentDuration;
    private boolean isWorking = true;   // Alterna entre trabalho e descanso

    public FocusTimer() {
        frame = new JFrame("Cronômetro de Tempo Focado");
        frame.setSize(300, 150);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        timeLabel = new JLabel("25:00", SwingConstants.CENTER);
        timeLabel.setFont(new Font("Arial", Font.BOLD, 40));
        frame.add(timeLabel, BorderLayout.CENTER);

        startButton = new JButton("Iniciar");
        startButton.addActionListener(new StartButtonListener());
        frame.add(startButton, BorderLayout.SOUTH);

        frame.setVisible(true);
    }

    private void startTimer() {
        currentDuration = isWorking ? workDuration : restDuration;
        timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (currentDuration > 0) {
                    currentDuration--;
                    updateTimeLabel();
                } else {
                    timer.stop();
                    isWorking = !isWorking;
                    adjustDurations();
                    startButton.setText("Próxima Sessão");
                    startButton.setEnabled(true);
                }
            }
        });
        timer.start();
        startButton.setEnabled(false);
    }

    private void adjustDurations() {
        if (isWorking) {
            workDuration = Math.min(workDuration + 60, 30 * 60);  // aumenta até 30 min
        } else {
            restDuration = Math.max(restDuration - 30, 3 * 60);   // reduz até 3 min
        }
    }

    private void updateTimeLabel() {
        int minutes = currentDuration / 60;
        int seconds = currentDuration % 60;
        timeLabel.setText(String.format("%02d:%02d", minutes, seconds));
    }

    private class StartButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            startTimer();
        }
    }

    public static void main(String[] args) {
        new FocusTimer();
    }
}
