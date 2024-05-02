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



public class TelaListagemHospedagem extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private HospedagemDAO dao =  HospedagemDAO.getInstancia(); 
	private JLabel caminho;
	private Hospedagem hospedagemSelecionada; 
	private Funcionario funcionarioLogado; 

	private DateTextField dtf = new DateTextField();

	ArrayList<Hospedagem> lista = dao.listarHospedagem();
	
	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
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
	}   */

	/**
	 * Create the frame.
	 */
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
		
		caminho = new JLabel("");
		caminho.setIcon(new ImageIcon("C:\\Users\\Aluno\\Downloads\\Repository-SIGH\\Sigh\\src\\main\\resources\\CaminhoListagemHospedagem.png"));
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
			
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Aluno\\Downloads\\Repository-SIGH\\Sigh\\src\\main\\resources\\botaoEditar.png"));
		lblNewLabel.setBounds(1570, 164, 120, 34);
		contentPane.add(lblNewLabel);
		
		/*BOTÃO EXCLUIR*/
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				HospedagemDAO dao = HospedagemDAO.getInstancia();
				int confirmacao = JOptionPane.showConfirmDialog(null,
						"Excluir a hospedagem " + hospedagemSelecionada.getQuarto() + "?");

				if (confirmacao == JOptionPane.YES_OPTION) {
					Boolean validacao = dao.removerHospedagem(hospedagemSelecionada);
					atualizarJTable();
					if (validacao == true) {
						JOptionPane.showMessageDialog(null,
								"A hospedagem " + hospedagemSelecionada.getQuarto() + " foi excluída");

					}
				}
			}
		});
			
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\Aluno\\Downloads\\Repository-SIGH\\Sigh\\src\\main\\resources\\botaoExcluir.png"));
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
			
		
		lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\Aluno\\Downloads\\Repository-SIGH\\Sigh\\src\\main\\resources\\botao cadastrar.png"));
		lblNewLabel_2.setBounds(1400, 164, 120, 34);
		contentPane.add(lblNewLabel_2);
		
		JLabel titulo = new JLabel("");
		titulo.setIcon(new ImageIcon("C:\\Users\\Aluno\\Downloads\\Repository-SIGH\\Sigh\\src\\main\\resources\\TituloListagemHospedagem.png"));
		titulo.setBounds(439, 101, 1444, 119);
		contentPane.add(titulo);
	}
	
	protected void atualizarJTable() {
		DefaultTableModel modelo = new DefaultTableModel(new Object[][] {}, new String[] {"Código", "Código quarto", "Nº de Hóspedes",  "Entrada", "Saída"});

		dao = HospedagemDAO.getInstancia();
		lista = dao.listarHospedagem();

		for (int i = 0; i < lista.size(); i++) {
			Hospedagem hosp = lista.get(i);
			modelo.addRow(new Object[] { hosp.getId(), hosp.getQuarto().getNumero(), hosp.getHospedes().size(), dtf.formatarData(hosp.getDataEntrada()), dtf.formatarData(hosp.getDataSaida())});
		}

		table.setModel(modelo);
	}
}
