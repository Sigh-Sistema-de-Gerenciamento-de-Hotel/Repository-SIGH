package visao;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import visao.padrao.RoundJFormattedTextField;

import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class TelaCadastroPedido extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblDepartamento;
	private JLabel lblBotaoSalvar;
	private JLabel lblBotaoCancelar;
	private JTextField txtDescricao;
	private JLabel lblQuarto;
	private JLabel lblDescricao;
	private JComboBox comboBox2Departamento;
	private JComboBox comboBox1Quarto;
	private JLabel lblCadastroPedido;
	private JLabel lblPedidosPequeno;
	private JLabel lblHospedes;
	private JLabel lblTextHospedagem;
	private JLabel lblTextFuncionarios;
	private JLabel lblBotaoSair;
	private JLabel lblConta;
	private JLabel lblEmail;
	private JLabel lblNomeConta;
	private JLabel lblNome;
	private JTextField txtNome;
	private JTextField txtNumeroReserva;
	private JTextField txtData;
	private JTextField txtHorario;
	private JTextField txtHospedagem;
	private JTextField txtFeito;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCadastroPedido frame = new TelaCadastroPedido();
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
	public TelaCadastroPedido() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("src/main/resources/logo sigh.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1404, 788);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblEmail = new JLabel("Julia.Almeida@sigh.com");
		lblEmail.setBounds(39, 598, 181, 28);
		contentPane.add(lblEmail);
		
		lblNomeConta = new JLabel("JULIA ALMEIDA");
		lblNomeConta.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNomeConta.setBounds(39, 585, 90, 14);
		contentPane.add(lblNomeConta);
		
		lblConta = new JLabel("Conta");
		lblConta.setBounds(29, 552, 46, 14);
		contentPane.add(lblConta);
		
		lblTextFuncionarios = new JLabel("Funcionários");
		lblTextFuncionarios.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblTextFuncionarios.setBounds(72, 501, 78, 14);
		contentPane.add(lblTextFuncionarios);
		
		lblTextHospedagem = new JLabel("Hospedagem");
		lblTextHospedagem.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblTextHospedagem.setBounds(72, 435, 78, 14);
		contentPane.add(lblTextHospedagem);
		
		lblHospedes = new JLabel("Hóspedes");
		lblHospedes.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblHospedes.setBounds(72, 375, 70, 14);
		contentPane.add(lblHospedes);
		
		JLabel lblTextPedidos = new JLabel("Pedidos");
		lblTextPedidos.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblTextPedidos.setBounds(72, 317, 46, 14);
		contentPane.add(lblTextPedidos);
		
		lblBotaoSair = new JLabel("");
		lblBotaoSair.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
			}
			@Override
			public void mouseEntered(MouseEvent e) {
			}
			@Override
			public void mouseExited(MouseEvent e) {
			}
		});
		lblBotaoSair.setIcon(new ImageIcon("src/main/resources/botao sair.png"));
		lblBotaoSair.setBounds(10, 645, 277, 69);
		contentPane.add(lblBotaoSair);
		
		JLabel lblIconeFunionarios = new JLabel("");
		lblIconeFunionarios.setIcon(new ImageIcon("src/main/resources/icone funcionarios (menu).png"));
		lblIconeFunionarios.setBounds(39, 489, 24, 26);
		contentPane.add(lblIconeFunionarios);
		
		JLabel lblIconeHospedagem = new JLabel("");
		lblIconeHospedagem.setIcon(new ImageIcon("src/main/resources/icone Hospedagem (menu).png"));
		lblIconeHospedagem.setBounds(41, 424, 24, 36);
		contentPane.add(lblIconeHospedagem);
		
		JLabel lblIocneHospedes = new JLabel("");
		lblIocneHospedes.setIcon(new ImageIcon("src/main/resources/icone hospedes (menu).png"));
		lblIocneHospedes.setBounds(39, 363, 24, 26);
		contentPane.add(lblIocneHospedes);
		
		JLabel lblIconePedidos = new JLabel("");
		lblIconePedidos.setIcon(new ImageIcon("src/main/resources/icone pedidos (menu).png"));
		lblIconePedidos.setBounds(41, 311, 34, 20);
		contentPane.add(lblIconePedidos);
		
		JLabel lblMenu = new JLabel("Menu");
		lblMenu.setBounds(29, 274, 46, 14);
		contentPane.add(lblMenu);
		
		JLabel lblGrandeCadastrar = new JLabel("CADASTRAR PEDIDO");
		lblGrandeCadastrar.setFont(new Font("Tahoma", Font.PLAIN, 28));
		lblGrandeCadastrar.setBounds(313, 73, 365, 44);
		contentPane.add(lblGrandeCadastrar);
		
		lblCadastroPedido = new JLabel("Cadastrar Pedido");
		lblCadastroPedido.setBounds(356, 11, 114, 14);
		contentPane.add(lblCadastroPedido);
		
		lblPedidosPequeno = new JLabel("Pedidos >");
		lblPedidosPequeno.setBounds(297, 11, 58, 14);
		contentPane.add(lblPedidosPequeno);
		
		JLabel lblLogoSIGH = new JLabel("");
		lblLogoSIGH.setIcon(new ImageIcon("src/main/resources/logo sigh.png"));
		lblLogoSIGH.setBounds(61, 11, 149, 237);
		contentPane.add(lblLogoSIGH);
		
		JLabel lblTelaCinza = new JLabel("");
		lblTelaCinza.setIcon(new ImageIcon("src/main/resources/fundo cinza (menu).png"));
		lblTelaCinza.setBounds(0, 0, 287, 749);
		contentPane.add(lblTelaCinza);
		
		JLabel lblTelaBrancaMenor = new JLabel("");
		lblTelaBrancaMenor.setIcon(new ImageIcon("src/main/resources/Hero block.png"));
		lblTelaBrancaMenor.setBounds(285, 0, 1085, 36);
		contentPane.add(lblTelaBrancaMenor);
		
		JLabel lblTelaBrancaMaior = new JLabel("");
		lblTelaBrancaMaior.setIcon(new ImageIcon("src/main/resources/Hero block.png"));
		lblTelaBrancaMaior.setBounds(285, 61, 1085, 69);
		contentPane.add(lblTelaBrancaMaior);
		
		JLabel label = new JLabel("New label");
		label.setBounds(51, 57, 46, 14);
		contentPane.add(label);
		
		lblDepartamento = new JLabel("Departamento*");
		lblDepartamento.setBounds(1024, 286, 92, 14);
		contentPane.add(lblDepartamento);
		
		lblBotaoSalvar = new JLabel("");
		lblBotaoSalvar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
			@Override
			public void mouseEntered(MouseEvent e) {
			}
			@Override
			public void mouseExited(MouseEvent e) {
			}
		});
		lblBotaoSalvar.setIcon(new ImageIcon("src/main/resources/botao salvar.png"));
		lblBotaoSalvar.setBounds(824, 624, 292, 77);
		contentPane.add(lblBotaoSalvar);
		
		lblBotaoCancelar = new JLabel("");
		lblBotaoCancelar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		lblBotaoCancelar.setIcon(new ImageIcon("src/main/resources/botao cancelar.png"));
		lblBotaoCancelar.setBounds(1170, 645, 139, 44);
		contentPane.add(lblBotaoCancelar);
		
		txtDescricao = new RoundJFormattedTextField(null);
		txtDescricao.setHorizontalAlignment(SwingConstants.LEFT);
		txtDescricao.setBounds(459, 475, 443, 85);
		contentPane.add(txtDescricao);
		txtDescricao.setColumns(10);
		
		lblQuarto = new JLabel("Quarto*");
		lblQuarto.setBounds(1024, 201, 55, 14);
		contentPane.add(lblQuarto);
		
		lblDescricao = new JLabel("Descrição*");
		lblDescricao.setBounds(459, 450, 92, 14);
		contentPane.add(lblDescricao);
		
		comboBox2Departamento = new JComboBox();
		comboBox2Departamento.setBounds(1024, 311, 164, 20);
		contentPane.add(comboBox2Departamento);
		
		comboBox1Quarto = new JComboBox();
		comboBox1Quarto.setBounds(1024, 221, 164, 20);
		contentPane.add(comboBox1Quarto);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(85, 311, 46, 14);
		contentPane.add(lblNewLabel);
		
		lblNome = new JLabel("Nome*");
		lblNome.setBounds(458, 201, 93, 14);
		contentPane.add(lblNome);
		
		txtNome = new RoundJFormattedTextField(null);
		txtNome.setBounds(458, 221, 165, 20);
		contentPane.add(txtNome);
		txtNome.setColumns(10);
		
		JLabel lblHospedagem = new JLabel("Hospedagem*");
		lblHospedagem.setBounds(458, 375, 93, 14);
		contentPane.add(lblHospedagem);
		
		txtNumeroReserva = new RoundJFormattedTextField(null);
		txtNumeroReserva.setBounds(458, 311, 165, 20);
		contentPane.add(txtNumeroReserva);
		txtNumeroReserva.setColumns(10);
		
		JLabel lblData = new JLabel("Data*");
		lblData.setBounds(739, 201, 46, 14);
		contentPane.add(lblData);
		
		txtData = new RoundJFormattedTextField(null);
		txtData.setBounds(738, 221, 164, 20);
		contentPane.add(txtData);
		txtData.setColumns(10);
		
		JLabel lblHorario = new JLabel("Horário*");
		lblHorario.setBounds(739, 286, 78, 14);
		contentPane.add(lblHorario);
		
		txtHorario = new RoundJFormattedTextField(null);
		txtHorario.setBounds(739, 311, 163, 20);
		contentPane.add(txtHorario);
		txtHorario.setColumns(10);
		
		JLabel lblNumeroReserva = new JLabel("Número da Reserva*");
		lblNumeroReserva.setBounds(458, 286, 149, 14);
		contentPane.add(lblNumeroReserva);
		
		txtHospedagem = new RoundJFormattedTextField(null);
		txtHospedagem.setBounds(458, 392, 165, 20);
		contentPane.add(txtHospedagem);
		txtHospedagem.setColumns(10);
		
		JLabel lblFeito = new JLabel("Feito*");
		lblFeito.setBounds(739, 375, 46, 14);
		contentPane.add(lblFeito);
		
		txtFeito = new RoundJFormattedTextField(null);
		txtFeito.setBounds(739, 392, 163, 20);
		contentPane.add(txtFeito);
		txtFeito.setColumns(10);
	}
}
