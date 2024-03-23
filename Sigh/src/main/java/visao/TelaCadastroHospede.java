package visao;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JTextField;

public class TelaCadastroHospede extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCadastroHospede frame = new TelaCadastroHospede();
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
	public TelaCadastroHospede() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100,  1920, 1080);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\Aluno\\Desktop\\Repository-SIGH\\Sigh\\src\\main\\resources\\logo sigh.png"));
		lblNewLabel_1.setBounds(134, 44, 144, 176);
		contentPane.add(lblNewLabel_1);
		
		
		
		JLabel lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setIcon(new ImageIcon("C:\\Users\\Aluno\\Desktop\\Repository-SIGH\\Sigh\\src\\main\\resources\\menu hospedagem.png"));
		lblNewLabel_5.setBounds(68, 472, 150, 20);
		contentPane.add(lblNewLabel_5);
		
		
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\Aluno\\Desktop\\Repository-SIGH\\Sigh\\src\\main\\resources\\botao sair.png"));
		lblNewLabel_2.setBounds(84, 955, 263, 45);
		contentPane.add(lblNewLabel_2);
		
		
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon("C:\\Users\\Aluno\\Desktop\\Repository-SIGH\\Sigh\\src\\main\\resources\\menu pedidos.png"));
		lblNewLabel_3.setBounds(68, 346, 150, 20);
		contentPane.add(lblNewLabel_3);
		
		
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setIcon(new ImageIcon("C:\\Users\\Aluno\\Desktop\\Repository-SIGH\\Sigh\\src\\main\\resources\\menu - hospede.png"));
		lblNewLabel_4.setBounds(68, 407, 150, 20);
		contentPane.add(lblNewLabel_4);
		
		
		
		JLabel lblNewLabel_6 = new JLabel("");
		lblNewLabel_6.setIcon(new ImageIcon("C:\\Users\\Aluno\\Desktop\\Repository-SIGH\\Sigh\\src\\main\\resources\\menu funcionarios.png"));
		lblNewLabel_6.setBounds(68, 532, 150, 20);
		contentPane.add(lblNewLabel_6);
		
		
		
		JLabel lblNewLabel_7 = new JLabel("");
		lblNewLabel_7.setIcon(new ImageIcon("C:\\Users\\Aluno\\Desktop\\Repository-SIGH\\Sigh\\src\\main\\resources\\divisor (menu).png"));
		lblNewLabel_7.setBounds(77, 897, 243, 14);
		contentPane.add(lblNewLabel_7);
		
		
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(0, 0, 420, 1083);
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Aluno\\Desktop\\Repository-SIGH\\Sigh\\src\\main\\resources\\fundo cinza (menu).png"));
		contentPane.add(lblNewLabel);
		
		
		
		JLabel lblMenu = new JLabel("Menu");
		lblMenu.setForeground(new Color(128, 128, 128));
		lblMenu.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblMenu.setBounds(67, 289, 46, 14);
		contentPane.add(lblMenu);
		
		
		
		JLabel lblNewLabel_8 = new JLabel("");
		lblNewLabel_8.setIcon(new ImageIcon("C:\\Users\\Aluno\\Desktop\\Repository-SIGH\\Sigh\\src\\main\\resources\\Frame 675.png"));
		lblNewLabel_8.setBounds(420, 0, 1500, 62);
		contentPane.add(lblNewLabel_8);
		
		
		
		JLabel lblNewLabel_10 = new JLabel("Nome *");
		lblNewLabel_10.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_10.setBounds(554, 288, 55, 20);
		contentPane.add(lblNewLabel_10);
		
		
		
		textField = new JTextField();
		textField.setBounds(554, 326, 343, 48);
		contentPane.add(textField);
		textField.setColumns(10);
	
		
		
		JLabel lblNewLabel_11 = new JLabel("Gênero *");
		lblNewLabel_11.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_11.setBounds(554, 390, 100, 20);
		contentPane.add(lblNewLabel_11);
		
		
		
		textField = new JTextField();
		textField.setBounds(554, 415, 343, 48);
		contentPane.add(textField);
		textField.setColumns(11);
		
		
		
		JLabel lblNewLabel_12 = new JLabel("Nacionalidade *");
		lblNewLabel_12.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_12.setBounds(554, 480, 100, 20);
		contentPane.add(lblNewLabel_12);
		
		
		
		textField = new JTextField();
		textField.setBounds(554, 515, 343, 48);
		contentPane.add(textField);
		textField.setColumns(12);
		
		
		
		JLabel lblNewLabel_13 = new JLabel("Cep *");
		lblNewLabel_13.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_13.setBounds(554, 570, 100, 20);
		contentPane.add(lblNewLabel_13);
		
		
		
		textField = new JTextField();
		textField.setBounds(554, 615, 343, 48);
		contentPane.add(textField);
		textField.setColumns(13);
		
		
		JLabel lblNewLabel_14 = new JLabel("Endereço *");
		lblNewLabel_14.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_14.setBounds(554, 670, 100, 20);
		contentPane.add(lblNewLabel_14);
		
		
		
		textField = new JTextField();
		textField.setBounds(554, 715, 343, 48);
		contentPane.add(textField);
		textField.setColumns(14);
		
		
		
		JLabel lblNewLabel_15 = new JLabel("Telefone *");
		lblNewLabel_15.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_15.setBounds(554, 780, 100, 20);
		contentPane.add(lblNewLabel_15);
		
		
		
		textField = new JTextField();
		textField.setBounds(554, 815, 343, 48);
		contentPane.add(textField);
		textField.setColumns(15);
		
		
		
		JLabel lblNewLabel_16 = new JLabel("Necessidade Especial");
		lblNewLabel_16.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_16.setBounds(554, 870, 100, 20);
		contentPane.add(lblNewLabel_16);
		
		textField = new JTextField();
		textField.setBounds(554, 915, 343, 48);
		contentPane.add(textField);
		textField.setColumns(16);
		
		
		
		
		
		
		
		
		
		
		JLabel lblNewLabel_9 = new JLabel("");
		lblNewLabel_9.setIcon(new ImageIcon("C:\\Users\\Aluno\\Desktop\\Repository-SIGH\\Sigh\\src\\main\\resources\\Hero block.png"));
		lblNewLabel_9.setBounds(446, 108, 1455, 119);
		contentPane.add(lblNewLabel_9);
		
	}
}
