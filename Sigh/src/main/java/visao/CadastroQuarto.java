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
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.Toolkit;

public class CadastroQuarto extends JFrame implements TelaListagemInterface{

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
	private JComboBox<Integer>comboCamaCasal;
	private JComboBox<Integer>comboCamaSolteiro;
	private JComboBox<Integer>comboNHospedes;
	private JComboBox comboFrigobar;
	private JComboBox comboBanheira;
	private JComboBox comboLimpeza;
	private JComboBox comboConserto;
	private JTextField txtNumQuarto;
	private JComboBox comboAr;
	private JLabel menuQuartos;
	private JTextField txtAcessibilidade;
	Funcionario funcionarioLogado;

	/**
	 * Launch the application.
	 
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

	
	 * Create the frame.
	 */
	public CadastroQuarto(Funcionario func) {
		funcionarioLogado = func;
		setIconImage(Toolkit.getDefaultToolkit().getImage("src/main/resources/logo sigh.png"));
		setTitle("Cadastro de Quarto");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1920, 1080);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		comboCamaCasal = new JComboBox<Integer>();
		comboCamaCasal.setModel(
				new DefaultComboBoxModel(new Integer[] {  0, 1, 2 }));
		comboCamaCasal.setBounds(491, 442, 343, 50);
		contentPane.add(comboCamaCasal);

		comboCamaSolteiro = new JComboBox<Integer>();
		comboCamaSolteiro.setModel(
				new DefaultComboBoxModel(new Integer[] {  0, 1, 2}));
		comboCamaSolteiro.setBounds(491, 579, 343, 50);
		contentPane.add(comboCamaSolteiro);

		comboNHospedes = new JComboBox<Integer>();
		comboNHospedes.setModel(
				new DefaultComboBoxModel(new Integer[] { 0, 1, 2, 3, 4}));
		comboNHospedes.setBounds(491, 705, 343, 50);
		contentPane.add(comboNHospedes);

		comboFrigobar = new JComboBox();
		comboFrigobar.setModel(new DefaultComboBoxModel(new String[] { "", "sim", "não" }));
		comboFrigobar.setBounds(985, 442, 343, 50);
		contentPane.add(comboFrigobar);

		comboBanheira = new JComboBox();
		comboBanheira.setModel(new DefaultComboBoxModel(new String[] { "", "sim", "não" }));
		comboBanheira.setBounds(985, 580, 343, 50);
		contentPane.add(comboBanheira);

		comboLimpeza = new JComboBox();
		comboLimpeza.setModel(new DefaultComboBoxModel(new String[] { "", "sim", "não" }));
		comboLimpeza.setBounds(1506, 313, 343, 50);
		contentPane.add(comboLimpeza);

		comboConserto = new JComboBox();
		comboConserto.setModel(new DefaultComboBoxModel(new String[] { "", "sim", "não" }));
		comboConserto.setBounds(1506, 440, 343, 50);
		contentPane.add(comboConserto);

		txtNumQuarto = new RoundJFormattedTextField(null);
		txtNumQuarto.setBounds(491, 313, 343, 50);
		contentPane.add(txtNumQuarto);
		txtNumQuarto.setColumns(10);
		
		txtAcessibilidade = new JTextField();
		txtAcessibilidade.setBounds(985, 705, 343, 50);
		contentPane.add(txtAcessibilidade);
		txtAcessibilidade.setColumns(10);

		comboAr = new JComboBox();
		comboAr.setModel(new DefaultComboBoxModel(new String[] { "", "sim", "não" }));
		comboAr.setBounds(984, 314, 343, 50);
		contentPane.add(comboAr);
		
		setContentPane(contentPane);
		contentPane.setLayout(null);
				
		botaoSalvar = new JLabel("");
		botaoSalvar.addMouseListener(new MouseAdapter() {
							@Override
							public void mouseClicked(MouseEvent e) {

								Quarto quarto = new Quarto();

								Boolean erro = false;

								String numeroQuarto = txtNumQuarto.getText();
								int numQuarto = 0; 
								if (numeroQuarto.isEmpty()) {
									erro = true;
									// ERRO
								} else {
									try {
										numQuarto = Integer.parseInt(numeroQuarto);
									} catch (Exception ex) {
										JOptionPane.showMessageDialog(null, "Número do Quarto precisa ser um tipo numérico inteiro");
										erro = true;
									}
								}

								int camaCasal = (Integer) comboCamaCasal.getSelectedItem();
								int camaSolteiro = (Integer) comboCamaSolteiro.getSelectedItem();
								int numMaxHospedes = (Integer) comboNHospedes.getSelectedItem();

								String arCondicionado = (String) comboAr.getSelectedItem();
								Boolean ar = null;
								if (arCondicionado.isEmpty()) {
									erro = true;
									// ERRO
								} else {
									if(arCondicionado == "sim") {
										ar = true;
									} else {
										ar = false;
									}
								}

								String frigobar = (String) comboFrigobar.getSelectedItem();
							    Boolean frigo = null; 	
								if (frigobar.isEmpty()) {
									erro = true;
									// ERRO
								} else {
									if(frigobar == "sim") {
										frigo = true;
									} else {
										frigo = false;
									}
								}

								String banheira = (String) comboBanheira.getSelectedItem();
								Boolean ban = null; 
								if (banheira.isEmpty()) {
									erro = true;
									// ERRO
								} else {
									if(banheira == "sim") {
										ban = true;
									} else {
										ban = false;
									}
								}

								String acessibilidade = txtAcessibilidade.getText();
								if (acessibilidade.isEmpty()) {
									erro = true;
									// ERRO
								} 

								String preco = txtpreco.getText();
								float precoo = 0;
								if (preco.isEmpty()) {
									erro = true;
									// ERRO
								} else {
									try {
										precoo = Float.valueOf(preco);
									} catch (Exception ex) {
										JOptionPane.showMessageDialog(null, "Preço precisa ser um tipo numérico");
										erro = true;

									}
								}

								if(erro==false) {
									quarto.setNumero(numQuarto);
									quarto.setNumCamaCasal(camaCasal);
									quarto.setNumCamaSolteiro(camaSolteiro);
									quarto.setArCondicionado(ar);
									quarto.setFrigobar(frigo);
									quarto.setBanheira(ban);
									quarto.setAcessibilidade(acessibilidade);
									quarto.setPreco(precoo);
									
									QuartoDAO dao = QuartoDAO.getInstacia();
									dao.inserirQuarto(quarto);
									
									TelaListagemFuncionario lf = new TelaListagemFuncionario(funcionarioLogado);
									lf.setVisible(true);
									lf.setExtendedState(JFrame.MAXIMIZED_BOTH);
									dispose();
								
									TelaConfirmacao telaConfirmacao = new TelaConfirmacao(quarto);
									telaConfirmacao.setVisible(true);
								}		
							
			 }
			 @Override
			 public void mouseEntered(MouseEvent e) {
					 botaoSalvar.setIcon(new ImageIcon("src/main/resources/botao salvar  claro.png"));
			 }
			 @Override
		     public void mouseExited(MouseEvent e) {
					 botaoSalvar.setIcon(new ImageIcon("src/main/resources/botao salvar.png"));
			 }
		});
		 botaoSalvar.setIcon(new ImageIcon("src/main/resources/botao salvar.png"));
		 botaoSalvar.setBounds(1310, 928, 292, 54);
		 contentPane.add(botaoSalvar);
		
		BotaoCancelar = new JLabel("");
		BotaoCancelar.addMouseListener(new MouseAdapter() {
		    @Override
		    public void mouseClicked(MouseEvent e) {
		         dispose();	
		    }
		    @Override
		    public void mouseEntered(MouseEvent e) {
		         BotaoCancelar.setIcon(new ImageIcon("src/main/resources/botao cancelar azul escuro.png"));
		    }
		    @Override
		    public void mouseExited(MouseEvent e) {
		         BotaoCancelar.setIcon(new ImageIcon("src/main/resources/botao cancelar.png"));
			}
		});
		BotaoCancelar.setIcon(new ImageIcon("src/main/resources/botao cancelar.png"));
		BotaoCancelar.setBounds(1682, 931, 134, 24);
		contentPane.add(BotaoCancelar);

		/*menuQuartos = new JLabel("");
		menuQuartos.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				menuQuartos.setIcon(new ImageIcon("src/main/resources/menu - quartos selecionado.png"));//
			}
			@Override
			public void mouseExited(MouseEvent e) {
				menuQuartos.setIcon(new ImageIcon("src/main/resources/menu quartoss.png"));
			}
		});
		menuQuartos.setIcon(new ImageIcon("src/main/resources/menu quartoss.png"));
		menuQuartos.setBounds(91, 590, 335, 50);
		contentPane.add(menuQuartos);*/

		lblMenuFuncionarios = new JLabel("");
		lblMenuFuncionarios.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				TelaListagemFuncionario listaFuncionario = new TelaListagemFuncionario(funcionarioLogado);
				setVisible(false);
				listaFuncionario.setExtendedState(MAXIMIZED_BOTH);
				listaFuncionario.setVisible(true);
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				lblMenuFuncionarios.setIcon(new ImageIcon("src/main/resources/menu - funcionarios selecionado.png"));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				lblMenuFuncionarios.setIcon(new ImageIcon("src/main/resources/menu funcionarios.png"));
			}
		});
		lblMenuFuncionarios.setIcon(new ImageIcon("src/main/resources/menu funcionarios.png"));
		lblMenuFuncionarios.setBounds(91, 532, 335, 50);
		contentPane.add(lblMenuFuncionarios);

		lblDivisormenu = new JLabel("");
		lblDivisormenu.setIcon(new ImageIcon("src/main/resources/divisor (menu).png"));
		lblDivisormenu.setBounds(90, 897, 400, 30);
		contentPane.add(lblDivisormenu);

		lblSair = new JLabel("");
		lblSair.addMouseListener(new MouseAdapter() {
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
				lblSair.setIcon(new ImageIcon("src/main/resources/botao sair cinza claro.png"));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblSair.setIcon(new ImageIcon("src/main/resources/botao sair.png"));
			}
		});
		lblSair.setIcon(new ImageIcon("src/main/resources/botao sair.png"));
		lblSair.setBounds(84, 955, 263, 45);
		contentPane.add(lblSair);

		lblMenuHospedagem = new JLabel("");
		lblMenuHospedagem.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				TelaListagemHospedagem tlh = new TelaListagemHospedagem(funcionarioLogado);
				tlh.setVisible(true);
				tlh.setExtendedState(JFrame.MAXIMIZED_BOTH);
				dispose();
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				lblMenuHospedagem.setIcon(new ImageIcon("src/main/resources/menu hospedagem selecionado.png"));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				lblMenuHospedagem.setIcon(new ImageIcon("src/main/resources/menu hospedagem.png"));
			}
		});
		lblMenuHospedagem.setIcon(new ImageIcon("src/main/resources/menu hospedagem.png"));
		lblMenuHospedagem.setBounds(91, 468, 335, 50);
		contentPane.add(lblMenuHospedagem);

		lblMenuHospede = new JLabel("");
		lblMenuHospede.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				TelaListagemHospede tlh = new TelaListagemHospede(funcionarioLogado);
				dispose();
				tlh.setExtendedState(MAXIMIZED_BOTH);
				tlh.setVisible(true);
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				lblMenuHospede.setIcon(new ImageIcon("src/main/resources/menu - hospedes selecionado.png"));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				lblMenuHospede.setIcon(new ImageIcon("src/main/resources/menu - hospede.png"));
			}
		});
		lblMenuHospede.setIcon(new ImageIcon("src/main/resources/menu - hospede.png"));
		lblMenuHospede.setBounds(92, 404, 335, 50);
		contentPane.add(lblMenuHospede);

		lblMenuPedidos = new JLabel("");
		lblMenuPedidos.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				lblMenuPedidos.setIcon(new ImageIcon("src/main/resources/menu - pedidos selecionado.png"));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				lblMenuPedidos.setIcon(new ImageIcon("src/main/resources/menu pedidos.png"));
			}
		});

		lblMenuPedidos.setIcon(new ImageIcon("src/main/resources/menu pedidos.png"));
		lblMenuPedidos.setBounds(92, 345, 335, 50);
		contentPane.add(lblMenuPedidos);

		lblLogo = new JLabel("");
		lblLogo.setIcon(new ImageIcon("src/main/resources/logo sigh.png"));
		lblLogo.setBounds(135, 42, 144, 176);
		contentPane.add(lblLogo);

		JLabel lblCadastrarQuartos = new JLabel("");
		lblCadastrarQuartos.setIcon(new ImageIcon("src/main/resources/Cadastrar Quartos.png"));
		lblCadastrarQuartos.setBounds(446, 108, 1455, 126);
		contentPane.add(lblCadastrarQuartos);

		txtpreco = new RoundJFormattedTextField(null);
		txtpreco.setColumns(10);
		txtpreco.setBounds(1506, 575, 343, 50);
		contentPane.add(txtpreco);

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
		lblAr.setBounds(985, 289, 120, 20);
		contentPane.add(lblAr);

		lblFrigobar = new JLabel("Frigobar");
		lblFrigobar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblFrigobar.setBounds(985, 421, 120, 20);
		contentPane.add(lblFrigobar);

		lblBanheira = new JLabel("Banheira");
		lblBanheira.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblBanheira.setBounds(985, 560, 120, 20);
		contentPane.add(lblBanheira);

		lblAcessibilidade = new JLabel("Acessibilidade");
		lblAcessibilidade.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblAcessibilidade.setBounds(985, 685, 120, 20);
		contentPane.add(lblAcessibilidade);

		lblLimpeza = new JLabel("Limpeza");
		lblLimpeza.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblLimpeza.setBounds(1506, 293, 120, 20);
		contentPane.add(lblLimpeza);

		lblConserto = new JLabel("Conserto");
		lblConserto.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblConserto.setBounds(1506, 420, 120, 20);
		contentPane.add(lblConserto);

		lblPreco = new JLabel("Preço");
		lblPreco.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPreco.setBounds(1506, 545, 62, 22);
		contentPane.add(lblPreco);

		JLabel lblFundoMenu = new JLabel("");
		lblFundoMenu.setIcon(new ImageIcon("src/main/resources/fundo cinza (menu).png"));
		lblFundoMenu.setBounds(0, 0, 420, 1080);
		contentPane.add(lblFundoMenu);

		JLabel lblCaminho = new JLabel("");
		lblCaminho.setIcon(new ImageIcon("src/main/resources/superior pequeno quartos.png"));
		lblCaminho.setBounds(408, 0, 1512, 62);
		contentPane.add(lblCaminho);
		
	}

	@Override
	public void atualizarJTableModel() {
		// TODO Auto-generated method stub
		
	}
}
