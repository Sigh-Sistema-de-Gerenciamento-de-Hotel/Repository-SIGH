package visao;

import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import controle.funcionario.FuncionarioDAO;
import controle.hospedagem.HospedagemDAO;
import controle.quarto.QuartoDAO;
import modelo.Funcionario;
import modelo.Hospedagem;
import modelo.Quarto;

import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JScrollPane;
import javax.swing.JTable;

public class TelaListagemQuarto extends JFrame implements TelaListagemInterface{

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private Quarto quartoSelecionado;
	private QuartoDAO dao = QuartoDAO.getInstacia();
	private static Funcionario funcionarioLogado;
	
	ArrayList<Quarto> lista = dao.listarQuarto();

	/**
	 * Create the frame.
	 */
	public TelaListagemQuarto(Funcionario funcLogado) {
		funcionarioLogado = funcLogado;
		setIconImage(Toolkit.getDefaultToolkit().getImage("src/main/resources/logo sigh.png"));
		setTitle("Listagem de Quarto");
		TelaListagemQuarto janela = this;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100,  1920, 1080);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCadastrar = new JLabel("");
		lblCadastrar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				CadastroQuarto cadQua = new CadastroQuarto(funcionarioLogado);
				cadQua.setExtendedState(JFrame.MAXIMIZED_BOTH);
				cadQua.setVisible(true);	
				dispose();
			}
		});
		
		
		lblCadastrar.setIcon(new ImageIcon("src/main/resources/botao cadastrar.png"));
		lblCadastrar.setBounds(1293, 252, 120, 34);
		contentPane.add(lblCadastrar);
		
		JLabel lblLogoSigh = new JLabel("");
		lblLogoSigh.setIcon(new ImageIcon("src/main/resources/logo sigh.png"));
		lblLogoSigh.setBounds(135, 46, 144, 176);
		contentPane.add(lblLogoSigh);
		
		JLabel lblCaminhoListagemQuarto = new JLabel("");
		lblCaminhoListagemQuarto.setIcon(new ImageIcon("src/main/resources/CaminhoListagemQuarto.png"));
		lblCaminhoListagemQuarto.setBounds(420, 0, 1500, 62);
		contentPane.add(lblCaminhoListagemQuarto);
		
		JLabel lblTitulo = new JLabel("");
		lblTitulo.setIcon(new ImageIcon("src/main/resources/TituloListagemQuarto.png"));
		lblTitulo.setBounds(446, 108, 1455, 126);
		contentPane.add(lblTitulo);
		
		JLabel lblQuarto = new JLabel("");
		lblQuarto.setIcon(new ImageIcon("src/main/resources/menu - quartos selecionado.png"));
		lblQuarto.setBounds(51,346, 335, 50);
		contentPane.add(lblQuarto);
		
		JLabel lblHospedes = new JLabel("");
		lblHospedes.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				TelaListagemHospede tlh = new TelaListagemHospede(funcionarioLogado);
				dispose();
				tlh.setExtendedState(MAXIMIZED_BOTH);
				tlh.setVisible(true);
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				lblHospedes.setIcon(new ImageIcon("src/main/resources/menu - hospedes selecionado.png"));
				lblHospedes.setBounds(51, 410, 335, 50);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblHospedes.setIcon(new ImageIcon("src/main/resources/menu - hospede.png"));
				lblHospedes.setBounds(68, 410, 335, 50);
			}
		});
		lblHospedes.setIcon(new ImageIcon("src/main/resources/menu - hospede.png"));
		lblHospedes.setBounds(68, 410, 335, 50);
		contentPane.add(lblHospedes);
		
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
				lblHospedagem.setBounds(51, 472, 335, 50);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblHospedagem.setIcon(new ImageIcon("src/main/resources/menu hospedagem.png"));
				lblHospedagem.setBounds(68, 472, 335, 50);
			}
		});
		lblHospedagem.setIcon(new ImageIcon("src/main/resources/menu hospedagem.png"));
		lblHospedagem.setBounds(68, 472, 335, 50);
		contentPane.add(lblHospedagem);
		
		JLabel lblFuncionarios = new JLabel("");
		lblFuncionarios.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				TelaListagemFuncionario tlf = new TelaListagemFuncionario(funcionarioLogado);
				dispose();
				tlf.setExtendedState(MAXIMIZED_BOTH);
				tlf.setVisible(true);
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				lblFuncionarios.setIcon(new ImageIcon("src/main/resources/menu - funcionarios selecionado.png"));
				lblFuncionarios.setBounds(51, 523, 335, 50);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblFuncionarios.setIcon(new ImageIcon("src/main/resources/menu funcionarios.png"));
				lblFuncionarios.setBounds(68, 523, 335, 50);
			}
		});
		lblFuncionarios.setIcon(new ImageIcon("src/main/resources/menu funcionarios.png"));
		lblFuncionarios.setBounds(68, 523, 335, 50);
		contentPane.add(lblFuncionarios);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBorder(null);
		scrollPane.setBackground(new Color(255, 255, 255));
		scrollPane.setAlignmentX(Component.RIGHT_ALIGNMENT);
		scrollPane.setBounds(444, 369, 1391, 569);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int linhaSelecionada = table.getSelectedRow();
				dao = QuartoDAO.getInstacia();
				lista = dao.listarQuarto();
				quartoSelecionado = lista.get(linhaSelecionada);
			}
		});
		scrollPane.setViewportView(table);
		table.setModel(
				new DefaultTableModel(new Object[][] {}, new String[] {"Número do Quarto", "Cama Casal", "Cama Solteiro", "Máx. Hóspedes",  "Ar Condicionado", "Frigobar", "Banheira", "Acessibilidade", "Limpeza", "Conserto", "Preço"}));
		atualizarJTableModel();
		JLabel lblBotaoSair = new JLabel("");
		lblBotaoSair.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// Logoff
				dispose();
				funcionarioLogado = null;
				TelaLogin tela = new TelaLogin();
				tela.setVisible(true);
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
		
		lblBotaoSair.setIcon(new ImageIcon("src/main/resources/botao sair.png"));
		lblBotaoSair.setBounds(84, 955, 263, 45);
		contentPane.add(lblBotaoSair);
		
		JLabel lblEditar = new JLabel("");
		lblEditar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				TelaEdicaoQuarto telaEdQua = new TelaEdicaoQuarto(funcionarioLogado, quartoSelecionado);
				telaEdQua.setExtendedState(JFrame.MAXIMIZED_BOTH);
				telaEdQua.setVisible(true);
				dispose();
			}
		});  
		lblEditar.setIcon(new ImageIcon("src/main/resources/botaoEditar.png"));
		lblEditar.setBounds(1478, 252, 120, 34);
		contentPane.add(lblEditar);
		
		JLabel lblExcluir = new JLabel("");
		TelaListagemInterface estaTela = this;
		lblExcluir.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				TelaConfirmacaoExclusao telaExclusao = new TelaConfirmacaoExclusao("Você deseja excluir o quarto?", quartoSelecionado, estaTela);
				telaExclusao.setLocationRelativeTo(null);
				telaExclusao.setVisible(true);
			}
		}); 
		lblExcluir.setIcon(new ImageIcon("src/main/resources/botaoExcluir.png"));
		lblExcluir.setBounds(1675, 252, 120, 34);
		contentPane.add(lblExcluir);
		
		JLabel lblFundoCinza = new JLabel("");
		lblFundoCinza.setIcon(new ImageIcon("src/main/resources/fundo cinza (menu).png"));
		lblFundoCinza.setBounds(0, 0, 420, 1080);
		contentPane.add(lblFundoCinza);

	}

	public void atualizarJTableModel() {
		DefaultTableModel modelo = new DefaultTableModel(new Object[][] {}, 
				new String[] {"Número do Quarto", "Cama Casal", "Cama Solteiro", "Máx. Hóspedes",  "Ar Condicionado", "Frigobar", "Banheira", "Acessibilidade", "Limpeza", "Conserto", "Preço"});
		
		dao = QuartoDAO.getInstacia();
		lista = dao.listarQuarto();
		
		for (int i = 0; i < lista.size(); i++) {
			Quarto qua = lista.get(i);
			modelo.addRow(new Object[] {qua.getNumero(), qua.getNumCamaCasal(), qua.getNumCamaSolteiro(), qua.getNumMaxHospedes(), qua.isArCondicionado(), qua.isFrigobar(), qua.isBanheira(), qua.isAcessibilidade(), qua.isPrecisaLimpeza(), qua.isPrecisaConserto(), qua.getPreco()});
		}
		table.setModel(modelo);
	}
	

}
