package visao;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import controle.funcionario.FuncionarioDAO;
import controle.hospedagem.HospedagemDAO;
import controle.hospede.HospedeDAO;
import modelo.Funcionario;
import modelo.Hospedagem;
import modelo.Hospede;
import visao.padrao.DateTextField;

import javax.swing.JScrollPane;
import java.awt.Component;
import javax.swing.ScrollPaneConstants;
import java.awt.Color;
import java.awt.ComponentOrientation;

public class TelaListagemHospede extends JFrame implements TelaListagemInterface{

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table; 
	private Hospede hospedeSelecionado;
	private HospedeDAO dao = HospedeDAO.getInstancia();
	private static Funcionario funcionarioLogado;
	private DateTextField dtf = new DateTextField();

	ArrayList<Hospede> lista = dao.listarHospede();

	public TelaListagemHospede(Funcionario funcLogado) {
		funcionarioLogado = funcLogado;
		setTitle("Listagem de Hospede");
		TelaListagemHospede janela = this;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100,  1920, 1080);
		contentPane = new JPanel();
		contentPane.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("src/main/resources/logo sigh.png"));
		lblNewLabel_1.setBounds(135, 46, 144, 176);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Menu");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_2.setBounds(67, 286, 244, 20);
		contentPane.add(lblNewLabel_2);

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
			}
			@Override
			public void mouseExited(MouseEvent e) {
				menuQuarto.setIcon(new ImageIcon("src/main/resources/menu quartoss.png"));
			}
		});
		menuQuarto.setIcon(new ImageIcon("src/main/resources/menu quartoss.png"));
		menuQuarto.setBounds(68, 346, 340, 40);
		contentPane.add(menuQuarto);

		JLabel lblHospede = new JLabel("");
		lblHospede.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				TelaListagemHospede tlh = new TelaListagemHospede(funcionarioLogado);
				dispose();
				tlh.setExtendedState(MAXIMIZED_BOTH);
				tlh.setVisible(true);
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				lblHospede.setIcon(new ImageIcon("src/main/resources/menu - hospedes selecionado.png"));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblHospede.setIcon(new ImageIcon("src/main/resources/menu - hospede.png"));
			}
		});
		lblHospede.setIcon(new ImageIcon("src/main/resources/menu - hospedes selecionado.png"));
		lblHospede.setBounds(51, 400, 340, 40);
		contentPane.add(lblHospede);

		JLabel lblHospedagem = new JLabel("");
		lblHospedagem.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				TelaListagemHospedagem tlhp = new TelaListagemHospedagem(funcionarioLogado);
				dispose();
				tlhp.setExtendedState(MAXIMIZED_BOTH);
				tlhp.setVisible(true);
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
		lblHospedagem.setBounds(68, 472, 340, 40);
		contentPane.add(lblHospedagem);

		JLabel lblFuncionario = new JLabel("");
		lblFuncionario.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				TelaListagemFuncionario tlf = new TelaListagemFuncionario(funcionarioLogado);
				dispose();
				tlf.setExtendedState(MAXIMIZED_BOTH);
				tlf.setVisible(true);
			}
		});
		lblFuncionario.setIcon(new ImageIcon("src/main/resources/menu funcionarios.png"));
		lblFuncionario.setBounds(68, 530, 150, 20);
		contentPane.add(lblFuncionario);

		JLabel lblNewLabel_8 = new JLabel("");
		lblNewLabel_8.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// Logoff
				dispose();
				funcionarioLogado = null;
				TelaLogin tela = new TelaLogin();
				tela.setVisible(true);
			}
		});
		lblNewLabel_8.setIcon(new ImageIcon("src/main/resources/botao sair.png"));
		lblNewLabel_8.setBounds(84, 955, 263, 45);
		contentPane.add(lblNewLabel_8);

		JLabel lblNewLabel_7 = new JLabel("");
		lblNewLabel_7.setIcon(new ImageIcon("src/main/resources/barra funcionários.png"));
		lblNewLabel_7.setBounds(408, 0, 1512, 62);
		contentPane.add(lblNewLabel_7);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane.setBorder(null);
		scrollPane.setBackground(new Color(255, 255, 255));
		scrollPane.setAlignmentX(Component.RIGHT_ALIGNMENT);
		scrollPane.setBounds(444, 308, 1455, 600);
		contentPane.add(scrollPane);

		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int linhaSelecionada = table.getSelectedRow();
				dao = HospedeDAO.getInstancia();
				lista = dao.listarHospede();
				hospedeSelecionado = lista.get(linhaSelecionada);
			}
		});
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
						"Nome", "Nacionalidade",  "Telefone", "Email", "Data Nascimento", "Responsável"

				}
				));
		atualizarJTableModel();

		JLabel botaoEditar = new JLabel("");
		botaoEditar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				TelaEdicaoHospede telaEdFun = new TelaEdicaoHospede(funcionarioLogado, hospedeSelecionado);
				telaEdFun.setExtendedState(JFrame.MAXIMIZED_BOTH);
				telaEdFun.setVisible(true);
				dispose();
			}
		});  
		botaoEditar.setIcon(new ImageIcon("src/main/resources/botaoEditar.png"));
		botaoEditar.setBounds(1570, 164, 120, 34);
		contentPane.add(botaoEditar);

		JLabel botaoExcluir = new JLabel("");
		TelaListagemHospede estaTela = this;
		botaoExcluir.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				TelaConfirmacaoExclusao telaExclusao = new TelaConfirmacaoExclusao("Você deseja excluir o(a) hospede?", hospedeSelecionado, estaTela);
				telaExclusao.setLocationRelativeTo(null);
				telaExclusao.setVisible(true);
			}
		});
		botaoExcluir.setIcon(new ImageIcon("src/main/resources/botaoExcluir.png"));
		botaoExcluir.setBounds(1740, 164, 120, 34);
		contentPane.add(botaoExcluir);

		JLabel lblBotaoCadastrar = new JLabel("");
		lblBotaoCadastrar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				TelaCadastroHospede cadHos = new TelaCadastroHospede(funcionarioLogado);
				cadHos.setExtendedState(JFrame.MAXIMIZED_BOTH);
				cadHos.setVisible(true);
				dispose();
			}
		});
		lblBotaoCadastrar.setIcon(new ImageIcon("src/main/resources/botao cadastrar.png"));
		lblBotaoCadastrar.setBounds(1400, 164, 120, 34);
		contentPane.add(lblBotaoCadastrar);

		JLabel lblNewLabel_9 = new JLabel("");
		lblNewLabel_9.setIcon(new ImageIcon("src/main/resources/TituloListarHospede.png"));
		lblNewLabel_9.setBounds(444, 115, 1455, 126);
		contentPane.add(lblNewLabel_9);

		JLabel lblNewLabel_11 = new JLabel("");
		lblNewLabel_11.setIcon(new ImageIcon("src/main/resources/caminhoListagemHospede.png"));
		lblNewLabel_11.setBounds(420, 0, 1500, 62);
		contentPane.add(lblNewLabel_11);
		
				JLabel lblNewLabel = new JLabel("");
				lblNewLabel.setForeground(new Color(0, 128, 0));
				lblNewLabel.setBounds(0, 0, 420, 1080);
				lblNewLabel.setIcon(new ImageIcon("src/main/resources/fundo cinza (menu).png"));
				contentPane.add(lblNewLabel);
	}

	public void atualizarJTableModel() {
		DefaultTableModel modelo = new DefaultTableModel(new Object[][] {}, new String[] {"Nome", "Nacionalidade",  "Telefone", "Email", "Data Nascimento", "Responsável"});

		dao = HospedeDAO.getInstancia();
		lista = dao.listarHospede();

		for (int i = 0; i < lista.size(); i++) {
			Hospede hos = lista.get(i);
			String nomeCompleto;
			if (hos.getNomeSocial() == null || hos.getNomeSocial().trim().isEmpty()) {
				nomeCompleto = hos.getNome() + " " + hos.getSobrenome();
			} else {
				nomeCompleto = hos.getNomeSocial() + " " + hos.getSobrenome();
			}
			String nomeCompletoResp = "";
			if(hos.getResponsavel() != null) {
				if(hos.getResponsavel().getNomeSocial() == null || hos.getResponsavel().getNomeSocial().trim().isEmpty()) {
					nomeCompletoResp = hos.getResponsavel().getNome() + " " + hos.getResponsavel().getSobrenome();
				} else {
					nomeCompletoResp = hos.getResponsavel().getNomeSocial() + " " + hos.getResponsavel().getSobrenome();
				}
			}
			modelo.addRow(new Object[] { nomeCompleto, hos.getNacionalidade(), hos.getTelefone(), hos.getEmail(), dtf.formatarData(hos.getDataNascimento()), nomeCompletoResp});

		}

		table.setModel(modelo);

	}
}

