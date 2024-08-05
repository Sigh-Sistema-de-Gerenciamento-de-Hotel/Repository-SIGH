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
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class TelaEdicaoHospedagem extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private final JLabel lblMenu = new JLabel("");
	private JTextField txtDataCheckin;
	private JTextField txtDataCheckout;
	private JComboBox <Integer> comboBoxQuartos;
	private JComboBox <Integer> comboBoxNumHosp; 
	private Funcionario funcionarioLogado;

	public TelaEdicaoHospedagem(Funcionario funcLogado, Hospedagem hospSelecionada) {
		this.funcionarioLogado = funcLogado;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1471, 912);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		DateTextField dateTf = new DateTextField();

		int numQuarto = hospSelecionada.getQuarto().getNumero();
		comboBoxQuartos = new JComboBox<Integer>();
		QuartoDAO daoQ = QuartoDAO.getInstacia();
		ArrayList<Quarto> quartos = daoQ.listarQuarto();
		for (Quarto quarto : quartos) {
			int id = quarto.getNumero();
			comboBoxQuartos.addItem(id);
		}
		comboBoxQuartos.setFont(new Font("Tahoma", Font.PLAIN, 14));
		comboBoxQuartos.setBounds(1010, 355, 343, 48);
		comboBoxQuartos.setSelectedItem(numQuarto);
		contentPane.add(comboBoxQuartos);


		setContentPane(contentPane);
		contentPane.setLayout(null);
		JPanel panel = new JPanel();
		panel.setBounds(502, 486, 343, 74);
		contentPane.add(panel);
		panel.setLayout(new MigLayout("", "[grow]", "[][]"));

		JLabel lblNewLabel = new JLabel("Hospedes*");
		panel.add(lblNewLabel, "cell 0 0");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		
		ArrayList<Hospede> hospedesHospedagem = hospSelecionada.getHospedes();
		ArrayList<String> infosHospedes = new ArrayList<>();
		for (Hospede h : hospedesHospedagem) {
			String infos;
			String nomeCompleto;
			if(h.getNomeSocial() == null) {
				nomeCompleto = h.getNome() + " " + h.getSobrenome(); 
			} else {
				nomeCompleto = h.getNomeSocial() + " " + h.getSobrenome(); 
			} 
			String doc;
			String cpf = String.valueOf(h.getCpf());
			if (h.getCpf() == null || h.getCpf().isEmpty()) {
				doc = h.getPassaporte();
			} else {
				doc = cpf; 
			}
			infos = nomeCompleto +" - " + doc;
			infosHospedes.add(infos);
		}

		
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
			if (h.getCpf() == null || h.getCpf().isEmpty()) {
				doc = h.getPassaporte();
			} else {
				doc = cpf; 
			}
			infos = nomeCompleto +" - " + doc;
			comboBoxHospede1.addItem(infos);
		}
		comboBoxHospede1.setSelectedItem(infosHospedes.get(0));
		panel.add(comboBoxHospede1, "cell 0 1,growx");


		JPanel panel_1 = new JPanel();
		panel_1.setBounds(1010, 486, 334, 80);
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
			if (resp.getCpf() == null || resp.getCpf().isEmpty()) {
				doc = resp.getPassaporte();
			} else {
				doc = cpf; 
			}
			infos = nomeCompleto +" - " + doc;
			if(infosHospedes.size() > 1) {
				comboBoxHospede2.setSelectedItem(infosHospedes.get(1));
			}
			comboBoxHospede2.addItem(infos);
		}
		panel_1.add(comboBoxHospede2, "cell 0 1,growx");
		panel_1.setVisible(false);

		JPanel panel_2 = new JPanel();
		panel_2.setBounds(502, 623, 334, 95);
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
			if (resp.getCpf() == null || resp.getCpf().isEmpty()) {
				doc = resp.getPassaporte();
			} else {
				doc = cpf; 
			}
			infos = nomeCompleto +" - " + doc;
			if(infosHospedes.size() > 2) {
				comboBoxHospede3.setSelectedItem(infosHospedes.get(2));
			}
			comboBoxHospede3.addItem(infos);
		}
		panel_2.add(comboBoxHospede3, "cell 0 1,growx");
		panel_2.setVisible(false);

		JPanel panel_3 = new JPanel();
		panel_3.setBounds(1010, 623, 334, 95);
		contentPane.add(panel_3);
		panel_3.setLayout(new MigLayout("", "[grow]", "[][]"));

		JLabel lblNewLabel_3 = new JLabel("Hospedes*");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel_3.add(lblNewLabel_3, "cell 0 0");		
		
		//		ArrayList<Hospede> hosp4 = hospSelecionada.getHospedes();
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
			if (resp.getCpf() == null || resp.getCpf().isEmpty()) {
				doc = resp.getPassaporte();
			} else {
				doc = cpf; 
			}
			infos = nomeCompleto +" - " + doc;
			if(infosHospedes.size() > 3) {
				comboBoxHospede4.setSelectedItem(infosHospedes.get(3));
			}
			comboBoxHospede4.addItem(infos);
		}
		panel_3.add(comboBoxHospede4, "cell 0 1,growx");
		panel_3.setVisible(false);
		
		int NumHosp = hospSelecionada.getTotalHospedes();
		panel_1.setVisible(false);
		panel_2.setVisible(false);
		panel_3.setVisible(false);
		if(NumHosp >= 2) {
			panel_1.setVisible(true);
		}
		if(NumHosp >= 3) {
			panel_2.setVisible(true);
		}
		if(NumHosp == 4) {
			panel_3.setVisible(true);
		}
		
		comboBoxNumHosp = new JComboBox<Integer>();
		comboBoxNumHosp.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				panel_1.setVisible(false);
				panel_2.setVisible(false);
				panel_3.setVisible(false);
				int num = (int) comboBoxNumHosp.getSelectedItem();
				if(num >= 2) {
					panel_1.setVisible(true);
				}
				if(num >= 3) {
					panel_2.setVisible(true);
				}
				if(num == 4) {
					panel_3.setVisible(true);
				}
			}
		});
		comboBoxNumHosp.setModel(new DefaultComboBoxModel<Integer>(new Integer[] {1, 2, 3, 4}));
		comboBoxNumHosp.setForeground(Color.BLACK);
		comboBoxNumHosp.setFont(new Font("Tahoma", Font.PLAIN, 14));
		comboBoxNumHosp.setSelectedItem(hospSelecionada.getNumHospedes());
		comboBoxNumHosp.setBounds(502, 355, 343, 48);
		comboBoxNumHosp.setSelectedItem(NumHosp);
		contentPane.add(comboBoxNumHosp);
		
		

		JLabel lblBotaoFuncionarios = new JLabel("");
		lblBotaoFuncionarios.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				TelaListagemFuncionario listaFuncionario = new TelaListagemFuncionario(funcionarioLogado);
				listaFuncionario.setVisible(true);
				listaFuncionario.setExtendedState(MAXIMIZED_BOTH);
				dispose();
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				lblBotaoFuncionarios.setIcon(new ImageIcon("src/main/resources/menu - funcionarios selecionado.png"));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblBotaoFuncionarios.setIcon(new ImageIcon("src\\main\\resources\\menu funcionarios.png"));
			}
		});
		lblBotaoFuncionarios.setIcon(new ImageIcon("src\\main\\resources\\menu funcionarios.png"));
		lblBotaoFuncionarios.setBounds(67, 523, 295, 38);
		contentPane.add(lblBotaoFuncionarios);

		JLabel lblSimboloSigh = new JLabel("");
		lblSimboloSigh.setIcon(new ImageIcon("src\\main\\resources\\logo sigh.png"));
		lblSimboloSigh.setBounds(130, 35, 161, 182);
		contentPane.add(lblSimboloSigh);

		JLabel lblBotaoQuarto = new JLabel("");
		lblBotaoQuarto.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				TelaListagemQuarto tlq = new TelaListagemQuarto(funcionarioLogado);
				tlq.setVisible(true);
				tlq.setExtendedState(JFrame.MAXIMIZED_BOTH);
			    dispose();
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				lblBotaoQuarto.setIcon(new ImageIcon("src/main/resources/menu - quartos selecionado.png"));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblBotaoQuarto.setIcon(new ImageIcon("src\\main\\resources\\menu pedidos.png"));
			}
		});
		lblBotaoQuarto.setIcon(new ImageIcon("src\\main\\resources\\menu pedidos.png"));
		lblBotaoQuarto.setBounds(67, 345, 295, 38);
		contentPane.add(lblBotaoQuarto);

		JLabel lblBotaoHospedes = new JLabel("");
		lblBotaoHospedes.setIcon(new ImageIcon("src\\main\\resources\\menu - hospede.png"));
		lblBotaoHospedes.setBounds(67, 407, 295, 38);
		contentPane.add(lblBotaoHospedes);

		JLabel lblBotaoHospedagemSelecionado = new JLabel("");
		lblBotaoHospedagemSelecionado.setIcon(new ImageIcon("src\\main\\resources\\menu hospedagem selecionado.png"));
		lblBotaoHospedagemSelecionado.setBounds(43, 457, 342, 45);
		contentPane.add(lblBotaoHospedagemSelecionado);

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
		lblParteSuperiorPequena.setIcon(new ImageIcon("src/main/resources/caminho Editar Hospedagem.png"));
		lblParteSuperiorPequena.setBounds(420, 0, 1500, 62);
		contentPane.add(lblParteSuperiorPequena);

		JLabel lblRetanguloBranco = new JLabel("");
		lblRetanguloBranco.setIcon(new ImageIcon("src/main/resources/Titulo Editar hospedagem.png"));
		lblRetanguloBranco.setBounds(440, 100, 1455, 119);
		contentPane.add(lblRetanguloBranco);

		JLabel lblHospede = new JLabel("Hóspedes *");
		lblHospede.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblHospede.setBounds(502, 315, 145, 40);
		contentPane.add(lblHospede);


		JLabel lblDataCheckin = new JLabel("Data check-in *");
		lblDataCheckin.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDataCheckin.setBounds(502, 779, 145, 40);
		contentPane.add(lblDataCheckin);

		LocalDate dataIn = hospSelecionada.getDataEntrada();
		String dataCheckIn = dateTf.formatarData(dataIn);
		txtDataCheckin = new DateTextField();
		txtDataCheckin.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtDataCheckin.setBounds(502, 779, 145, 40);
		txtDataCheckin.setText(dataCheckIn);
		contentPane.add(txtDataCheckin);
		txtDataCheckin.setColumns(10);

		JLabel lblQuartos = new JLabel("Quartos *");
		lblQuartos.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblQuartos.setBounds(1010, 315, 145, 40);
		contentPane.add(lblQuartos);

		JLabel lblDataCheckout = new JLabel("Data check-out");
		lblDataCheckout.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDataCheckout.setBounds(1010, 779, 145, 40);
		contentPane.add(lblDataCheckout);

		LocalDate dataOut = hospSelecionada.getDataEntrada();
		String dataCheckOut = dateTf.formatarData(dataOut);
		txtDataCheckout = new DateTextField();
		txtDataCheckout.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtDataCheckout.setBounds(1010, 814, 343, 48);
		txtDataCheckout.setText(dataCheckOut);
		contentPane.add(txtDataCheckout);
		txtDataCheckout.setColumns(10);



		JLabel lblBotaoSalvar = new JLabel("");
		lblBotaoSalvar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				boolean erro = false;

				int indexNumQuartos = comboBoxQuartos.getSelectedIndex();
				Quarto q = new Quarto();
				q = quartos.get(indexNumQuartos);
				hospSelecionada.setQuarto(q);

				int numHospedes = (int) comboBoxNumHosp.getSelectedItem();
				hospSelecionada.setNumHospedes(numHospedes);


				DateTextField dtf = new DateTextField();

				// Validação dos campos obrigatórios
				if (txtDataCheckin.getText().isEmpty() || txtDataCheckout.getText().isEmpty()) {
					erro = true;
					TelaErro dadosIncorretos = new TelaErro("Insira uma Data Válida!");
					dadosIncorretos.setLocationRelativeTo(null);
					dadosIncorretos.setVisible(true);
				} else {
					LocalDate dataEntrada = dtf.stringParaData(txtDataCheckin.getText());
					hospSelecionada.setDataEntrada(dataEntrada);

					LocalDate dataSaida = dtf.stringParaData(txtDataCheckout.getText());
					hospSelecionada.setDataSaida(dataSaida);
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
				hospSelecionada.setHospedes(hospedesHosp);

				if (erro==false) {
					HospedagemDAO dao = HospedagemDAO.getInstancia();
					boolean atualizacao = dao.atualizarHospedagem(hospSelecionada);

					if (atualizacao == true) {
						TelaListagemHospedagem lf = new TelaListagemHospedagem(funcionarioLogado);
						lf.setVisible(true);
						lf.setExtendedState(JFrame.MAXIMIZED_BOTH);
						dispose();
						TelaConfirmacaoEdicao telaConfirmacao = new TelaConfirmacaoEdicao(hospSelecionada);
						telaConfirmacao.setVisible(true);

					} else {
						TelaErro dadosIncorretos = new TelaErro("Falha ao atualizar a hospedagem no banco de dados.");
						dadosIncorretos.setLocationRelativeTo(null);
						dadosIncorretos.setVisible(true);
					}
				}
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				lblBotaoSalvar.setIcon(new ImageIcon("src/main/resources/botao salvar  claro.png"));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblBotaoSalvar.setIcon(new ImageIcon("src\\main\\resources\\botao salvar.png"));
			}
		});
		lblBotaoSalvar.setIcon(new ImageIcon("src\\main\\resources\\botao salvar.png"));
		lblBotaoSalvar.setBounds(1300, 915, 300, 60);
		contentPane.add(lblBotaoSalvar);
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new TelaListagemHospedagem(funcionarioLogado).setVisible(true);
				dispose();
			}
		});
		lblNewLabel_4.setIcon(new ImageIcon("C:\\Users\\Aluno\\Downloads\\Repository-SIGH\\Sigh\\src\\main\\resources\\botao cancelar.png"));
		lblNewLabel_4.setBounds(1670, 930, 150, 40);
		contentPane.add(lblNewLabel_4);



			}
		
	}


