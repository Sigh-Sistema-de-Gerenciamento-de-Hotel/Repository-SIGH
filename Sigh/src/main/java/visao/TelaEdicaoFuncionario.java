package visao;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;

import controle.funcionario.FuncionarioDAO;
import modelo.Funcionario;
import modelo.Hospede;
import visao.padrao.RoundJFormattedTextField;

import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTextField;

public class TelaEdicaoFuncionario extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtNome;
	private JTextField txtNomeSocial;
	private JTextField txtCargo;
	private JPasswordField txtSenha;
	private JTextField txtUsuario;
	private JTextField txtSobrenome;
	private Funcionario funcEditar;
	private static Funcionario funcionarioLogado;

	/**
	 * Launch the application.
	 * 
	 * 
	 * public static void main(String[] args) { EventQueue.invokeLater(new
	 * Runnable() { public void run() { try { TelaEdicaoFuncionario frame = new
	 * TelaEdicaoFuncionario(); frame.setVisible(true);
	 * frame.setExtendedState(JFrame.MAXIMIZED_BOTH); } catch (Exception e) {
	 * e.printStackTrace(); } } }); }
	 * 
	 * /* Create the frame.
	 */
	public TelaEdicaoFuncionario(Funcionario funcLogado, Funcionario funcEditar) {
		funcionarioLogado = funcLogado;
		this.funcEditar = funcEditar;
		
		setIconImage(Toolkit.getDefaultToolkit().getImage("src/main/resources/logo sigh.png"));
		setTitle("Edição de Funcionario");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1386, 860);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblPedidos = new JLabel("");
		lblPedidos.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				lblPedidos.setIcon(new ImageIcon("src/main/resources/menu - pedidos selecionado.png"));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				lblPedidos.setIcon(new ImageIcon("src/main/resources/menu pedidos.png"));
			}
		});

		JLabel lblHospedes = new JLabel("");
		lblHospedes.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				lblHospedes.setIcon(new ImageIcon("src/main/resources/menu - hospedes selecionado.png"));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				lblHospedes.setIcon(new ImageIcon("src/main/resources/menu - hospede.png"));
			}
		});

		JLabel lblHospedagem = new JLabel("");
		lblHospedagem.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				TelaListagemHospedagem tlh = new TelaListagemHospedagem(funcionarioLogado);
				tlh.setVisible(true);
				tlh.setExtendedState(JFrame.MAXIMIZED_BOTH);
				dispose();
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				lblHospedagem.setIcon(new ImageIcon("src/main/resources/menu hospedagem selecionado.png"));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				lblHospedagem.setIcon(new ImageIcon("src/main/resources/menu hospedagem.png"));
			}
		});

		JLabel lblFuncionarios = new JLabel("");
		lblFuncionarios.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				lblFuncionarios.setIcon(new ImageIcon("src/main/resources/menu - funcionarios selecionado.png"));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				lblFuncionarios.setIcon(new ImageIcon("src/main/resources/menu funcionarios.png"));
			}
		});

		JLabel lblBotaoSair = new JLabel("");
		lblBotaoSair.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// Logoff
				dispose();
				funcionarioLogado = null;
				TelaLogin tela = new TelaLogin();
				tela.setVisible(true);
				tela.setExtendedState(JFrame.MAXIMIZED_BOTH);
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				lblBotaoSair.setIcon(new ImageIcon("src/main/resources/botao sair cinza claro.png"));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				lblBotaoSair.setIcon(new ImageIcon("src/main/resources/botao sair.png"));
			}
		});

		JLabel lblBotaoSalvar = new JLabel("");
		lblBotaoSalvar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				FuncionarioDAO dao = FuncionarioDAO.getInstancia();
				
				String nome = txtNome.getText();
				if(nome.isEmpty()) {
					// ERRO
					TelaErro dadosIncorretos = new TelaErro("Insira seu nome!");
					dadosIncorretos.setLocationRelativeTo(null);
					dadosIncorretos.setVisible(true);
				} else {
					funcEditar.setNome(nome);
				}
				
				String sobrenome = txtSobrenome.getText();
				if(sobrenome.isEmpty()){
					// ERRO
					TelaErro dadosIncorretos = new TelaErro("Insira seu sobrenome!");
					dadosIncorretos.setLocationRelativeTo(null);
					dadosIncorretos.setVisible(true);
				} else {
					funcEditar.setSobrenome(sobrenome);
				}
				
				String nomeSocial = txtNomeSocial.getText();
				funcEditar.setNomeSocial(nomeSocial);
				
				String cargo = txtCargo.getText();
				if(cargo.isEmpty()) {
					// ERRO
					TelaErro dadosIncorretos = new TelaErro("Insira seu cargo!");
					dadosIncorretos.setLocationRelativeTo(null);
					dadosIncorretos.setVisible(true);
				}  else {
					funcEditar.setCargo(cargo);
				}
				
				
				String usuario = txtUsuario.getText();
				if(usuario.isEmpty()) {
					// ERRO
					TelaErro dadosIncorretos = new TelaErro("Insira seu usuário!");
					dadosIncorretos.setLocationRelativeTo(null);
					dadosIncorretos.setVisible(true);
				} else {
					funcEditar.setUsuario(usuario);
				}
				
				char[] senhaChar = txtSenha.getPassword();
				
				if(senhaChar == null) {
					// ERRO
					TelaErro dadosIncorretos = new TelaErro("Insira sua senha!");
					dadosIncorretos.setLocationRelativeTo(null);
					dadosIncorretos.setVisible(true);
				} else {
					//String senha = senhaChar.toString();
					//String.valueOf(senhaChar);
					funcEditar.setSenha(String.valueOf(senhaChar));
				}
				
				
				boolean validacao = dao.atualizarFuncionario(funcEditar);
				if (validacao == true) {
					TelaListagemFuncionario lf = new TelaListagemFuncionario(funcLogado);
					lf.setVisible(true);
					lf.setExtendedState(JFrame.MAXIMIZED_BOTH);
					/*TelaConfirmacao telaConfirmacao = new TelaConfirmacao(func.getPrimeiroNome(), func.getSobrenome(),
							func.getNomeSocial(), func.getUsuario(), func.getCargo());
					telaConfirmacao.setVisible(true);*/
					dispose();
				} else {
					// mensagem de ERRO
					TelaErro dadosIncorretos = new TelaErro("Insira seus dados!");
					dadosIncorretos.setLocationRelativeTo(null);
					dadosIncorretos.setVisible(true);
				}

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				lblBotaoSalvar.setIcon(new ImageIcon("src/main/resources/botao salvar  claro.png"));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				lblBotaoSalvar.setIcon(new ImageIcon("src/main/resources/botao salvar.png"));
			}
		});

		JLabel lblBotaoCancelar = new JLabel("");
		lblBotaoCancelar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				TelaListagemFuncionario telaListFunc = new TelaListagemFuncionario(funcLogado);
				telaListFunc.setVisible(true);
				telaListFunc.setExtendedState(JFrame.MAXIMIZED_BOTH);
				dispose();				
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

		JLabel lblNomeUsuario = new JLabel("JULIA ALMEIDA");
		lblNomeUsuario.setBounds(129, 798, 100, 14);
		contentPane.add(lblNomeUsuario);

		JLabel lblConta = new JLabel("Conta");
		lblConta.setForeground(new Color(128, 128, 128));
		lblConta.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblConta.setBounds(79, 760, 46, 14);
		contentPane.add(lblConta);
		lblBotaoCancelar.setIcon(new ImageIcon("src/main/resources/botao cancelar.png"));
		lblBotaoCancelar.setBounds(1595, 902, 300, 50);
		contentPane.add(lblBotaoCancelar);
		lblBotaoSalvar.setIcon(new ImageIcon("src/main/resources/botao salvar.png"));
		lblBotaoSalvar.setBounds(1245, 902, 343, 50);
		contentPane.add(lblBotaoSalvar);
		lblBotaoSair.setIcon(new ImageIcon("src/main/resources/botao sair.png"));
		lblBotaoSair.setBounds(84, 958, 270, 40);
		contentPane.add(lblBotaoSair);

		JLabel lblMenu = new JLabel("Menu");
		lblMenu.setForeground(new Color(128, 128, 128));
		lblMenu.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblMenu.setBounds(67, 289, 46, 14);
		contentPane.add(lblMenu);
		lblFuncionarios.setIcon(new ImageIcon("src/main/resources/menu funcionarios.png"));
		lblFuncionarios.setBounds(68, 523, 335, 50);
		contentPane.add(lblFuncionarios);
		lblHospedagem.setIcon(new ImageIcon("src/main/resources/menu hospedagem.png"));
		lblHospedagem.setBounds(68, 472, 335, 50);
		contentPane.add(lblHospedagem);
		lblHospedes.setIcon(new ImageIcon("src/main/resources/menu - hospede.png"));
		lblHospedes.setBounds(68, 410, 335, 50);
		contentPane.add(lblHospedes);
		lblPedidos.setIcon(new ImageIcon("src/main/resources/menu pedidos.png"));
		lblPedidos.setBounds(68, 348, 335, 50);
		contentPane.add(lblPedidos);

		JLabel lblLogoSigh = new JLabel("");
		lblLogoSigh.setIcon(new ImageIcon("src/main/resources/logo sigh.png"));
		lblLogoSigh.setBounds(131, 35, 150, 200);
		contentPane.add(lblLogoSigh);

		JLabel lblFundoCinza = new JLabel("");
		lblFundoCinza.setIcon(new ImageIcon("src/main/resources/fundo cinza (menu).png"));
		lblFundoCinza.setBounds(0, 0, 420, 1080);
		contentPane.add(lblFundoCinza);

		JLabel lblCaminho = new JLabel("");
		lblCaminho.setIcon(new ImageIcon("src/main/resources/CaminhoEditarFuncionario.png"));
		lblCaminho.setBounds(420, 0, 1500, 62);
		contentPane.add(lblCaminho);

		JLabel lblTitulo = new JLabel("");
		lblTitulo.setIcon(new ImageIcon("src/main/resources/TituloEditarFuncionario.png"));
		lblTitulo.setBounds(443, 119, 1455, 126);
		contentPane.add(lblTitulo);

		JLabel lblNome = new JLabel("Nome*");
		lblNome.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNome.setBounds(554, 306, 139, 14);
		contentPane.add(lblNome);

		String nome = funcEditar.getNome();

		txtNome = new RoundJFormattedTextField(null);
		txtNome.setText(nome);
		txtNome.setBounds(554, 326, 343, 48);
		contentPane.add(txtNome);
		txtNome.setColumns(10);

		JLabel lblNomeSocial = new JLabel("Nome Social");
		lblNomeSocial.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNomeSocial.setBounds(554, 385, 139, 14);
		contentPane.add(lblNomeSocial);

		String nomeSocial = funcEditar.getNomeSocial();

		txtNomeSocial = new RoundJFormattedTextField(null);
		txtNomeSocial.setText(nomeSocial);
		txtNomeSocial.setBounds(554, 410, 343, 48);
		contentPane.add(txtNomeSocial);
		txtNomeSocial.setColumns(10);

		JLabel lblCargo = new JLabel("Cargo*");
		lblCargo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCargo.setBounds(554, 472, 139, 22);
		contentPane.add(lblCargo);

		String cargo = funcEditar.getCargo();

		txtCargo = new RoundJFormattedTextField(null);
		txtCargo.setText(cargo);
		txtCargo.setBounds(554, 497, 343, 48);
		contentPane.add(txtCargo);
		txtCargo.setColumns(10);

		JLabel lblSenha = new JLabel("Senha*");
		lblSenha.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSenha.setBounds(1001, 476, 139, 14);
		contentPane.add(lblSenha);

		String senha = funcEditar.getSenha();

		txtSenha = new JPasswordField(null);
		txtSenha.setText(senha);
		txtSenha.setBounds(1001, 497, 343, 48);
		contentPane.add(txtSenha);
		txtSenha.setColumns(10);

		JLabel lblUsuario = new JLabel("Usuário*");
		lblUsuario.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblUsuario.setBounds(1001, 384, 139, 14);
		contentPane.add(lblUsuario);

		String usuario = funcEditar.getUsuario();

		txtUsuario = new RoundJFormattedTextField(null);
		txtUsuario.setText(usuario);
		txtUsuario.setBounds(1001, 412, 343, 48);
		contentPane.add(txtUsuario);
		txtUsuario.setColumns(10);

		JLabel lblSobrenome = new JLabel("Sobrenome*");
		lblSobrenome.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSobrenome.setBounds(1001, 306, 139, 14);
		contentPane.add(lblSobrenome);

		String sobrenome = funcEditar.getSobrenome();

		txtSobrenome = new RoundJFormattedTextField(null);
		txtSobrenome.setText(sobrenome);
		txtSobrenome.setBounds(1001, 326, 343, 48);
		contentPane.add(txtSobrenome);
		txtSobrenome.setColumns(10);

	}

}
