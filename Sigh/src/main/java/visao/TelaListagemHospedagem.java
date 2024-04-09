package visao;

import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import controle.hospedagem.HospedagemDAO;
import modelo.Hospedagem;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import javax.swing.border.LineBorder;



public class TelaListagemHospedagem extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private HospedagemDAO dao;	
	private ArrayList<Hospedagem> lista;
	private JLabel caminho;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaListagemHospedagem frame = new TelaListagemHospedagem();
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
	public TelaListagemHospedagem() {
		
		setIconImage(Toolkit.getDefaultToolkit().getImage("src/main/resources/logo sigh.png"));
		setTitle("Listagem Hospedagem");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 777, 648);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel botaoCadastrar = new JLabel("Cadastrar");
		botaoCadastrar.setIcon(new ImageIcon("src/main/resources/botao cadastrar.png"));
		botaoCadastrar.setBounds(1720, 144, 120, 34);
		contentPane.add(botaoCadastrar);
		
		// Listagem
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBorder(new LineBorder(new Color(237, 237, 237), 2, true));
		scrollPane.setBackground(new Color(255, 255, 255));
		scrollPane.setAlignmentX(Component.RIGHT_ALIGNMENT);
		scrollPane.setBounds(444, 308, 1455, 600);
		contentPane.add(scrollPane);
		
		
		table = new JTable();
		table.setFont(new Font("Tahoma", Font.PLAIN, 14));
		table.setBackground(new Color(255, 255, 255));
		table.setGridColor(new Color(229, 233, 235));
		table.setRowHeight(40);
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(new Object[][] {}, new String[] {"Código", "Código quarto", "Nº de Hóspedes",  "Entrada", "Saída"}));
		// atualiza JTable
		atualizarJTable();
		
		// Menu
		
		JLabel botaoSair = new JLabel("Sair");
		botaoSair.setIcon(new ImageIcon("src/main/resources/botao sair.png"));
		botaoSair.setBounds(69, 955, 263, 45);
		contentPane.add(botaoSair);
		
		JLabel divisaoMenu = new JLabel("Divisão Menu");
		divisaoMenu.setIcon(new ImageIcon("src/main/resources/divisor (menu).png"));
		divisaoMenu.setBounds(77, 897, 243, 14);
		contentPane.add(divisaoMenu);
		
		JLabel usuario = new JLabel("Júlia Almeida");
		usuario.setFont(new Font("Tahoma", Font.PLAIN, 14));
		usuario.setBounds(129, 798, 80, 30);
		contentPane.add(usuario);
		
		JLabel conta = new JLabel("Conta");
		conta.setForeground(Color.GRAY);
		conta.setFont(new Font("Tahoma", Font.PLAIN, 14));
		conta.setBounds(79, 760, 46, 14);
		contentPane.add(conta);
		
		JLabel funcionarios = new JLabel("Funciários");
		funcionarios.setIcon(new ImageIcon("src/main/resources/menu funcionarios.png"));
		funcionarios.setBounds(68, 523, 295, 38);
		contentPane.add(funcionarios);
		
		JLabel hospedagem = new JLabel("Hospedagem");
		hospedagem.setIcon(new ImageIcon("src/main/resources/menu hospedagem.png"));
		hospedagem.setBounds(68, 472, 150, 20);
		contentPane.add(hospedagem);
		
		JLabel pedidos = new JLabel("Pedidos");
		pedidos.setIcon(new ImageIcon("src/main/resources/menu pedidos.png"));
		pedidos.setBounds(68, 346, 150, 20);
		contentPane.add(pedidos);
		
		JLabel hospedes = new JLabel("Hóspedes");
		hospedes.setIcon(new ImageIcon("src/main/resources/menu - hospede.png"));
		hospedes.setBounds(68, 407, 150, 20);
		contentPane.add(hospedes);
		
		JLabel logo = new JLabel("Logo");
		logo.setIcon(new ImageIcon("src/main/resources/logo sigh.png"));
		logo.setBounds(135, 46, 144, 176);
		contentPane.add(logo);
		
		JLabel menu = new JLabel("Menu");
		menu.setIcon(new ImageIcon("src/main/resources/fundo cinza (menu).png"));
		menu.setBounds(0, 0, 420, 1080);
		contentPane.add(menu);	
		
		caminho = new JLabel("Caminho");
		caminho.setIcon(new ImageIcon("src/main/resources/CaminhoListagemHospedagem.png"));
		caminho.setBounds(420, 0, 1500, 60);
		contentPane.add(caminho);
		
		JLabel titulo = new JLabel("Titulo");
		titulo.setIcon(new ImageIcon("src/main/resources/TituloListagemHospedagem.png"));
		titulo.setBounds(439, 101, 1444, 119);
		contentPane.add(titulo);
	}
	
	protected void atualizarJTable() {
		DefaultTableModel modelo = new DefaultTableModel(new Object[][] {}, new String[] {"Código", "Código quarto", "Nº de Hóspedes",  "Entrada", "Saída"});

		dao = HospedagemDAO.getInstancia();
		lista = dao.listarHospedagem();

		for (int i = 0; i < lista.size(); i++) {
			Hospedagem hosp = lista.get(i);
			modelo.addRow(new Object[] { hosp.getId(), hosp.getQuarto().getNumero(), hosp.getHospedes().size(), hosp.getDataEntrada(), hosp.getDataSaida()});
		}

		table.setModel(modelo);
	}
}
