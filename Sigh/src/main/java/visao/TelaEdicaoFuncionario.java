package visao;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;

import controle.funcionario.FuncionarioDAO;
import modelo.Funcionario;
import modelo.Setor;
import visao.padrao.RoundJFormattedTextField;
import visao.padrao.RoundJPasswordField;

import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

public class TelaEdicaoFuncionario extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtNome;
	private JTextField txtNomeSocial;
	private JTextField txtCargo;
	private RoundJPasswordField txtSenha;
	private JTextField txtUsuario;
	private JTextField txtSobrenome;
	private JComboBox<Setor> txtSetor;
	private Funcionario funcionarioEditar;
	private static Funcionario funcionarioLogado;

	
	public TelaEdicaoFuncionario(Funcionario funcLogado, Funcionario funcEditar) {
		funcionarioLogado = funcLogado;
		funcionarioEditar = funcEditar;
		
		setIconImage(Toolkit.getDefaultToolkit().getImage("src/main/resources/logo sigh.png"));
		setTitle("Edição de Funcionario");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1386, 860);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel menuQuarto = new JLabel("");
		menuQuarto.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				TelaListagemQuarto tlq = new TelaListagemQuarto(funcionarioLogado);
				dispose();
				tlq.setExtendedState(MAXIMIZED_BOTH);
				tlq.setVisible(true);
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				menuQuarto.setIcon(new ImageIcon("src/main/resources/menu - quartos selecionado.png"));
				menuQuarto.setBounds(51, 348, 335, 50);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				menuQuarto.setIcon(new ImageIcon("src/main/resources/menu quartoss.png"));
				menuQuarto.setBounds(68, 348, 335, 50);
			}
		});
		menuQuarto.setIcon(new ImageIcon("src/main/resources/menu quartoss.png"));
		menuQuarto.setBounds(68, 348, 335, 50);
		contentPane.add(menuQuarto);

		JLabel lblHospedes = new JLabel("");
		lblHospedes.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				TelaListagemHospede tlh = new TelaListagemHospede(funcionarioLogado);
				dispose();
				tlh.setExtendedState(MAXIMIZED_BOTH);
				tlh.setVisible(true);
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				lblHospedes.setIcon(new ImageIcon("src/main/resources/menu - hospedes selecionado.png"));
				lblHospedes.setBounds(51, 407, 400, 60);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				lblHospedes.setIcon(new ImageIcon("src/main/resources/menu - hospede.png"));
				lblHospedes.setBounds(68, 407, 400, 60);
			}
		});
		lblHospedes.setIcon(new ImageIcon("src/main/resources/menu - hospede.png"));
		lblHospedes.setBounds(68, 407, 400, 60);
		contentPane.add(lblHospedes);

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
				lblHospedagem.setBounds(51, 472, 400, 60);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				lblHospedagem.setIcon(new ImageIcon("src/main/resources/menu hospedagem.png"));
				lblHospedagem.setBounds(68, 472, 400, 60);
			}
		});
		lblHospedagem.setIcon(new ImageIcon("src/main/resources/menu hospedagem.png"));
		lblHospedagem.setBounds(68, 472, 400, 60);
		contentPane.add(lblHospedagem);

		JLabel lblFuncionarios = new JLabel("");
		lblFuncionarios.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				TelaListagemFuncionario tlf = new TelaListagemFuncionario(funcionarioLogado);
				tlf.setVisible(true);
				tlf.setExtendedState(JFrame.MAXIMIZED_BOTH);
				dispose();
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				lblFuncionarios.setIcon(new ImageIcon("src/main/resources/menu - funcionarios selecionado.png"));
				lblFuncionarios.setBounds(51, 533, 335, 50);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				lblFuncionarios.setIcon(new ImageIcon("src/main/resources/menu funcionarios.png"));
				lblFuncionarios.setBounds(68, 533, 335, 50);
			}
		});
		lblFuncionarios.setIcon(new ImageIcon("src\\main\\resources\\menu - funcionarios selecionado.png"));
		lblFuncionarios.setBounds(68, 533, 335, 50);
		contentPane.add(lblFuncionarios);

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
		
		JLabel lblNome = new JLabel("Nome*");
		lblNome.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNome.setBounds(554, 306, 139, 14);
		contentPane.add(lblNome);

		String nome = funcionarioEditar.getNome();

		txtNome = new RoundJFormattedTextField(null);
		txtNome.setText(nome);
		txtNome.setBounds(554, 326, 343, 48);
		contentPane.add(txtNome);
		txtNome.setColumns(10);

		JLabel lblNomeSocial = new JLabel("Nome Social");
		lblNomeSocial.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNomeSocial.setBounds(554, 385, 139, 14);
		contentPane.add(lblNomeSocial);

		String nomeSocial = funcionarioEditar.getNomeSocial();

		txtNomeSocial = new RoundJFormattedTextField(null);
		txtNomeSocial.setText(nomeSocial);
		txtNomeSocial.setBounds(554, 410, 343, 48);
		contentPane.add(txtNomeSocial);
		txtNomeSocial.setColumns(10);

		JLabel lblCargo = new JLabel("Cargo*");
		lblCargo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCargo.setBounds(554, 472, 139, 22);
		contentPane.add(lblCargo);

		String cargo = funcionarioEditar.getCargo();

		txtCargo = new RoundJFormattedTextField(null);
		txtCargo.setText(cargo);
		txtCargo.setBounds(554, 497, 343, 48);
		contentPane.add(txtCargo);
		txtCargo.setColumns(10);

		JLabel lblSenha = new JLabel("Senha*");
		lblSenha.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSenha.setBounds(1001, 476, 139, 14);
		contentPane.add(lblSenha);

		String senha = funcionarioEditar.getSenha();

		txtSenha = new RoundJPasswordField();
		txtSenha.setText(senha);
		txtSenha.setBounds(1001, 497, 343, 48);
		contentPane.add(txtSenha);
		txtSenha.setColumns(10);

		JLabel lblUsuario = new JLabel("Usuário*");
		lblUsuario.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblUsuario.setBounds(1001, 384, 139, 14);
		contentPane.add(lblUsuario);

		String usuario = funcionarioEditar.getUsuario();

		txtUsuario = new RoundJFormattedTextField(null);
		txtUsuario.setText(usuario);
		txtUsuario.setBounds(1001, 412, 343, 48);
		contentPane.add(txtUsuario);
		txtUsuario.setColumns(10);

		JLabel lblSobrenome = new JLabel("Sobrenome*");
		lblSobrenome.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSobrenome.setBounds(1001, 306, 139, 14);
		contentPane.add(lblSobrenome);

		String sobrenome = funcionarioEditar.getSobrenome();

		txtSobrenome = new RoundJFormattedTextField(null);
		txtSobrenome.setText(sobrenome);
		txtSobrenome.setBounds(1001, 326, 343, 48);
		contentPane.add(txtSobrenome);
		txtSobrenome.setColumns(10);
		
		Setor setor = funcionarioEditar.getSetor();
		
		JComboBox<Setor> txtSetor = new JComboBox<Setor>();
		txtSetor.setBounds(554, 592, 343, 48);
		txtSetor.setModel(new DefaultComboBoxModel<>(Setor.values()));
		txtSetor.setSelectedItem(setor);
		contentPane.add(txtSetor);
		
		JLabel lblSetor = new JLabel("Setor*");
		lblSetor.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSetor.setBounds(554, 567, 139, 22);
		contentPane.add(lblSetor);

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
					funcionarioEditar.setNome(nome);
				}
				
				String sobrenome = txtSobrenome.getText();
				if(sobrenome.isEmpty()){
					// ERRO
					TelaErro dadosIncorretos = new TelaErro("Insira seu sobrenome!");
					dadosIncorretos.setLocationRelativeTo(null);
					dadosIncorretos.setVisible(true);
				} else {
					funcionarioEditar.setSobrenome(sobrenome);
				}
				
				String nomeSocial = txtNomeSocial.getText();
				funcionarioEditar.setNomeSocial(nomeSocial);
				
				String cargo = txtCargo.getText();
				if(cargo.isEmpty()) {
					// ERRO
					TelaErro dadosIncorretos = new TelaErro("Insira seu cargo!");
					dadosIncorretos.setLocationRelativeTo(null);
					dadosIncorretos.setVisible(true);
				}  else {
					funcionarioEditar.setCargo(cargo);
				}
				
				Setor setor = (Setor) txtSetor.getSelectedItem();
				if (setor == null) {
					TelaErro dadosIncorretos = new TelaErro("Insira o setor!");
					dadosIncorretos.setLocationRelativeTo(null);
					dadosIncorretos.setVisible(true);
				} else {
					funcionarioEditar.setSetor(setor);
				}

				
				String usuario = txtUsuario.getText();
				if(usuario.isEmpty()) {
					// ERRO
					TelaErro dadosIncorretos = new TelaErro("Insira seu usuário!");
					dadosIncorretos.setLocationRelativeTo(null);
					dadosIncorretos.setVisible(true);
				} else {
					funcionarioEditar.setUsuario(usuario);
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
					funcionarioEditar.setSenha(String.valueOf(senhaChar));
				}
				
				
				boolean validacao = dao.atualizarFuncionario(funcionarioEditar);
				if (validacao == true) {
					TelaListagemFuncionario lf = new TelaListagemFuncionario(funcionarioLogado);
					lf.setVisible(true);
					lf.setExtendedState(JFrame.MAXIMIZED_BOTH);
					TelaConfirmacaoEdicao telaConfirmacaoEdicao = new TelaConfirmacaoEdicao(funcEditar);
					telaConfirmacaoEdicao.setVisible(true);
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
				TelaListagemFuncionario telaListFunc = new TelaListagemFuncionario(funcionarioLogado);
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

		lblBotaoCancelar.setIcon(new ImageIcon("src/main/resources/botao cancelar.png"));
		lblBotaoCancelar.setBounds(1595, 902, 300, 50);
		contentPane.add(lblBotaoCancelar);
		lblBotaoSalvar.setIcon(new ImageIcon("src/main/resources/botao salvar.png"));
		lblBotaoSalvar.setBounds(1245, 902, 343, 50);
		contentPane.add(lblBotaoSalvar);
		lblBotaoSair.setIcon(new ImageIcon("src/main/resources/botao sair.png"));
		lblBotaoSair.setBounds(84, 958, 270, 40);
		contentPane.add(lblBotaoSair);
		lblFuncionarios.setIcon(new ImageIcon("src/main/resources/menu funcionarios.png"));
		lblFuncionarios.setBounds(68, 523, 335, 50);
		contentPane.add(lblFuncionarios);
		lblHospedagem.setIcon(new ImageIcon("src/main/resources/menu hospedagem.png"));
		lblHospedagem.setBounds(68, 472, 335, 50);
		contentPane.add(lblHospedagem);
		lblHospedes.setIcon(new ImageIcon("src/main/resources/menu - hospede.png"));
		lblHospedes.setBounds(68, 410, 335, 50);
		contentPane.add(lblHospedes);
		menuQuarto.setIcon(new ImageIcon("src/main/resources/menu pedidos.png"));
		menuQuarto.setBounds(68, 348, 335, 50);
		contentPane.add(menuQuarto);

		JLabel lblLogoSigh = new JLabel("");
		lblLogoSigh.setIcon(new ImageIcon("src/main/resources/logo sigh.png"));
		lblLogoSigh.setBounds(131, 35, 150, 200);
		contentPane.add(lblLogoSigh);

		JLabel lblFundoCinza = new JLabel("");
		lblFundoCinza.setIcon(new ImageIcon("src/main/resources/fundo cinza (menu).png"));
		lblFundoCinza.setBounds(0, 0, 420, 1080);
		contentPane.add(lblFundoCinza);

		JLabel lblCaminho = new JLabel("");
		lblCaminho.setIcon(new ImageIcon("src/main/resources/Caminho Editar funcionário.png"));
		lblCaminho.setBounds(420, 0, 1500, 62);
		contentPane.add(lblCaminho);

		JLabel lblTitulo = new JLabel("");
		lblTitulo.setIcon(new ImageIcon("src/main/resources/TituloEditarFuncionario.png"));
		lblTitulo.setBounds(443, 119, 1455, 126);
		contentPane.add(lblTitulo);

	}
}
