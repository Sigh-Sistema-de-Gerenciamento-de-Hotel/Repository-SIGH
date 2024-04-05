package visao;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import visao.padrao.RoundJFormattedTextField;

import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Font;
import javax.swing.event.AncestorListener;
import javax.swing.event.AncestorEvent;
import java.awt.Color;

public class TelaCadastroPedido extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtNome;
	private JLabel lblNome;
	private JLabel lblDepartamento;
	private JLabel lblBotaoSalvar;
	private JLabel lblBotaoCancelar;
	private JTextField txtDescricao;
	private JTextField txtNumReserva;
	private JLabel lblQuarto;
	private JLabel lblNumReserva;
	private JLabel lblDescricao;
	private JTextField txtHospedagem;
	private JLabel lblHospedag;
	private JComboBox comboBox2Departamento;
	private JComboBox comboBox1Quarto;
	private JTextField txtData;
	private JTextField txtHora;
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
		setTitle("Cadastrar Pedido");
		setIconImage(Toolkit.getDefaultToolkit().getImage("src/main/resources/logo sigh.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1386, 860);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblSair = new JLabel("");
		lblSair.addMouseListener(new MouseAdapter() {
			@Override 
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
				setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				lblSair.setIcon(new ImageIcon("src/main/resources/botao sair cinza claro.png"));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblSair.setIcon(new ImageIcon("src/main/resources/botao sair.png"));
			}
		});
		
		JLabel lblCadastrarPedidoGrande = new JLabel("CADASTRAR PEDIDO");
		lblCadastrarPedidoGrande.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblCadastrarPedidoGrande.setBounds(473, 158, 224, 26);
		contentPane.add(lblCadastrarPedidoGrande);
		
		JLabel lblCadastrarPedido = new JLabel("Cadastrar Pedido");
		lblCadastrarPedido.setBounds(512, 21, 126, 14);
		contentPane.add(lblCadastrarPedido);
		
		JLabel lblPedidosNaBarra = new JLabel("Pedidos >");
		lblPedidosNaBarra.setBounds(442, 21, 60, 14);
		contentPane.add(lblPedidosNaBarra);
		
		JLabel lblFuncionarios = new JLabel("");
		lblFuncionarios.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				lblFuncionarios.setIcon(new ImageIcon("src/main/resources/menu - funcionarios selecionado.png"));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblFuncionarios.setIcon(new ImageIcon("src/main/resources/menu funcionarios.png"));
			}
		});
		lblFuncionarios.setIcon(new ImageIcon("src/main/resources/menu funcionarios.png"));
		lblFuncionarios.setBounds(68, 523, 335, 50);
		contentPane.add(lblFuncionarios);
		
		JLabel lblHospedagem = new JLabel("");
		lblHospedagem.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
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
		lblHospedagem.setBounds(68, 472, 335, 50);
		contentPane.add(lblHospedagem);
		
		JLabel lblHospedes = new JLabel("");
		lblHospedes.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				lblHospedes.setIcon(new ImageIcon("src/main/resources/menu - hospedes selecionado.png"));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblHospedes.setIcon(new ImageIcon("src/main/resources/menu - hospede.png"));
			}
		});
		lblHospedes.setIcon(new ImageIcon("src/main/resources/menu - hospede.png"));
		lblHospedes.setBounds(68, 410, 335, 50);
		contentPane.add(lblHospedes);
		
		JLabel lblPedidos = new JLabel("");
		lblPedidos.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				lblPedidos.setIcon(new ImageIcon("src/main/resources/menu - pedidos selecionado.png"));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblPedidos.setIcon(new ImageIcon("src/main/resources/menu pedidos.png"));
			}
		});
		lblPedidos.setIcon(new ImageIcon("src/main/resources/menu pedidos.png"));
		lblPedidos.setBounds(68, 348, 335, 50);
		contentPane.add(lblPedidos);
		
		JLabel lblNomeUsuario = new JLabel("JULIA ALMEIDA");
		lblNomeUsuario.setBounds(129, 798, 100, 14);
		contentPane.add(lblNomeUsuario);
		
		JLabel lblConta = new JLabel("Conta");
		lblConta.setForeground(new Color(128, 128, 128));
		lblConta.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblConta.setBounds(79, 760, 46, 14);
		contentPane.add(lblConta);
		
		JLabel lblMenu = new JLabel("Menu");
		lblMenu.setForeground(new Color(128, 128, 128));
		lblMenu.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblMenu.setBounds(67, 289, 46, 14);
		contentPane.add(lblMenu);
		lblSair.setIcon(new ImageIcon("src/main/resources/botao sair.png"));
		lblSair.setBounds(84, 958, 270, 40);
		contentPane.add(lblSair);
		
		JLabel lblLogoSIGH = new JLabel("");
		lblLogoSIGH.setIcon(new ImageIcon("src/main/resources/logo sigh.png"));
		lblLogoSIGH.setBounds(131, 35, 150, 200);
		contentPane.add(lblLogoSIGH);
		
		JLabel lblTelaCinza = new JLabel("");
		lblTelaCinza.setIcon(new ImageIcon("src/main/resources/fundo cinza (menu).png"));
		lblTelaCinza.setBounds(0, 0, 420, 1080);
		contentPane.add(lblTelaCinza);
		
		JLabel lblTelaBrancaMenor = new JLabel("");
		lblTelaBrancaMenor.setIcon(new ImageIcon("src/main/resources/Hero block.png"));
		lblTelaBrancaMenor.setBounds(421, 0, 1498, 60);
		contentPane.add(lblTelaBrancaMenor);
		
		JLabel lblTelaBrancaMaior = new JLabel("");
		lblTelaBrancaMaior.setIcon(new ImageIcon("src/main/resources/Hero block.png"));
		lblTelaBrancaMaior.setBounds(442, 108, 1455, 129);
		contentPane.add(lblTelaBrancaMaior);
		
		
		txtNome = new RoundJFormattedTextField(null);
		txtNome.setBounds(554, 326, 343, 48);
		contentPane.add(txtNome);
		txtNome.setColumns(10);
		
		lblNome = new JLabel("Nome*");
		lblNome.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNome.setBounds(554, 306, 139, 14);
		contentPane.add(lblNome);
		
		lblDepartamento = new JLabel("Departamento*");
		lblDepartamento.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDepartamento.setBounds(1450, 300, 201, 26);
		contentPane.add(lblDepartamento);
		
		
		lblBotaoSalvar = new JLabel("");
		lblBotaoSalvar.addAncestorListener(new AncestorListener() {
			public void ancestorAdded(AncestorEvent event) {
				
//				String sobrenome = textSobrenome.getText();
				
				//if(sobrenome.isEmpty()) {
				//	JanelaErro janelo = new JanelaErro();
				//	janela.setVisible(true);
				//	else {
				//		Cliente c = new Cliente();
				//		c.setSobrenome(sobrenome);
						
						
						
				//		ClienteDAO dao = ClienteDAO.setInstancia();
				//		
				//		int id = dao.inserirCliente(c);
				//		boolean validou = dao.inserirCliente(); //VERDADEIRO OU FALSO
				//		
				//		if(validou == true) {
				//			//MENSAGEM DE SUCESSO
				//		}
				//		else {
				//			//mensagem de ERRO
				//		}
				//	}
				//}
				
			}
			public void ancestorMoved(AncestorEvent event) {
			}
			public void ancestorRemoved(AncestorEvent event) {
			}
		});
		lblBotaoSalvar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				lblBotaoSalvar.setIcon(new ImageIcon("src/main/resources/botao salvar  claro.png"));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblBotaoSalvar.setIcon(new ImageIcon("src/main/resources/botao salvar.png"));
			}
		});
		lblBotaoSalvar.setIcon(new ImageIcon("src/main/resources/botao salvar.png"));
		lblBotaoSalvar.setBounds(1245, 902, 343, 50);
		contentPane.add(lblBotaoSalvar);
		
		lblBotaoCancelar = new JLabel("");
		lblBotaoCancelar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				lblBotaoCancelar.setIcon(new ImageIcon("src/main/resources/botao cancelar azul escuro.png"));
			}	
			@Override
			public void mouseExited(MouseEvent e) {
				lblBotaoCancelar.setIcon(new ImageIcon("src/main/resources/botao cancelar.png"));
			}
		});
		lblBotaoCancelar.setIcon(new ImageIcon("src/main/resources/botao cancelar.png"));
		lblBotaoCancelar.setBounds(1595, 902, 300, 50);
		contentPane.add(lblBotaoCancelar);
		
		txtDescricao = new RoundJFormattedTextField(null);
		txtDescricao.setHorizontalAlignment(SwingConstants.LEFT);
		txtDescricao.setBounds(554, 641, 343, 85);
		contentPane.add(txtDescricao);
		txtDescricao.setColumns(10);
		
		txtNumReserva = new RoundJFormattedTextField(null);
		txtNumReserva.setBounds(554, 425, 343, 48);
		contentPane.add(txtNumReserva);
		txtNumReserva.setColumns(10);
		
		lblQuarto = new JLabel("Quarto*");
		lblQuarto.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblQuarto.setBounds(1450, 399, 150, 26);
		contentPane.add(lblQuarto);
		
		lblNumReserva = new JLabel("Número da Reserva*");
		lblNumReserva.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNumReserva.setBounds(554, 405, 231, 14);
		contentPane.add(lblNumReserva);
		
		lblDescricao = new JLabel("Descrição*");
		lblDescricao.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDescricao.setBounds(554, 606, 112, 26);
		contentPane.add(lblDescricao);
		
		txtHospedagem = new RoundJFormattedTextField(null);
		txtHospedagem.setBounds(554, 524, 343, 48);
		contentPane.add(txtHospedagem);
		txtHospedagem.setColumns(10);
		
		lblHospedag = new JLabel("Hospedagem*");
		lblHospedag.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblHospedag.setBounds(554, 494, 143, 26);
		contentPane.add(lblHospedag);
		
		comboBox2Departamento = new JComboBox();
		comboBox2Departamento.setModel(new DefaultComboBoxModel(new String[] {" Camareira", " ", " Manutenção", " ", " Cozinha", " ", " Recepção", 
				" ", " Limpeza"}));
		comboBox2Departamento.setBounds(1450, 326, 343, 48);
		contentPane.add(comboBox2Departamento);
		
		comboBox1Quarto = new JComboBox();
		comboBox1Quarto.setModel(new DefaultComboBoxModel(new String[] {" 1", " ", "2", " ", "3", " ", "4", 
				" ", "5", " ", "6", " ", "7", " ", "8", " ", "9", " ", 
				"10", " ", "11", " ", "12", " ", "13", " ", "14 ", " ", "15 ", " ", "16 ",
				" ", "17", " ", "18", " ", "19 ", " ", "20 ", " ", "21",
				" ", "22", " ", "23", " ", "24", " ", "25", " ",
				"26", " ", "27", " ", "28", " ", "29", " ",
				"30", " ", "31", " ", "32", " ", "33", " ", "34",
				" ", "35", " ", "36", " ", "37", " ", "38", " ", "39", 
				" ", "40", " ", "41", " ", "42", " ", "43", " ", "44", " ",
				"45", " ", "46", " ", "47", " ", "48", " ", "49", " ", "50", 
				" ", "51", " ", "52", " ", "53", " ", "54", " ", "55", " ", "56",
				" ", "57", " ", "58", " ", "59", " ", "60", "  ", "61", " ", "62", 
				" ", "63", " ", "64", " ", "65", " ", "66", " ", "67", " ", "68", " ",
				"69", " ", "70", " ", "71", " ", "72", " ", "73", " ", "74", " ", "75", " ", "76", " ", "77", " ", "78", " ", "79", " ", "80", " ", "81", " ", "82", "", "83", " ", "83",
				" ", "84", " ", "85", " ", "86", " ", "87", " ", "88", " ", "89", " ", "90", 
				" ", "91", " ", "92", "", "93", " ", "94", " ",
				"95", " ", "96", " ", "97", " ", "98", " ", "99", " ", "100"}));
		comboBox1Quarto.setBounds(1450, 425, 343, 48);
		contentPane.add(comboBox1Quarto);
		
		txtData = new RoundJFormattedTextField(null);
		txtData.setBounds(1001, 523, 343, 48);
		contentPane.add(txtData);
		txtData.setColumns(10);
		
		txtHora = new RoundJFormattedTextField(null);
		txtHora.setBounds(1001, 326, 343, 48);
		contentPane.add(txtHora);
		txtHora.setColumns(10);
		
		txtFeito = new RoundJFormattedTextField(null);
		txtFeito.setBounds(1001, 425, 343, 48);
		contentPane.add(txtFeito);
		txtFeito.setColumns(10);
		
		JLabel lblData = new JLabel("Data*");
		lblData.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblData.setBounds(1001, 500, 46, 14);
		contentPane.add(lblData);
		
		JLabel lblHora = new JLabel("Hora*");
		lblHora.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblHora.setBounds(1001, 306, 46, 14);
		contentPane.add(lblHora);
		
		JLabel lblFeito = new JLabel("Feito*");
		lblFeito.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblFeito.setBounds(1001, 405, 46, 14);
		contentPane.add(lblFeito);
	}
}
