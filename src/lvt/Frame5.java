package lvt;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class Frame5 extends JFrame {
	private PointManager pointManager;
	private int questionNumber = 4;

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
					PointManager pointManager = new PointManager();
					Frame5 frame = new Frame5(pointManager);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	private int getSelectedCheckboxCount() {
        int count = 0;
        if (cb1.isSelected()) count++;
        if (cb2.isSelected()) count++;
        if (cb3.isSelected()) count++;
        if (cb4.isSelected()) count++;
        return count;
    }

	/**
	 * Create the frame.
	 */
	public Frame5(PointManager pointManager) {
		this.pointManager = pointManager;
		
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 480);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//CheckBoxes
		cb1 = new JCheckBox("int[] newArray = array.clone();");
		cb1.setFont(new Font("Cherry Bomb One", Font.PLAIN, 25));
		cb1.setForeground(new Color(255, 255, 255));
		cb1.setBounds(236, 168, 401, 43);
		cb1.setOpaque(false);
		contentPane.add(cb1);
		
		cb2 = new JCheckBox("int[] newArray = Arrays.copyOf(array, array.length);");
		cb2.setOpaque(false);
		cb2.setForeground(Color.WHITE);
		cb2.setFont(new Font("Cherry Bomb One", Font.PLAIN, 25));
		cb2.setBounds(53, 214, 674, 39);
		contentPane.add(cb2);
		
		cb3 = new JCheckBox("int[] newArray = array;");
		cb3.setOpaque(false);
		cb3.setForeground(Color.WHITE);
		cb3.setFont(new Font("Cherry Bomb One", Font.PLAIN, 25));
		cb3.setBounds(236, 256, 321, 38);
		contentPane.add(cb3);
		
		cb4 = new JCheckBox("System.arraycopy(array, 0, newArray, 0, array.length);");
		cb4.setOpaque(false);
		cb4.setForeground(Color.WHITE);
		cb4.setFont(new Font("Cherry Bomb One", Font.PLAIN, 25));
		cb4.setBounds(53, 297, 691, 43);
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
		
		JButton btnSub = new JButton("Submit");
		btnSub.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (getSelectedCheckboxCount() == 0) {
                    JOptionPane.showMessageDialog(contentPane, "Lūdzu, izdariet izvēli", "Kļūda", JOptionPane.ERROR_MESSAGE);
                } else {
				boolean isCorrect = cb1.isSelected() && cb2.isSelected() 
                        && !cb3.isSelected() && cb4.isSelected();
    
			    if (isCorrect) {
			    	pointManager.addPoints(1);
			    } else {
			    	pointManager.addIncQuestion(questionNumber);
			    }
			 
			    Frame6 jf6 = new Frame6(pointManager);
				jf6.show();
				dispose();
                }
			}
		});
		btnSub.setBackground(Color.WHITE);
		btnSub.setForeground(new Color(61, 148, 150));
		btnSub.setFont(new Font("Cherry Bomb One", Font.PLAIN, 22));
		btnSub.setBounds(298, 375, 178, 55);
		contentPane.add(btnSub);
		
		JLabel GrayBox = new JLabel("");
		GrayBox.setIcon(new ImageIcon("gray1.jpg"));
		GrayBox.setBounds(10, 161, 764, 191);
		contentPane.add(GrayBox);
		
		JLabel lblText = new JLabel("masīvā newArray?");
		lblText.setForeground(Color.WHITE);
		lblText.setFont(new Font("Cherry Bomb One", Font.PLAIN, 35));
		lblText.setBounds(259, 54, 349, 97);
		contentPane.add(lblText);
		
		JLabel lblText2_1 = new JLabel("4)");
        lblText2_1.setForeground(Color.WHITE);
        lblText2_1.setFont(new Font("Cherry Bomb One", Font.PLAIN, 35));
        lblText2_1.setBounds(735, -24, 525, 97);
        contentPane.add(lblText2_1);
		
		JLabel lblText2 = new JLabel("Kā var kopēt masīvu jaunā");
		lblText2.setForeground(new Color(255, 255, 255));
		lblText2.setFont(new Font("Cherry Bomb One", Font.PLAIN, 35));
		lblText2.setBounds(190, 11, 431, 97);
		contentPane.add(lblText2);
		
		JLabel Background = new JLabel("");
		Background.setForeground(new Color(255, 255, 255));
		Background.setBounds(0, 0, 784, 441);
		Background.setIcon(new ImageIcon("Background3.jpg"));
		contentPane.add(Background);
	}

}
