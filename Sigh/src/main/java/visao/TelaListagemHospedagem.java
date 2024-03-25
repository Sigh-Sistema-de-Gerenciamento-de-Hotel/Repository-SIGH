package visao;

import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

import controle.hospedagem.HospedagemDAO;
import modelo.Hospedagem;
import javax.swing.JLabel;
import javax.swing.ImageIcon;



public class TelaListagemHospedagem extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	//private JTable table; 
	
	//HospedagemDAO dao = new HospedagemDAO().getInstancia();
	
	//ArrayList<Hospedagem> lista = dao.listarHospedagem();

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
		setTitle("Listagem Hospedagem");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 777, 648);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel pedidos = new JLabel("Pedidos");
		pedidos.setIcon(new ImageIcon("src/main/resources/menu pedidos.png"));
		pedidos.setBounds(68, 346, 150, 20);
		contentPane.add(pedidos);
		
		JLabel logo = new JLabel("Logo");
		logo.setIcon(new ImageIcon("src/main/resources/logo sigh.png"));
		logo.setBounds(135, 46, 144, 176);
		contentPane.add(logo);
		
		JLabel hospedes = new JLabel("Hóspedes");
		hospedes.setIcon(new ImageIcon("src/main/resources/menu - hospede.png"));
		hospedes.setBounds(68, 407, 150, 20);
		contentPane.add(hospedes);
		
		JLabel menu = new JLabel("Menu");
		menu.setIcon(new ImageIcon("src/main/resources/fundo cinza (menu).png"));
		menu.setBounds(0, 0, 420, 1080);
		contentPane.add(menu);
		
		
		
		
	}
}
