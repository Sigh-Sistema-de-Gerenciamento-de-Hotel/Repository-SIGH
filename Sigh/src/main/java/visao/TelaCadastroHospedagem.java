package visao;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controle.funcionario.FuncionarioDAO;
import controle.hospedagem.HospedagemDAO;
import controle.hospede.HospedeDAO;
import controle.quarto.QuartoDAO;
import modelo.Funcionario;
import modelo.Hospedagem;
import modelo.Hospede;
import modelo.Quarto;
import visao.padrao.DateTextField;
import visao.padrao.RoundJFormattedTextField;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Locale;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import net.miginfocom.swing.MigLayout;

public class TelaCadastroHospedagem extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private final JLabel lblMenu = new JLabel("");
	private JTextField txtDataCheckin;
	private JTextField txtDataCheckout;
	private JComboBox <Integer> comboBoxQuartos;
	private JComboBox <Integer> comboBoxNumHosp; 
	private Funcionario funcionarioLogado;

	public TelaCadastroHospedagem(Funcionario funcLogado) {
		this.funcionarioLogado = funcLogado;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1471, 912);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		comboBoxQuartos = new JComboBox<Integer>();
		QuartoDAO daoQ = QuartoDAO.getInstacia();
		ArrayList<Quarto> quartos = daoQ.listarQuarto();
		for (Quarto quarto : quartos) {
			int id = quarto.getNumero();
			comboBoxQuartos.addItem(id);
		}
		comboBoxQuartos.setFont(new Font("Tahoma", Font.PLAIN, 14));
		comboBoxQuartos.setBounds(1010, 355, 343, 48);
		contentPane.add(comboBoxQuartos);


		setContentPane(contentPane);
		contentPane.setLayout(null);
		JPanel panel = new JPanel();
		panel.setBounds(1500, 355, 334, 139);
		contentPane.add(panel);
		panel.setLayout(new MigLayout("", "[grow]", "[][]"));

		JLabel lblNewLabel = new JLabel("Hospedes*");
		panel.add(lblNewLabel, "cell 0 0");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));

		JComboBox<String> comboBoxHospede1 = new JComboBox<>();
		HospedeDAO dao = HospedeDAO.getInstancia();
		ArrayList<Hospede> hospedes = dao.listarHospede();
		for (Hospede h : hospedes) {
			String infos;

			String nomeCompleto;
			if(h.getNomeSocial() == null) {
				nomeCompleto = h.getNome() + " " + h.getSobrenome(); 
			} else {
				nomeCompleto = h.getNomeSocial() + " " + h.getSobrenome(); 
			} 
			String doc;
			String cpf = String.valueOf(h.getCpf());
			if (h.getCpf() == 0) {
				doc = h.getPassaporte();
			} else {
				doc = cpf; 
			}
			infos = nomeCompleto +" - " + doc;
			comboBoxHospede1.addItem(infos);
		}
		panel.add(comboBoxHospede1, "cell 0 1,growx");


		JPanel panel_1 = new JPanel();
		panel_1.setBounds(1500, 548, 334, 139);
		contentPane.add(panel_1);
		panel_1.setLayout(new MigLayout("", "[grow]", "[][]"));

		JLabel lblNewLabel_1 = new JLabel("Hospedes*");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel_1.add(lblNewLabel_1, "cell 0 0");

		JComboBox<String> comboBoxHospede2 = new JComboBox<>();
		for (Hospede resp : hospedes) {
			String infos;

			String nomeCompleto;
			if(resp.getNomeSocial() == null) {
				nomeCompleto = resp.getNome() + " " + resp.getSobrenome(); 
			} else {
				nomeCompleto = resp.getNomeSocial() + " " + resp.getSobrenome(); 
			} 
			String doc;
			String cpf = String.valueOf(resp.getCpf());
			if (resp.getCpf() == 0) {
				doc = resp.getPassaporte();
			} else {
				doc = cpf; 
			}
			infos = nomeCompleto +" - " + doc;
			comboBoxHospede2.addItem(infos);
		}
		panel_1.add(comboBoxHospede2, "cell 0 1,growx");
//		panel_1.setVisible(false);

		JPanel panel_2 = new JPanel();
		panel_2.setBounds(1500, 741, 334, 139);
		contentPane.add(panel_2);
		panel_2.setLayout(new MigLayout("", "[grow]", "[][]"));

		JLabel lblNewLabel_2 = new JLabel("Hospedes*");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel_2.add(lblNewLabel_2, "cell 0 0");

		JComboBox<String> comboBoxHospede3 = new JComboBox<>();
		for (Hospede resp : hospedes) {
			String infos;

			String nomeCompleto;
			if(resp.getNomeSocial() == null) {
				nomeCompleto = resp.getNome() + " " + resp.getSobrenome(); 
			} else {
				nomeCompleto = resp.getNomeSocial() + " " + resp.getSobrenome(); 
			} 
			String doc;
			String cpf = String.valueOf(resp.getCpf());
			if (resp.getCpf() == 0) {
				doc = resp.getPassaporte();
			} else {
				doc = cpf; 
			}
			infos = nomeCompleto +" - " + doc;
			comboBoxHospede3.addItem(infos);
		}
		panel_2.add(comboBoxHospede3, "cell 0 1,growx");
//		panel_2.setVisible(false);

		JPanel panel_3 = new JPanel();
		panel_3.setBounds(1500, 934, 334, 139);
		contentPane.add(panel_3);
		panel_3.setLayout(new MigLayout("", "[grow]", "[][]"));

		JLabel lblNewLabel_3 = new JLabel("Hospedes*");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel_3.add(lblNewLabel_3, "cell 0 0");

		JComboBox<String> comboBoxHospede4 = new JComboBox<>();
		for (Hospede resp : hospedes) {
			String infos;

			String nomeCompleto;
			if(resp.getNomeSocial() == null) {
				nomeCompleto = resp.getNome() + " " + resp.getSobrenome(); 
			} else {
				nomeCompleto = resp.getNomeSocial() + " " + resp.getSobrenome(); 
			} 
			String doc;
			String cpf = String.valueOf(resp.getCpf());
			if (resp.getCpf() == 0) {
				doc = resp.getPassaporte();
			} else {
				doc = cpf; 
			}
			infos = nomeCompleto +" - " + doc;
			comboBoxHospede4.addItem(infos);
		}
		panel_3.add(comboBoxHospede4, "cell 0 1,growx");
//		panel_3.setVisible(false);

		comboBoxNumHosp = new JComboBox<Integer>();
		comboBoxNumHosp.setModel(new DefaultComboBoxModel<Integer>(new Integer[] {1, 2, 3, 4}));
		comboBoxNumHosp.setForeground(Color.BLACK);
		comboBoxNumHosp.setFont(new Font("Tahoma", Font.PLAIN, 14));
		comboBoxNumHosp.setBounds(502, 355, 343, 48);
//		comboBoxNumHosp.addMouseListener(new MouseAdapter() {
//			@Override
//			public void mouseExited(MouseEvent e) {
//				int num = (int) comboBoxNumHosp.getSelectedItem();
//				if(num >= 2) {
//					panel_1.setVisible(true);
//				}
//				if(num >= 3) {
//					panel_2.setVisible(true);
//				}
//				if(num == 4) {
//					panel_3.setVisible(true);
//				}
//			}
//		});
		contentPane.add(comboBoxNumHosp);

		JLabel lblBotaoFuncionarios = new JLabel("");
		lblBotaoFuncionarios.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				TelaListagemFuncionario listaFuncionario = new TelaListagemFuncionario(funcionarioLogado);
				setVisible(false);
				listaFuncionario.setExtendedState(MAXIMIZED_BOTH);
				listaFuncionario.setVisible(true);

			}
		});
		lblBotaoFuncionarios.setIcon(new ImageIcon("src\\main\\resources\\menu funcionarios.png"));
		lblBotaoFuncionarios.setBounds(67, 523, 295, 38);
		contentPane.add(lblBotaoFuncionarios);

		JLabel lblSimboloSigh = new JLabel("");
		lblSimboloSigh.setIcon(new ImageIcon("src\\main\\resources\\logo sigh.png"));
		lblSimboloSigh.setBounds(130, 35, 161, 182);
		contentPane.add(lblSimboloSigh);

		JLabel lblBotaoPedidos = new JLabel("");
		lblBotaoPedidos.setIcon(new ImageIcon("src\\main\\resources\\menu pedidos.png"));
		lblBotaoPedidos.setBounds(67, 345, 295, 38);
		contentPane.add(lblBotaoPedidos);

		JLabel lblBotaoHospedes = new JLabel("");
		lblBotaoHospedes.setIcon(new ImageIcon("src\\main\\resources\\menu - hospede.png"));
		lblBotaoHospedes.setBounds(67, 407, 295, 38);
		contentPane.add(lblBotaoHospedes);

		JLabel lblBotaoHospedagemSelecionado = new JLabel("");
		lblBotaoHospedagemSelecionado.setIcon(new ImageIcon("src\\main\\resources\\menu hospedagem selecionado.png"));
		lblBotaoHospedagemSelecionado.setBounds(43, 457, 342, 45);
		contentPane.add(lblBotaoHospedagemSelecionado);

		JLabel lblConta = new JLabel("Conta");
		lblConta.setForeground(Color.GRAY);
		lblConta.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblConta.setBounds(79, 760, 46, 14);
		contentPane.add(lblConta);

		JLabel lblNomeConta = new JLabel("Julia Almeida");
		lblNomeConta.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNomeConta.setBounds(129, 798, 80, 30);
		contentPane.add(lblNomeConta);

		JLabel lblDivisaoMenu = new JLabel("");
		lblDivisaoMenu.setIcon(new ImageIcon("src\\main\\resources\\divisor (menu).png"));
		lblDivisaoMenu.setBounds(77, 897, 243, 14);
		contentPane.add(lblDivisaoMenu);

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
				lblBotaoSair.setIcon(new ImageIcon("src\\main\\resources\\botao sair.png"));
			}
		});
		lblBotaoSair.setIcon(new ImageIcon("src\\main\\resources\\botao sair.png"));
		lblBotaoSair.setBounds(69, 955, 263, 45);
		contentPane.add(lblBotaoSair);
		lblMenu.setFont(new Font("Tahoma", Font.PLAIN, 14));

		lblMenu.setIcon(new ImageIcon("src\\main\\resources\\fundo cinza (menu).png"));
		lblMenu.setBounds(0, 0, 420, 1080);
		contentPane.add(lblMenu);

		JLabel lblParteSuperiorPequena = new JLabel("");
		lblParteSuperiorPequena.setIcon(new ImageIcon("src/main/resources/Caminho Cadastrar Hospedagem.png"));
		lblParteSuperiorPequena.setBounds(420, 0, 1500, 62);
		contentPane.add(lblParteSuperiorPequena);

		JLabel lblRetanguloBranco = new JLabel("");
		lblRetanguloBranco.setIcon(new ImageIcon("src/main/resources/Titulo Cadastrar Hospedagem.png"));
		lblRetanguloBranco.setBounds(440, 100, 1455, 119);
		contentPane.add(lblRetanguloBranco);

		JLabel lblHospede = new JLabel("Hóspedes *");
		lblHospede.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblHospede.setBounds(502, 315, 145, 40);
		contentPane.add(lblHospede);


		JLabel lblDataCheckin = new JLabel("Data check-in *");
		lblDataCheckin.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDataCheckin.setBounds(502, 510, 145, 40);
		contentPane.add(lblDataCheckin);

		txtDataCheckin = new DateTextField();
		txtDataCheckin.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtDataCheckin.setBounds(502, 548, 343, 48);
		contentPane.add(txtDataCheckin);
		txtDataCheckin.setColumns(10);

		JLabel lblQuartos = new JLabel("Quartos *");
		lblQuartos.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblQuartos.setBounds(1010, 315, 145, 40);
		contentPane.add(lblQuartos);

		JLabel lblDataCheckout = new JLabel("Data check-out");
		lblDataCheckout.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDataCheckout.setBounds(1010, 510, 145, 40);
		contentPane.add(lblDataCheckout);

		txtDataCheckout = new DateTextField();
		txtDataCheckout.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtDataCheckout.setBounds(1010, 548, 343, 48);
		contentPane.add(txtDataCheckout);
		txtDataCheckout.setColumns(10);



		JLabel lblBotaoSalvar = new JLabel("");
		lblBotaoSalvar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Hospedagem hospedagem = new Hospedagem();

				boolean erro = false;

				int indexNumQuartos = comboBoxQuartos.getSelectedIndex();
				Quarto q = new Quarto();
				q = quartos.get(indexNumQuartos);
				hospedagem.setQuarto(q);

				int numHospedes = (int) comboBoxNumHosp.getSelectedItem();
				hospedagem.setNumHospedes(numHospedes);


				DateTextField dtf = new DateTextField();

				// Validação dos campos obrigatórios
				if (txtDataCheckin.getText().isEmpty() || txtDataCheckout.getText().isEmpty()) {
					erro = true;
					TelaErro dadosIncorretos = new TelaErro("Insira uma Data Válida!");
					dadosIncorretos.setLocationRelativeTo(null);
					dadosIncorretos.setVisible(true);
				} else {
					LocalDate dataEntrada = dtf.stringParaData(txtDataCheckin.getText());
					hospedagem.setDataEntrada(dataEntrada);

					LocalDate dataSaida = dtf.stringParaData(txtDataCheckout.getText());
					hospedagem.setDataSaida(dataSaida);
				}

				int indexHosp;
				Hospede hospede = new Hospede();
				ArrayList<Hospede> hospedesHosp = new ArrayList<>();
				if(numHospedes >= 1) {
					indexHosp = comboBoxHospede1.getSelectedIndex();
					hospede = hospedes.get(indexHosp);
					hospedesHosp.add(hospede);
				}
				if(numHospedes >= 2) {
					indexHosp = comboBoxHospede2.getSelectedIndex();
					hospede = hospedes.get(indexHosp);
					hospedesHosp.add(hospede);
				}
				if(numHospedes >= 3) {
					indexHosp = comboBoxHospede3.getSelectedIndex();
					hospede = hospedes.get(indexHosp);
					hospedesHosp.add(hospede);
				}
				if(numHospedes == 4) {
					indexHosp = comboBoxHospede4.getSelectedIndex();
					hospede = hospedes.get(indexHosp);
					hospedesHosp.add(hospede);
				}
				hospedagem.setHospedes(hospedesHosp);

				if (erro==false) {
					HospedagemDAO dao = HospedagemDAO.getInstancia();
					int id_hosp = dao.inserirHospedagem(hospedagem);

					if (id_hosp > 0) {
						hospedagem.setId(id_hosp);
						
						for (Hospede h : hospedagem.getHospedes()) {
							int id = dao.inserirHospedeHospedagem(h, hospedagem);
							if(id <= 0) {
								TelaErro dadosIncorretos = new TelaErro("Falha ao inserir a hospedagem no banco de dados.");
								dadosIncorretos.setLocationRelativeTo(null);
								dadosIncorretos.setVisible(true);
								break;
							}
						}

						TelaListagemHospedagem lf = new TelaListagemHospedagem(funcionarioLogado);
						lf.setVisible(true);
						lf.setExtendedState(JFrame.MAXIMIZED_BOTH);
						dispose();
						TelaConfirmacao telaConfirmacao = new TelaConfirmacao(hospedagem);
						telaConfirmacao.setVisible(true);

					} else {
						TelaErro dadosIncorretos = new TelaErro("Falha ao inserir a hospedagem no banco de dados.");
						dadosIncorretos.setLocationRelativeTo(null);
						dadosIncorretos.setVisible(true);
					}
				}
			}
		});
		lblBotaoSalvar.setIcon(new ImageIcon("src\\main\\resources\\botao salvar.png"));
		lblBotaoSalvar.setBounds(512, 724, 343, 50);
		contentPane.add(lblBotaoSalvar);




		JLabel lblBotaoCancelar = new JLabel("");
		lblBotaoCancelar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new TelaListagemHospedagem(funcionarioLogado).setVisible(true);
				dispose();
			}
		});
	}
}

