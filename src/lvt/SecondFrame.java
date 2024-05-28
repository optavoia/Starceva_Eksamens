package lvt;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SecondFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public JCheckBox cb1, cb2 , cb3, cb4;
	public int points;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SecondFrame frame = new SecondFrame();
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
	public SecondFrame() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 480);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//CheckBoxes
		cb1 = new JCheckBox("int[] array = new int[5];");
		cb1.setFont(new Font("Cherry Bomb One", Font.PLAIN, 25));
		cb1.setForeground(new Color(255, 255, 255));
		cb1.setBounds(236, 168, 321, 43);
		cb1.setOpaque(false);
		contentPane.add(cb1);
		
		cb2 = new JCheckBox("int array = new int[5];");
		cb2.setOpaque(false);
		cb2.setForeground(Color.WHITE);
		cb2.setFont(new Font("Cherry Bomb One", Font.PLAIN, 25));
		cb2.setBounds(236, 214, 297, 39);
		contentPane.add(cb2);
		
		cb3 = new JCheckBox("int array[] = new int[5];");
		cb3.setOpaque(false);
		cb3.setForeground(Color.WHITE);
		cb3.setFont(new Font("Cherry Bomb One", Font.PLAIN, 25));
		cb3.setBounds(236, 256, 321, 38);
		contentPane.add(cb3);
		
		cb4 = new JCheckBox("int[] array = new int();");
		cb4.setOpaque(false);
		cb4.setForeground(Color.WHITE);
		cb4.setFont(new Font("Cherry Bomb One", Font.PLAIN, 25));
		cb4.setBounds(236, 301, 305, 38);
		contentPane.add(cb4);
		
		JButton btnNewButton = new JButton("Submit");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean isCorrect = cb1.isSelected() && cb3.isSelected()
                        && !cb2.isSelected() && !cb4.isSelected();
    
		    if (isCorrect) {
		    	points++;
		    } else {
		    	points += 0;
		    }
		    
		    ThirdFrame jf3 = new ThirdFrame(); //open form 2
			//display form 2
			jf3.show();
			//close current form after opening form 2
			dispose();
			
			}
		});
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.setForeground(new Color(61, 148, 150));
		btnNewButton.setFont(new Font("Cherry Bomb One", Font.PLAIN, 22));
		btnNewButton.setBounds(298, 375, 178, 55);
		contentPane.add(btnNewButton);
		
		JLabel GrayBox = new JLabel("");
		GrayBox.setIcon(new ImageIcon("D:\\Bum\\Starceva_Eksamens\\gray1.jpg"));
		GrayBox.setBounds(59, 161, 674, 191);
		contentPane.add(GrayBox);
		
		JLabel lblText = new JLabel("skaitļu masīvu Java?");
		lblText.setForeground(Color.WHITE);
		lblText.setFont(new Font("Cherry Bomb One", Font.PLAIN, 35));
		lblText.setBounds(223, 53, 349, 97);
		contentPane.add(lblText);
		
		JLabel lblText2 = new JLabel("Kā izveidot viendimensiju veselu");
		lblText2.setForeground(new Color(255, 255, 255));
		lblText2.setFont(new Font("Cherry Bomb One", Font.PLAIN, 35));
		lblText2.setBounds(145, 11, 525, 97);
		contentPane.add(lblText2);
		
		JLabel Background = new JLabel("");
		Background.setForeground(new Color(255, 255, 255));
		Background.setBounds(0, 0, 784, 441);
		Background.setIcon(new ImageIcon("D:\\Bum\\Starceva_Eksamens\\Background3.jpg"));
		contentPane.add(Background);
	}
}
