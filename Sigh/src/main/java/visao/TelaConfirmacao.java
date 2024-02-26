package visao;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Color;
import java.awt.Panel;
import java.awt.Window.Type;
import java.awt.Label;
import java.awt.TextField;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Toolkit;

public class TelaConfirmacao extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaConfirmacao frame = new TelaConfirmacao();
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
	public TelaConfirmacao() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Jaqueline\\Amanda\\IFSC\\Sigh\\Repository-SIGH\\Sigh\\src\\main\\resources\\logo sigh.png"));
		setType(Type.POPUP);
		setForeground(new Color(255, 253, 253));
		setTitle("Confirmação de cadastro");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Panel panel = new Panel();
		panel.setBackground(new Color(66, 138, 147));
		panel.setBounds(0, 0, 484, 42);
		contentPane.add(panel);
		panel.setLayout(null);
		
		Label lblConfirmacao = new Label("Cadastro feito com sucesso!");
		lblConfirmacao.setForeground(new Color(255, 253, 253));
		lblConfirmacao.setFont(new Font("Montserrat Thin", Font.PLAIN, 25));
		lblConfirmacao.setBounds(30, 10, 375, 22);
		panel.add(lblConfirmacao);
		
		Label lblNome = new Label("Nome: ");
		lblNome.setFont(new Font("Montserrat Thin", Font.PLAIN, 15));
		lblNome.setBounds(79, 73, 62, 22);
		contentPane.add(lblNome);
		
		Label lblSetor = new Label("Setor: ");
		lblSetor.setFont(new Font("Montserrat Thin", Font.PLAIN, 15));
		lblSetor.setBounds(79, 106, 62, 22);
		contentPane.add(lblSetor);
		
		Label lblCargo = new Label("Cargo: ");
		lblCargo.setFont(new Font("Montserrat Thin", Font.PLAIN, 15));
		lblCargo.setBounds(79, 139, 62, 22);
		contentPane.add(lblCargo);
		
		Label lblUsuario = new Label("Usuário: ");
		lblUsuario.setFont(new Font("Montserrat Thin", Font.PLAIN, 15));
		lblUsuario.setBounds(79, 175, 62, 22);
		contentPane.add(lblUsuario);
		
		JLabel nome = new JLabel("Nome ");
		nome.setFont(new Font("Montserrat Thin", Font.PLAIN, 15));
		nome.setBounds(170, 73, 271, 22);
		contentPane.add(nome);
		
		JLabel setor = new JLabel("Setor ");
		setor.setFont(new Font("Montserrat Thin", Font.PLAIN, 15));
		setor.setBounds(170, 106, 271, 22);
		contentPane.add(setor);
		
		JLabel cargo = new JLabel("Cargo ");
		cargo.setFont(new Font("Montserrat Thin", Font.PLAIN, 15));
		cargo.setBounds(170, 139, 291, 22);
		contentPane.add(cargo);
		
		JLabel usuario = new JLabel("Usuário ");
		usuario.setFont(new Font("Montserrat Thin", Font.PLAIN, 15));
		usuario.setBounds(170, 175, 281, 22);
		contentPane.add(usuario);
		
		JLabel lblNewLabel = new JLabel("  ");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Jaqueline\\Amanda\\IFSC\\Sigh\\Repository-SIGH\\Sigh\\src\\main\\resources\\botaoOKverde.png"));
		lblNewLabel.setBounds(317, 208, 86, 26);
		contentPane.add(lblNewLabel);
	}
}