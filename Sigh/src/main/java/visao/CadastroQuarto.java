package visao;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import visao.padrao.RoundJFormattedTextField;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import java.awt.Font;

public class CadastroQuarto extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_5;
	private JLabel lblNewLabel_6;
	private JLabel lblNewLabel_7;
	private JLabel lblNewLabel_8;
	private JLabel lblNewLabel_9;
	private JLabel lblNewLabel_10;
	private JLabel lblNewLabel_11;
	private JLabel lblNewLabel_12;
	private JLabel lblNewLabel_13;
	private JLabel lblNewLabel_14;
	private JLabel lblNewLabel_15;
	private JLabel lblNewLabel_16;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastroQuarto frame = new CadastroQuarto();
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
	public CadastroQuarto() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1920, 1080);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblNewLabel_16 = new JLabel("");
		lblNewLabel_16.setIcon(new ImageIcon("C:\\Users\\Aluno\\Desktop\\Repository-SIGH\\Sigh\\src\\main\\resources\\logo sigh.png"));
		lblNewLabel_16.setBounds(135, 42, 144, 176);
		contentPane.add(lblNewLabel_16);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\Aluno\\Desktop\\Repository-SIGH\\Sigh\\src\\main\\resources\\Cadastrar Quartos.png"));
		lblNewLabel_1.setBounds(446, 108, 1455, 126);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Aluno\\Desktop\\Repository-SIGH\\Sigh\\src\\main\\resources\\fundo cinza (menu).png"));
		lblNewLabel.setBounds(0, 0, 420, 1080);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\Aluno\\Desktop\\Repository-SIGH\\Sigh\\src\\main\\resources\\superior pequeno quartos.png"));
		lblNewLabel_2.setBounds(408, 0, 1512, 62);
		contentPane.add(lblNewLabel_2);
		
		textField =  new RoundJFormattedTextField(null);
		textField.setBounds(491, 313, 343, 48);
		contentPane.add(textField);
		textField.setColumns(10);
	
		
		textField_1 =  new RoundJFormattedTextField(null);
		textField_1.setBounds(491, 442, 343, 48);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 =  new RoundJFormattedTextField(null);
		textField_2.setBounds(491, 579, 343, 48);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 =  new RoundJFormattedTextField(null);
		textField_3.setColumns(10);
		textField_3.setBounds(491, 705, 343, 48);
		contentPane.add(textField_3);
		
		textField_4 =  new RoundJFormattedTextField(null);
		textField_4.setColumns(10);
		textField_4.setBounds(1017, 313, 343, 48);
		contentPane.add(textField_4);
		
		textField_5 =  new RoundJFormattedTextField(null);
		textField_5.setColumns(10);
		textField_5.setBounds(1017, 442, 343, 48);
		contentPane.add(textField_5);
		
		textField_6 =  new RoundJFormattedTextField(null);
		textField_6.setColumns(10);
		textField_6.setBounds(1017, 579, 343, 48);
		contentPane.add(textField_6);
		
		textField_7 = new RoundJFormattedTextField(null);
		textField_7.setColumns(10);
		textField_7.setBounds(1017, 705, 343, 48);
		contentPane.add(textField_7);
		
		textField_8 =  new RoundJFormattedTextField(null);
		textField_8.setColumns(10);
		textField_8.setBounds(1506, 313, 343, 48);
		contentPane.add(textField_8);
		
		textField_9 =  new RoundJFormattedTextField(null);
		textField_9.setColumns(10);
		textField_9.setBounds(1506, 442, 343, 48);
		contentPane.add(textField_9);
		
		lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon("C:\\Users\\Aluno\\Desktop\\Repository-SIGH\\Sigh\\src\\main\\resources\\botao cancelar.png"));
		lblNewLabel_3.setBounds(1682, 931, 140, 40);
		contentPane.add(lblNewLabel_3);
		
		textField_10 = new RoundJFormattedTextField(null);
		textField_10.setColumns(10);
		textField_10.setBounds(1506, 579, 343, 48);
		contentPane.add(textField_10);
		
		lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setIcon(new ImageIcon("C:\\Users\\Aluno\\Desktop\\Repository-SIGH\\Sigh\\src\\main\\resources\\botao salvar.png"));
		lblNewLabel_4.setBounds(1310, 928, 292, 54);
		contentPane.add(lblNewLabel_4);
		
		lblNewLabel_5 = new JLabel("Número do Quarto ");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_5.setBounds(491, 289, 120, 20);
		contentPane.add(lblNewLabel_5);
		
		lblNewLabel_6 = new JLabel("Cama Casal");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_6.setBounds(491, 411, 120, 20);
		contentPane.add(lblNewLabel_6);
		
		lblNewLabel_7 = new JLabel("Cama Solteiro");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_7.setBounds(491, 548, 120, 20);
		contentPane.add(lblNewLabel_7);
		
		lblNewLabel_8 = new JLabel("Número de óspedes");
		lblNewLabel_8.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_8.setBounds(491, 674, 150, 20);
		contentPane.add(lblNewLabel_8);
		
		lblNewLabel_9 = new JLabel("Ar-Condicionado");
		lblNewLabel_9.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_9.setBounds(1017, 282, 120, 20);
		contentPane.add(lblNewLabel_9);
		
		lblNewLabel_10 = new JLabel("Frigobar");
		lblNewLabel_10.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_10.setBounds(1017, 411, 120, 20);
		contentPane.add(lblNewLabel_10);
		
		lblNewLabel_11 = new JLabel("Banheira");
		lblNewLabel_11.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_11.setBounds(1017, 548, 120, 20);
		contentPane.add(lblNewLabel_11);
		
		lblNewLabel_12 = new JLabel("Acessibilidade");
		lblNewLabel_12.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_12.setBounds(1017, 674, 120, 20);
		contentPane.add(lblNewLabel_12);
		
		lblNewLabel_13 = new JLabel("Limpeza");
		lblNewLabel_13.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_13.setBounds(1506, 282, 120, 20);
		contentPane.add(lblNewLabel_13);
		
		lblNewLabel_14 = new JLabel("Conserto");
		lblNewLabel_14.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_14.setBounds(1506, 411, 120, 20);
		contentPane.add(lblNewLabel_14);
		
		lblNewLabel_15 = new JLabel("Preço");
		lblNewLabel_15.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_15.setBounds(1506, 548, 120, 20);
		contentPane.add(lblNewLabel_15);
	}
}
