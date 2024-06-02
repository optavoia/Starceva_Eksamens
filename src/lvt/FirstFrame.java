package lvt;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;

public class FirstFrame extends JFrame {
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
					FirstFrame frame = new FirstFrame(pointManager);
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
	public FirstFrame(PointManager pointManager) {
		
		ImageIcon background = new ImageIcon(getClass().getClassLoader().getResource("Background3.jpg"));
		
		setResizable(false);
		this.pointManager = pointManager;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 480);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnStart = new JButton("Start");
		btnStart.setBackground(new Color(255, 255, 255));
		btnStart.setForeground(new Color(61, 148, 150));
		btnStart.setFont(new Font("Cherry Bomb One", Font.PLAIN, 22));
		btnStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Points: "+ pointManager.getPoints());
				SecondFrame jf2 = new SecondFrame(pointManager);
				jf2.show();
				dispose();
			}
		});
		btnStart.setBounds(310, 179, 163, 58);
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
		btnQuit.setBounds(310, 262, 163, 58);
		contentPane.add(btnQuit);
		
		JLabel lblNewLabel = new JLabel("Laipni aicināti uz testu");
		lblNewLabel.setFont(new Font("Cherry Bomb One", Font.PLAIN, 35));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBounds(206, 34, 383, 45);
		contentPane.add(lblNewLabel);
		
		JLabel lblviendimensijuMasviProgrammanas = new JLabel("\"Viendimensiju masīvi programmēšanas");
		lblviendimensijuMasviProgrammanas.setForeground(Color.WHITE);
		lblviendimensijuMasviProgrammanas.setFont(new Font("Cherry Bomb One", Font.PLAIN, 35));
		lblviendimensijuMasviProgrammanas.setBounds(69, 71, 641, 45);
		contentPane.add(lblviendimensijuMasviProgrammanas);
		
		JLabel lblValodJava = new JLabel("valodā Java\"!");
		lblValodJava.setForeground(Color.WHITE);
		lblValodJava.setFont(new Font("Cherry Bomb One", Font.PLAIN, 35));
		lblValodJava.setBounds(288, 110, 226, 45);
		contentPane.add(lblValodJava);
		
		JLabel Background1 = new JLabel("");
		Background1.setBounds(-192, -236, 1920, 1080);
		contentPane.add(Background1);
		Background1.setIcon(background);
		
	}
}
