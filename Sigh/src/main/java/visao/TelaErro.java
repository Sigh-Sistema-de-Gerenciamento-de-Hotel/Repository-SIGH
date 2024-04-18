package visao;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Color;
import javax.swing.border.EtchedBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class TelaErro extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaErro frame = new TelaErro();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TelaErro() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 250);
		setUndecorated(true);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 253, 253));
		contentPane.setBorder(new EtchedBorder(EtchedBorder.LOWERED, Color.RED, Color.RED));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, Color.RED, Color.RED));
		panel.setBackground(new Color(208, 211, 218));
		panel.setBounds(0, 0, 450, 80);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblErro = new JLabel("ERRO!");
		lblErro.setForeground(Color.RED);
		lblErro.setFont(new Font("Arial", Font.BOLD, 32));
		lblErro.setBounds(108, 24, 106, 45);
		panel.add(lblErro);
		
		JLabel lblAtencao = new JLabel("");
		lblAtencao.setIcon(new ImageIcon("C:\\Users\\Aluno\\Desktop\\Repository-SIGH\\Sigh\\src\\main\\resources\\AtençaoErro.png"));
		lblAtencao.setBounds(22, 11, 89, 68);
		panel.add(lblAtencao);
		
		JLabel lblBotaoSair = new JLabel("");
		lblBotaoSair.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
			}
		});
		lblBotaoSair.setIcon(new ImageIcon("C:\\Users\\Aluno\\Desktop\\Repository-SIGH\\Sigh\\src\\main\\resources\\botaoTelaErro.png"));
		lblBotaoSair.setBounds(351, 11, 89, 31);
		panel.add(lblBotaoSair);
	}
}
