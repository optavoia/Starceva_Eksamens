package lvt;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.ActionEvent;

public class Frame4 extends JFrame {
	private PointManager pointManager;
	private int questionNumber = 3;

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public JCheckBox cb1, cb2 , cb3, cb4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PointManager pointManager = new PointManager();
					Frame4 frame = new Frame4(pointManager);
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
	public Frame4(PointManager pointManager) {
		setResizable(false);
		this.pointManager = pointManager;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 480);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		cb1 = new JCheckBox("Arrays.sort(array);");
		cb1.setOpaque(false);
		cb1.setForeground(Color.WHITE);
		cb1.setFont(new Font("Cherry Bomb One", Font.PLAIN, 25));
		cb1.setBounds(213, 185, 321, 43);
		contentPane.add(cb1);
		
		cb2 = new JCheckBox("array.sort();");
		cb2.setOpaque(false);
		cb2.setForeground(Color.WHITE);
		cb2.setFont(new Font("Cherry Bomb One", Font.PLAIN, 25));
		cb2.setBounds(212, 225, 297, 39);
		contentPane.add(cb2);
		
		cb3 = new JCheckBox("Collections.sort(Arrays.asList(array));");
		cb3.setOpaque(false);
		cb3.setForeground(Color.WHITE);
		cb3.setFont(new Font("Cherry Bomb One", Font.PLAIN, 25));
		cb3.setBounds(213, 266, 512, 38);
		contentPane.add(cb3);
		
		cb4 = new JCheckBox("sort(array);");
		cb4.setOpaque(false);
		cb4.setForeground(Color.WHITE);
		cb4.setFont(new Font("Cherry Bomb One", Font.PLAIN, 25));
		cb4.setBounds(213, 306, 305, 38);
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
		
		JLabel lblText2 = new JLabel("Kādu metodi var izmantot");
		lblText2.setForeground(Color.WHITE);
		lblText2.setFont(new Font("Cherry Bomb One", Font.PLAIN, 35));
		lblText2.setBounds(179, 11, 546, 97);
		contentPane.add(lblText2);
		
		JLabel lblText = new JLabel("masīva kārtošanai?");
		lblText.setForeground(Color.WHITE);
		lblText.setFont(new Font("Cherry Bomb One", Font.PLAIN, 35));
		lblText.setBounds(234, 47, 313, 97);
		contentPane.add(lblText);
		
		JButton btnSub = new JButton("Submit");
		btnSub.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean isCorrect = cb1.isSelected() && cb3.isSelected()
                        && !cb2.isSelected() && !cb4.isSelected();
				 if (isCorrect) {
					 pointManager.addPoints(1);
				 } else {
					 pointManager.addIncQuestion(questionNumber);
				 }
				    
				 Frame5 jf5 = new Frame5(pointManager);
				 jf5.show();
				 dispose();
					
					}
			});
		
		btnSub.setForeground(new Color(61, 148, 150));
		btnSub.setFont(new Font("Cherry Bomb One", Font.PLAIN, 22));
		btnSub.setBackground(Color.WHITE);
		btnSub.setBounds(288, 375, 178, 55);
		contentPane.add(btnSub);
		
		JLabel lblText2_1 = new JLabel("3)");
        lblText2_1.setForeground(Color.WHITE);
        lblText2_1.setFont(new Font("Cherry Bomb One", Font.PLAIN, 35));
        lblText2_1.setBounds(735, -24, 525, 97);
        contentPane.add(lblText2_1);
		
		JLabel GrayBox = new JLabel("");
		GrayBox.setIcon(new ImageIcon("gray1.jpg"));
		GrayBox.setBackground(Color.LIGHT_GRAY);
		GrayBox.setBounds(10, 173, 764, 191);
		contentPane.add(GrayBox);
		
		JLabel Background = new JLabel("");
		Background.setIcon(new ImageIcon("Background3.jpg"));
		Background.setBounds(0, 0, 784, 441);
		contentPane.add(Background);
	}

}
