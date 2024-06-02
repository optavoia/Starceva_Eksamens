package lvt;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.ActionEvent;

public class ThirdFrame extends JFrame {
	private PointManager pointManager;
	private int questionNumber = 2;

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public JCheckBox cb1, cb2 , cb3, cb4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				PointManager pointManager = new PointManager();
				try {
					ThirdFrame frame = new ThirdFrame(pointManager);
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
	
	private int getSelectedCheckboxCount() {
        int count = 0;
        if (cb1.isSelected()) count++;
        if (cb2.isSelected()) count++;
        if (cb3.isSelected()) count++;
        if (cb4.isSelected()) count++;
        return count;
    }
	
	public ThirdFrame(PointManager pointManager) {
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
		
		cb1 = new JCheckBox("int[] array = {1, 2, 3, 4, 5};");
		cb1.setOpaque(false);
		cb1.setForeground(Color.WHITE);
		cb1.setFont(new Font("Cherry Bomb One", Font.PLAIN, 25));
		cb1.setBounds(201, 167, 357, 43);
		contentPane.add(cb1);
		
		cb2 = new JCheckBox("int array[] = new int[]{1, 2, 3, 4, 5};");
		cb2.setOpaque(false);
		cb2.setForeground(Color.WHITE);
		cb2.setFont(new Font("Cherry Bomb One", Font.PLAIN, 25));
		cb2.setBounds(201, 216, 475, 39);
		contentPane.add(cb2);
		
		cb3 = new JCheckBox("int[] array = new int[5]{1, 2, 3, 4, 5};");
		cb3.setOpaque(false);
		cb3.setForeground(Color.WHITE);
		cb3.setFont(new Font("Cherry Bomb One", Font.PLAIN, 25));
		cb3.setBounds(201, 260, 479, 38);
		contentPane.add(cb3);
		
		cb4 = new JCheckBox("int array = {1, 2, 3, 4, 5};");
		cb4.setOpaque(false);
		cb4.setForeground(Color.WHITE);
		cb4.setFont(new Font("Cherry Bomb One", Font.PLAIN, 25));
		cb4.setBounds(201, 301, 333, 38);
		contentPane.add(cb4);
		
		ItemListener itemListener = new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    if (getSelectedCheckboxCount() > 3) {
                        ((JCheckBox) e.getSource()).setSelected(false);
                    }
                }
            }
        };
        
        cb1.addItemListener(itemListener);
        cb2.addItemListener(itemListener);
        cb3.addItemListener(itemListener);
        cb4.addItemListener(itemListener);
        
        JLabel lblText2_1 = new JLabel("2)");
        lblText2_1.setForeground(Color.WHITE);
        lblText2_1.setFont(new Font("Cherry Bomb One", Font.PLAIN, 35));
        lblText2_1.setBounds(735, -24, 525, 97);
        contentPane.add(lblText2_1);
		
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
		
		JButton btnSub = new JButton("Submit");
		btnSub.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (getSelectedCheckboxCount() == 0) {
                    JOptionPane.showMessageDialog(contentPane, "Lūdzu, izdariet izvēli", "Kļūda", JOptionPane.ERROR_MESSAGE);
                } else {
				boolean isCorrect = cb1.isSelected() && cb2.isSelected()
                        && !cb3.isSelected() && !cb4.isSelected();
    
				if (isCorrect) {
                	pointManager.addPoints(1);
                }else {
                	pointManager.addIncQuestion(questionNumber);
                }
			    
			    Frame4 jf4 = new Frame4(pointManager);
				jf4.show();
				dispose();
				
				}
			}
		});
		btnSub.setForeground(new Color(61, 148, 150));
		btnSub.setFont(new Font("Cherry Bomb One", Font.PLAIN, 22));
		btnSub.setBackground(Color.WHITE);
		btnSub.setBounds(302, 375, 178, 55);
		contentPane.add(btnSub);
		
		JLabel GrayBox = new JLabel("");
		GrayBox.setIcon(box);
		GrayBox.setBackground(new Color(192, 192, 192));
		GrayBox.setBounds(10, 159, 764, 191);
		contentPane.add(GrayBox);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(background);
		lblNewLabel.setBounds(0, 0, 784, 441);
		contentPane.add(lblNewLabel);
	}
}
