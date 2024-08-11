package visao;

import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import controle.funcionario.FuncionarioDAO;
import modelo.Funcionario;
import modelo.Setor;
import visao.padrao.RoundJFormattedTextField;
import visao.padrao.RoundJPasswordField;

import javax.swing.JPasswordField;

public class TelaCadastroFuncionario extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtNomeText;
	private JTextField txtNomeSocialText;
	private JTextField txtCargoText;
	private JTextField txtCpfText;
	private JTextField txtSobrenomeText;
	private JComboBox<Setor> txtSetorText;
	private JTextField txtUsuarioText;
	private RoundJPasswordField passwordField;
	private Funcionario funcionarioLogado;

	/**
	 * Create the frame.
	 */
	public TelaCadastroFuncionario(Funcionario funcLogado) {
		this.funcionarioLogado = funcLogado;
		setIconImage(Toolkit.getDefaultToolkit().getImage("src/main/resources/logo sigh.png"));
		setTitle("Cadastro de Funcionário");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1404, 1050);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);


		JLabel lblBotaoFuncionarios = new JLabel("");
		lblBotaoFuncionarios.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				TelaListagemFuncionario listaFuncionario = new TelaListagemFuncionario(funcLogado);
				setVisible(false);
				listaFuncionario.setExtendedState(MAXIMIZED_BOTH);
				listaFuncionario.setVisible(true);
			}
		});
		lblBotaoFuncionarios.setIcon(new ImageIcon("src\\main\\resources\\menu - funcionarios selecionado.png"));
		lblBotaoFuncionarios.setBounds(51, 533, 335, 50);
		contentPane.add(lblBotaoFuncionarios);

		JLabel lblBotaoHospedagem = new JLabel("");
		lblBotaoHospedagem.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				TelaListagemHospedagem tlh = new TelaListagemHospedagem(funcionarioLogado);
				tlh.setVisible(true);
				tlh.setExtendedState(JFrame.MAXIMIZED_BOTH);
				dispose();
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				lblBotaoHospedagem.setIcon(new ImageIcon("src/main/resources/menu hospedagem selecionado.png"));
				lblBotaoHospedagem.setBounds(51, 472, 335, 50);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				lblBotaoHospedagem.setIcon(new ImageIcon("src/main/resources/menu hospedagem.png"));
				lblBotaoHospedagem.setBounds(68, 472, 335, 50);
			}
		});
		lblBotaoHospedagem.setIcon(new ImageIcon("src\\main\\resources\\menu hospedagem.png"));
		lblBotaoHospedagem.setBounds(68, 472, 335, 50);
		contentPane.add(lblBotaoHospedagem);

		JLabel lblBotaoHospede = new JLabel("");
		lblBotaoHospede.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				TelaListagemHospede tlh = new TelaListagemHospede(funcionarioLogado);
				dispose();
				tlh.setExtendedState(MAXIMIZED_BOTH);
				tlh.setVisible(true);
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				lblBotaoHospede.setIcon(new ImageIcon("src/main/resources/menu - hospedes selecionado.png"));
				lblBotaoHospede.setBounds(51, 410, 335, 50);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				lblBotaoHospede.setIcon(new ImageIcon("src/main/resources/menu - hospede.png"));
				lblBotaoHospede.setBounds(68, 410, 335, 50);
			}
		});
		lblBotaoHospede.setIcon(new ImageIcon("src\\main\\resources\\menu - hospede.png"));
		lblBotaoHospede.setBounds(68, 410, 335, 50);
		contentPane.add(lblBotaoHospede);

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
				lblBotaoSair.setIcon(new ImageIcon("src\\main\\resources\\botao sair.png"));
			}
		});
		lblBotaoSair.setIcon(new ImageIcon("src\\main\\resources\\botao sair.png"));
		lblBotaoSair.setBounds(84, 958, 270, 40);
		contentPane.add(lblBotaoSair);

		JLabel lblParteSuperior = new JLabel("");
		lblParteSuperior.setIcon(new ImageIcon("src/main/resources/CaminhoCadsatrarFuncionario.png"));
		lblParteSuperior.setBounds(421, 0, 1498, 60);
		contentPane.add(lblParteSuperior);

		JLabel lblTituloSuperior = new JLabel("");
		lblTituloSuperior.setIcon(new ImageIcon("src/main/resources/TituloCadastrarFuncionario.png"));
		lblTituloSuperior.setBounds(442, 108, 1445, 138);
		contentPane.add(lblTituloSuperior);

		JLabel lblSimbolo = new JLabel("");
		lblSimbolo.setIcon(new ImageIcon("src\\main\\resources\\logo sigh.png"));
		lblSimbolo.setBounds(131, 35, 150, 200);
		contentPane.add(lblSimbolo);

		JLabel lblMenu = new JLabel("");
		lblMenu.setIcon(new ImageIcon("src\\main\\resources\\fundo cinza (menu).png"));
		lblMenu.setBounds(0, 0, 450, 1050);
		contentPane.add(lblMenu);

		JLabel lblNomeSociallLabel = new JLabel("Sobrenome *");
		lblNomeSociallLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNomeSociallLabel.setBounds(650, 410, 100, 18);
		contentPane.add(lblNomeSociallLabel);

		txtSobrenomeText = new RoundJFormattedTextField(null);
		txtSobrenomeText.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtSobrenomeText.setBounds(650, 436, 343, 48);
		contentPane.add(txtSobrenomeText);
		txtSobrenomeText.setColumns(10);

		JLabel lblNomeLabel = new JLabel("Nome *");
		lblNomeLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNomeLabel.setBounds(650, 272, 55, 18);
		contentPane.add(lblNomeLabel);

		txtNomeText = new RoundJFormattedTextField(null);
		txtNomeText.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtNomeText.setBounds(650, 298, 343, 48);
		contentPane.add(txtNomeText);
		txtNomeText.setColumns(10);

		JLabel lblUsuarioLabel = new JLabel("Usuário *");
		lblUsuarioLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblUsuarioLabel.setBounds(1245, 360, 90, 18);
		contentPane.add(lblUsuarioLabel);

		JLabel lblCpfLabel = new JLabel("Cpf *");
		lblCpfLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCpfLabel.setBounds(1245, 498, 90, 18);
		contentPane.add(lblCpfLabel);

		txtNomeSocialText = new RoundJFormattedTextField(null);
		txtNomeSocialText.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtNomeSocialText.setBounds(650, 574, 343, 48);
		contentPane.add(txtNomeSocialText);
		txtNomeSocialText.setColumns(10);

		JLabel lblCargoLabel = new JLabel("Cargo *");
		lblCargoLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCargoLabel.setBounds(650, 686, 58, 18);
		contentPane.add(lblCargoLabel);

		txtCargoText = new RoundJFormattedTextField(null);
		txtCargoText.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtCargoText.setBounds(650, 712, 343, 48);
		contentPane.add(txtCargoText);
		txtCargoText.setColumns(10);

		JLabel lblNomeSocialLabel = new JLabel("Nome Social");
		lblNomeSocialLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNomeSocialLabel.setBounds(650, 548, 90, 14);
		contentPane.add(lblNomeSocialLabel);

		txtCpfText = new RoundJFormattedTextField(null);
		txtCpfText.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtCpfText.setBounds(1245, 524, 343, 48);
		contentPane.add(txtCpfText);
		txtCpfText.setColumns(10);

		JLabel lblSenhaLabel = new JLabel("Senha *");
		lblSenhaLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSenhaLabel.setBounds(1245, 636, 80, 14);
		contentPane.add(lblSenhaLabel);
		
		JLabel lblSetorLabel = new JLabel("Setor *");
		lblSetorLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSetorLabel.setBounds(650, 824, 46, 14);
		contentPane.add(lblSetorLabel);

		JComboBox<Setor> txtSetorText = new JComboBox<Setor>();
		txtSetorText.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtSetorText.setBounds(650, 850, 343, 48);
		txtSetorText.setModel(new DefaultComboBoxModel<>(Setor.values()));
		contentPane.add(txtSetorText);
		//txtSetorText.setColumns(10);

		txtUsuarioText = new RoundJFormattedTextField(null);
		txtUsuarioText.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtUsuarioText.setBounds(1245, 386, 343, 48);
		contentPane.add(txtUsuarioText);
		txtUsuarioText.setColumns(10);

		passwordField = new RoundJPasswordField();
		passwordField.setBounds(1245, 660, 343, 48);
		contentPane.add(passwordField);

		JLabel lblBotaoSalvar = new JLabel("");
		lblBotaoSalvar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Funcionario func = new Funcionario();

				Boolean erro = false;

				String id = txtCpfText.getText();

				if (id.isEmpty()) {
					// ERRO
					TelaErro dadosIncorretos = new TelaErro("Insira seu CPF!");
					dadosIncorretos.setLocationRelativeTo(null);
					dadosIncorretos.setVisible(true);
				} else {
					boolean valida = validarCPF(id);
					if(valida == true) {
						func.setId(id);
					} else {
						TelaErro dadosIncorretos = new TelaErro("CPF inválido");
						dadosIncorretos.setLocationRelativeTo(null);
						dadosIncorretos.setVisible(true);
						erro = true;
					}
				}

				String nome = txtNomeText.getText();
				if (nome.isEmpty()) {
					erro = true;
					// ERRO
					TelaErro dadosIncorretos = new TelaErro("Insira nome!");
					dadosIncorretos.setLocationRelativeTo(null);
					dadosIncorretos.setVisible(true);
				} else {
					func.setNome(nome);
				}

				String sobrenome = txtSobrenomeText.getText();
				if (sobrenome.isEmpty()) {
					erro = true;
					// ERRO
					TelaErro dadosIncorretos = new TelaErro("Insira sobrenome!");
					dadosIncorretos.setLocationRelativeTo(null);
					dadosIncorretos.setVisible(true);
				} else {
					func.setSobrenome(sobrenome);
				}

				String nomeSocial = txtNomeSocialText.getText();
				func.setNomeSocial(nomeSocial);

				String cargo = txtCargoText.getText();
				if (cargo.isEmpty()) {
					erro = true;
					// ERRO
					TelaErro dadosIncorretos = new TelaErro("Insira cargo!");
					dadosIncorretos.setLocationRelativeTo(null);
					dadosIncorretos.setVisible(true);
				} else {
					func.setCargo(cargo);
				}
				
				Setor setor = (Setor) txtSetorText.getSelectedItem();
				if (setor == null) {
					erro = true;
					TelaErro dadosIncorretos = new TelaErro("Insira o setor!");
					dadosIncorretos.setLocationRelativeTo(null);
					dadosIncorretos.setVisible(true);
				} else {
					func.setSetor(setor);
				}

				String usuario = txtUsuarioText.getText();
				if (usuario.isEmpty()) {
					erro = true;
					// ERRO
					TelaErro dadosIncorretos = new TelaErro("Insira usuário!");
					dadosIncorretos.setLocationRelativeTo(null);
					dadosIncorretos.setVisible(true);
				} else {
					func.setUsuario(usuario);
				}

				char[] senhaChar = passwordField.getPassword();
				if (senhaChar == null) {
					erro = true;
					// ERRO
					TelaErro dadosIncorretos = new TelaErro("Insira senha!");
					dadosIncorretos.setLocationRelativeTo(null);
					dadosIncorretos.setVisible(true);
				} else {
					String senha = senhaChar.toString();
					func.setSenha(senha);
				}

				if (erro == false) {
					FuncionarioDAO dao = FuncionarioDAO.getInstancia();

					boolean validacao = dao.inserirFuncionario(func);

					if (validacao == true) {
						TelaListagemFuncionario lf = new TelaListagemFuncionario(funcionarioLogado);
						lf.setVisible(true);
						lf.setExtendedState(JFrame.MAXIMIZED_BOTH);
						TelaConfirmacao telaConfirmacao = new TelaConfirmacao(func);
						telaConfirmacao.setVisible(true);
						setVisible(false);
					} else {
						// mensagem de ERRO
						TelaErro dadosIncorretos = new TelaErro("Insira seus dados!");
						dadosIncorretos.setLocationRelativeTo(null);
						dadosIncorretos.setVisible(true);
					}
				}
			}
			
			private boolean validarCPF(String cpf) {
				if(cpf.trim().isEmpty() || cpf == null) {
					return false;
				} else if(!cpf.matches("[0-9]+")) {
					return false;
				} else if(cpf.length() != 11) {
					return false;
				} else {
					return true;
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

		lblBotaoSalvar.setIcon(new ImageIcon("src\\main\\resources\\botao salvar.png"));
		lblBotaoSalvar.setBounds(1245, 902, 343, 50);
		contentPane.add(lblBotaoSalvar);

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

		lblBotaoCancelar.setIcon(new ImageIcon("src\\main\\resources\\botao cancelar.png"));
		lblBotaoCancelar.setBounds(1595, 902, 300, 50);
		contentPane.add(lblBotaoCancelar);

		
	}
}
