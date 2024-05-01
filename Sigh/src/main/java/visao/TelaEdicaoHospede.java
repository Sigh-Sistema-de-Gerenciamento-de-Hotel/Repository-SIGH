package visao;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controle.funcionario.FuncionarioDAO;
import controle.hospede.HospedeDAO;
import modelo.Endereco;
import modelo.Funcionario;
import modelo.Hospede;
import visao.padrao.DateTextField;
import visao.padrao.RoundJFormattedTextField;

import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.LocalDate;

import javax.swing.JTextField;
import javax.swing.JComboBox;

public class TelaEdicaoHospede extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtNome;
	private JTextField txtCep;
	private JTextField txtEndereco;
	private JTextField txtSobrenome;
	private JTextField txtData;
	private JLabel lblCPF;
	private JTextField txtCPF;
	private JTextField txtEstado;
	private JTextField txtComplemento;
	private Hospede hosEditar;
	private static Funcionario funcionarioLogado;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaEdicaoHospede frame = new TelaEdicaoHospede();
					frame.setVisible(true);
					frame.setExtendedState(JFrame.MAXIMIZED_BOTH); 
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}   */

	/**
	 * Create the frame.
	 */
	public TelaEdicaoHospede(Funcionario hosLogado, Hospede hosEditar) {
		funcionarioLogado = hosLogado;
		this.hosEditar = hosEditar;
		setIconImage(Toolkit.getDefaultToolkit().getImage("src/main/resources/logo sigh.png"));
		setTitle("Edição de Hóspedes");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100,  1920, 1080);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		JLabel lblBotaoSair = new JLabel("");
		lblBotaoSair.setBounds(84, 958, 270, 40);
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
		
		JLabel lblBotaoCancelar = new JLabel("");
		lblBotaoCancelar.setBounds(1595, 902, 300, 50);
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
		
		JLabel lblBotaoSalvar = new JLabel("");
		lblBotaoSalvar.setBounds(1245, 902, 343, 50);
		lblBotaoSalvar.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {

				HospedeDAO dao = HospedeDAO.getInstancia();
				
				String nome = txtNome.getText();
				if(nome.isEmpty()) {
					// ERRO
				} else {
					hosEditar.setNome(nome);
				}
				
				String sobrenome = txtSobrenome.getText();
				if(sobrenome.isEmpty()){
					// ERRO
				} else {
					hosEditar.setSobrenome(sobrenome);
				}
				
		//		String nomeSocial = txtNomeSocial.getText();
		//		funcEditar.setNomeSocial(nomeSocial);
				
		/*		String genero = comboBox.getSelectedItem();
				if(genero.isEmpty()) {
					// ERRO
				}  else {
					hosEditar.setSelectedItem(genero);
				}   */
				
				
		/*		String nacionalidade = comboBox_1.getSelectedItem();
				if(nacionalidade.isEmpty()) {
					// ERRO
				} else {
					hosEditar.setSelectedItem(nacionalidade);
				}    */
				
		/*		String passaporte = txtPassaporte.getText();
				if (passaporte.isEmpty()) {
					// ERRO
				} else {
					hosEditar.setPassaporte(passaporte);
				}   */
				
		/*		String email = txtEmail.getText();
				if (email.isEmpty()) {
					// ERRO
				} else {
					hosEditar.setEmail(email);
				}  */
				
			//	LocaDate dataNascimento = txtData.getText(); 
			//	hosEditar.setDataNascimento(dataNascimento);
				
			//  Endereco endereco = txtEndereco.getText();
			//  hosEditar.setEndereco(endereco);
				
				boolean validacao = dao.atualizarHospede(hosEditar);
				if (validacao == true) {
					TelaListagemHospede lh = new TelaListagemHospede(hosLogado);
					lh.setVisible(true);
					lh.setExtendedState(JFrame.MAXIMIZED_BOTH);
					/*TelaConfirmacao telaConfirmacao = new TelaConfirmacao(func.getPrimeiroNome(), func.getSobrenome(),
							func.getNomeSocial(), func.getUsuario(), func.getCargo());
					telaConfirmacao.setVisible(true);*/
					dispose();
				} else {
					// mensagem de ERRO
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
		
		JLabel lblPedidos = new JLabel("");
		lblPedidos.setBounds(68, 348, 335, 50);
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
		lblHospedes.setBounds(68, 410, 335, 50);
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
		lblHospedagem.setBounds(68, 472, 335, 50);
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
		
		JLabel lblFuncionarios = new JLabel("");
		lblFuncionarios.setBounds(68, 523, 335, 50);
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
		contentPane.setLayout(null);
		
		JLabel lblConta = new JLabel("Conta");
		lblConta.setBounds(79, 760, 46, 14);
		lblConta.setForeground(new Color(128, 128, 128));
		lblConta.setFont(new Font("Tahoma", Font.BOLD, 15));
		contentPane.add(lblConta);
		
		JLabel lblNomeUsuario = new JLabel("JULIA ALMEIDA");
		lblNomeUsuario.setBounds(129, 798, 100, 14);
		contentPane.add(lblNomeUsuario);
		
		lblFuncionarios.setIcon(new ImageIcon("src/main/resources/menu funcionarios.png"));
		contentPane.add(lblFuncionarios);
		
		lblHospedagem.setIcon(new ImageIcon("src/main/resources/menu hospedagem.png"));
		contentPane.add(lblHospedagem);
		
		lblHospedes.setIcon(new ImageIcon("src/main/resources/menu - hospede.png"));
		contentPane.add(lblHospedes);
		
		lblPedidos.setIcon(new ImageIcon("src/main/resources/menu pedidos.png"));
		contentPane.add(lblPedidos);
		
		lblBotaoSalvar.setIcon(new ImageIcon("src/main/resources/botao salvar.png"));
		contentPane.add(lblBotaoSalvar);
		
		lblBotaoCancelar.setIcon(new ImageIcon("src/main/resources/botao cancelar.png"));
		contentPane.add(lblBotaoCancelar);
		
		lblBotaoSair.setIcon(new ImageIcon("src/main/resources/botao sair.png"));
		lblBotaoCancelar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				TelaListagemHospede telaListHos = new TelaListagemHospede(hosLogado);
				telaListHos.setVisible(true);
				telaListHos.setExtendedState(JFrame.MAXIMIZED_BOTH);
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
		contentPane.add(lblBotaoSair);
		
		JLabel lblMenu = new JLabel("Menu");
		lblMenu.setBounds(67, 289, 46, 14);
		lblMenu.setForeground(new Color(128, 128, 128));
		lblMenu.setFont(new Font("Tahoma", Font.BOLD, 15));
		contentPane.add(lblMenu);
		
		JLabel lblLogo = new JLabel("");
		lblLogo.setBounds(134, 44, 144, 176);
		lblLogo.setIcon(new ImageIcon("src/main/resources/logo sigh.png"));
		contentPane.add(lblLogo);
		
		JLabel lblFundoCinza = new JLabel("");
		lblFundoCinza.setBounds(0, 0, 420, 1080);
		lblFundoCinza.setIcon(new ImageIcon("src/main/resources/fundo cinza (menu).png"));
		contentPane.add(lblFundoCinza);
		
		JLabel lblCaminho = new JLabel("");
		lblCaminho.setBounds(420, 0, 1500, 62);
		lblCaminho.setIcon(new ImageIcon("src/main/resources/CaminhoEditarHospedes.png"));
		contentPane.add(lblCaminho);
		
		JLabel lblTitulo = new JLabel("");
		lblTitulo.setBounds(445, 105, 1455, 119);
		lblTitulo.setIcon(new ImageIcon("src/main/resources/TituloEditarHospedes.png"));
		contentPane.add(lblTitulo);
		
		JLabel lblNome = new JLabel("Nome*");
		lblNome.setBounds(554, 288, 55, 20);
		lblNome.setFont(new Font("Tahoma", Font.PLAIN, 14));
		contentPane.add(lblNome);
		
		String nome = hosEditar.getNome();
		
		txtNome = new RoundJFormattedTextField(null);
		txtNome.setBounds(554, 326, 343, 48);
		txtNome.setFont(new Font("Tahoma", Font.PLAIN, 14));
		contentPane.add(txtNome);
		txtNome.setColumns(10);
		
		JLabel lblGenero = new JLabel("Gênero*");
		lblGenero.setBounds(554, 390, 100, 20);
		lblGenero.setFont(new Font("Tahoma", Font.PLAIN, 14));
		contentPane.add(lblGenero);
		
		JComboBox comboBoxGenero = new JComboBox();
		comboBoxGenero.setBounds(554, 415, 343, 48);
		comboBoxGenero.setModel(new DefaultComboBoxModel(new String[] {"Feminino ", "Masculino"}));
		contentPane.add(comboBoxGenero);
		
		JLabel lblNacionalidade = new JLabel("Nacionalidade*");
		lblNacionalidade.setBounds(554, 480, 100, 20);
		lblNacionalidade.setFont(new Font("Tahoma", Font.PLAIN, 14));
		contentPane.add(lblNacionalidade);
		
		JComboBox comboBoxNacionalidade = new JComboBox();
		comboBoxNacionalidade.setBounds(554, 515, 343, 48);
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
		contentPane.add(comboBoxNacionalidade);
		
		JLabel lblCep = new JLabel("Cep*");
		lblCep.setBounds(556, 583, 100, 20);
		lblCep.setFont(new Font("Tahoma", Font.PLAIN, 14));
		contentPane.add(lblCep);
		
	//	String cep = hosEditar.getCep();
		
		txtCep = new RoundJFormattedTextField(null);
		txtCep.setBounds(554, 615, 343, 48);
		txtCep.setFont(new Font("Tahoma", Font.PLAIN, 14));
		contentPane.add(txtCep);
		txtCep.setColumns(10);
		
		JLabel lblEndereco = new JLabel("Endereço*");
		lblEndereco.setBounds(554, 670, 100, 20);
		lblEndereco.setFont(new Font("Tahoma", Font.PLAIN, 14));
		contentPane.add(lblEndereco);
		
		Endereco endereco = hosEditar.getEndereco();
		
		txtEndereco = new RoundJFormattedTextField(null);
		txtEndereco.setBounds(553, 703, 343, 48);
		txtEndereco.setFont(new Font("Tahoma", Font.PLAIN, 14));
		contentPane.add(txtEndereco);
		txtEndereco.setColumns(10);
		
		JLabel lblSobrenome = new JLabel("Sobrenome*");
		lblSobrenome.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSobrenome.setBounds(1000, 288, 100, 20);
		contentPane.add(lblSobrenome);
		
		String sobrenome = hosEditar.getSobrenome();
		
		txtSobrenome = new RoundJFormattedTextField(null);
		txtSobrenome.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtSobrenome.setBounds(1001, 323, 343, 48);
		contentPane.add(txtSobrenome);
		txtSobrenome.setColumns(10);
		
		JLabel lblData = new JLabel("Data de Nascimento*");
		lblData.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblData.setBounds(1002, 394, 148, 20);
		contentPane.add(lblData);
		
		LocalDate data = hosEditar.getDataNascimento();
		
		txtData = new DateTextField();
		txtData.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtData.setBounds(1000, 415, 343, 48);
		contentPane.add(txtData);
		txtData.setColumns(10);
		
		lblCPF = new JLabel("CPF*");
		lblCPF.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCPF.setBounds(1003, 484, 100, 20);
		contentPane.add(lblCPF);
		
		int cpf = hosEditar.getCpf();
		
		txtCPF = new RoundJFormattedTextField(null);
		txtCPF.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtCPF.setBounds(1000, 515, 343, 48);
		contentPane.add(txtCPF);
		txtCPF.setColumns(10);
		
		JLabel lblEstado = new JLabel("Estado*");
		lblEstado.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblEstado.setBounds(1000, 585, 100, 20);
		contentPane.add(lblEstado);
		
	//	String estado = hosEditar.getEstado();
		
		txtEstado = new RoundJFormattedTextField(null);
		txtEstado.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtEstado.setBounds(1000, 615, 343, 48);
		contentPane.add(txtEstado);
		txtEstado.setColumns(10);
		
		JLabel lblComplemento = new JLabel("Complemento*");
		lblComplemento.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblComplemento.setBounds(1000, 670, 100, 20);
		contentPane.add(lblComplemento);
		
		
		txtComplemento = new RoundJFormattedTextField(null);
		txtComplemento.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtComplemento.setBounds(999, 704, 343, 48);
		contentPane.add(txtComplemento);
		txtComplemento.setColumns(10);
	}

}
