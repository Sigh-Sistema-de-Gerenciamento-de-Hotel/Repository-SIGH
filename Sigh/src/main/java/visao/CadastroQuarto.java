package visao;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controle.quarto.QuartoDAO;
import modelo.Funcionario;
import modelo.Quarto;
import visao.padrao.RoundJFormattedTextField;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class CadastroQuarto extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtpreco;
	private JLabel BotaoCancelar;
	private JLabel botaoSalvar;
	private JLabel lblNumeroQuarto;
	private JLabel lblCamaCasal;
	private JLabel lblNumeroHospedes;
	private JLabel lblAr;
	private JLabel lblFrigobar;
	private JLabel lblBanheira;
	private JLabel lblAcessibilidade;
	private JLabel lblLimpeza;
	private JLabel lblConserto;
	private JLabel lblPreco;
	private JLabel lblLogo;
	private JLabel lblMenuPedidos;
	private JLabel lblMenuHospede;
	private JLabel lblMenuHospedagem;
	private JLabel lblMenuFuncionarios;
	private JLabel lblSair;
	private JLabel lblDivisormenu;
	private JComboBox comboCamaCasal;
	private JComboBox comboCamaSolteiro;
	private JComboBox comboNHospedes;
	private JComboBox comboFrigobar;
	private JComboBox comboBanheira;
	private JComboBox comboAcessibilidade;
	private JComboBox comboLimpeza;
	private JComboBox comboConserto;
	private JTextField textField;
	private JComboBox comboAr;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastroQuarto frame = new CadastroQuarto();
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
	public CadastroQuarto() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1920, 1080);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblDivisormenu = new JLabel("");
		lblDivisormenu.setIcon(new ImageIcon("src/main/resources/divisor (menu).png"));
		lblDivisormenu.setBounds(90, 897, 400, 30);
		contentPane.add(lblDivisormenu);
		
		lblSair = new JLabel("");
		lblSair.setIcon(new ImageIcon("src/main/resources/botao sair.png"));
		lblSair.setBounds(84, 955, 263, 45);
		contentPane.add(lblSair);
		
		lblMenuFuncionarios = new JLabel("");
		lblMenuFuncionarios.setIcon(new ImageIcon("src/main/resources/menu funcionarios.png"));
		lblMenuFuncionarios.setBounds(91, 532, 145, 22);
		contentPane.add(lblMenuFuncionarios);
		
		lblMenuHospedagem = new JLabel("");
		lblMenuHospedagem.setIcon(new ImageIcon("src/main/resources/menu hospedagem.png"));
		lblMenuHospedagem.setBounds(91, 468, 130, 22);
		contentPane.add(lblMenuHospedagem);
		
		lblMenuHospede = new JLabel("");
		lblMenuHospede.setIcon(new ImageIcon("src/main/resources/menu - hospede.png"));
		lblMenuHospede.setBounds(92, 404, 120, 22);
		contentPane.add(lblMenuHospede);
		
		lblMenuPedidos = new JLabel("");
		lblMenuPedidos.setIcon(new ImageIcon("src/main/resources/menu pedidos.png"));
		lblMenuPedidos.setBounds(92, 345, 120, 22);
		contentPane.add(lblMenuPedidos);
		
		lblLogo = new JLabel("");
		lblLogo.setIcon(new ImageIcon("src/main/resources/logo sigh.png"));
		lblLogo.setBounds(135, 42, 144, 176);
		contentPane.add(lblLogo);
		
		JLabel lblCadastrarQuartos = new JLabel("");
		lblCadastrarQuartos.setIcon(new ImageIcon("src/main/resources/Cadastrar Quartos.png"));
		lblCadastrarQuartos.setBounds(446, 108, 1455, 126);
		contentPane.add(lblCadastrarQuartos);
		
		BotaoCancelar = new JLabel("");
		BotaoCancelar.setIcon(new ImageIcon("src/main/resources/botao cancelar.png"));
		BotaoCancelar.setBounds(1682, 931, 140, 40);
		contentPane.add(BotaoCancelar);
		
		txtpreco = new RoundJFormattedTextField(null);
		txtpreco.setColumns(10);
		txtpreco.setBounds(1506, 579, 343, 48);
		contentPane.add(txtpreco);
		
		botaoSalvar = new JLabel("");
		botaoSalvar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				 QuartoDAO dao = QuartoDAO.getInstacia();
	                
	                Quarto quarto = new Quarto();
	                quarto.setNumero(ABORT);
	                quarto.setNumCamaCasal(ABORT);
	                quarto.setNumCamaSolteiro(ABORT);
	                quarto.setNumMaxHospedes(ABORT);
	                quarto.setArCondicionado(rootPaneCheckingEnabled);
	                quarto.setFrigobar(rootPaneCheckingEnabled);
	                quarto.setBanheira(rootPaneCheckingEnabled);
	                quarto.setAcessibilidade(getName());
	                
	               dao.inserirQuarto(null);
					
	                
	            	Boolean erro= false;

					String numeroQuarto = textField.getText();
					if(numeroQuarto.isEmpty()) {
						erro = true;
						// ERRO
					} else {
						quarto.setNumero(ABORT);
					}

					String camaCasal = comboCamaCasal.getUIClassID();
					if(camaCasal.isEmpty()){
						erro = true;
						// ERRO
					} else {
						quarto.setNumCamaCasal(ABORT);
					}
					
					String camaSolteiro = comboCamaSolteiro.getUIClassID();
					if(camaSolteiro.isEmpty()){
						erro = true;
						// ERRO
					} else {
						quarto.setNumCamaSolteiro(ABORT);
					}

					String numMaxHospedes = comboNHospedes.getUIClassID();
					if(numMaxHospedes.isEmpty()) {
						erro = true;
						// ERRO
					}  else {
						quarto.setNumMaxHospedes(ABORT);
					}

					String ArCondicionado = comboAr.getUIClassID();
					if(ArCondicionado.isEmpty()) {
						erro = true;
						// ERRO
					} else {
						quarto.setArCondicionado(rootPaneCheckingEnabled);
					}
					
					String frigobar = comboFrigobar.getUIClassID();
					if(frigobar.isEmpty()) {
						erro = true;
						//ERRO
					} else {
						quarto.setFrigobar(rootPaneCheckingEnabled);
					}
					
					String banheira = comboBanheira.getUIClassID();
					if(banheira.isEmpty()) {
						erro = true;
						//ERRO
					} else {
						quarto.setBanheira(rootPaneCheckingEnabled);
					}
					
					String acessibilidade =comboAcessibilidade.getUIClassID();
					if(acessibilidade.isEmpty()) {
						erro = true;
						//ERRO
					} else {
						quarto.setArCondicionado(rootPaneCheckingEnabled);
					}
					
					
					/*
					 * if(erro==false) {
						QuartoDAO dao = QuartoDAO.getInstacia();

					      int validacao = dao.inserirQuarto(quarto);
						
						  if(validacao == true) {
							TelaListagemHospede lf = new TelaListagemHospede();
							lf.setVisible(true);
							lf.setExtendedState(JFrame.MAXIMIZED_BOTH);
							TelaConfirmacao telaConfirmacao = new TelaConfirmacao(quarto.getNumero(), quarto.getNumCamaCasal(), quarto.getNumCamaSolteiro(), quarto.getNumMaxHospedes());
							telaConfirmacao.setVisible(true);
							setVisible(false);
						}
						else {
							//mensagem de ERRO
						}
					}		
			    }
					 */
				
			    }
		});
		botaoSalvar.setIcon(new ImageIcon("src/main/resources/botao salvar.png"));
		botaoSalvar.setBounds(1310, 928, 292, 54);
		contentPane.add(botaoSalvar);
		
		lblNumeroQuarto = new JLabel("Número do Quarto ");
		lblNumeroQuarto.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNumeroQuarto.setBounds(491, 289, 120, 20);
		contentPane.add(lblNumeroQuarto);
		
		lblCamaCasal = new JLabel("Cama Casal");
		lblCamaCasal.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCamaCasal.setBounds(491, 411, 120, 20);
		contentPane.add(lblCamaCasal);
		
		JLabel lblCamaSolteiro = new JLabel("Cama Solteiro");
		lblCamaSolteiro.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCamaSolteiro.setBounds(491, 548, 120, 20);
		contentPane.add(lblCamaSolteiro);
		
		lblNumeroHospedes = new JLabel("Número de hóspedes");
		lblNumeroHospedes.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNumeroHospedes.setBounds(491, 674, 150, 20);
		contentPane.add(lblNumeroHospedes);
		
		lblAr = new JLabel("Ar-Condicionado");
		lblAr.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblAr.setBounds(1017, 282, 120, 20);
		contentPane.add(lblAr);
		
		lblFrigobar = new JLabel("Frigobar");
		lblFrigobar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblFrigobar.setBounds(1017, 411, 120, 20);
		contentPane.add(lblFrigobar);
		
		lblBanheira = new JLabel("Banheira");
		lblBanheira.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblBanheira.setBounds(1017, 548, 120, 20);
		contentPane.add(lblBanheira);
		
		lblAcessibilidade = new JLabel("Acessibilidade");
		lblAcessibilidade.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblAcessibilidade.setBounds(1017, 674, 120, 20);
		contentPane.add(lblAcessibilidade);
		
		lblLimpeza = new JLabel("Limpeza");
		lblLimpeza.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblLimpeza.setBounds(1506, 282, 120, 20);
		contentPane.add(lblLimpeza);
		
		lblConserto = new JLabel("Conserto");
		lblConserto.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblConserto.setBounds(1506, 411, 120, 20);
		contentPane.add(lblConserto);
		
		lblPreco = new JLabel("Preço");
		lblPreco.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPreco.setBounds(1506, 548, 120, 20);
		contentPane.add(lblPreco);
		
		JLabel lblFundoMenu = new JLabel("");
		lblFundoMenu.setIcon(new ImageIcon("src/main/resources/fundo cinza (menu).png"));
		lblFundoMenu.setBounds(0, 0, 420, 1080);
		contentPane.add(lblFundoMenu);
		
		JLabel lblCaminho = new JLabel("");
		lblCaminho.setIcon(new ImageIcon("src/main/resources/superior pequeno quartos.png"));
		lblCaminho.setBounds(408, 0, 1512, 62);
		contentPane.add(lblCaminho);
		
		comboCamaCasal = new JComboBox();
		comboCamaCasal.setModel(new DefaultComboBoxModel(new String[] {"", "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10"}));
		comboCamaCasal.setBounds(491, 442, 343, 48);
		contentPane.add(comboCamaCasal);
		
		comboCamaSolteiro = new JComboBox();
		comboCamaSolteiro.setModel(new DefaultComboBoxModel(new String[] {"", "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10"}));
		comboCamaSolteiro.setBounds(491, 579, 343, 48);
		contentPane.add(comboCamaSolteiro);
		
		comboNHospedes = new JComboBox();
		comboNHospedes.setModel(new DefaultComboBoxModel(new String[] {"", "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10"}));
		comboNHospedes.setBounds(491, 705, 343, 48);
		contentPane.add(comboNHospedes);
		
		comboFrigobar = new JComboBox();
		comboFrigobar.setModel(new DefaultComboBoxModel(new String[] {"", "sim", "não"}));
		comboFrigobar.setBounds(1017, 442, 343, 48);
		contentPane.add(comboFrigobar);
		
		comboBanheira = new JComboBox();
		comboBanheira.setModel(new DefaultComboBoxModel(new String[] {"", "sim", "não"}));
		comboBanheira.setBounds(1017, 579, 343, 48);
		contentPane.add(comboBanheira);
		
		comboAcessibilidade = new JComboBox();
		comboAcessibilidade.setModel(new DefaultComboBoxModel(new String[] {"", "sim", "não"}));
		comboAcessibilidade.setBounds(1017, 705, 343, 48);
		contentPane.add(comboAcessibilidade);
		
		comboLimpeza = new JComboBox();
		comboLimpeza.setModel(new DefaultComboBoxModel(new String[] {"", "sim", "não"}));
		comboLimpeza.setBounds(1506, 313, 343, 48);
		contentPane.add(comboLimpeza);
		
		comboConserto = new JComboBox();
		comboConserto.setModel(new DefaultComboBoxModel(new String[] {"", "sim", " não"}));
		comboConserto.setBounds(1506, 442, 343, 48);
		contentPane.add(comboConserto);
		
		textField = new RoundJFormattedTextField(null);
		textField.setBounds(491, 313, 343, 48);
		contentPane.add(textField);
		textField.setColumns(10);
		
		comboAr = new JComboBox();
		comboAr.setModel(new DefaultComboBoxModel(new String[] {"", "sim", "não"}));
		comboAr.setBounds(1017, 313, 343, 48);
		contentPane.add(comboAr);
	}
}
