package visao;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import controle.funcionario.FuncionarioDAO;
import controle.hospedagem.HospedagemDAO;
import modelo.Funcionario;
import modelo.Hospedagem;

import javax.swing.JScrollPane;
import java.awt.Component;
import javax.swing.ScrollPaneConstants;
import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class TelaListagemFuncionario extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private Funcionario funcionarioSelecionado;
	private FuncionarioDAO dao = FuncionarioDAO.getInstancia();

	ArrayList<Funcionario> lista = dao.listarFuncionario();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaListagemFuncionario frame = new TelaListagemFuncionario();
					frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TelaListagemFuncionario() {
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
		lblNewLabel_4.setIcon(new ImageIcon("src/main/resources/menu - hospede.png"));
		lblNewLabel_4.setBounds(68, 407, 150, 20);
		contentPane.add(lblNewLabel_4);

		JLabel lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setIcon(new ImageIcon("src/main/resources/menu hospedagem.png"));
		lblNewLabel_5.setBounds(68, 472, 150, 20);
		contentPane.add(lblNewLabel_5);

		JLabel lblNewLabel_6 = new JLabel("");
		lblNewLabel_6.setIcon(new ImageIcon("src/main/resources/menu - funcionarios selecionado.png"));
		lblNewLabel_6.setBounds(48, 520, 335, 45);
		contentPane.add(lblNewLabel_6);

		JLabel lblNewLabel_8 = new JLabel("");
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
				TelaEdicaoFuncionario telaEdFun = new TelaEdicaoFuncionario(funcionarioSelecionado);
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
				FuncionarioDAO dao = FuncionarioDAO.getInstancia();
				int confirmacao = JOptionPane.showConfirmDialog(null,
						"Excluir o funcionário " + funcionarioSelecionado.getNome() + "?");

				if (confirmacao == JOptionPane.YES_OPTION) {
					Boolean validacao = dao.removerFuncionarios(funcionarioSelecionado);
					atualizarJTableModel();
					if (validacao==true) {
						JOptionPane.showMessageDialog(null,
								"O funcionário " + funcionarioSelecionado.getNome() + " foi excluído");
						
					}
				}
			}
		});
		botaoExcluir.setIcon(new ImageIcon("src/main/resources/botaoExcluir.png"));
		botaoExcluir.setBounds(1740, 164, 120, 34);
		contentPane.add(botaoExcluir);

		JLabel botaoCadastrar = new JLabel("");
		botaoCadastrar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				CadastroFuncionario cadFun = new CadastroFuncionario();
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
