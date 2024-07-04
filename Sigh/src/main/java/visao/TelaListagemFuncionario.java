package visao;

import java.awt.Color;
import java.awt.Component;
import java.awt.ComponentOrientation;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import controle.funcionario.FuncionarioDAO;
import controle.hospedagem.HospedagemDAO;
import modelo.Funcionario;

public class TelaListagemFuncionario extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private Funcionario funcionarioSelecionado;
	private FuncionarioDAO dao = FuncionarioDAO.getInstancia();
	private static Funcionario funcionarioLogado;

	ArrayList<Funcionario> lista = dao.listarFuncionario();

	/**
	 * Create the frame.
	 */
	public TelaListagemFuncionario(Funcionario funcLogado) {
		funcionarioLogado = funcLogado;
		setTitle("Listagem de funcionário");
		TelaListagemFuncionario janela = this;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1920, 1080);
		contentPane = new JPanel();
		contentPane.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel logo = new JLabel("");
		logo.setIcon(new ImageIcon("src/main/resources/logo sigh.png"));
		logo.setBounds(135, 46, 144, 176);
		contentPane.add(logo);

		JLabel menu = new JLabel("Menu");
		menu.setFont(new Font("Tahoma", Font.PLAIN, 16));
		menu.setBounds(67, 286, 244, 20);
		contentPane.add(menu);

		JLabel menuPedidos = new JLabel("");
		menuPedidos.setIcon(new ImageIcon("src/main/resources/menu pedidos.png"));
		menuPedidos.setBounds(68, 346, 150, 20);
		contentPane.add(menuPedidos);

		JLabel menuHospedes = new JLabel("");
		menuHospedes.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				TelaListagemHospede tlh = new TelaListagemHospede(funcionarioLogado);
				dispose();
				tlh.setExtendedState(MAXIMIZED_BOTH);
				tlh.setVisible(true);
			}
		});
		menuHospedes.setIcon(new ImageIcon("src/main/resources/menu - hospede.png"));
		menuHospedes.setBounds(68, 407, 150, 20);
		contentPane.add(menuHospedes);

		JLabel menuHospedagem = new JLabel("");
		menuHospedagem.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				TelaListagemHospedagem tlh = new TelaListagemHospedagem(funcionarioLogado);
				tlh.setVisible(true);
				tlh.setExtendedState(JFrame.MAXIMIZED_BOTH);
				dispose();
			}
		});
		menuHospedagem.setIcon(new ImageIcon("src/main/resources/menu hospedagem.png"));
		menuHospedagem.setBounds(68, 472, 150, 20);
		contentPane.add(menuHospedagem);

		JLabel menuFuncionario = new JLabel("");
		menuFuncionario.setIcon(new ImageIcon("src/main/resources/menu - funcionarios selecionado.png"));
		menuFuncionario.setBounds(48, 520, 335, 45);
		contentPane.add(menuFuncionario);

		JLabel botaoSair = new JLabel("");
		botaoSair.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// Logoff
				dispose();
				funcionarioLogado = null;
				TelaLogin tela = new TelaLogin();
				tela.setVisible(true);
				tela.setExtendedState(JFrame.MAXIMIZED_BOTH);
			}
		});
		botaoSair.setIcon(new ImageIcon("src/main/resources/botao sair.png"));
		botaoSair.setBounds(84, 955, 263, 45);
		contentPane.add(botaoSair);

		JLabel fundoCinza = new JLabel("");
		fundoCinza.setForeground(new Color(0, 128, 0));
		fundoCinza.setBounds(0, 0, 420, 1080);
		fundoCinza.setIcon(new ImageIcon("src/main/resources/fundo cinza (menu).png"));
		contentPane.add(fundoCinza);

		JLabel barra = new JLabel("");
		barra.setIcon(new ImageIcon("src/main/resources/barra funcionários.png"));
		barra.setBounds(408, 0, 1512, 62);
		contentPane.add(barra);

		JScrollPane scrollPane = new JScrollPane();
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
				dao = FuncionarioDAO.getInstancia();
				lista = dao.listarFuncionario();
				funcionarioSelecionado = lista.get(linhaSelecionada);
			}
		});
		scrollPane.setViewportView(table);
		table.setModel(
				new DefaultTableModel(new Object[][] {}, new String[] { "CPF", "Nome Completo", "Usuario", "Cargo", "Setor" }));
		atualizarJTableModel();

		JLabel botaoEditar = new JLabel("");
		botaoEditar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				TelaEdicaoFuncionario telaEdFun = new TelaEdicaoFuncionario(funcionarioLogado, funcionarioSelecionado);
				telaEdFun.setExtendedState(JFrame.MAXIMIZED_BOTH);
				telaEdFun.setVisible(true);
				dispose();
			}
		});
		botaoEditar.setIcon(new ImageIcon("src/main/resources/botaoEditar.png"));
		botaoEditar.setBounds(1570, 164, 120, 34);
		contentPane.add(botaoEditar);

		JLabel botaoExcluir = new JLabel("");
		botaoExcluir.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				/*			TelaConfirmacaoExclusao telaExclusao = new TelaConfirmacaoExclusao("Você deseja excluir o(a) funcionário(a)?");
				telaExclusao.setLocationRelativeTo(null);
				telaExclusao.setVisible(true);   */
			}
		});   
		botaoExcluir.setIcon(new ImageIcon("src/main/resources/botaoExcluir.png"));
		botaoExcluir.setBounds(1740, 164, 120, 34);
		contentPane.add(botaoExcluir);

		JLabel botaoCadastrar = new JLabel("");
		botaoCadastrar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				TelaCadastroFuncionario cadFun = new TelaCadastroFuncionario(funcionarioLogado);
				cadFun.setExtendedState(JFrame.MAXIMIZED_BOTH);
				cadFun.setVisible(true);
				dispose();
			}
		});
		botaoCadastrar.setIcon(new ImageIcon("src/main/resources/botao cadastrar.png"));
		botaoCadastrar.setBounds(1400, 164, 120, 34);
		contentPane.add(botaoCadastrar);

		JLabel lblNewLabel_9 = new JLabel("");
		lblNewLabel_9.setIcon(new ImageIcon("src/main/resources/TituloListagemFuncionario.png"));
		lblNewLabel_9.setBounds(444, 115, 1455, 126);
		contentPane.add(lblNewLabel_9);
	}

	protected void atualizarJTableModel() {
		DefaultTableModel modelo = new DefaultTableModel(new Object[][] {},
				new String[] { "CPF", "Nome Completo", "Usuario", "Cargo", "Setor" });

		dao = FuncionarioDAO.getInstancia();
		lista = dao.listarFuncionario();

		for (int i = 0; i < lista.size(); i++) {
			Funcionario fun = lista.get(i);
			String nomeCompleto;
			if (fun.getNomeSocial() == null || fun.getNomeSocial().trim().isEmpty()) {
				nomeCompleto = fun.getNome() + " " + fun.getSobrenome();
				modelo.addRow(new Object[] { fun.getId(), nomeCompleto, fun.getUsuario(), fun.getCargo(), fun.getSetor().getNome() });
			} else {
				nomeCompleto = fun.getNomeSocial() + " " + fun.getSobrenome();
				modelo.addRow(new Object[] { fun.getId(), nomeCompleto, fun.getUsuario(), fun.getCargo(), fun.getSetor().getNome() });
			}

		}

		table.setModel(modelo);
	}
}
