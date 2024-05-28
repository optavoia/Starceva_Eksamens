package lvt;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ThirdFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ThirdFrame frame = new ThirdFrame();
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
	public ThirdFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 480);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JCheckBox cb1 = new JCheckBox("int[] array = {1, 2, 3, 4, 5};");
		cb1.setOpaque(false);
		cb1.setForeground(Color.WHITE);
		cb1.setFont(new Font("Cherry Bomb One", Font.PLAIN, 25));
		cb1.setBounds(239, 169, 357, 43);
		contentPane.add(cb1);
		
		JCheckBox cb2 = new JCheckBox("int array[] = new int[]{1, 2, 3, 4, 5};");
		cb2.setOpaque(false);
		cb2.setForeground(Color.WHITE);
		cb2.setFont(new Font("Cherry Bomb One", Font.PLAIN, 25));
		cb2.setBounds(239, 213, 475, 39);
		contentPane.add(cb2);
		
		JCheckBox cb3 = new JCheckBox("int[] array = new int[5]{1, 2, 3, 4, 5};");
		cb3.setOpaque(false);
		cb3.setForeground(Color.WHITE);
		cb3.setFont(new Font("Cherry Bomb One", Font.PLAIN, 25));
		cb3.setBounds(239, 255, 479, 38);
		contentPane.add(cb3);
		
		JCheckBox cb4 = new JCheckBox("int array = {1, 2, 3, 4, 5};");
		cb4.setOpaque(false);
		cb4.setForeground(Color.WHITE);
		cb4.setFont(new Font("Cherry Bomb One", Font.PLAIN, 25));
		cb4.setBounds(239, 299, 333, 38);
		contentPane.add(cb4);
		
		JLabel lblText2 = new JLabel("Kā inicializēt masīvu ar vērtībām,");
		lblText2.setForeground(Color.WHITE);
		lblText2.setFont(new Font("Cherry Bomb One", Font.PLAIN, 35));
		lblText2.setBounds(140, 11, 546, 97);
		contentPane.add(lblText2);
		
		JLabel lblText = new JLabel("to deklarējot?");
		lblText.setForeground(Color.WHITE);
		lblText.setFont(new Font("Cherry Bomb One", Font.PLAIN, 35));
		lblText.setBounds(277, 51, 239, 97);
		contentPane.add(lblText);
		
		JButton btnNewButton = new JButton("Submit");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean isCorrect = cb1.isSelected() && cb2.isSelected()
                        && !cb3.isSelected() && !cb4.isSelected();
    
		    if (isCorrect) {
		        System.out.println("User selected the correct answers.");
		    } else {
		        System.out.println("User did not select the correct answers");
		    }
			}
		});
		btnNewButton.setForeground(new Color(61, 148, 150));
		btnNewButton.setFont(new Font("Cherry Bomb One", Font.PLAIN, 22));
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.setBounds(302, 375, 178, 55);
		contentPane.add(btnNewButton);
		
		JLabel GrayBox = new JLabel("");
		GrayBox.setIcon(new ImageIcon("D:\\Bum\\Starceva_Eksamens\\gray1.jpg"));
		GrayBox.setBackground(new Color(192, 192, 192));
		GrayBox.setBounds(58, 159, 674, 191);
		contentPane.add(GrayBox);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("D:\\Bum\\Starceva_Eksamens\\Background3.jpg"));
		lblNewLabel.setBounds(0, 0, 784, 441);
		contentPane.add(lblNewLabel);
	}
}
