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

public class InfoFrame extends JFrame {
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
					InfoFrame frame = new InfoFrame(pointManager);
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
	public InfoFrame(PointManager pointManager) {
		
		ImageIcon background = new ImageIcon(getClass().getClassLoader().getResource("Background3.jpg"));
		ImageIcon box = new ImageIcon(getClass().getClassLoader().getResource("gray1.jpg"));
		
		setResizable(false);
		this.pointManager = pointManager;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 480);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnStart = new JButton("To main menu");
		btnStart.setBackground(new Color(255, 255, 255));
		btnStart.setForeground(new Color(61, 148, 150));
		btnStart.setFont(new Font("Cherry Bomb One", Font.PLAIN, 22));
		btnStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FirstFrame jf1 = new FirstFrame(pointManager);
				jf1.show();
				dispose();
			}
		});
		btnStart.setBounds(285, 288, 205, 58);
		contentPane.add(btnStart);
		
		JLabel lblPrbaudIr = new JLabel("Testā ir 10 jautājumi, katram jautājumam");
		lblPrbaudIr.setForeground(Color.WHITE);
		lblPrbaudIr.setFont(new Font("Dialog", Font.PLAIN, 32));
		lblPrbaudIr.setBounds(111, 98, 574, 68);
		contentPane.add(lblPrbaudIr);
		
		JLabel lblValodJava = new JLabel("ir 4 iespējamās atbildes, no kurām");
		lblValodJava.setForeground(Color.WHITE);
		lblValodJava.setFont(new Font("Dialog", Font.PLAIN, 32));
		lblValodJava.setBounds(165, 142, 479, 75);
		contentPane.add(lblValodJava);
		
		JLabel lblVai = new JLabel("2 vai 3 ir pareizas.");
		lblVai.setForeground(Color.WHITE);
		lblVai.setFont(new Font("Dialog", Font.PLAIN, 32));
		lblVai.setBounds(267, 189, 263, 75);
		contentPane.add(lblVai);
		
		JLabel GrayBox = new JLabel("");
        GrayBox.setIcon(box);
        GrayBox.setBounds(59, 86, 658, 191);
        contentPane.add(GrayBox);
		
		JLabel Background1 = new JLabel("");
		Background1.setBounds(-178, -225, 1920, 1080);
		contentPane.add(Background1);
		Background1.setIcon(background);
		
	}
}
