package visao;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.JTextField;

public class CadastroFuncionario extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtNomeText;
	private JTextField txtNomeSocialText;
	private JTextField txtCargoText;
	private JTextField txtSetorText;
	private JTextField txtUsuarioText;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastroFuncionario frame = new CadastroFuncionario();
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
	public CadastroFuncionario() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1404, 1050);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblBarraMenu = new JLabel("");
		lblBarraMenu.setIcon(new ImageIcon("C:\\Users\\Aluno\\Desktop\\Repository-SIGH\\Sigh\\src\\main\\resources\\divisor (menu).png"));
		lblBarraMenu.setBounds(88, 900, 260, 14);
		contentPane.add(lblBarraMenu);
		
		JLabel lblNomeFuncionario = new JLabel("Julia Almeida");
		lblNomeFuncionario.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNomeFuncionario.setBounds(129, 798, 100, 14);
		contentPane.add(lblNomeFuncionario);
		
		JLabel lblConta = new JLabel("Conta");
		lblConta.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblConta.setForeground(SystemColor.textInactiveText);
		lblConta.setBounds(79, 760, 46, 14);
		contentPane.add(lblConta);
		
		JLabel lblEscritaMenu = new JLabel("Menu");
		lblEscritaMenu.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblEscritaMenu.setForeground(SystemColor.textInactiveText);
		lblEscritaMenu.setBounds(67, 289, 46, 14);
		contentPane.add(lblEscritaMenu);
		
		JLabel lblBotaoFuncionarios = new JLabel("");
		lblBotaoFuncionarios.setIcon(new ImageIcon("C:\\Users\\Aluno\\Desktop\\Repository-SIGH\\Sigh\\src\\main\\resources\\menu - funcionarios selecionado.png"));
		lblBotaoFuncionarios.setBounds(48, 523, 335, 50);
		contentPane.add(lblBotaoFuncionarios);
		
		JLabel lblBotaoHospedagem = new JLabel("");
		lblBotaoHospedagem.setIcon(new ImageIcon("C:\\Users\\Aluno\\Desktop\\Repository-SIGH\\Sigh\\src\\main\\resources\\menu hospedagem.png"));
		lblBotaoHospedagem.setBounds(68, 472, 190, 40);
		contentPane.add(lblBotaoHospedagem);
		
		JLabel lblBotaoHospede = new JLabel("");
		lblBotaoHospede.setIcon(new ImageIcon("C:\\Users\\Aluno\\Desktop\\Repository-SIGH\\Sigh\\src\\main\\resources\\menu - hospede.png"));
		lblBotaoHospede.setBounds(68, 410, 190, 40);
		contentPane.add(lblBotaoHospede);
		
		JLabel lblPretoNot = new JLabel("");
		lblPretoNot.setIcon(new ImageIcon("C:\\Users\\Aluno\\Desktop\\Repository-SIGH\\Sigh\\src\\main\\resources\\fundinho preto n° notificação.png"));
		lblPretoNot.setBounds(318, 350, 39, 27);
		contentPane.add(lblPretoNot);
		
		JLabel lblBotaoPedido = new JLabel("");
		lblBotaoPedido.setIcon(new ImageIcon("C:\\Users\\Aluno\\Desktop\\Repository-SIGH\\Sigh\\src\\main\\resources\\menu pedidos.png"));
		lblBotaoPedido.setBounds(68, 348, 190, 40);
		contentPane.add(lblBotaoPedido);
		
		JLabel lblFuncionarioEscrita = new JLabel("Funcionários");
		lblFuncionarioEscrita.setFont(new Font("Tahoma", Font.PLAIN, 28));
		lblFuncionarioEscrita.setBounds(476, 168, 160, 35);
		contentPane.add(lblFuncionarioEscrita);
		
		JLabel lblCadastroDe = new JLabel("Cadastro de ");
		lblCadastroDe.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblCadastroDe.setBounds(477, 136, 100, 30);
		contentPane.add(lblCadastroDe);
		
		JLabel lblBotaoSair = new JLabel("");
		lblBotaoSair.setIcon(new ImageIcon("C:\\Users\\Aluno\\Desktop\\Repository-SIGH\\Sigh\\src\\main\\resources\\botao sair.png"));
		lblBotaoSair.setBounds(84, 958, 270, 40);
		contentPane.add(lblBotaoSair);
		
		JLabel lblParteSuperior = new JLabel("");
		lblParteSuperior.setIcon(new ImageIcon("C:\\Users\\Aluno\\Desktop\\Repository-SIGH\\Sigh\\src\\main\\resources\\parte superior pequena.png"));
		lblParteSuperior.setBounds(421, 0, 1498, 60);
		contentPane.add(lblParteSuperior);
		
		JLabel lblTituloSuperior = new JLabel("");
		lblTituloSuperior.setIcon(new ImageIcon("C:\\Users\\Aluno\\Desktop\\Repository-SIGH\\Sigh\\src\\main\\resources\\Hero block.png"));
		lblTituloSuperior.setBounds(442, 108, 1455, 129);
		contentPane.add(lblTituloSuperior);
		
		JLabel lblSimbolo = new JLabel("");
		lblSimbolo.setIcon(new ImageIcon("C:\\Users\\Aluno\\Desktop\\Repository-SIGH\\Sigh\\src\\main\\resources\\logo sigh.png"));
		lblSimbolo.setBounds(131, 35, 150, 200);
		contentPane.add(lblSimbolo);
		
		JLabel lblMenu = new JLabel("");
		lblMenu.setIcon(new ImageIcon("C:\\Users\\Aluno\\Desktop\\Repository-SIGH\\Sigh\\src\\main\\resources\\fundo cinza (menu).png"));
		lblMenu.setBounds(0, 0, 450, 1050);
		contentPane.add(lblMenu);
		
		JLabel lblNomeLabel = new JLabel("Nome *");
		lblNomeLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNomeLabel.setBounds(650, 272, 55, 18);
		contentPane.add(lblNomeLabel);
		
		txtNomeText = new JTextField();
		txtNomeText.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtNomeText.setBounds(650, 298, 323, 48);
		contentPane.add(txtNomeText);
		txtNomeText.setColumns(10);
		
		JLabel lblNomeSocialLabel = new JLabel("Nome Social");
		lblNomeSocialLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNomeSocialLabel.setBounds(650, 388, 90, 18);
		contentPane.add(lblNomeSocialLabel);
		
		txtNomeSocialText = new JTextField();
		txtNomeSocialText.setBounds(650, 426, 343, 48);
		contentPane.add(txtNomeSocialText);
		txtNomeSocialText.setColumns(10);
		
		JLabel lblCargoLabel = new JLabel("Cargo *");
		lblCargoLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCargoLabel.setBounds(650, 540, 70, 18);
		contentPane.add(lblCargoLabel);
		
		txtCargoText = new JTextField();
		txtCargoText.setBounds(650, 566, 343, 48);
		contentPane.add(txtCargoText);
		txtCargoText.setColumns(10);
		
		JLabel lblSetorLabel = new JLabel("Setor *");
		lblSetorLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSetorLabel.setBounds(650, 688, 46, 18);
		contentPane.add(lblSetorLabel);
		
		txtSetorText = new JTextField();
		txtSetorText.setBounds(650, 712, 343, 48);
		contentPane.add(txtSetorText);
		txtSetorText.setColumns(10);
		
		JLabel lblUsuarioLabel = new JLabel("Usuário *");
		lblUsuarioLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblUsuarioLabel.setBounds(650, 800, 58, 14);
		contentPane.add(lblUsuarioLabel);
		
		txtUsuarioText = new JTextField();
		txtUsuarioText.setBounds(650, 900, 343, 48);
		contentPane.add(txtUsuarioText);
		txtUsuarioText.setColumns(10);
		
		
		
	}

}
