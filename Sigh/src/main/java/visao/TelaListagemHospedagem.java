package visao;

import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import controle.funcionario.FuncionarioDAO;
import controle.hospedagem.HospedagemDAO;
import modelo.Funcionario;
import modelo.Hospedagem;
import visao.padrao.DateTextField;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;



public class TelaListagemHospedagem extends JFrame implements TelaListagemInterface{

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private HospedagemDAO dao =  HospedagemDAO.getInstancia(); 
	private JLabel caminho;
	private Hospedagem hospedagemSelecionada; 
	private Funcionario funcionarioLogado; 

	private DateTextField dtf = new DateTextField();
	ArrayList<Hospedagem> lista = dao.listarHospedagem();
	
	public TelaListagemHospedagem(Funcionario funcLogado) {
		funcionarioLogado = funcLogado;
		TelaListagemHospedagem janela = this;
		setIconImage(Toolkit.getDefaultToolkit().getImage("src/main/resources/logo sigh.png"));
		setTitle("Listagem Hospedagem");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 777, 648);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		// Listagem
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
				dao = HospedagemDAO.getInstancia();
				lista = dao.listarHospedagem();
				hospedagemSelecionada = lista.get(linhaSelecionada);
			}
		});
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(new Object[][] {}, new String[] {"Código", "Código quarto", "Nº de Hóspedes",  "Entrada", "Saída"}));
		// atualiza JTable
		atualizarJTableModel();
		
		// Menu
		
		JLabel botaoSair = new JLabel("Sair");
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
			public void mouseEntered(MouseEvent e) {
				botaoSair.setIcon(new ImageIcon("src/main/resources/botao sair cinza claro.png"));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				botaoSair.setIcon(new ImageIcon("src/main/resources/botao sair.png"));
			}
		});
		botaoSair.setIcon(new ImageIcon("src/main/resources/botao sair.png"));
		botaoSair.setBounds(69, 955, 263, 45);
		contentPane.add(botaoSair);
		
		JLabel divisaoMenu = new JLabel("Divisão Menu");
		divisaoMenu.setIcon(new ImageIcon("src/main/resources/divisor (menu).png"));
		divisaoMenu.setBounds(77, 897, 243, 14);
		contentPane.add(divisaoMenu);
		
		JLabel funcionarios = new JLabel("");
		funcionarios.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				TelaListagemFuncionario tlf = new TelaListagemFuncionario(funcionarioLogado);
				tlf.setVisible(true);
				tlf.setExtendedState(JFrame.MAXIMIZED_BOTH);
				dispose();
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				funcionarios.setIcon(new ImageIcon("src/main/resources/menu - funcionarios selecionado.png"));
				funcionarios.setBounds(35, 517, 363, 51);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				funcionarios.setIcon(new ImageIcon("src/main/resources/menu funcionarios.png"));
				funcionarios.setBounds(57, 517, 363, 51);
			}
		});
		funcionarios.setIcon(new ImageIcon("src/main/resources/menu funcionarios.png"));
		funcionarios.setBounds(57, 517, 363, 51);
		contentPane.add(funcionarios);
		
		JLabel hospedagem = new JLabel("");
		hospedagem.setIcon(new ImageIcon("src/main/resources/menu hospedagem selecionado.png"));
		hospedagem.setBounds(35, 461, 363, 45);
		contentPane.add(hospedagem);
		
		JLabel quartos = new JLabel("");
		quartos.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				TelaListagemQuarto tlq = new TelaListagemQuarto(funcionarioLogado);
				tlq.setVisible(true);
				tlq.setExtendedState(JFrame.MAXIMIZED_BOTH);
				dispose();
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				quartos.setIcon(new ImageIcon("src/main/resources/menu - quartos selecionado.png"));
				quartos.setBounds(35, 337, 363, 51);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				quartos.setIcon(new ImageIcon("src/main/resources/menu quartoss.png"));
				quartos.setBounds(57, 337, 363, 51);
			}
		});
		quartos.setIcon(new ImageIcon("src/main/resources/menu quartoss.png"));
		quartos.setBounds(57, 337, 363, 51);
		contentPane.add(quartos);
		
		JLabel hospedes = new JLabel("");
		hospedes.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				TelaListagemHospede tlh = new TelaListagemHospede(funcionarioLogado);
				dispose();
				tlh.setExtendedState(MAXIMIZED_BOTH);
				tlh.setVisible(true);
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				hospedes.setIcon(new ImageIcon("src/main/resources/menu - hospedes selecionado.png"));
				hospedes.setBounds(35, 399, 363, 45);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				hospedes.setIcon(new ImageIcon("src/main/resources/menu - hospede.png"));
				hospedes.setBounds(57, 399, 363, 45);
			}
		});
		hospedes.setIcon(new ImageIcon("src/main/resources/menu - hospede.png"));
		hospedes.setBounds(57, 399, 363, 45);
		contentPane.add(hospedes);
		
		JLabel logo = new JLabel("");
		logo.setIcon(new ImageIcon("src/main/resources/logo sigh.png"));
		logo.setBounds(135, 46, 144, 176);
		contentPane.add(logo);
		
		JLabel menu = new JLabel("");
		menu.setIcon(new ImageIcon("src/main/resources/fundo cinza (menu).png"));
		menu.setBounds(0, 0, 420, 1080);
		contentPane.add(menu);	
		
		caminho = new JLabel("");
		caminho.setIcon(new ImageIcon("src/main/resources/CaminhoListagemHospedagem.png"));
		caminho.setBounds(420, 0, 1500, 60);
		contentPane.add(caminho);
		
		/*BOTÃO EDITAR*/
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
		TelaEdicaoHospedagem telaEdhosp = new TelaEdicaoHospedagem(funcionarioLogado, hospedagemSelecionada);
			telaEdhosp.setExtendedState(JFrame.MAXIMIZED_BOTH);
		telaEdhosp.setVisible(true);
			dispose();
	 		}
		});
			
		lblNewLabel.setIcon(new ImageIcon("src/main/resources/botaoEditar.png"));
		lblNewLabel.setBounds(1570, 164, 120, 34);
		contentPane.add(lblNewLabel);
		
		/*BOTÃO EXCLUIR*/
		JLabel lblNewLabel_1 = new JLabel("");
		TelaListagemHospedagem estaTela = this;
		lblNewLabel_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			    TelaConfirmacaoExclusao telaExclusao = new TelaConfirmacaoExclusao("Você deseja excluir a hospedagem?", hospedagemSelecionada, estaTela);
				telaExclusao.setLocationRelativeTo(null);
				telaExclusao.setVisible(true);   
			}
		});
			
		lblNewLabel_1.setIcon(new ImageIcon("src/main/resources/botaoExcluir.png"));
		lblNewLabel_1.setBounds(1740, 164, 120, 34);
		contentPane.add(lblNewLabel_1);
		
		/*BOTÃO CADASTRAR*/
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				TelaCadastroHospedagem cadhosp = new TelaCadastroHospedagem(funcionarioLogado);
				cadhosp.setExtendedState(JFrame.MAXIMIZED_BOTH);
				cadhosp.setVisible(true);
				dispose();
			}
		});
			
		
		lblNewLabel_2.setIcon(new ImageIcon("src/main/resources/botao cadastrar.png"));
		lblNewLabel_2.setBounds(1400, 164, 120, 34);
		contentPane.add(lblNewLabel_2);
		
		JLabel titulo = new JLabel("");
		titulo.setIcon(new ImageIcon("src/main/resources/TituloListagemHospedagem.png"));
		titulo.setBounds(439, 101, 1444, 119);
		contentPane.add(titulo);
	}
	
	public void atualizarJTableModel() {
		DefaultTableModel modelo = new DefaultTableModel(new Object[][] {}, new String[] {"Código", "Código quarto", "Nº de Hóspedes",  "Entrada", "Saída"});

		dao = HospedagemDAO.getInstancia();
		lista = dao.listarHospedagem();

		for (int i = 0; i < lista.size(); i++) {
			Hospedagem hosp = lista.get(i);
			modelo.addRow(new Object[] { hosp.getId(), hosp.getQuarto().getNumero(), hosp.getTotalHospedes(), dtf.formatarData(hosp.getDataEntrada()), dtf.formatarData(hosp.getDataSaida())});
		}

		table.setModel(modelo);
	}
}
		
