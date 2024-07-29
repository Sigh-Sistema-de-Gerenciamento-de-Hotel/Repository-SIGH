package visao;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controle.endereco.EnderecoDAO;
import controle.hospede.HospedeDAO;
import controle.quarto.QuartoDAO;
import modelo.Endereco;
import modelo.Funcionario;
import modelo.Hospedagem;
import modelo.Hospede;
import modelo.Quarto;
import visao.padrao.DateTextField;
import visao.padrao.RoundJFormattedTextField;

import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;

import java.awt.Font;
import java.awt.GraphicsConfiguration;

import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.LocalDate;

public class TelaEdicaoQuarto extends JFrame {

	private static final long serialVersionUID = 1L;
	protected static final GraphicsConfiguration QuartLogado = null;
	private JPanel contentPane;
	private JTextField txtNumQuarto;
	private JComboBox<Integer>comboCamaCasal;
	private JComboBox<Integer>comboCamaSolteiro;
	private JComboBox<Integer>comboMaxDeHospedes;
	private JComboBox comboArCondicionado;
	private JComboBox comboFrigobar;
	private JComboBox comboBanheira;
	private JTextField txtAcessibilidade;
	private JComboBox comboLimpeza;
	private JComboBox comboConserto;
	private JTextField txtPreco;
	private Quarto quartoEditar;
	private static Funcionario funcionarioLogado;
	

	/**
	 * Create the frame.
	 */
	public TelaEdicaoQuarto(Funcionario funcLogado, Quarto quaEditar) {
		funcionarioLogado = funcLogado;
		quartoEditar = quaEditar;
		setIconImage(Toolkit.getDefaultToolkit().getImage("src/main/resources/logo sigh.png"));
		setTitle("Edição Quarto");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1920, 1080);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JLabel lblQuartos = new JLabel("");
		lblQuartos.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				TelaListagemQuarto tlq = new TelaListagemQuarto(funcionarioLogado);
				tlq.setVisible(true);
				tlq.setExtendedState(JFrame.MAXIMIZED_BOTH);
				dispose();
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				lblQuartos.setIcon(new ImageIcon("src/main/resources/menu - quartos selecionado.png"));//
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblQuartos.setIcon(new ImageIcon("src/main/resources/menu quartoss.png"));
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
		
		JLabel lblMenu = new JLabel("Menu");
		lblMenu.setForeground(new Color(128, 128, 128));
		lblMenu.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblMenu.setBounds(67, 289, 46, 14);
		contentPane.add(lblMenu);
		
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
		
		JLabel lblLogoSigh = new JLabel("");
		lblLogoSigh.setIcon(new ImageIcon("src/main/resources/logo sigh.png"));
		lblLogoSigh.setBounds(135, 46, 144, 176);
		contentPane.add(lblLogoSigh);
		lblQuartos.setIcon(new ImageIcon("src/main/resources/menu quartoss.png"));
		lblQuartos.setBounds(67, 344, 336, 50);
		contentPane.add(lblQuartos);
		
		JLabel lblFundoCinza = new JLabel("");
		lblFundoCinza.setIcon(new ImageIcon("src/main/resources/fundo cinza (menu).png"));
		lblFundoCinza.setBounds(0, 0, 420, 1080);
		contentPane.add(lblFundoCinza);
		
		JLabel lblTituloEditarQuarto = new JLabel("");
		lblTituloEditarQuarto.setIcon(new ImageIcon("src/main/resources/TituloEditarQuarto.png"));
		lblTituloEditarQuarto.setBounds(446, 108, 1455, 126);
		contentPane.add(lblTituloEditarQuarto);
		
		
		JLabel lblNumQuarto = new JLabel("Número do Quarto*");
		lblNumQuarto.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNumQuarto.setBounds(514, 344, 134, 22);
		contentPane.add(lblNumQuarto);
		
		int numero = quartoEditar.getNumero();
		
		txtNumQuarto = new RoundJFormattedTextField(null);
		txtNumQuarto.setBounds(514, 372, 334, 48);
		contentPane.add(txtNumQuarto);
		txtNumQuarto.setColumns(10);
		
		JLabel lblCamaCasal = new JLabel("Cama Casal");
		lblCamaCasal.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCamaCasal.setBounds(514, 448, 112, 22);
		contentPane.add(lblCamaCasal);
		
		int numCamaCasal = quartoEditar.getNumCamaCasal();
		
		comboCamaCasal = new JComboBox<Integer>();
		comboCamaCasal.setModel(new DefaultComboBoxModel(new Integer[] { 0, 1, 2}));
		comboCamaCasal.setBounds(514, 481, 343, 50);
		contentPane.add(comboCamaCasal);
		
		JLabel lblCamaSolteiro = new JLabel("Cama Solteiro");
		lblCamaSolteiro.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCamaSolteiro.setBounds(514, 565, 112, 22);
		contentPane.add(lblCamaSolteiro);
		
		int numCamaSolteiro = quartoEditar.getNumCamaSolteiro();
		
		comboCamaSolteiro = new JComboBox<Integer>();
		comboCamaSolteiro.setModel(new DefaultComboBoxModel(new Integer[] {  0, 1, 2}));
		comboCamaSolteiro.setBounds(514, 598, 343, 50);
		contentPane.add(comboCamaSolteiro);
		
		JLabel lblMaxDeHospedes = new JLabel("Máximo de Hóspdes*");
		lblMaxDeHospedes.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblMaxDeHospedes.setBounds(514, 693, 134, 22);
		contentPane.add(lblMaxDeHospedes);
		
		int MaxDeHospedes = quaEditar.getNumMaxHospedes();
		
		comboMaxDeHospedes = new JComboBox<Integer>();
		comboMaxDeHospedes.setModel(new DefaultComboBoxModel(new Integer[] { 0, 1, 2, 3, 4}));
		comboMaxDeHospedes.setBounds(514, 730, 343, 50);
		contentPane.add(comboMaxDeHospedes);
		
		JLabel lblArCondicionado = new JLabel("Ar Condicionado");
		lblArCondicionado.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblArCondicionado.setBounds(1002, 350, 136, 22);
		contentPane.add(lblArCondicionado);
		
		Boolean ArCondicionado = quaEditar.isArCondicionado();
				
		comboArCondicionado = new JComboBox();
		comboArCondicionado.setModel(new DefaultComboBoxModel(new String[] { "", "sim", "não" }));
		comboArCondicionado.setBounds(1002, 393, 343, 50);
		contentPane.add(comboArCondicionado);
		
		JLabel lblFrigobar = new JLabel("Frigobar");
		lblFrigobar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblFrigobar.setBounds(1002, 454, 121, 22);
		contentPane.add(lblFrigobar);
		
		Boolean Frigobar = quaEditar.isFrigobar();
		
		comboFrigobar = new JComboBox();
		comboFrigobar.setModel(new DefaultComboBoxModel(new String[] { "", "sim", "não" }));
		comboFrigobar.setBounds(1002, 493, 343, 50);
		contentPane.add(comboFrigobar);
		
		JLabel lblBanheira = new JLabel("Banheira");
		lblBanheira.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblBanheira.setBounds(1002, 571, 121, 22);
		contentPane.add(lblBanheira);
		
		Boolean Banheira = quaEditar.isBanheira();
		
		comboBanheira = new JComboBox();
		comboBanheira.setModel(new DefaultComboBoxModel(new String[] { "", "sim", "não" }));
		comboBanheira.setBounds(1002, 616, 343, 50);
		contentPane.add(comboBanheira);
		
		JLabel lblAcessibilidade = new JLabel("Acessibilidade");
		lblAcessibilidade.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblAcessibilidade.setBounds(1002, 699, 121, 22);
		contentPane.add(lblAcessibilidade);
		
		String acessibilidade = quartoEditar.isAcessibilidade();
		
		txtAcessibilidade = new RoundJFormattedTextField(null);
		txtAcessibilidade.setBounds(1002, 731, 334, 48);
		contentPane.add(txtAcessibilidade);
		txtAcessibilidade.setColumns(10);
		
		JLabel lblLimpeza = new JLabel("Limpeza");
		lblLimpeza.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblLimpeza.setBounds(1472, 350, 121, 22);
		contentPane.add(lblLimpeza);
		
		Boolean Limpeza = quaEditar.isPrecisaLimpeza();
		
		comboLimpeza = new JComboBox();
		comboLimpeza.setModel(new DefaultComboBoxModel(new String[] { "", "sim", "não" }));
		comboLimpeza.setBounds(1472, 383, 343, 50);
		contentPane.add(comboLimpeza);
		
		JLabel lblConserto = new JLabel("Conserto");
		lblConserto.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblConserto.setBounds(1472, 460, 121, 22);
		contentPane.add(lblConserto);
		
		Boolean Conserto = quaEditar.isPrecisaConserto();
		
		comboConserto = new JComboBox();
		comboConserto.setModel(new DefaultComboBoxModel(new String[] { "", "sim", "não" }));
		comboConserto.setBounds(1472, 493, 343, 50);
		contentPane.add(comboConserto);
		
		JLabel lblPreco = new JLabel("Preço");
		lblPreco.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPreco.setBounds(1472, 577, 121, 22);
		contentPane.add(lblPreco);
		
		float preco = quartoEditar.getPreco();
		
		txtPreco = new RoundJFormattedTextField(null);
		txtPreco.setBounds(1472, 598, 334, 48);
		contentPane.add(txtPreco);
		txtPreco.setColumns(10);
		
		JLabel lblBotaoSalvar = new JLabel("");
		lblBotaoSalvar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				QuartoDAO dao = QuartoDAO.getInstacia();
				
				String NumeroDoQuarto = txtNumQuarto.getText();
				if (NumeroDoQuarto.isEmpty()) {
					TelaErro dadosIncorretos = new TelaErro("Insira o Número do Quarto");
					dadosIncorretos.setLocationRelativeTo(null);
					dadosIncorretos.setVisible(true);
				} else {
					quartoEditar.setNumero(Integer.valueOf(NumeroDoQuarto));
				}

				String CamaCasal = (String) comboCamaCasal.getSelectedItem();
				if(CamaCasal.isEmpty()) {
					TelaErro dadosIncorretos = new TelaErro("Insira a quantidade de camas para Casal");
					dadosIncorretos.setLocationRelativeTo(null);
					dadosIncorretos.setVisible(true);
				} else {
					quartoEditar.setNumCamaCasal(Integer.valueOf(CamaCasal));
				}
				
				String CamaSolteiro = (String) comboCamaSolteiro.getSelectedItem();
				if (CamaSolteiro.isEmpty()) {
					TelaErro dadosIncorretos = new TelaErro("Insira a quantidade de camas para Solteiro");
					dadosIncorretos.setLocationRelativeTo(null);
					dadosIncorretos.setVisible(true);
				} else {
					quartoEditar.setNumCamaSolteiro(Integer.valueOf(CamaSolteiro));
				}

				String MaxDeHospedes = (String) comboMaxDeHospedes.getSelectedItem();
				if (MaxDeHospedes.isEmpty()) {
					TelaErro dadosIncorretos = new TelaErro("Insira o Máximo de Hóspedes");
					dadosIncorretos.setLocationRelativeTo(null);
					dadosIncorretos.setVisible(true);
				} else {
					quartoEditar.setNumMaxHospedes(Integer.valueOf(MaxDeHospedes));
				}

				String ArCondicionado = (String) comboArCondicionado.getSelectedItem();
				if (ArCondicionado.isEmpty()) {
					TelaErro dadosIncorretos = new TelaErro("Insira se precisa de ar condicionado");
					dadosIncorretos.setLocationRelativeTo(null);
					dadosIncorretos.setVisible(true);
				} else {
					quartoEditar.setArCondicionado(Boolean.valueOf(ArCondicionado));
				}

				String Frigobar = (String) comboFrigobar.getSelectedItem();
				if (Frigobar.isEmpty()) {
					TelaErro dadosIncorretos = new TelaErro("Insira se precisa de frigobar");
					dadosIncorretos.setLocationRelativeTo(null);
					dadosIncorretos.setVisible(true);
				} else {
					quartoEditar.setFrigobar(Boolean.valueOf(Frigobar));
				}
				
				String Banheira = (String) comboBanheira.getSelectedItem();
				if (Banheira.isEmpty()) {
					TelaErro dadosIncorretos = new TelaErro("Insira se precisa de banheira");
					dadosIncorretos.setLocationRelativeTo(null);
					dadosIncorretos.setVisible(true);
				} else {
					quartoEditar.setBanheira(Boolean.valueOf(Banheira));
				}
				
				String Acessibilidade = txtAcessibilidade.getText();
				if (Acessibilidade.isEmpty()) {
					TelaErro dadosIncorretos = new TelaErro("Insira se precisa de Acessibilidade");
					dadosIncorretos.setLocationRelativeTo(null);
					dadosIncorretos.setVisible(true);
				} else {
					quartoEditar.setAcessibilidade(Acessibilidade);
				}
				
				String Limpeza = (String) comboLimpeza.getSelectedItem();
				if (Limpeza.isEmpty()) {
					TelaErro dadosIncorretos = new TelaErro("Insira se precisa de Limpeza");
					dadosIncorretos.setLocationRelativeTo(null);
					dadosIncorretos.setVisible(true);
				} else {
					quartoEditar.setPrecisaLimpeza(Boolean.valueOf(Limpeza));
				}
				
				String Conserto = (String) comboConserto.getSelectedItem();
				if (Conserto.isEmpty()) {
					TelaErro dadosIncorretos = new TelaErro("Insira se precisa de Conserto");
					dadosIncorretos.setLocationRelativeTo(null);
					dadosIncorretos.setVisible(true);
				} else {
					quartoEditar.setPrecisaConserto(Boolean.valueOf(Conserto));
				}
				
				String Preco = txtPreco.getText();
				if (Preco.isEmpty()) {
					TelaErro dadosIncorretos = new TelaErro("Insira o preço");
					dadosIncorretos.setLocationRelativeTo(null);
					dadosIncorretos.setVisible(true);
				} else {
					quartoEditar.setPreco(Float.valueOf(Preco));
				}

				boolean validacao = dao.atualizarQuarto(quaEditar);
				if (validacao == true) {
					TelaListagemQuarto tlq = new TelaListagemQuarto(funcionarioLogado);
					tlq.setVisible(true);
					tlq.setExtendedState(JFrame.MAXIMIZED_BOTH);
					TelaConfirmacaoEdicao telaConfirmacaoEd = new TelaConfirmacaoEdicao(quaEditar);
					telaConfirmacaoEd.setVisible(true);
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
		lblBotaoSalvar.setIcon(new ImageIcon("src/main/resources/botao salvar.png"));
		lblBotaoSalvar.setBounds(1314, 927, 292, 54);
		contentPane.add(lblBotaoSalvar);
		
		JLabel lblBotaoCancelar = new JLabel("");
		lblBotaoCancelar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				TelaListagemQuarto tlq = new TelaListagemQuarto(funcionarioLogado);
				tlq.setVisible(true);
				tlq.setExtendedState(JFrame.MAXIMIZED_BOTH);
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
		lblBotaoCancelar.setBounds(1685, 929, 134, 35);
		contentPane.add(lblBotaoCancelar);
		
		JLabel lblCaminhoEditarQuarto = new JLabel("");
		lblCaminhoEditarQuarto.setIcon(new ImageIcon("src/main/resources/CaminhoEditarQuarto.png"));
		lblCaminhoEditarQuarto.setBounds(420, 0, 1500, 62);
		contentPane.add(lblCaminhoEditarQuarto);
		
	}

}
