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

		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("src/main/resources/logo sigh.png"));
		lblNewLabel_1.setBounds(135, 46, 144, 176);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Menu");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_2.setBounds(67, 286, 244, 20);
		contentPane.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon("src/main/resources/menu pedidos.png"));
		lblNewLabel_3.setBounds(68, 346, 150, 20);
		contentPane.add(lblNewLabel_3);

		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				TelaListagemHospede tlh = new TelaListagemHospede(funcionarioLogado);
				dispose();
				tlh.setExtendedState(MAXIMIZED_BOTH);
				tlh.setVisible(true);
			}
		});
		lblNewLabel_4.setIcon(new ImageIcon("src/main/resources/menu - hospede.png"));
		lblNewLabel_4.setBounds(68, 407, 150, 20);
		contentPane.add(lblNewLabel_4);

		JLabel lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				TelaListagemHospedagem tlh = new TelaListagemHospedagem(funcionarioLogado);
				tlh.setVisible(true);
				tlh.setExtendedState(JFrame.MAXIMIZED_BOTH);
				dispose();
			}
		});
		lblNewLabel_5.setIcon(new ImageIcon("src/main/resources/menu hospedagem.png"));
		lblNewLabel_5.setBounds(68, 472, 150, 20);
		contentPane.add(lblNewLabel_5);

		JLabel lblNewLabel_6 = new JLabel("");
		lblNewLabel_6.setIcon(new ImageIcon("src/main/resources/menu - funcionarios selecionado.png"));
		lblNewLabel_6.setBounds(48, 520, 335, 45);
		contentPane.add(lblNewLabel_6);

		JLabel lblNewLabel_8 = new JLabel("");
		lblNewLabel_8.addMouseListener(new MouseAdapter() {
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
		lblNewLabel_8.setIcon(new ImageIcon("src/main/resources/botao sair.png"));
		lblNewLabel_8.setBounds(84, 955, 263, 45);
		contentPane.add(lblNewLabel_8);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setForeground(new Color(0, 128, 0));
		lblNewLabel.setBounds(0, 0, 420, 1080);
		lblNewLabel.setIcon(new ImageIcon("src/main/resources/fundo cinza (menu).png"));
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_7 = new JLabel("");
		lblNewLabel_7.setIcon(new ImageIcon("src/main/resources/barra funcionários.png"));
		lblNewLabel_7.setBounds(408, 0, 1512, 62);
		contentPane.add(lblNewLabel_7);

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
				new DefaultTableModel(new Object[][] {}, new String[] { "CPF", "Nome Completo", "Usuario", "Cargo" }));
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
				TelaConfirmacaoExclusao excluir = new TelaConfirmacaoExclusao("Excluir o funcionário" + funcionarioSelecionado.getNome() + "?");
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
				new String[] { "CPF", "Nome Completo", "Usuario", "Cargo" });

		dao = FuncionarioDAO.getInstancia();
		lista = dao.listarFuncionario();

		for (int i = 0; i < lista.size(); i++) {
			Funcionario fun = lista.get(i);
			String nomeCompleto;
			if (fun.getNomeSocial() == null || fun.getNomeSocial().trim().isEmpty()) {
				nomeCompleto = fun.getNome() + " " + fun.getSobrenome();
				modelo.addRow(new Object[] { fun.getId(), nomeCompleto, fun.getUsuario(), fun.getCargo() });
			} else {
				nomeCompleto = fun.getNomeSocial() + " " + fun.getSobrenome();
				modelo.addRow(new Object[] { fun.getId(), nomeCompleto, fun.getUsuario(), fun.getCargo() });
			}

		}

		table.setModel(modelo);
	}
}
