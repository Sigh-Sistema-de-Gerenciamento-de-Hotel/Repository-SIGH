package visao;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import modelo.Funcionario;
import modelo.Hospedagem;
import modelo.Hospede;
import modelo.Quarto;

import java.awt.Color;
import java.awt.Panel;
import java.awt.Label;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.HeadlessException;

import javax.swing.ImageIcon;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTextField;

public class TelaConfirmacao extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private String txtNome;
	private String txtSobrenome;
	private String txtNomeSocial;
	private String txtUsuario;
	private String txtCargo;

	public TelaConfirmacao(Funcionario func) {
		
		this.txtNome = func.getNome();
		this.txtSobrenome = func.getSobrenome();
		this.txtNomeSocial = func.getNomeSocial();
		this.txtUsuario = func.getUsuario();
		this.txtCargo = func.getCargo();
		
		setIconImage(Toolkit.getDefaultToolkit().getImage("src/main/resources/logo sigh.png"));
		setType(Type.POPUP);
		setForeground(new Color(255, 253, 253));
		setTitle("Confirmação de cadastro");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(1480, 760, 400, 230);
		setUndecorated(true);
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
		lblNome.setBounds(50, 61, 62, 22);
		contentPane.add(lblNome);

		Label lblNomeSocial = new Label("Nome social: ");
		lblNomeSocial.setFont(new Font("Montserrat Thin", Font.PLAIN, 15));
		lblNomeSocial.setBounds(50, 94, 92, 22);
		contentPane.add(lblNomeSocial);

		Label lblCargo = new Label("Cargo: ");
		lblCargo.setFont(new Font("Montserrat Thin", Font.PLAIN, 15));
		lblCargo.setBounds(50, 127, 62, 22);
		contentPane.add(lblCargo);

		Label lblUsuario = new Label("Usuário: ");
		lblUsuario.setFont(new Font("Montserrat Thin", Font.PLAIN, 15));
		lblUsuario.setBounds(50, 163, 62, 22);
		contentPane.add(lblUsuario);

		String nomeCompleto = txtNome + " " + txtSobrenome;

		JLabel nome = new JLabel(nomeCompleto);
		nome.setFont(new Font("Montserrat Thin", Font.PLAIN, 15));
		nome.setBounds(141, 61, 271, 22);
		contentPane.add(nome);

		JLabel nomeSocial = new JLabel(txtNomeSocial);
		nomeSocial.setFont(new Font("Montserrat Thin", Font.PLAIN, 15));
		nomeSocial.setBounds(141, 94, 271, 22);
		contentPane.add(nomeSocial);

		JLabel cargo = new JLabel(txtCargo);
		cargo.setFont(new Font("Montserrat Thin", Font.PLAIN, 15));
		cargo.setBounds(141, 127, 291, 22);
		contentPane.add(cargo);

		JLabel usuario = new JLabel(txtUsuario);
		usuario.setFont(new Font("Montserrat Thin", Font.PLAIN, 15));
		usuario.setBounds(141, 163, 281, 22);
		contentPane.add(usuario);

		JLabel lblNewLabel = new JLabel("  ");
		lblNewLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
				setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

			}
			@Override
			public void mouseEntered(MouseEvent e) {
				lblNewLabel.setIcon(new ImageIcon("src/main/resources/botaoOkVerdeClaraNot.png"));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblNewLabel.setIcon(new ImageIcon("src/main/resources/botaoOKverde.png"));
			}
		});
		lblNewLabel.setIcon(new ImageIcon("src/main/resources/botaoOKverde.png"));
		lblNewLabel.setBounds(288, 183, 86, 26);
		contentPane.add(lblNewLabel);

	}
	
	public TelaConfirmacao(Hospede hospede) {
		setIconImage(Toolkit.getDefaultToolkit().getImage("src/main/resources/logo sigh.png"));
		setType(Type.POPUP);
		setForeground(new Color(255, 253, 253));
		setTitle("Confirmação de cadastro");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(1480, 760, 400, 230);
		setUndecorated(true);
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
		lblNome.setBounds(50, 61, 62, 22);
		contentPane.add(lblNome);

		Label lblNomeSocial = new Label("Nome social: ");
		lblNomeSocial.setFont(new Font("Montserrat Thin", Font.PLAIN, 15));
		lblNomeSocial.setBounds(50, 94, 92, 22);
		contentPane.add(lblNomeSocial);

		Label lblNacionalidade = new Label("Nacionalidade: ");
		lblNacionalidade.setFont(new Font("Montserrat Thin", Font.PLAIN, 15));
		lblNacionalidade.setBounds(50, 127, 106, 22);
		contentPane.add(lblNacionalidade);

		Label lblCodigo = new Label("Código: ");
		lblCodigo.setFont(new Font("Montserrat Thin", Font.PLAIN, 15));
		lblCodigo.setBounds(50, 163, 62, 22);
		contentPane.add(lblCodigo);

		String nomeCompleto = hospede.getNome() + hospede.getSobrenome();

		JLabel nome = new JLabel(nomeCompleto);
		nome.setFont(new Font("Montserrat Thin", Font.PLAIN, 15));
		nome.setBounds(123, 61, 267, 22);
		contentPane.add(nome);

		JLabel nomeSocial = new JLabel(hospede.getNomeSocial());
		nomeSocial.setFont(new Font("Montserrat Thin", Font.PLAIN, 15));
		nomeSocial.setBounds(148, 94, 225, 22);
		contentPane.add(nomeSocial);

		JLabel nacionalidade = new JLabel(hospede.getNacionalidade());
		nacionalidade.setFont(new Font("Montserrat Thin", Font.PLAIN, 15));
		nacionalidade.setBounds(161, 127, 229, 22);
		contentPane.add(nacionalidade);

		JLabel codigo = new JLabel(String.valueOf(hospede.getId()));
		codigo.setFont(new Font("Montserrat Thin", Font.PLAIN, 15));
		codigo.setBounds(119, 163, 258, 22);
		contentPane.add(codigo);

		JLabel lblNewLabel = new JLabel("  ");
		lblNewLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
				setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

			}
			@Override
			public void mouseEntered(MouseEvent e) {
				lblNewLabel.setIcon(new ImageIcon("src/main/resources/botaoOkVerdeClaraNot.png"));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblNewLabel.setIcon(new ImageIcon("src/main/resources/botaoOKverde.png"));
			}
		});
		lblNewLabel.setIcon(new ImageIcon("src/main/resources/botaoOKverde.png"));
		lblNewLabel.setBounds(288, 183, 86, 26);
		contentPane.add(lblNewLabel);
	}
	
	public TelaConfirmacao(Hospedagem hospedagem) {
		setIconImage(Toolkit.getDefaultToolkit().getImage("src/main/resources/logo sigh.png"));
		setType(Type.POPUP);
		setForeground(new Color(255, 253, 253));
		setTitle("Confirmação de cadastro");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(1480, 760, 400, 230);
		setUndecorated(true);
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

		Label lblCodigo = new Label("Código: ");
		lblCodigo.setFont(new Font("Montserrat Thin", Font.PLAIN, 15));
		lblCodigo.setBounds(50, 61, 62, 22);
		contentPane.add(lblCodigo);
		
		Label lblNumHosp = new Label("Num. Hóspedes: ");
		lblNumHosp.setFont(new Font("Montserrat Thin", Font.PLAIN, 15));
		lblNumHosp.setBounds(50, 94, 145, 22);
		contentPane.add(lblNumHosp);

		Label lblNumQuarto = new Label("Cod. Quarto: ");
		lblNumQuarto.setFont(new Font("Montserrat Thin", Font.PLAIN, 15));
		lblNumQuarto.setBounds(50, 127, 106, 22);
		contentPane.add(lblNumQuarto);
		
		JLabel codigo = new JLabel(String.valueOf(hospedagem.getId()));
		codigo.setFont(new Font("Montserrat Thin", Font.PLAIN, 15));
		codigo.setBounds(123, 61, 267, 22);
		contentPane.add(codigo);
		
		JLabel numHosp = new JLabel(String.valueOf(hospedagem.getNumHospedes()));
		numHosp.setFont(new Font("Montserrat Thin", Font.PLAIN, 15));
		numHosp.setBounds(197, 94, 176, 22);
		contentPane.add(numHosp);

		JLabel numQuarto = new JLabel(String.valueOf(hospedagem.getQuarto().getNumero()));
		numQuarto.setFont(new Font("Montserrat Thin", Font.PLAIN, 15));
		numQuarto.setBounds(161, 127, 229, 22);
		contentPane.add(numQuarto);


		JLabel lblNewLabel = new JLabel("  ");
		lblNewLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
				setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				lblNewLabel.setIcon(new ImageIcon("src/main/resources/botaoOkVerdeClaraNot.png"));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblNewLabel.setIcon(new ImageIcon("src/main/resources/botaoOKverde.png"));
			}
		});
		lblNewLabel.setIcon(new ImageIcon("src/main/resources/botaoOKverde.png"));
		lblNewLabel.setBounds(288, 183, 86, 26);
		contentPane.add(lblNewLabel);
	}
	
	public TelaConfirmacao(Quarto quarto) {
		setIconImage(Toolkit.getDefaultToolkit().getImage("src/main/resources/logo sigh.png"));
		setType(Type.POPUP);
		setForeground(new Color(255, 253, 253));
		setTitle("Confirmação de cadastro");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(1480, 760, 400, 230);
		setUndecorated(true);
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

		Label lblCodigo = new Label("Código: ");
		lblCodigo.setFont(new Font("Montserrat Thin", Font.PLAIN, 15));
		lblCodigo.setBounds(50, 61, 62, 22);
		contentPane.add(lblCodigo);
		
		Label lblNumHosp = new Label("Num. Hóspedes: ");
		lblNumHosp.setFont(new Font("Montserrat Thin", Font.PLAIN, 15));
		lblNumHosp.setBounds(50, 94, 92, 22);
		contentPane.add(lblNumHosp);

		Label lblPreco = new Label("Preço: ");
		lblPreco.setFont(new Font("Montserrat Thin", Font.PLAIN, 15));
		lblPreco.setBounds(50, 127, 106, 22);
		contentPane.add(lblPreco);
		
		JLabel codigo = new JLabel(String.valueOf(quarto.getNumero()));
		codigo.setFont(new Font("Montserrat Thin", Font.PLAIN, 15));
		codigo.setBounds(123, 61, 267, 22);
		contentPane.add(codigo);
		
		JLabel numHosp = new JLabel(String.valueOf(quarto.getNumMaxHospedes()));
		numHosp.setFont(new Font("Montserrat Thin", Font.PLAIN, 15));
		numHosp.setBounds(148, 94, 225, 22);
		contentPane.add(numHosp);

		JLabel preco = new JLabel(String.valueOf(quarto.getPreco()));
		preco.setFont(new Font("Montserrat Thin", Font.PLAIN, 15));
		preco.setBounds(161, 127, 229, 22);
		contentPane.add(preco);


		JLabel lblNewLabel = new JLabel("  ");
		lblNewLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
				setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				lblNewLabel.setIcon(new ImageIcon("src/main/resources/botaoOkVerdeClaraNot.png"));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblNewLabel.setIcon(new ImageIcon("src/main/resources/botaoOKverde.png"));
			}
		});
		lblNewLabel.setIcon(new ImageIcon("src/main/resources/botaoOKverde.png"));
		lblNewLabel.setBounds(288, 183, 86, 26);
		contentPane.add(lblNewLabel);
	}
}