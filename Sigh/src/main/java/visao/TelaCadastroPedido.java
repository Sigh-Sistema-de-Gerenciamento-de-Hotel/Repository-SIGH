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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Font;
import javax.swing.event.AncestorListener;
import javax.swing.event.AncestorEvent;

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
	private JTextField txtPreco;
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
		setBounds(100, 100, 1404, 788);
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
				lblSair.setIcon(new ImageIcon("src/main/resources/botao sair cinza escuro.png"));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblSair.setIcon(new ImageIcon("src/main/resources/botao sair.png"));
			}
		});
		
		JLabel lblCadastrarPedidoGrande = new JLabel("CADASTRAR PEDIDO");
		lblCadastrarPedidoGrande.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblCadastrarPedidoGrande.setBounds(401, 79, 224, 26);
		contentPane.add(lblCadastrarPedidoGrande);
		
		JLabel lblCadastrarPedido = new JLabel("Cadastrar Pedido");
		lblCadastrarPedido.setBounds(431, 11, 126, 14);
		contentPane.add(lblCadastrarPedido);
		
		JLabel lblPedidosNaBarra = new JLabel("Pedidos >");
		lblPedidosNaBarra.setBounds(370, 11, 60, 14);
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
		lblFuncionarios.setBounds(10, 465, 339, 49);
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
		lblHospedagem.setBounds(10, 405, 339, 49);
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
		lblHospedes.setBounds(10, 345, 339, 49);
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
		lblPedidos.setBounds(10, 284, 339, 50);
		contentPane.add(lblPedidos);
		
		JLabel lblNomeUsuario = new JLabel("JULIA ALMEIDA");
		lblNomeUsuario.setBounds(51, 585, 92, 14);
		contentPane.add(lblNomeUsuario);
		
		JLabel lblConta = new JLabel("Conta");
		lblConta.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblConta.setBounds(32, 560, 46, 14);
		contentPane.add(lblConta);
		
		JLabel lblMenu = new JLabel("Menu");
		lblMenu.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblMenu.setBounds(33, 259, 46, 14);
		contentPane.add(lblMenu);
		lblSair.setIcon(new ImageIcon("src/main/resources/botao sair.png"));
		lblSair.setBounds(43, 629, 268, 55);
		contentPane.add(lblSair);
		
		JLabel lblLogoSIGH = new JLabel("");
		lblLogoSIGH.setIcon(new ImageIcon("src/main/resources/logo sigh.png"));
		lblLogoSIGH.setBounds(108, 11, 149, 237);
		contentPane.add(lblLogoSIGH);
		
		JLabel lblTelaCinza = new JLabel("");
		lblTelaCinza.setIcon(new ImageIcon("src/main/resources/fundo cinza (menu).png"));
		lblTelaCinza.setBounds(0, 0, 355, 749);
		contentPane.add(lblTelaCinza);
		
		JLabel lblTelaBrancaMenor = new JLabel("");
		lblTelaBrancaMenor.setIcon(new ImageIcon("src/main/resources/Hero block.png"));
		lblTelaBrancaMenor.setBounds(351, 0, 1019, 36);
		contentPane.add(lblTelaBrancaMenor);
		
		JLabel lblTelaBrancaMaior = new JLabel("");
		lblTelaBrancaMaior.setIcon(new ImageIcon("src/main/resources/Hero block.png"));
		lblTelaBrancaMaior.setBounds(351, 61, 1019, 69);
		contentPane.add(lblTelaBrancaMaior);
		
		
		txtNome = new RoundJFormattedTextField(null);
		txtNome.setBounds(418, 222, 183, 26);
		contentPane.add(txtNome);
		txtNome.setColumns(10);
		
		lblNome = new JLabel("Nome*");
		lblNome.setBounds(418, 206, 139, 14);
		contentPane.add(lblNome);
		
		lblDepartamento = new JLabel("Departamento*");
		lblDepartamento.setBounds(1013, 286, 92, 14);
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
				lblBotaoSalvar.setIcon(new ImageIcon("src/main/resources/botao salvar verde claro.png"));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblBotaoSalvar.setIcon(new ImageIcon("src/main/resources/botao salvar.png"));
			}
		});
		lblBotaoSalvar.setIcon(new ImageIcon("src/main/resources/botao salvar.png"));
		lblBotaoSalvar.setBounds(787, 611, 292, 77);
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
		lblBotaoCancelar.setBounds(1133, 627, 139, 44);
		contentPane.add(lblBotaoCancelar);
		
		txtDescricao = new RoundJFormattedTextField(null);
		txtDescricao.setHorizontalAlignment(SwingConstants.LEFT);
		txtDescricao.setBounds(418, 455, 486, 85);
		contentPane.add(txtDescricao);
		txtDescricao.setColumns(10);
		
		txtNumReserva = new RoundJFormattedTextField(null);
		txtNumReserva.setBounds(418, 300, 183, 26);
		contentPane.add(txtNumReserva);
		txtNumReserva.setColumns(10);
		
		lblQuarto = new JLabel("Quarto*");
		lblQuarto.setBounds(1013, 206, 46, 14);
		contentPane.add(lblQuarto);
		
		lblNumReserva = new JLabel("Número da Reserva*");
		lblNumReserva.setBounds(418, 286, 120, 14);
		contentPane.add(lblNumReserva);
		
		lblDescricao = new JLabel("Descrição*");
		lblDescricao.setBounds(418, 441, 92, 14);
		contentPane.add(lblDescricao);
		
		txtPreco = new RoundJFormattedTextField(null);
		txtPreco.setBounds(418, 383, 183, 26);
		contentPane.add(txtPreco);
		txtPreco.setColumns(10);
		
		lblHospedag = new JLabel("Hospedagem*");
		lblHospedag.setBounds(418, 369, 92, 14);
		contentPane.add(lblHospedag);
		
		comboBox2Departamento = new JComboBox();
		comboBox2Departamento.setBounds(1013, 300, 177, 26);
		contentPane.add(comboBox2Departamento);
		
		comboBox1Quarto = new JComboBox();
		comboBox1Quarto.setBounds(1013, 222, 177, 26);
		contentPane.add(comboBox1Quarto);
		
		txtData = new RoundJFormattedTextField(null);
		txtData.setBounds(715, 222, 183, 26);
		contentPane.add(txtData);
		txtData.setColumns(10);
		
		txtHora = new RoundJFormattedTextField(null);
		txtHora.setBounds(715, 300, 183, 26);
		contentPane.add(txtHora);
		txtHora.setColumns(10);
		
		txtFeito = new RoundJFormattedTextField(null);
		txtFeito.setBounds(715, 383, 183, 26);
		contentPane.add(txtFeito);
		txtFeito.setColumns(10);
		
		JLabel lblData = new JLabel("Data*");
		lblData.setBounds(715, 206, 46, 14);
		contentPane.add(lblData);
		
		JLabel lblHora = new JLabel("Hora*");
		lblHora.setBounds(715, 286, 46, 14);
		contentPane.add(lblHora);
		
		JLabel lblFeito = new JLabel("Feito*");
		lblFeito.setBounds(715, 369, 46, 14);
		contentPane.add(lblFeito);
	}
}
