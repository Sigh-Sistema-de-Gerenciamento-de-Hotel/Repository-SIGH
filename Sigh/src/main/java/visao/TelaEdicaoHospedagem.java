package visao;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controle.funcionario.FuncionarioDAO;
import controle.hospedagem.HospedagemDAO;
import modelo.Funcionario;
import modelo.Hospedagem;
import visao.padrao.DateTextField;
import visao.padrao.RoundJFormattedTextField;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class TelaEdicaoHospedagem extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private final JLabel lblMenu = new JLabel("");
	private JTextField txtDataCheckin;
	private JTextField txtDataCheckout;
	private Funcionario funcionarioLogado;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaEdicaoHospedagem frame = new TelaEdicaoHospedagem();
					frame.setVisible(true);
					frame.setExtendedState(JFrame.MAXIMIZED_BOTH); 
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}  */

	/**
	 * Create the frame.
	 */
	public TelaEdicaoHospedagem(Funcionario funcLogado, Hospedagem hospSelecionada) {
		funcionarioLogado = funcLogado;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1179, 912);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblBotaoFuncionarios = new JLabel("");
		lblBotaoFuncionarios.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				TelaListagemFuncionario tlf = new TelaListagemFuncionario(funcionarioLogado);
				tlf.setVisible(true);
				tlf.setExtendedState(JFrame.MAXIMIZED_BOTH);
				dispose();
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
		lblBotaoHospedes.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				TelaListagemHospede tlh = new TelaListagemHospede(funcionarioLogado);
				dispose();
				tlh.setExtendedState(MAXIMIZED_BOTH);
				tlh.setVisible(true);
			}
		});
		lblBotaoHospedes.setIcon(new ImageIcon("src\\main\\resources\\menu - hospede.png"));
		lblBotaoHospedes.setBounds(67, 407, 295, 38);
		contentPane.add(lblBotaoHospedes);

		JLabel lblBotaoHospedagemSelecionado = new JLabel("");
		lblBotaoHospedagemSelecionado.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				TelaListagemHospedagem tlh = new TelaListagemHospedagem(funcionarioLogado);
				tlh.setVisible(true);
				tlh.setExtendedState(JFrame.MAXIMIZED_BOTH);
				dispose();
			}
		});
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
				// Logoff
				dispose();
				funcionarioLogado = null;
				TelaLogin tela = new TelaLogin();
				tela.setVisible(true);
				tela.setExtendedState(JFrame.MAXIMIZED_BOTH);
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

		JLabel lblNumHospedes = new JLabel("Número de Hóspedes *");
		lblNumHospedes.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNumHospedes.setBounds(502, 315, 145, 40);
		contentPane.add(lblNumHospedes);

		JComboBox comboBoxHospedes = new JComboBox();
		comboBoxHospedes.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4"}));
		comboBoxHospedes.setForeground(Color.BLACK);
		comboBoxHospedes.setFont(new Font("Tahoma", Font.PLAIN, 14));
		comboBoxHospedes.setBounds(502, 355, 343, 48);
		contentPane.add(comboBoxHospedes);

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

		JComboBox comboBoxQuartos = new JComboBox();
		comboBoxQuartos.setFont(new Font("Tahoma", Font.PLAIN, 14));
		comboBoxQuartos.setBounds(1010, 355, 343, 48);
		contentPane.add(comboBoxQuartos);

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
				TelaListagemHospedagem tlh = new TelaListagemHospedagem(funcionarioLogado);
				dispose();
				tlh.setExtendedState(MAXIMIZED_BOTH);
				tlh.setVisible(true);
	
			}
		});
		lblBotaoSalvar.setIcon(new ImageIcon("src\\main\\resources\\botao salvar.png"));
		lblBotaoSalvar.setBounds(1245, 902, 343, 50);
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