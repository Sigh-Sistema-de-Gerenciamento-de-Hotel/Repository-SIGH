package visao;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.SwingConstants;

public class TelaCadastroPedido extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtNumReserva;
	private JLabel lblNumReserva;
	private JLabel lblDepartamento;
	private JLabel lblBotaoSalvar;
	private JLabel lblBotaoCancelar;
	private JTextField txtDescricao;
	private JTextField txtQuantidade;
	private JLabel lblQuarto;
	private JLabel lblQuantidade;
	private JLabel lblDescricao;
	private JTextField txtPreco;
	private JLabel lblPreco;
	private JComboBox comboBox2Departaemento;
	private JComboBox comboBox1Quarto;
	private JLabel label_1;
	private JLabel lblNewLabel_11;

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
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Gabrieli\\Documents\\Repository-SIGH\\Sigh\\src\\main\\resources\\logo sigh.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1404, 788);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Gabrieli\\Documents\\Repository-SIGH\\Sigh\\src\\main\\resources\\logo sigh.png"));
		lblNewLabel.setBounds(34, -19, 149, 267);
		contentPane.add(lblNewLabel);
		
		JLabel lblTelaCinza = new JLabel("");
		lblTelaCinza.setIcon(new ImageIcon("C:\\Users\\Gabrieli\\Documents\\Repository-SIGH\\Sigh\\src\\main\\resources\\fundo cinza (menu).png"));
		lblTelaCinza.setBounds(0, 0, 230, 749);
		contentPane.add(lblTelaCinza);
		
		JLabel lblTelaBrancaMenor = new JLabel("");
		lblTelaBrancaMenor.setIcon(new ImageIcon("C:\\Users\\Gabrieli\\Documents\\Repository-SIGH\\Sigh\\src\\main\\resources\\Hero block.png"));
		lblTelaBrancaMenor.setBounds(228, 0, 1142, 36);
		contentPane.add(lblTelaBrancaMenor);
		
		JLabel lblTelaBrancaMaior = new JLabel("");
		lblTelaBrancaMaior.setIcon(new ImageIcon("C:\\Users\\Gabrieli\\Documents\\Repository-SIGH\\Sigh\\src\\main\\resources\\Hero block.png"));
		lblTelaBrancaMaior.setBounds(228, 61, 1142, 69);
		contentPane.add(lblTelaBrancaMaior);
		
		JLabel label = new JLabel("New label");
		label.setBounds(51, 57, 46, 14);
		contentPane.add(label);
		
		txtNumReserva = new JTextField();
		txtNumReserva.setBounds(418, 222, 183, 26);
		contentPane.add(txtNumReserva);
		txtNumReserva.setColumns(10);
		
		lblNumReserva = new JLabel("Número da Reserva*");
		lblNumReserva.setBounds(418, 206, 139, 14);
		contentPane.add(lblNumReserva);
		
		lblDepartamento = new JLabel("Departamento*");
		lblDepartamento.setBounds(418, 311, 92, 14);
		contentPane.add(lblDepartamento);
		
		lblBotaoSalvar = new JLabel("");
		lblBotaoSalvar.setIcon(new ImageIcon("C:\\Users\\Gabrieli\\Documents\\Repository-SIGH\\Sigh\\src\\main\\resources\\botao salvar.png"));
		lblBotaoSalvar.setBounds(787, 611, 292, 77);
		contentPane.add(lblBotaoSalvar);
		
		lblBotaoCancelar = new JLabel("");
		lblBotaoCancelar.setIcon(new ImageIcon("C:\\Users\\Gabrieli\\Documents\\Repository-SIGH\\Sigh\\src\\main\\resources\\botao cancelar.png"));
		lblBotaoCancelar.setBounds(1133, 627, 139, 44);
		contentPane.add(lblBotaoCancelar);
		
		txtDescricao = new JTextField();
		txtDescricao.setHorizontalAlignment(SwingConstants.LEFT);
		txtDescricao.setBounds(418, 420, 492, 85);
		contentPane.add(txtDescricao);
		txtDescricao.setColumns(10);
		
		txtQuantidade = new JTextField();
		txtQuantidade.setBounds(727, 326, 183, 26);
		contentPane.add(txtQuantidade);
		txtQuantidade.setColumns(10);
		
		lblQuarto = new JLabel("Quarto*");
		lblQuarto.setBounds(727, 206, 46, 14);
		contentPane.add(lblQuarto);
		
		lblQuantidade = new JLabel("Quantidade*");
		lblQuantidade.setBounds(727, 311, 92, 14);
		contentPane.add(lblQuantidade);
		
		lblDescricao = new JLabel("Descrição*");
		lblDescricao.setBounds(418, 405, 92, 14);
		contentPane.add(lblDescricao);
		
		txtPreco = new JTextField();
		txtPreco.setBounds(418, 562, 183, 26);
		contentPane.add(txtPreco);
		txtPreco.setColumns(10);
		
		lblPreco = new JLabel("Preço*");
		lblPreco.setBounds(418, 545, 46, 14);
		contentPane.add(lblPreco);
		
		comboBox2Departaemento = new JComboBox();
		comboBox2Departaemento.setBounds(418, 326, 183, 26);
		contentPane.add(comboBox2Departaemento);
		
		comboBox1Quarto = new JComboBox();
		comboBox1Quarto.setBounds(727, 222, 177, 26);
		contentPane.add(comboBox1Quarto);
		
		label_1 = new JLabel("New label");
		label_1.setBounds(256, 11, 46, 14);
		contentPane.add(label_1);
		
		lblNewLabel_11 = new JLabel("Pedidos");
		lblNewLabel_11.setBounds(240, 11, 46, 14);
		contentPane.add(lblNewLabel_11);
	}
}
