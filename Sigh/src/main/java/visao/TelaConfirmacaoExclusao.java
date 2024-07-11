package visao;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.border.EtchedBorder;

import controle.funcionario.FuncionarioDAO;
import controle.hospedagem.HospedagemDAO;
import controle.hospede.HospedeDAO;
import controle.quarto.QuartoDAO;
import modelo.Funcionario;
import modelo.Hospedagem;
import modelo.Hospede;
import modelo.Quarto;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class TelaConfirmacaoExclusao extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private Funcionario funcionarioSelecionado;
	private Hospede hospedeSelecionado;
	private Hospedagem hospedagemSelecionada;
	private Quarto quartoSelecionado;
	private FuncionarioDAO dao = FuncionarioDAO.getInstancia();
	private HospedeDAO daoh = HospedeDAO.getInstancia();
	private HospedagemDAO daohs = HospedagemDAO.getInstancia();
	private QuartoDAO daoq = QuartoDAO.getInstacia();
	

	/**
	 * Launch the application.
	 */
/*	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaConfirmacaoExclusao frame = new TelaConfirmacaoExclusao();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}   */

	/**
	 * Create the frame.
	 * @wbp.parser.constructor
	 */
	// FUNCIONARIO
	public TelaConfirmacaoExclusao(String mensagem, Funcionario func) {
		funcionarioSelecionado = func;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 300, 144);
		setUndecorated(true);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(209, 233, 233));
		contentPane.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(64, 128, 128), new Color(64, 128, 128)));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblMensagem = new JLabel("");
		lblMensagem.setBounds(25, 16, 248, 75);
		contentPane.add(lblMensagem);
		lblMensagem.setText(mensagem);
		
		JLabel lblBotaoConfirmar = new JLabel("");
		lblBotaoConfirmar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				FuncionarioDAO dao = FuncionarioDAO.getInstancia();
				
				dao.removerFuncionarios(funcionarioSelecionado);
				
				dispose();
			}
		});
		lblBotaoConfirmar.setIcon(new ImageIcon("src/main/resources/BotaoConfirmarPequeno.png"));
		lblBotaoConfirmar.setBounds(86, 102, 58, 31);
		contentPane.add(lblBotaoConfirmar);
		
		JLabel lblBotaoCancelar = new JLabel("");
		lblBotaoCancelar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
				setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			}
		});
		lblBotaoCancelar.setIcon(new ImageIcon("src/main/resources/BotaoCancelarPequeno.png"));
		lblBotaoCancelar.setBounds(165, 102, 58, 31);
		contentPane.add(lblBotaoCancelar);
		
		}
		
	    //HOSPEDE
		public TelaConfirmacaoExclusao(String mensagem, Hospede hospede) {
			hospedeSelecionado = hospede;
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setBounds(100, 100, 300, 144);
			setUndecorated(true);
			contentPane = new JPanel();
			contentPane.setBackground(new Color(209, 233, 233));
			contentPane.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(64, 128, 128), new Color(64, 128, 128)));

			setContentPane(contentPane);
			contentPane.setLayout(null);
			
			JLabel lblMensagem = new JLabel("");
			lblMensagem.setBounds(25, 16, 248, 75);
			contentPane.add(lblMensagem);
			lblMensagem.setText(mensagem);
			
			JLabel lblBotaoConfirmar = new JLabel("");
			lblBotaoConfirmar.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {

					HospedeDAO daoh = HospedeDAO.getInstancia();
					
					daoh.removerHospede(hospedeSelecionado);
					
					dispose();
				}
			});
			lblBotaoConfirmar.setIcon(new ImageIcon("src/main/resources/BotaoConfirmarPequeno.png"));
			lblBotaoConfirmar.setBounds(86, 102, 58, 31);
			contentPane.add(lblBotaoConfirmar);
			
			JLabel lblBotaoCancelar = new JLabel("");
			lblBotaoCancelar.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					dispose();
					setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				}
			});
			lblBotaoCancelar.setIcon(new ImageIcon("src/main/resources/BotaoCancelarPequeno.png"));
			lblBotaoCancelar.setBounds(165, 102, 58, 31);
			contentPane.add(lblBotaoCancelar);
			
			}
			
		    //HOSPEDAGEM
			public TelaConfirmacaoExclusao(String mensagem, Hospedagem hospedagem) {
				hospedagemSelecionada = hospedagem;
				setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				setBounds(100, 100, 300, 144);
				setUndecorated(true);
				contentPane = new JPanel();
				contentPane.setBackground(new Color(209, 233, 233));
				contentPane.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(64, 128, 128), new Color(64, 128, 128)));

				setContentPane(contentPane);
				contentPane.setLayout(null);
				
				JLabel lblMensagem = new JLabel("");
				lblMensagem.setBounds(25, 16, 248, 75);
				contentPane.add(lblMensagem);
				lblMensagem.setText(mensagem);
				
				JLabel lblBotaoConfirmar = new JLabel("");
				lblBotaoConfirmar.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {

						HospedagemDAO daohs = HospedagemDAO.getInstancia();
						
						daohs.removerHospedagem(hospedagemSelecionada);
						
						dispose();
					}
				});
				lblBotaoConfirmar.setIcon(new ImageIcon("src/main/resources/BotaoConfirmarPequeno.png"));
				lblBotaoConfirmar.setBounds(86, 102, 58, 31);
				contentPane.add(lblBotaoConfirmar);
				
				JLabel lblBotaoCancelar = new JLabel("");
				lblBotaoCancelar.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						dispose();
						setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					}
				});
				lblBotaoCancelar.setIcon(new ImageIcon("src/main/resources/BotaoCancelarPequeno.png"));
				lblBotaoCancelar.setBounds(165, 102, 58, 31);
				contentPane.add(lblBotaoCancelar);
				
				}
				
			    //QUARTO
				public TelaConfirmacaoExclusao(String mensagem, Quarto quarto) {
					quartoSelecionado = quarto;
					setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					setBounds(100, 100, 300, 144);
					setUndecorated(true);
					contentPane = new JPanel();
					contentPane.setBackground(new Color(209, 233, 233));
					contentPane.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(64, 128, 128), new Color(64, 128, 128)));

					setContentPane(contentPane);
					contentPane.setLayout(null);
					
					JLabel lblMensagem = new JLabel("");
					lblMensagem.setBounds(25, 16, 248, 75);
					contentPane.add(lblMensagem);
					lblMensagem.setText(mensagem);
					
					JLabel lblBotaoConfirmar = new JLabel("");
					lblBotaoConfirmar.addMouseListener(new MouseAdapter() {
						@Override
						public void mouseClicked(MouseEvent e) {

							QuartoDAO daoq = QuartoDAO.getInstacia();
							
							daoq.removerQuarto(quartoSelecionado);
						}
					});
					lblBotaoConfirmar.setIcon(new ImageIcon("src/main/resources/BotaoConfirmarPequeno.png"));
					lblBotaoConfirmar.setBounds(86, 102, 58, 31);
					contentPane.add(lblBotaoConfirmar);
		
		JLabel lblBotaoCancelar = new JLabel("");
		lblBotaoCancelar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
				setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			}
		});
		lblBotaoCancelar.setIcon(new ImageIcon("src/main/resources/BotaoCancelarPequeno.png"));
		lblBotaoCancelar.setBounds(165, 102, 58, 31);
		contentPane.add(lblBotaoCancelar);
	}
}
