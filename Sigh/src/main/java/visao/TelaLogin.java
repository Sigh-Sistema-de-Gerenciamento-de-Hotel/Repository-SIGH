package visao;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import visao.padrao.RoundJFormattedTextField;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Font;
import javax.swing.text.MaskFormatter;

public class TelaLogin extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_0;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaLogin frame = new TelaLogin();
					frame.setVisible(true);
					
					frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TelaLogin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1920, 1080);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(234, 234, 234));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon("src/main/resources/pessoa no login.png"));
		lblNewLabel_2.setBounds(892, 158, 150, 150);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("src/main/resources/Heading.png"));
		lblNewLabel_1.setBounds(906, 343, 150, 40);
		contentPane.add(lblNewLabel_1);
		
		textField_0 = new RoundJFormattedTextField(null);
		textField_0.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				textField.setText("");
			}
		});
		textField_0.setForeground(new Color(102, 112, 133));
		textField_0.setText("       Digite seu usuário");
		textField_0.setBounds(682, 486, 547, 64);
		contentPane.add(textField_0);
		textField_0.setColumns(10);
		textField = new RoundJFormattedTextField(null);
		textField_0.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				textField_0.setText("");
				
			}
		});
		textField.setBounds(682, 486, 547, 64);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("USUÁRIO *");
		lblNewLabel_3.setForeground(new Color(52, 64, 84));
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_3.setBounds(682, 460, 80, 14);
		contentPane.add(lblNewLabel_3);
		
		RoundJFormattedTextField textField_1 = new RoundJFormattedTextField((MaskFormatter) null);
		textField_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				textField_1.setText("");
			}
			
		});
		textField_1.setText("       Digite sua senha");
		textField_1.setForeground(new Color(102, 112, 133));
		textField_1.setColumns(10);
		textField_1.setBounds(682, 615, 547, 64);
		contentPane.add(textField_1);
		
		JLabel lblNewLabel_3_1 = new JLabel("SENHA *");
		lblNewLabel_3_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_3_1.setBounds(682, 590, 80, 14);
		contentPane.add(lblNewLabel_3_1);
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblNewLabel_4.setIcon(new ImageIcon("src/main/resources/mostrar senha preto.png"));
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				lblNewLabel_4.setIcon(new ImageIcon("src/main/resources/mostrar senha claro.png"));
			}
		});
		lblNewLabel_4.setIcon(new ImageIcon("src/main/resources/mostrar senha preto.png"));
		lblNewLabel_4.setBounds(687, 698, 200, 10);
		contentPane.add(lblNewLabel_4);
		
		
		
		JLabel lblNewLabel_6 = new JLabel("");
		lblNewLabel_6.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblNewLabel_6.setIcon(new ImageIcon("src/main/resources/botao entrar.png"));
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				lblNewLabel_6.setIcon(new ImageIcon("src/main/resources/Frame 670.png"));
			}
		});
		lblNewLabel_6.setIcon(new ImageIcon("src/main/resources/botao entrar.png"));
		lblNewLabel_6.setBounds(781, 803, 359, 59);
		contentPane.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Funcionários");
		lblNewLabel_7.setForeground(new Color(102, 112, 133));
		lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_7.setBounds(920, 401, 90, 30);
		contentPane.add(lblNewLabel_7);
		
		JLabel lblNewLabel = new JLabel(" ");
		lblNewLabel.setForeground(new Color(52, 64, 84));
		lblNewLabel.setIcon(new ImageIcon("src/main/resources/fundo verde.png"));
		lblNewLabel.setBounds(584, 95, 751, 895);
		contentPane.add(lblNewLabel);
		
		
	}
}
