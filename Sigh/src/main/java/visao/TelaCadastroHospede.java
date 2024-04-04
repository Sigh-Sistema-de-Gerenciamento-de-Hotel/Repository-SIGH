package visao;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import visao.padrao.RoundJFormattedTextField;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class TelaCadastroHospede extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField txtNumero;
	private JTextField txtCidade;
	private JTextField txtPassaporte;
	private JTextField txtResponsavel;
	private JTextField txtNomeSocial;
	private JTextField txtEmail;
	private JTextField txtComplemento;
	private JTextField txtEstado;
	private JTextField txtCpf;
	private JTextField txtData;
	private JTextField txtSobrenome;
	private JTextField txtNecessidade;
	private JTextField txtTelefone;
	private JTextField txtEndreco;
	private JTextField txtCep;
	private JTextField txtNome;

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
		lblNewLabel_1.setIcon(new ImageIcon("src/main/resources/logo sigh.png"));
		lblNewLabel_1.setBounds(134, 44, 144, 176);
		contentPane.add(lblNewLabel_1);
		
		
		
		JLabel lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setIcon(new ImageIcon("src/main/resources/menu hospedagem.png"));
		lblNewLabel_5.setBounds(68, 472, 150, 20);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_55 = new JLabel("");
		lblNewLabel_5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				lblNewLabel_5.setIcon(new ImageIcon("src/main/resources/menu hospedagem selecionado.png"));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblNewLabel_5.setIcon(new ImageIcon("src/main/resources/menu hospedagem.png"));
			}
		});
		
		
		
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon("src/main/resources/botao sair.png"));
		lblNewLabel_2.setBounds(84, 955, 263, 45);
		contentPane.add(lblNewLabel_2);
		
		
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				lblNewLabel_3.setIcon(new ImageIcon("src/main/resources/menu - pedidos selecionado.png"));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblNewLabel_3.setIcon(new ImageIcon("src/main/resources/menu pedidos.png"));
			}
		});
		lblNewLabel_3.setIcon(new ImageIcon("src/main/resources/menu pedidos.png"));
		lblNewLabel_3.setBounds(68, 346, 400, 60);
		contentPane.add(lblNewLabel_3);
		
		
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setIcon(new ImageIcon("src/main/resources/menu - hospede.png"));
		lblNewLabel_4.setBounds(68, 407, 400, 60);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_44 = new JLabel("");
		lblNewLabel_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				lblNewLabel_4.setIcon(new ImageIcon("src/main/resources/menu - hospedes selecionado.png"));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblNewLabel_4.setIcon(new ImageIcon("src/main/resources/menu - hospede.png"));
			}
		});
		
		
		
		JLabel lblNewLabel_6 = new JLabel("");
		lblNewLabel_6.setIcon(new ImageIcon("src/main/resources/menu funcionarios.png"));
		lblNewLabel_6.setBounds(68, 532, 150, 20);
		contentPane.add(lblNewLabel_6);
		
		
		JLabel lblNewLabel_66 = new JLabel("");
		lblNewLabel_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				lblNewLabel_6.setIcon(new ImageIcon("src/main/resources/menu - funcionarios selecionado.png"));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblNewLabel_6.setIcon(new ImageIcon("src/main/resources/menu funcionarios.png"));
			}
		});
		
		
		
		JLabel lblNewLabel_7 = new JLabel("");
		lblNewLabel_7.setIcon(new ImageIcon("src/main/resources/divisor (menu).png"));
		lblNewLabel_7.setBounds(77, 897, 243, 14);
		contentPane.add(lblNewLabel_7);
		
		
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(0, 0, 420, 1083);
		lblNewLabel.setIcon(new ImageIcon("src/main/resources/fundo cinza (menu).png"));
		contentPane.add(lblNewLabel);
		
		
		
		JLabel lblMenu = new JLabel("Menu");
		lblMenu.setForeground(new Color(128, 128, 128));
		lblMenu.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblMenu.setBounds(67, 289, 46, 14);
		contentPane.add(lblMenu);
		
		
		
		JLabel lblNewLabel_8 = new JLabel("");
		lblNewLabel_8.setIcon(new ImageIcon("src/main/resources/Frame 675.png"));
		lblNewLabel_8.setBounds(420, 0, 1500, 62);
		contentPane.add(lblNewLabel_8);
		
		
		
		JLabel lblNome = new JLabel("Nome *");
		lblNome.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNome.setBounds(554, 288, 55, 20);
		contentPane.add(lblNome);
		
		
		txtNome = new RoundJFormattedTextField(null);
		txtNome.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtNome.setBounds(554, 326, 343, 48);
		contentPane.add(txtNome);
		txtNome.setColumns(10);
	
		JLabel lblSobrenome = new JLabel("Sobrenome *");
		lblSobrenome.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSobrenome.setBounds(1000, 288, 90, 20);
		contentPane.add(lblSobrenome);
		
		
		
		txtSobrenome = new RoundJFormattedTextField(null);
		txtSobrenome.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtSobrenome.setBounds(1000, 326, 343, 48);
		contentPane.add(txtSobrenome);
		txtSobrenome.setColumns(17);
		
		JLabel lblNomeSocial = new JLabel("Nome Social ");
		lblNomeSocial.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNomeSocial.setBounds(1460, 288, 100, 20);
		contentPane.add(lblNomeSocial);
		
		
		
		txtNomeSocial = new RoundJFormattedTextField(null);
		txtNomeSocial.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtNomeSocial.setBounds(1460, 326, 343, 48);
		contentPane.add(txtNomeSocial);
		txtNomeSocial.setColumns(23);
	
		
		JLabel lblGenero = new JLabel("Gênero *");
		lblGenero.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblGenero.setBounds(554, 390, 100, 20);
		contentPane.add(lblGenero);
		
		JLabel lblData = new JLabel("Data de Nascimento *");
		lblData.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblData.setBounds(1000, 390, 200, 20);
		contentPane.add(lblData);
		
		
		
		txtData = new RoundJFormattedTextField(null);
		txtData.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtData.setBounds(1000, 415, 343, 48);
		contentPane.add(txtData);
		txtData.setColumns(18);
		
		JLabel lblResponsável = new JLabel("Responsável ");
		lblResponsável.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblResponsável.setBounds(1460, 390, 100, 20);
		contentPane.add(lblResponsável);
		
		
		
		txtResponsavel = new RoundJFormattedTextField(null);
		txtResponsavel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtResponsavel.setBounds(1460, 415, 343, 48);
		contentPane.add(txtResponsavel);
		txtResponsavel.setColumns(24);
		
		
		
		JLabel lblNacionalidade = new JLabel("Nacionalidade *");
		lblNacionalidade.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNacionalidade.setBounds(554, 480, 100, 20);
		contentPane.add(lblNacionalidade);
		
		JLabel lblCpf = new JLabel("CPF ");
		lblCpf.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCpf.setBounds(1000, 480, 100, 20);
		contentPane.add(lblCpf);
		
		
		
		txtCpf = new RoundJFormattedTextField(null);
		txtCpf.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtCpf.setBounds(1000, 515, 343, 48);
		contentPane.add(txtCpf);
		txtCpf.setColumns(12);
		
		JLabel lblPassaporte = new JLabel("Passaporte ");
		lblPassaporte.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPassaporte.setBounds(1460, 480, 100, 20);
		contentPane.add(lblPassaporte);
		
		
		
		txtPassaporte = new RoundJFormattedTextField(null);
		txtPassaporte.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtPassaporte.setBounds(1460, 515, 343, 48);
		contentPane.add(txtPassaporte);
		txtPassaporte.setColumns(25);
		
		
		
		JLabel lblCep = new JLabel("Cep *");
		lblCep.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCep.setBounds(554, 570, 100, 20);
		contentPane.add(lblCep);
		
		
		
		txtCep = new RoundJFormattedTextField(null);
		txtCep.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtCep.setBounds(554, 615, 343, 48);
		contentPane.add(txtCep);
		txtCep.setColumns(13);
		

		JLabel lblEstado = new JLabel("Estado *");
		lblEstado.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblEstado.setBounds(1000, 570, 100, 20);
		contentPane.add(lblEstado);
		
		
		
		txtEstado = new RoundJFormattedTextField(null);
		txtEstado.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtEstado.setBounds(1000, 615, 343, 48);
		contentPane.add(txtEstado);
		txtEstado.setColumns(20);
		
		
		JLabel lblCidade = new JLabel("Cidade *");
		lblCidade.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCidade.setBounds(1460, 570, 100, 20);
		contentPane.add(lblCidade);
		
		
		
		txtCidade = new RoundJFormattedTextField(null);
		txtCidade.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtCidade.setBounds(1460, 615, 343, 48);
		contentPane.add(txtCidade);
		txtCidade.setColumns(26);
		
		
		JLabel lblEndereco = new JLabel("Endereço *");
		lblEndereco.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblEndereco.setBounds(554, 670, 100, 20);
		contentPane.add(lblEndereco);
		
		
		
		txtEndreco = new RoundJFormattedTextField(null);
		txtEndreco.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtEndreco.setBounds(554, 715, 343, 48);
		contentPane.add(txtEndreco);
		txtEndreco.setColumns(14);
		

		JLabel lblComplemento = new JLabel("Complemento ");
		lblComplemento.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblComplemento.setBounds(1000, 670, 100, 20);
		contentPane.add(lblComplemento);
		
		
		
		txtComplemento = new RoundJFormattedTextField(null);
		txtComplemento.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtComplemento.setBounds(1000, 715, 343, 48);
		contentPane.add(txtComplemento);
		txtComplemento.setColumns(21);
		

		JLabel lblNumero = new JLabel("Número *");
		lblNumero.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNumero.setBounds(1460, 670, 100, 20);
		contentPane.add(lblNumero);
		
		
		
		txtNumero = new RoundJFormattedTextField(null);
		txtNumero.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtNumero.setBounds(1460, 715, 343, 48);
		contentPane.add(txtNumero);
		txtNumero.setColumns(27);
		
		
		
		JLabel lblTelefone = new JLabel("Telefone *");
		lblTelefone.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTelefone.setBounds(554, 780, 100, 20);
		contentPane.add(lblTelefone);
		
		
		
		txtTelefone = new RoundJFormattedTextField(null);
		txtTelefone.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtTelefone.setBounds(554, 815, 343, 48);
		contentPane.add(txtTelefone);
		txtTelefone.setColumns(15);
		

		JLabel lblEmail = new JLabel("Email *");
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblEmail.setBounds(1000, 780, 100, 20);
		contentPane.add(lblEmail);
		
		
		
		txtEmail = new RoundJFormattedTextField(null);
		txtEmail.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtEmail.setBounds(1000, 815, 343, 48);
		contentPane.add(txtEmail);
		txtEmail.setColumns(15);
		
		
		
		JLabel lblNecessidade = new JLabel("Necessidade Especial");
		lblNecessidade.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNecessidade.setBounds(554, 870, 200, 20);
		contentPane.add(lblNecessidade);
		
		txtNecessidade  = new RoundJFormattedTextField(null);
		txtNecessidade.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtNecessidade.setBounds(554, 915, 343, 48);
		contentPane.add(txtNecessidade);
		txtNecessidade.setColumns(16);
		
		
		
		
		
		
		
		
		
		
		JLabel lblNewLabel_9 = new JLabel("");
		lblNewLabel_9.setIcon(new ImageIcon("src/main/resources/Hero block.png"));
		lblNewLabel_9.setBounds(446, 108, 1455, 119);
		contentPane.add(lblNewLabel_9);
		
		JLabel lblNewLabel_28 = new JLabel("");
		lblNewLabel_28.setIcon(new ImageIcon("src/main/resources/botao salvar.png"));
		lblNewLabel_28.setBounds(1300, 915, 300, 60);
		contentPane.add(lblNewLabel_28);
		
		JLabel lblNewLabel_29 = new JLabel("");
		lblNewLabel_29.setIcon(new ImageIcon("src/main/resources/botao cancelar.png"));
		lblNewLabel_29.setBounds(1670, 930, 150, 40);
		contentPane.add(lblNewLabel_29);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Feminino ", "Masculino"}));
		comboBox.setBounds(554, 415, 343, 48);
		contentPane.add(comboBox);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {" afegão", " ", "albanês", " ", " angolano", " ", " argentino  ", 
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
				" ", "Sueco  ", " ", "Suíço  ", " ", "Tailandês  ", " ", "Togolês  ", " ", "Tunisino  ", " ", "Tuurco ", " ", "Ucraniano  ", " ", "Ugandês  ", " ", "Árabe  ", "", "Britânico  ", " ", "Americano", " ",
				"Uruguaio  ", " ", "Venezuelano  ", " ", "Vietnamita  "}));
		comboBox_1.setBounds(554, 515, 343, 48);
		contentPane.add(comboBox_1);
		
	}
}
