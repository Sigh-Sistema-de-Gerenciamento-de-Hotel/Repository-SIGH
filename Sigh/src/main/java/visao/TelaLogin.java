package visao;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import controle.funcionario.FuncionarioDAO;
import modelo.Funcionario;
import visao.padrao.RoundJFormattedTextField;

public class TelaLogin extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField txtUsuario;
	private JPasswordField passwordField;
	private FuncionarioDAO func = FuncionarioDAO.getInstancia();

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

		JLabel lblPessoaLogin = new JLabel("");
		lblPessoaLogin.setIcon(new ImageIcon("src/main/resources/pessoa no login.png"));
		lblPessoaLogin.setBounds(892, 158, 150, 150);
		contentPane.add(lblPessoaLogin);

		JLabel lblNomeLogin = new JLabel("");
		lblNomeLogin.setIcon(new ImageIcon("src/main/resources/TituloLogIn.png"));
		lblNomeLogin.setBounds(906, 343, 150, 40);
		contentPane.add(lblNomeLogin);

		txtUsuario = new RoundJFormattedTextField(null);
		txtUsuario.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				textField.setText("");
			}
		});
		txtUsuario.setForeground(new Color(102, 112, 133));
		txtUsuario.setText("       Digite seu usuário");
		txtUsuario.setBounds(682, 486, 547, 64);
		contentPane.add(txtUsuario);
		txtUsuario.setColumns(10);
		textField = new RoundJFormattedTextField(null);
		txtUsuario.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtUsuario.setText("");

			}
		});
		textField.setBounds(682, 486, 547, 64);
		contentPane.add(textField);
		textField.setColumns(10);

		JLabel lblUsuario = new JLabel("USUÁRIO *");
		lblUsuario.setForeground(new Color(52, 64, 84));
		lblUsuario.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblUsuario.setBounds(682, 460, 80, 14);
		contentPane.add(lblUsuario);

		JLabel lblSenha = new JLabel("SENHA *");
		lblSenha.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblSenha.setBounds(682, 590, 80, 14);
		contentPane.add(lblSenha);

		JLabel lblMostrarSenha = new JLabel("");
		lblMostrarSenha.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}

			@Override
			public void mouseExited(MouseEvent e) {
				lblMostrarSenha.setIcon(new ImageIcon("src/main/resources/mostrar senha preto.png"));
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				lblMostrarSenha.setIcon(new ImageIcon("src/main/resources/mostrar senha claro.png"));
			}
		});
		lblMostrarSenha.setIcon(new ImageIcon("src/main/resources/mostrar senha preto.png"));
		lblMostrarSenha.setBounds(687, 698, 200, 10);
		contentPane.add(lblMostrarSenha);

		JLabel lblBotaoSalvar = new JLabel("");
		lblBotaoSalvar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				// Pega a string senha do TextField
				String usuario = txtUsuario.getText();

				// Pega o vetor de senha do TextField
				char[] pass = passwordField.getPassword();

				// Cria uma variável senha pra colocar o vetor
				String senha = "";

				// Se o vetor de senha não for nulo e maior do que 0...
				if (pass != null && pass.length > 0) {

					// Atribui o vetor pra uma variavel senha
					senha = String.valueOf(pass);

				}

				if (senha.isEmpty() && usuario.isEmpty()) {
					TelaErro dadosIncorretos = new TelaErro("Insira seus dados!");
					dadosIncorretos.setLocationRelativeTo(null);
					dadosIncorretos.setVisible(true);
					passwordField.setText(null);
					txtUsuario.setText(null);
				} else if (senha.isEmpty()) {
					// Exibe mensagem de erro
					TelaErro dadosIncorretos = new TelaErro("Insira uma senha!");
					dadosIncorretos.setLocationRelativeTo(null);
					dadosIncorretos.setVisible(true);
					passwordField.setText(null);
					txtUsuario.setText(null);
				} else if (usuario.isEmpty()) {
					// Exibe mensagem de erro
					TelaErro dadosIncorretos = new TelaErro("Insira um usuário!");
					dadosIncorretos.setLocationRelativeTo(null);
					dadosIncorretos.setVisible(true);
					passwordField.setText(null);
					txtUsuario.setText(null);

				} else {
					// Cria obj Funcionário para atribuir login e senha

					// Cria uma variavel boolean login1 que verifica se há o usuário no banco
					Funcionario funcLogado = func.login(usuario, senha);

					if (funcLogado != null) {
						// Passa para a proxima tela
						TelaListagemFuncionario listaFuncionario = new TelaListagemFuncionario(funcLogado);
						setVisible(false);
						listaFuncionario.setExtendedState(MAXIMIZED_BOTH);
						listaFuncionario.setVisible(true);
					} else {
						// Exibe mensagem de erro
						TelaErro dadosIncorretos = new TelaErro("Funcionário não encontrado!");
						dadosIncorretos.setLocationRelativeTo(null);
						dadosIncorretos.setVisible(true);
					}
				}
			}

			@Override
			public void mouseExited(MouseEvent e) {
				lblBotaoSalvar.setIcon(new ImageIcon("src/main/resources/botao entrar.png"));
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				lblBotaoSalvar.setIcon(new ImageIcon("src/main/resources/Frame 670.png"));
			}
		});
		lblBotaoSalvar.setIcon(new ImageIcon("src/main/resources/botao entrar.png"));
		lblBotaoSalvar.setBounds(781, 803, 359, 59);
		contentPane.add(lblBotaoSalvar);

		JLabel lblEscritaFuncionarios = new JLabel("Funcionários");
		lblEscritaFuncionarios.setForeground(new Color(102, 112, 133));
		lblEscritaFuncionarios.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblEscritaFuncionarios.setBounds(920, 401, 90, 30);
		contentPane.add(lblEscritaFuncionarios);

		JLabel lblFundo = new JLabel(" ");
		lblFundo.setForeground(new Color(52, 64, 84));
		lblFundo.setIcon(new ImageIcon("src/main/resources/fundo verde.png"));
		lblFundo.setBounds(584, 95, 751, 895);
		contentPane.add(lblFundo);

		passwordField = new JPasswordField();
		passwordField.setBounds(682, 616, 547, 64);
		contentPane.add(passwordField);

	}
}
