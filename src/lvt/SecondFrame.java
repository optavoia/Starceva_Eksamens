package lvt;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.*;

public class SecondFrame extends JFrame {
	
	private PointManager pointManager;
	private int questionNumber = 1;

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
					SecondFrame frame = new SecondFrame(pointManager);
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
	public SecondFrame(PointManager pointManager) {
		ImageIcon background = new ImageIcon(getClass().getClassLoader().getResource("Background3.jpg"));
		ImageIcon box = new ImageIcon(getClass().getClassLoader().getResource("gray1.jpg"));
		
		this.pointManager = pointManager;
		
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 800, 480);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

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

        //Prevents from 4 selected options
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
                    JOptionPane.showMessageDialog(contentPane, "Lūdzu, izdariet izvēli",
                    		"Kļūda", JOptionPane.ERROR_MESSAGE);
                } else {
                boolean isCorrect = cb1.isSelected() && cb3.isSelected()
                        && !cb2.isSelected() && !cb4.isSelected();
                
                pointManager.resetPoints();

                if (isCorrect) {
                	pointManager.addPoints(1);
                }else {
                	pointManager.addIncQuestion(questionNumber);
                }

                ThirdFrame jf3 = new ThirdFrame(pointManager); //open frame3
                jf3.setVisible(true); //show frame3
                dispose(); //close previous frame
                }
            }
        });

        btnSub.setBackground(Color.WHITE);
        btnSub.setForeground(new Color(61, 148, 150));
        btnSub.setFont(new Font("Cherry Bomb One", Font.PLAIN, 22));
        btnSub.setBounds(298, 375, 178, 55);
        contentPane.add(btnSub);

        JLabel GrayBox = new JLabel("");
        GrayBox.setIcon(box);
        GrayBox.setBounds(10, 161, 764, 191);
        contentPane.add(GrayBox);

        JLabel lblText = new JLabel("skaitļu masīvu Java?");
        lblText.setForeground(Color.WHITE);
        lblText.setFont(new Font("Cherry Bomb One", Font.PLAIN, 35));
        lblText.setBounds(223, 53, 349, 97);
        contentPane.add(lblText);
        
        JLabel lblText2_1 = new JLabel("1)");
        lblText2_1.setForeground(Color.WHITE);
        lblText2_1.setFont(new Font("Cherry Bomb One", Font.PLAIN, 35));
        lblText2_1.setBounds(735, -24, 525, 97);
        contentPane.add(lblText2_1);

        JLabel lblText2 = new JLabel("Kā izveidot viendimensiju veselu");
        lblText2.setForeground(new Color(255, 255, 255));
        lblText2.setFont(new Font("Cherry Bomb One", Font.PLAIN, 35));
        lblText2.setBounds(145, 11, 525, 97);
        contentPane.add(lblText2);

        JLabel Background = new JLabel("");
        Background.setForeground(new Color(255, 255, 255));
        Background.setBounds(0, 0, 784, 441);
        Background.setIcon(background);
        contentPane.add(Background);
    }
}
