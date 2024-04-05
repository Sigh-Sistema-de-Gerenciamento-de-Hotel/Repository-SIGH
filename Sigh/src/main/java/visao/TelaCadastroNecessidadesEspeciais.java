package visao;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import visao.padrao.RoundJFormattedTextField;

import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTextField;
import javax.swing.JComboBox;

public class TelaCadastroNecessidadesEspeciais extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtNome;
	private JTextField txtSobrenome;
	private JTextField txtDescricao;
	private JTextField txtNecessidadeEspecial1;
	private JTextField txtNecessidadeEspecial2;
	private JTextField txtNecessidadeEspecial3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCadastroNecessidadesEspeciais frame = new TelaCadastroNecessidadesEspeciais();
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
	public TelaCadastroNecessidadesEspeciais() {
		setTitle("Cadastro de Necessidades Especiais");
		setIconImage(Toolkit.getDefaultToolkit().getImage("src/main/resources/logo sigh.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1386, 860);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
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
		lblFuncionarios.setIcon(new ImageIcon("src/main/resources/menu funcionarios.png"));
		lblFuncionarios.setBounds(68, 523, 335, 50);
		contentPane.add(lblFuncionarios);
		
		JLabel lblHospedagem = new JLabel("");
		lblHospedagem.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
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
		lblHospedagem.setIcon(new ImageIcon("src/main/resources/menu hospedagem.png"));
		lblHospedagem.setBounds(68, 472, 335, 50);
		contentPane.add(lblHospedagem);
		
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
		lblHospedes.setIcon(new ImageIcon("src/main/resources/menu - hospede.png"));
		lblHospedes.setBounds(68, 410, 335, 50);
		contentPane.add(lblHospedes);
		
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
		lblPedidos.setIcon(new ImageIcon("src/main/resources/menu pedidos.png"));
		lblPedidos.setBounds(68, 348, 335, 50);
		contentPane.add(lblPedidos);
		
		JLabel lblMenu = new JLabel("Menu");
		lblMenu.setForeground(new Color(128, 128, 128));
		lblMenu.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblMenu.setBounds(67, 289, 46, 14);
		contentPane.add(lblMenu);
		
		JLabel lblLogo = new JLabel("");
		lblLogo.setIcon(new ImageIcon("src/main/resources/logo sigh.png"));
		lblLogo.setBounds(131, 35, 150, 200);
		contentPane.add(lblLogo);
		
		JLabel lblBotaoSair = new JLabel("");
		lblBotaoSair.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
				setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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

		lblBotaoSair.setIcon(new ImageIcon("src/main/resources/botao sair.png"));
		lblBotaoSair.setBounds(84, 958, 270, 40);
		contentPane.add(lblBotaoSair);
		
		JLabel lblConta = new JLabel("Conta");
		lblConta.setForeground(new Color(128, 128, 128));
		lblConta.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblConta.setBounds(79, 760, 46, 14);
		contentPane.add(lblConta);
		
		JLabel lblNomeUsuario = new JLabel("JULIA ALMEIDA");
		lblNomeUsuario.setBounds(129, 798, 100, 14);
		contentPane.add(lblNomeUsuario);
		
		JLabel lblBotaoSalvar = new JLabel("");
		lblBotaoSalvar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
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

		lblBotaoSalvar.setIcon(new ImageIcon("src/main/resources/botao salvar.png"));
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
		
	
		lblBotaoCancelar.setIcon(new ImageIcon("src/main/resources/botao cancelar.png"));
		lblBotaoCancelar.setBounds(1595, 902, 300, 50);
		contentPane.add(lblBotaoCancelar);
		
		JLabel lblNome = new JLabel("Nome*");
		lblNome.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNome.setBounds(554, 306, 139, 14);
		contentPane.add(lblNome);
		
		txtNome = new RoundJFormattedTextField(null);
		txtNome.setBounds(554, 326, 343, 48);
		contentPane.add(txtNome);
		txtNome.setColumns(10);
		
		JLabel lblNacionalidade = new JLabel("Nacionalidade*");
		lblNacionalidade.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNacionalidade.setBounds(554, 495, 231, 14);
		contentPane.add(lblNacionalidade);
		
		JLabel lblSobrenome = new JLabel("Sobrenome*");
		lblSobrenome.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSobrenome.setBounds(554, 410, 150, 14);
		contentPane.add(lblSobrenome);
		
		txtSobrenome = new RoundJFormattedTextField(null);
		txtSobrenome.setBounds(554, 430, 343, 48);
		contentPane.add(txtSobrenome);
		txtSobrenome.setColumns(10);
		
		JLabel lblDescricao = new JLabel("Descrição*");
		lblDescricao.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDescricao.setBounds(554, 608, 112, 26);
		contentPane.add(lblDescricao);
		
		txtDescricao = new RoundJFormattedTextField(null);
		txtDescricao.setBounds(554, 645, 343, 85);
		contentPane.add(txtDescricao);
		txtDescricao.setColumns(10);
		
		JComboBox comboBoxNacionalidade = new JComboBox();
		comboBoxNacionalidade.setModel(new DefaultComboBoxModel(new String[] {" afegão", " ", "albanês", " ", " angolano", " ", " argentino  ", 
				" ", " australiano  ", " ", " austríaco ", " ", " bangladês ", " ", " barbadiano  ", " ", "bielorrusso  ", " ", 
				" belizenho ", " ", "Belga  ", " ", "Boliviano  ", " ", "Brasileiro  ", " ", "Bbúlgaro  ", " ", "Butanês  ", " ", "Camaronês  ",
				" ", "Canadense  ", " ", "Chileno  ", " ", "Chinês  ", " ", "Colombiano  ", " ", "Costa-riquenho  ",
				" ", "Croata  ", " ", "Cubano  ", " ", "Dinamarquês  ", " ", "Dominicano  ", " ",
				"Equatoriano  ", " ", "Egípcio  ", " ", "Salvadorenho  ", " ", "Inglês  ", " ",
				"Etíope  ", " ", "Finlandês  ", " ", "Francês  ", " ", "Ganese/ganês  ", " ", "Alemão  ",
				" ", "Grego  ", " ", "Guatemalteco  ", " ", "Guianês  ", " ", "Haitiano  ", " ", "Húngaro  ", 
				" ", "Iindiano  ", " ", "Iraniano  ", " ", "Irraquiano  ", " ", "Irlandês  ", " ", "Israelita  ", " ",
				"Iitaliano  ", " ", "Costa-marfinense  ", " ", "Japonês  ", " ", "Jordaniana  ", " ", "Queniano  ", " ", "Kuwaitiano  ", 
				" ", "Libanês  ", " ", "Líbio  ", " ", "Llituano  ", " ", "Luxemburguês  ", " ", "Madagascarense/ malgaxe  ", " ", "Malaio  ",
				" ", "Mexicano  ", " ", "Marroquino  ", " ", "Moçambiquenho ", " ", "Nepalês", "  ", "Holandês  ", " ", "Neozelandês  ", 
				" ", "Nicaraguense  ", " ", "Nigeriano  ", " ", "Norueguês  ", " ", "Norte-coreano  ", " ", "Panamenho  ", " ", "Paraguaio  ", " ",
				"Peruano  ", " ", "Filipino  ", " ", "Polonês  ", " ", "Português  ", " ", "Romeno  ", " ", "Russo  ", " ", "Senegalês  ", " ", "Sérvio  ", " ", "Singapuriano  ", " ", "Sírio  ", " ", "Sslovaco  ", " ", "Esloveno  ", " ", "Sul-africano  ", " ", "Sul-coreano  ", "", "Espanhol  ", " ", "Surimanês  ",
				" ", "Sueco  ", " ", "Suíço  ", " ", "Tailandês  ", " ", "Togolês  ", " ", "Tunisino  ", " ", "Tuurco ", " ", "Ucraniano  ", 
				" ", "Ugandês  ", " ", "Árabe  ", "", "Britânico  ", " ", "Americano", " ",
				"Uruguaio  ", " ", "Venezuelano  ", " ", "Vietnamita  "}));
		
		
		comboBoxNacionalidade.setBounds(553, 526, 343, 48);
		contentPane.add(comboBoxNacionalidade);
		
		JLabel lblNecessidadeEspecial1 = new JLabel("Necessidade Especial*");
		lblNecessidadeEspecial1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNecessidadeEspecial1.setBounds(1112, 304, 158, 19);
		contentPane.add(lblNecessidadeEspecial1);
		
		JLabel lblNecessidadeEspecial2 = new JLabel("Necessidade Especial*");
		lblNecessidadeEspecial2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNecessidadeEspecial2.setBounds(1112, 408, 158, 19);
		contentPane.add(lblNecessidadeEspecial2);
		
		txtNecessidadeEspecial1 = new RoundJFormattedTextField(null);
		txtNecessidadeEspecial1.setBounds(1112, 326, 343, 48);
		contentPane.add(txtNecessidadeEspecial1);
		txtNecessidadeEspecial1.setColumns(10);
		
		txtNecessidadeEspecial2 = new RoundJFormattedTextField(null);
		txtNecessidadeEspecial2.setBounds(1112, 430, 343, 48);
		contentPane.add(txtNecessidadeEspecial2);
		txtNecessidadeEspecial2.setColumns(10);
		
		JLabel lblNecessidadeEspecial3 = new JLabel("Necessidade Especial*");
		lblNecessidadeEspecial3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNecessidadeEspecial3.setBounds(1112, 506, 150, 19);
		contentPane.add(lblNecessidadeEspecial3);
		
		txtNecessidadeEspecial3 = new RoundJFormattedTextField(null);
		txtNecessidadeEspecial3.setBounds(1112, 533, 343, 48);
		contentPane.add(txtNecessidadeEspecial3);
		txtNecessidadeEspecial3.setColumns(10);
		
		JLabel lblFundoCinza = new JLabel("");
		lblFundoCinza.setIcon(new ImageIcon("src/main/resources/fundo cinza (menu).png"));
		lblFundoCinza.setBounds(0, 0, 420, 1080);
		contentPane.add(lblFundoCinza);
		
		JLabel lblCaminho = new JLabel("");
		lblCaminho.setIcon(new ImageIcon("src/main/resources/CaminhoCadastrarNecessidadesEspeciais.png"));
		lblCaminho.setBounds(420, 0, 1500, 62);
		contentPane.add(lblCaminho);
		
		JLabel lblTitulo = new JLabel("");
		lblTitulo.setIcon(new ImageIcon("src/main/resources/TituloCadastrarNecessidadesEspeciais.png"));
		lblTitulo.setBounds(445, 105, 1455, 119);
		contentPane.add(lblTitulo);
		
	}
}
