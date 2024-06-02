package lvt;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;

public class EndFrame extends JFrame {
	private PointManager pointManager;

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PointManager pointManager = new PointManager();
					EndFrame frame = new EndFrame(pointManager);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public EndFrame(PointManager pointManager) {
		this.pointManager = pointManager;
		
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 480);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnStart = new JButton("Mēģināt velreiz");
		btnStart.setBackground(new Color(255, 255, 255));
		btnStart.setForeground(new Color(61, 148, 150));
		btnStart.setFont(new Font("Cherry Bomb One", Font.PLAIN, 22));
		btnStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SecondFrame jf2 = new SecondFrame(pointManager);
				jf2.show();
				dispose();
			}
		});
		btnStart.setBounds(566, 306, 208, 58);
		contentPane.add(btnStart);
		
		JButton btnQuit = new JButton("Quit");
		btnQuit.setBackground(new Color(255, 255, 255));
		btnQuit.setForeground(new Color(61, 148, 150));
		btnQuit.setFont(new Font("Cherry Bomb One", Font.PLAIN, 22));
		btnQuit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnQuit.setBounds(566, 375, 208, 58);
		contentPane.add(btnQuit);
		
		JLabel lblPoints = new JLabel("Jūs pareizi atbildējāt uz "+ pointManager.getPoints()+ " jautājumiem!");
		lblPoints.setForeground(Color.WHITE);
		lblPoints.setFont(new Font("Cherry Bomb One", Font.PLAIN, 28));
		lblPoints.setBounds(10, 74, 661, 45);
		contentPane.add(lblPoints);
		
		JLabel lblNewLabel = new JLabel("Rezultāts");
		lblNewLabel.setFont(new Font("Cherry Bomb One", Font.PLAIN, 35));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBounds(320, 11, 163, 45);
		contentPane.add(lblNewLabel);
		
		// Display incorrect questions
        List<Integer> incorrectQuestions = pointManager.getIncQuestions();
        StringBuilder incorrectQuestionsText = new StringBuilder("Incorrect Questions: ");
        for (int question : incorrectQuestions) {
            incorrectQuestionsText.append(question).append("), ");
        }
		
		JLabel lblIncQuestions = new JLabel("" + incorrectQuestionsText);
		lblIncQuestions.setForeground(Color.WHITE);
		lblIncQuestions.setFont(new Font("Cherry Bomb One", Font.PLAIN, 28));
		lblIncQuestions.setBounds(10, 130, 764, 45);
		contentPane.add(lblIncQuestions);
		
		JLabel Background = new JLabel("");
		Background.setBounds(-192, -236, 1920, 1080);
		Background.setIcon(new ImageIcon("Background3.jpg"));
		contentPane.add(Background);
	}
}
