package visao;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JComboBox;

public class TelaCadastroHospedagem extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private final JLabel lblMenu = new JLabel("");
	private JTextField txtDataCheckin;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCadastroHospedagem frame = new TelaCadastroHospedagem();
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
	public TelaCadastroHospedagem() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1179, 912);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblBotaoFuncionarios = new JLabel("");
		lblBotaoFuncionarios.setIcon(new ImageIcon("C:\\Users\\Aluno\\Desktop\\Repository-SIGH\\Sigh\\src\\main\\resources\\menu funcionarios.png"));
		lblBotaoFuncionarios.setBounds(67, 525, 295, 38);
		contentPane.add(lblBotaoFuncionarios);
		
		JLabel lblSimboloSigh = new JLabel("");
		lblSimboloSigh.setIcon(new ImageIcon("C:\\Users\\Aluno\\Desktop\\Repository-SIGH\\Sigh\\src\\main\\resources\\logo sigh.png"));
		lblSimboloSigh.setBounds(130, 35, 161, 182);
		contentPane.add(lblSimboloSigh);
		
		JLabel lblMenuEscrita = new JLabel("Menu");
		lblMenuEscrita.setForeground(Color.GRAY);
		lblMenuEscrita.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblMenuEscrita.setBounds(67, 286, 42, 14);
		contentPane.add(lblMenuEscrita);
		
		JLabel lblBotaoPedidos = new JLabel("");
		lblBotaoPedidos.setIcon(new ImageIcon("C:\\Users\\Aluno\\Desktop\\Repository-SIGH\\Sigh\\src\\main\\resources\\menu pedidos.png"));
		lblBotaoPedidos.setBounds(67, 345, 295, 38);
		contentPane.add(lblBotaoPedidos);
		
		JLabel lblBotaoHospedes = new JLabel("");
		lblBotaoHospedes.setIcon(new ImageIcon("C:\\Users\\Aluno\\Desktop\\Repository-SIGH\\Sigh\\src\\main\\resources\\menu - hospede.png"));
		lblBotaoHospedes.setBounds(67, 407, 295, 38);
		contentPane.add(lblBotaoHospedes);
		
		JLabel lblBotaoHospedagemSelecionado = new JLabel("");
		lblBotaoHospedagemSelecionado.setIcon(new ImageIcon("C:\\Users\\Aluno\\Desktop\\Repository-SIGH\\Sigh\\src\\main\\resources\\menu hospedagem selecionado.png"));
		lblBotaoHospedagemSelecionado.setBounds(43, 457, 342, 45);
		contentPane.add(lblBotaoHospedagemSelecionado);
		
		JLabel lblConta = new JLabel("Conta");
		lblConta.setForeground(Color.GRAY);
		lblConta.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblConta.setBounds(79, 739, 46, 14);
		contentPane.add(lblConta);
		
		JLabel lblNomeConta = new JLabel("Julia Almeida");
		lblNomeConta.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNomeConta.setBounds(120, 780, 80, 30);
		contentPane.add(lblNomeConta);
		
		JLabel lblDivisaoMenu = new JLabel("");
		lblDivisaoMenu.setIcon(new ImageIcon("C:\\Users\\Aluno\\Desktop\\Repository-SIGH\\Sigh\\src\\main\\resources\\divisor (menu).png"));
		lblDivisaoMenu.setBounds(77, 897, 243, 14);
		contentPane.add(lblDivisaoMenu);
		
		JLabel lblBotaoSair = new JLabel("");
		lblBotaoSair.setIcon(new ImageIcon("C:\\Users\\Aluno\\Desktop\\Repository-SIGH\\Sigh\\src\\main\\resources\\botao sair.png"));
		lblBotaoSair.setBounds(69, 955, 263, 45);
		contentPane.add(lblBotaoSair);
		lblMenu.setIcon(new ImageIcon("C:\\Users\\Aluno\\Desktop\\Repository-SIGH\\Sigh\\src\\main\\resources\\fundo cinza (menu).png"));
		lblMenu.setBounds(0, 0, 420, 1080);
		contentPane.add(lblMenu);
		
		JLabel lblParteSuperiorPequena = new JLabel("");
		lblParteSuperiorPequena.setIcon(new ImageIcon("C:\\Users\\Aluno\\Desktop\\Repository-SIGH\\Sigh\\src\\main\\resources\\parte superior pequena.png"));
		lblParteSuperiorPequena.setBounds(420, 0, 1500, 62);
		contentPane.add(lblParteSuperiorPequena);
		
		JLabel lblEscritaHospedagem = new JLabel("Cadastrar Hospedagem");
		lblEscritaHospedagem.setFont(new Font("Swis721 LtEx BT", Font.PLAIN, 32));
		lblEscritaHospedagem.setBounds(473, 132, 400, 55);
		contentPane.add(lblEscritaHospedagem);
		
		JLabel lblHeroBlock = new JLabel("");
		lblHeroBlock.setIcon(new ImageIcon("C:\\Users\\Aluno\\Desktop\\Repository-SIGH\\Sigh\\src\\main\\resources\\Hero block.png"));
		lblHeroBlock.setBounds(440, 100, 1455, 119);
		contentPane.add(lblHeroBlock);
		
		JLabel lblNumHospedes = new JLabel("Número de Hóspedes *");
		lblNumHospedes.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNumHospedes.setBounds(502, 315, 145, 40);
		contentPane.add(lblNumHospedes);
		
		JComboBox comboBoxHospedes = new JComboBox();
		comboBoxHospedes.setBounds(502, 355, 343, 48);
		contentPane.add(comboBoxHospedes);
		
		JLabel lblDataCheckin = new JLabel("Data check-in *");
		lblDataCheckin.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDataCheckin.setBounds(502, 510, 145, 40);
		contentPane.add(lblDataCheckin);
		
		txtDataCheckin = new JTextField();
		txtDataCheckin.setBounds(502, 548, 343, 48);
		contentPane.add(txtDataCheckin);
		txtDataCheckin.setColumns(10);
	}
}
