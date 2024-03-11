package visao;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controle.funcionario.FuncionarioDAO;
import modelo.Funcionario;
import visao.padrao.RoundJFormattedTextField;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class CadastroFuncionario extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtNomeText;
	private JTextField txtNomeSocialText;
	private JTextField txtCargoText;
	private JTextField txtUsuarioText;
	private JTextField txtSobrenomeText;
	private JTextField txtSenhaText;

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
		lblBotaoSair.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
				setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				lblBotaoSair.setIcon(new ImageIcon("src/main/resources/botao sair cinza escuro.png"));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblBotaoSair.setIcon(new ImageIcon("src\\main\\resources\\botao sair.png"));
			}
		});
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
		
		txtNomeText = new RoundJFormattedTextField(null);
		txtNomeText.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtNomeText.setBounds(650, 298, 343, 48);
		contentPane.add(txtNomeText);
		txtNomeText.setColumns(10);
		
		JLabel lblNomeSocialLabel = new JLabel("Nome Social");
		lblNomeSocialLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNomeSocialLabel.setBounds(650, 420, 90, 18);
		contentPane.add(lblNomeSocialLabel);
		
		txtNomeSocialText = new RoundJFormattedTextField(null);
		txtNomeSocialText.setBounds(650, 450, 343, 48);
		contentPane.add(txtNomeSocialText);
		txtNomeSocialText.setColumns(10);
		
		JLabel lblCargoLabel = new JLabel("Cargo *");
		lblCargoLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCargoLabel.setBounds(650, 568, 70, 18);
		contentPane.add(lblCargoLabel);
		
		txtCargoText = new RoundJFormattedTextField(null);
		txtCargoText.setBounds(650, 598, 343, 48);
		contentPane.add(txtCargoText);
		txtCargoText.setColumns(10);
		
		JLabel lblUsuarioLabel = new JLabel("Usuário *");
		lblUsuarioLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblUsuarioLabel.setBounds(650, 716, 58, 14);
		contentPane.add(lblUsuarioLabel);
		
		txtUsuarioText = new RoundJFormattedTextField(null);
		txtUsuarioText.setBounds(650, 746, 343, 48);
		contentPane.add(txtUsuarioText);
		txtUsuarioText.setColumns(10);
		
		JLabel lblSobrenomeLabel = new JLabel("Sobrenome *");
		lblSobrenomeLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSobrenomeLabel.setBounds(1261, 291, 90, 14);
		contentPane.add(lblSobrenomeLabel);
		
		txtSobrenomeText = new RoundJFormattedTextField(null);
		txtSobrenomeText.setBounds(1261, 321, 343, 48);
		contentPane.add(txtSobrenomeText);
		txtSobrenomeText.setColumns(10);
		
		JLabel lblSenhaLabel = new JLabel("Senha *");
		lblSenhaLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSenhaLabel.setBounds(1261, 450, 80, 14);
		contentPane.add(lblSenhaLabel);
		
		txtSenhaText = new RoundJFormattedTextField(null);
		txtSenhaText.setBounds(1261, 480, 343, 48);
		contentPane.add(txtSenhaText);
		txtSenhaText.setColumns(10);
		
		JLabel lblBotaoSalvar = new JLabel("");
		lblBotaoSalvar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Funcionario func = new Funcionario();
				
				String nome = txtNomeText.getText();
				if(nome.isEmpty()) {
					// ERRO
				} else {
					func.setPrimeiroNome(nome);
				}
				
				String sobrenome = txtSobrenomeText.getText();
				if(sobrenome.isEmpty()){
					// ERRO
				} else {
					func.setSobrenome(sobrenome);
				}
				
				String nomeSocial = txtNomeSocialText.getText();
				if(!nomeSocial.isEmpty()) {
					func.setNomeSocial(nomeSocial);
				} else {
					
				}
				
				String cargo = txtCargoText.getText();
				if(cargo.isEmpty()) {
					// ERRO
				}  else {
					func.setCargo(cargo);
				}
				
				String usuario = txtUsuarioText.getText();
				if(usuario.isEmpty()) {
					// ERRO
				} else {
					func.setUsuario(usuario);
				}
				
				String senha = txtSenhaText.getText();
				if(senha.isEmpty()) {
					// ERRO
				} else {
					func.setSenha(senha);
				}
				
				FuncionarioDAO dao = FuncionarioDAO.getInstancia();
				
				boolean validacao = dao.inserirFuncionario(func);
				
				if(validacao == true) {
					TelaConfirmacao telaConfirmacao = new TelaConfirmacao();
					telaConfirmacao.setVisible(true);
				}
				else {
					//mensagem de ERRO
				}
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				 lblBotaoSalvar.setIcon(new ImageIcon("src/main/resources/botao salvar verde claro.png"));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				 lblBotaoSalvar.setIcon(new ImageIcon("src/main/resources/botao salvar.png"));
			}
		});
		lblBotaoSalvar.setIcon(new ImageIcon("C:\\Users\\Aluno\\Desktop\\Repository-SIGH\\Sigh\\src\\main\\resources\\botao salvar.png"));
		lblBotaoSalvar.setBounds(1245, 902, 343, 50);
		contentPane.add(lblBotaoSalvar);
		
		JLabel lblBotaoCancelar = new JLabel("");
		lblBotaoCancelar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				 lblBotaoCancelar.setIcon(new ImageIcon("src/main/resources/botao cancelar azul escuro.png"));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				 lblBotaoCancelar.setIcon(new ImageIcon("src/main/resources/botao cancelar.png"));
			}
		});
		
		lblBotaoCancelar.setIcon(new ImageIcon("C:\\Users\\Aluno\\Desktop\\Repository-SIGH\\Sigh\\src\\main\\resources\\botao cancelar.png"));
		lblBotaoCancelar.setBounds(1595, 902, 300, 50);
		contentPane.add(lblBotaoCancelar);
		
		
		
	}
}
