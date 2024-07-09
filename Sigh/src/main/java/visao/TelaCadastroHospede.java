package visao;

import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.text.ParseException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Locale;

import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
//import javax.swing.text.MaskFormatter;
import javax.swing.text.MaskFormatter;

import controle.endereco.EnderecoDAO;
import controle.hospede.HospedeDAO;
import modelo.Endereco;
import modelo.EnderecoViaCep;
import modelo.Funcionario;
import modelo.Hospede;
import servico.ViaCepService;
import visao.padrao.DateTextField;
import visao.padrao.RoundJFormattedTextField;

public class TelaCadastroHospede extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtNumero;
	private JTextField txtCidade;
	private JTextField txtPassaporte;
	//private JTextField txtResponsavel;
	private JTextField txtNomeSocial;
	private JTextField txtEmail;
	private JTextField txtComplemento;
	private JTextField txtEstado;
	private JTextField txtCpf;
	private JTextField txtData;
	private JTextField txtSobrenome;
	// private JTextField txtNecessidade;
	private JTextField txtTelefone; 
	private JTextField txtEndereco;
	private JTextField txtCep;
	private JTextField txtNome;
	private Funcionario funcionarioLogado;

	/**
	 * Create the frame.
	 */
	public TelaCadastroHospede(Funcionario funcLogado) {
		funcionarioLogado = funcLogado;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1920, 1080);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblQuarto = new JLabel("");
		lblQuarto.setIcon(new ImageIcon("src\\main\\resources\\menu quartoss.png"));
		lblQuarto.setBounds(68, 563, 400, 52);
		contentPane.add(lblQuarto);

		JLabel lblLogo = new JLabel("");
		lblLogo.setIcon(new ImageIcon("src/main/resources/logo sigh.png"));
		lblLogo.setBounds(134, 44, 144, 176);
		contentPane.add(lblLogo);

		JLabel lblHospedagem = new JLabel("");
		lblHospedagem.setIcon(new ImageIcon("src/main/resources/menu hospedagem.png"));
		lblHospedagem.setBounds(68, 458, 400, 67);
		contentPane.add(lblHospedagem);
		lblHospedagem.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				TelaListagemHospedagem tlh = new TelaListagemHospedagem(funcionarioLogado);
				tlh.setVisible(true);
				tlh.setExtendedState(JFrame.MAXIMIZED_BOTH);
				dispose();
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
		});
		lblBotaoSair.setIcon(new ImageIcon("src/main/resources/botao sair.png"));
		lblBotaoSair.setBounds(84, 955, 263, 45);
		contentPane.add(lblBotaoSair);

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
		lblPedidos.setBounds(68, 346, 400, 60);
		contentPane.add(lblPedidos);

		JLabel lblHospede = new JLabel("");
		lblHospede.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				TelaListagemHospede tlh = new TelaListagemHospede(funcionarioLogado);
				dispose();
				tlh.setExtendedState(MAXIMIZED_BOTH);
				tlh.setVisible(true);
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				lblHospede.setIcon(new ImageIcon("src/main/resources/menu - hospedes selecionado.png"));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				lblHospede.setIcon(new ImageIcon("src/main/resources/menu - hospede.png"));
			}
		});
		lblHospede.setIcon(new ImageIcon("src/main/resources/menu - hospede.png"));
		lblHospede.setBounds(68, 407, 400, 60);
		contentPane.add(lblHospede);

		JLabel lblFuncionario = new JLabel("");
		lblHospede.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				TelaListagemFuncionario tlf = new TelaListagemFuncionario(funcionarioLogado);
				tlf.setVisible(true);
				tlf.setExtendedState(JFrame.MAXIMIZED_BOTH);
				dispose();
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				lblFuncionario.setIcon(new ImageIcon("src/main/resources/menu - funcionarios selecionado.png"));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				lblFuncionario.setIcon(new ImageIcon("src/main/resources/menu funcionarios.png"));
			}
		});
		lblFuncionario.setIcon(new ImageIcon("src/main/resources/menu funcionarios.png"));
		lblFuncionario.setBounds(68, 515, 374, 52);
		contentPane.add(lblFuncionario);

		JLabel lblDivisoriaSair = new JLabel("");
		lblDivisoriaSair.setIcon(new ImageIcon("src/main/resources/divisor (menu).png"));
		lblDivisoriaSair.setBounds(77, 897, 243, 14);
		contentPane.add(lblDivisoriaSair);

		JLabel lblMenu = new JLabel("");
		lblMenu.setBounds(0, 0, 420, 1083);
		lblMenu.setIcon(new ImageIcon("src/main/resources/fundo cinza (menu).png"));
		contentPane.add(lblMenu);

		JLabel lblCaminho = new JLabel("");
		lblCaminho.setIcon(new ImageIcon("src/main/resources/Frame 675.png"));
		lblCaminho.setBounds(420, 0, 1500, 62);
		contentPane.add(lblCaminho);

		JLabel lblNome = new JLabel("Nome *");
		lblNome.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNome.setBounds(554, 288, 55, 20);
		contentPane.add(lblNome);

		txtNome = new RoundJFormattedTextField(null);
		txtNome.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtNome.setBounds(554, 326, 343, 48);
		contentPane.add(txtNome);
		txtNome.setColumns(10);

		JLabel lblSobrenome = new JLabel("Sobrenome *");
		lblSobrenome.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSobrenome.setBounds(1000, 288, 90, 20);
		contentPane.add(lblSobrenome);

		txtSobrenome = new RoundJFormattedTextField(null);
		txtSobrenome.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtSobrenome.setBounds(1000, 326, 343, 48);
		contentPane.add(txtSobrenome);
		txtSobrenome.setColumns(17);

		JLabel lblNomeSocial = new JLabel("Nome Social ");
		lblNomeSocial.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNomeSocial.setBounds(1460, 288, 100, 20);
		contentPane.add(lblNomeSocial);

		txtNomeSocial = new RoundJFormattedTextField(null);
		txtNomeSocial.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtNomeSocial.setBounds(1460, 326, 343, 48);
		contentPane.add(txtNomeSocial);
		txtNomeSocial.setColumns(23);

		JLabel lblGenero = new JLabel("Gênero *");
		lblGenero.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblGenero.setBounds(554, 390, 100, 20);
		contentPane.add(lblGenero);

		JComboBox<String> comboBoxGenero = new JComboBox<>();
		comboBoxGenero.setBounds(554, 415, 343, 48);
		comboBoxGenero.addItem("Feminino");
		comboBoxGenero.addItem("Masculino");
		comboBoxGenero.addItem("Prefiro não dizer");
		contentPane.add(comboBoxGenero);

		JLabel lblData = new JLabel("Data de Nascimento *");
		lblData.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblData.setBounds(1000, 390, 200, 20);
		contentPane.add(lblData);

		txtData = new DateTextField();
		txtData.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtData.setBounds(1000, 415, 343, 48);
		contentPane.add(txtData);
		txtData.setColumns(18);

		/*
		 * JLabel lblResponsável = new JLabel("Responsável ");
		 * lblResponsável.setFont(new Font("Tahoma", Font.PLAIN, 14));
		 * lblResponsável.setBounds(1460, 390, 100, 20);
		 * contentPane.add(lblResponsável);
		 */

		/*
		 * txtResponsavel = new RoundJFormattedTextField(null);
		 * txtResponsavel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		 * txtResponsavel.setBounds(1460, 415, 343, 48);
		 * contentPane.add(txtResponsavel); txtResponsavel.setColumns(24);
		 */

		JLabel lblNacionalidade = new JLabel("Nacionalidade *");
		lblNacionalidade.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNacionalidade.setBounds(554, 480, 100, 20);
		contentPane.add(lblNacionalidade);

		JComboBox<String> comboBoxPaises = new JComboBox<>();
		String[] paises = java.util.Locale.getISOCountries();
		for (String pais : paises) {

			Locale obj = new Locale("", pais);
			String nomePais =  obj.getDisplayCountry();
			comboBoxPaises.addItem(nomePais);
		}
		comboBoxPaises.setBounds(554, 515, 343, 48);
		contentPane.add(comboBoxPaises);

		JLabel lblResponsavel = new JLabel("Responsável *");
		lblResponsavel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblResponsavel.setBounds(1460, 390, 200, 20);
		contentPane.add(lblResponsavel);

		JComboBox<String> comboBoxResp = new JComboBox<>();
		comboBoxResp.setBounds(1460, 415, 343, 45);
		HospedeDAO dao = HospedeDAO.getInstancia();
		ArrayList<Hospede> hospedesResp = dao.listarHospedeResp();
		for (Hospede resp : hospedesResp) {
			String infos;
			
			String nomeCompleto;
			if(resp.getNomeSocial() == null) {
				nomeCompleto = resp.getNome() + " " + resp.getSobrenome();
			} else {
				nomeCompleto = resp.getNomeSocial() + " " + resp.getSobrenome();
			}
			
			String doc;
			String cpf = String.valueOf(resp.getCpf());
			if(resp.getCpf() == 0) {
				doc = resp.getPassaporte();
			} else {
				doc = cpf;
			}
			
			infos = nomeCompleto + " - " + doc;
			
			comboBoxResp.addItem(infos);
			
		}
		contentPane.add(comboBoxResp);
		
		JLabel lblCpf = new JLabel("CPF ");
		lblCpf.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCpf.setBounds(1000, 480, 100, 20);
		contentPane.add(lblCpf);

		txtCpf = new RoundJFormattedTextField(null);
		txtCpf.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtCpf.setBounds(1000, 515, 343, 48);
		contentPane.add(txtCpf);
		txtCpf.setColumns(12);

		JLabel lblPassaporte = new JLabel("Passaporte ");
		lblPassaporte.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPassaporte.setBounds(1460, 480, 100, 20);
		contentPane.add(lblPassaporte);

		txtPassaporte = new RoundJFormattedTextField(null);
		txtPassaporte.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtPassaporte.setBounds(1460, 515, 343, 48);
		contentPane.add(txtPassaporte);
		txtPassaporte.setColumns(25);

		JLabel lblCep = new JLabel("Cep *"); 
		lblCep.setFont(new Font("Tahoma", Font.PLAIN, 14)); 
		lblCep.setBounds(554, 570, 100, 20);
		contentPane.add(lblCep);

		txtCep = new RoundJFormattedTextField(null); 
		txtCep.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent e) {
				String cep = txtCep.getText();
				if(!cep.isBlank() && !cep.isEmpty()) {
					ViaCepService vcs = new ViaCepService();
					try {
						EnderecoViaCep endvp = vcs.getEndereco(cep);

						txtCidade.setText(endvp.getLocalidade());
						txtEstado.setText(endvp.getUf());
						txtEndereco.setText(endvp.getLogradouro());
						txtComplemento.setText(endvp.getComplemento());

					} catch (IOException e1) {
						e1.printStackTrace();
					} catch (IllegalStateException e2) {
						e2.printStackTrace();
					}
				}
			}
		});
		txtCep.setFont(new Font("Tahoma", Font.PLAIN, 14)); 
		txtCep.setBounds(554, 615, 343, 48);
		contentPane.add(txtCep); 
		txtCep.setColumns(13);

		JLabel lblEstado = new JLabel("Estado *"); 
		lblEstado.setFont(new Font("Tahoma", Font.PLAIN, 14)); 
		lblEstado.setBounds(1000, 570, 100, 20);
		contentPane.add(lblEstado);

		txtEstado = new RoundJFormattedTextField(null); 
		txtEstado.setFont(new Font("Tahoma", Font.PLAIN, 14)); 
		txtEstado.setBounds(1000, 615, 343, 48);
		contentPane.add(txtEstado); 
		txtEstado.setColumns(20);

		JLabel lblCidade = new JLabel("Cidade *"); 
		lblCidade.setFont(new Font("Tahoma", Font.PLAIN, 14)); 
		lblCidade.setBounds(1460, 570, 100, 20);
		contentPane.add(lblCidade);

		txtCidade = new RoundJFormattedTextField(null); 
		txtCidade.setFont(new Font("Tahoma", Font.PLAIN, 14)); 
		txtCidade.setBounds(1460, 615, 343, 48);
		contentPane.add(txtCidade); 
		txtCidade.setColumns(26);

		JLabel lblEndereco = new JLabel("Endereço *"); 
		lblEndereco.setFont(new Font("Tahoma", Font.PLAIN, 14)); 
		lblEndereco.setBounds(554, 670, 100, 20);
		contentPane.add(lblEndereco);

		txtEndereco = new RoundJFormattedTextField(null); 
		txtEndereco.setFont(new Font("Tahoma", Font.PLAIN, 14)); 
		txtEndereco.setBounds(554, 715, 343, 48);
		contentPane.add(txtEndereco); 
		txtEndereco.setColumns(14);

		JLabel lblComplemento = new JLabel("Complemento ");
		lblComplemento.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblComplemento.setBounds(1000, 670, 100, 20);
		contentPane.add(lblComplemento);

		txtComplemento = new RoundJFormattedTextField(null);
		txtComplemento.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtComplemento.setBounds(1000, 715, 343, 48);
		contentPane.add(txtComplemento); 
		txtComplemento.setColumns(21);

		JLabel lblNumero = new JLabel("Número *"); 
		lblNumero.setFont(new Font("Tahoma", Font.PLAIN, 14)); 
		lblNumero.setBounds(1460, 670, 100, 20);
		contentPane.add(lblNumero);

		txtNumero = new RoundJFormattedTextField(null); 
		txtNumero.setFont(new Font("Tahoma", Font.PLAIN, 14)); 
		txtNumero.setBounds(1460, 715, 343, 48);
		contentPane.add(txtNumero); 
		txtNumero.setColumns(27);

		JLabel lblTelefone = new JLabel("Telefone *");
		lblTelefone.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTelefone.setBounds(554, 780, 100, 20);
		contentPane.add(lblTelefone);


		try {
			MaskFormatter mascara = new MaskFormatter("(##) #####-####");
			txtTelefone = new JFormattedTextField(mascara);
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		txtTelefone.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtTelefone.setBounds(554, 815, 343, 48);
		contentPane.add(txtTelefone);
		txtTelefone.setColumns(15);

		JLabel lblEmail = new JLabel("Email *");
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblEmail.setBounds(1000, 780, 100, 20);
		contentPane.add(lblEmail);

		txtEmail = new RoundJFormattedTextField(null);
		txtEmail.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtEmail.setBounds(1000, 815, 343, 48);
		contentPane.add(txtEmail);
		txtEmail.setColumns(15);

		/*
		 * JLabel lblNecessidade = new JLabel("Necessidade Especial");
		 * lblNecessidade.setFont(new Font("Tahoma", Font.PLAIN, 14));
		 * lblNecessidade.setBounds(554, 870, 200, 20); contentPane.add(lblNecessidade);
		 * 
		 * txtNecessidade = new RoundJFormattedTextField(null);
		 * txtNecessidade.setFont(new Font("Tahoma", Font.PLAIN, 14));
		 * txtNecessidade.setBounds(554, 915, 343, 48); contentPane.add(txtNecessidade);
		 * txtNecessidade.setColumns(16);
		 */

		JLabel lblCaminho2 = new JLabel("");
		lblCaminho2.setIcon(new ImageIcon("src\\main\\resources\\CaminhoCadastrarHospede.png"));
		lblCaminho2.setBounds(408, 0, 1512, 62);
		contentPane.add(lblCaminho2);

		JLabel lblTitulo = new JLabel("");
		lblTitulo.setIcon(new ImageIcon("src\\main\\resources\\TituloCadastrarHospede.png"));
		lblTitulo.setBounds(446, 108, 1455, 126);
		contentPane.add(lblTitulo);

		JLabel lblTitulo2 = new JLabel("");
		lblTitulo2.setIcon(new ImageIcon("src/main/resources/TituloCadastrarHospede.png"));
		lblTitulo2.setBounds(446, 108, 1455, 119);
		contentPane.add(lblTitulo2);

		// BOTAO SALVAR

		JLabel lblBotaoSalvar = new JLabel("");
		lblBotaoSalvar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Boolean erro = false;

				Endereco end = new Endereco();

				String cep = txtCep.getText();
				if (cep.isEmpty()) {
					erro = true;
					TelaErro dadosIncorretos = new TelaErro("Insira o CEP");
					dadosIncorretos.setLocationRelativeTo(null);
					dadosIncorretos.setVisible(true);
				} else {
					end.setCep(Integer.valueOf(cep));
				}

				String rua = txtEndereco.getText();
				if(rua.isEmpty()) {
					erro = true;
					TelaErro dadosIncorretos = new TelaErro("Insira o endereço");
					dadosIncorretos.setLocationRelativeTo(null);
					dadosIncorretos.setVisible(true);
				} else {
					end.setEndereco(rua);
				}

				String cidade = txtCidade.getText();
				if (cidade.isEmpty()) {
					erro = true;
					TelaErro dadosIncorretos = new TelaErro("Insira a cidade");
					dadosIncorretos.setLocationRelativeTo(null);
					dadosIncorretos.setVisible(true);
				} else {
					end.setCidade(cidade);
				}

				String estado = txtEstado.getText();
				if (estado.isEmpty()) {
					erro = true;
					TelaErro dadosIncorretos = new TelaErro("Insira o estado");
					dadosIncorretos.setLocationRelativeTo(null);
					dadosIncorretos.setVisible(true);
				} else {
					end.setEstado(estado);
				}

				String numero = txtNumero.getText();
				if (numero.isEmpty()) {
					erro = true;
					TelaErro dadosIncorretos = new TelaErro("Insira o número");
					dadosIncorretos.setLocationRelativeTo(null);
					dadosIncorretos.setVisible(true);
				} else {
					end.setNumero(Integer.valueOf(numero));
				}

				String complemento = txtComplemento.getText();
				if (!complemento.isEmpty()) {
					end.setComplemento(complemento);
				}

				EnderecoDAO endDao = EnderecoDAO.getInstancia();
				int idEnd = endDao.inserirEndereco(end);
				end.setId(idEnd);

				Hospede hos = new Hospede();
				hos.setEndereco(end);

				// Só fazer o if isEmpty() se o campo for obrigatório

				String nome = txtNome.getText();
				if (nome.isEmpty()) {
					erro = true;
					TelaErro dadosIncorretos = new TelaErro("Insira seu Nome");
					dadosIncorretos.setLocationRelativeTo(null);
					dadosIncorretos.setVisible(true);

				} else {
					hos.setNome(nome);
				}

				String sobrenome = txtSobrenome.getText();
				if (sobrenome.isEmpty()) {
					erro = true;
					TelaErro dadosIncorretos = new TelaErro("Insira seu Sobrenome!");
					dadosIncorretos.setLocationRelativeTo(null);
					dadosIncorretos.setVisible(true);

				} else {
					hos.setSobrenome(sobrenome);
				}

				String nomeSocial = txtNomeSocial.getText();
				hos.setNomeSocial(nomeSocial);

				String telefone = txtTelefone.getText();
				if (telefone.isEmpty()) {
					erro = true;
					TelaErro dadosIncorretos = new TelaErro("Insira seu Telefone!");
					dadosIncorretos.setLocationRelativeTo(null);
					dadosIncorretos.setVisible(true);
				} else {
					hos.setTelefone(telefone);
				}

				// String responsavel = txtResponsavel.getText();
				// hos.setResponsavel(responsavel); - Esquece o responsável por enquanto
				
				int indexResp = comboBoxResp.getSelectedIndex();
				Hospede resp = hospedesResp.get(indexResp);
				hos.setResponsavel(resp);

				DateTextField dtf = new DateTextField();
				LocalDate data = dtf.stringParaData(txtData.getText());
				// String dataNascimento = txtData.getText();
				if (txtData.getText().isEmpty()) {
					erro = true;
					TelaErro dadosIncorretos = new TelaErro("Insira uma Data Válida!");
					dadosIncorretos.setLocationRelativeTo(null);
					dadosIncorretos.setVisible(true);
				} else {
					hos.setDataNascimento(data);
				}

				String genero = (String) comboBoxGenero.getSelectedItem();
				if (genero.isEmpty()) {
					erro = true;
					TelaErro dadosIncorretos = new TelaErro("Insira seu Gênero!");
					dadosIncorretos.setLocationRelativeTo(null);
					dadosIncorretos.setVisible(true);
				} else {
					hos.setGenero(genero);
				}

				String nacionalidade = (String) comboBoxPaises.getSelectedItem();
				if (nacionalidade == null) {
					erro = true;
					TelaErro dadosIncorretos = new TelaErro("Insira sua Nacionalidade!");
					dadosIncorretos.setLocationRelativeTo(null);
					dadosIncorretos.setVisible(true);
				} else {
					hos.setNacionalidade(nacionalidade);
				}

				// No caso de CPF e Passaporte a verificação vai ser diferente
				String cpf = txtCpf.getText();
				String passaporte = txtPassaporte.getText();

				// Verifica se ambos os campos estão vazios
				if (cpf.isEmpty() && passaporte.isEmpty()) {
					TelaErro dadosIncorretos = new TelaErro("CPF e Passaporte estão vazios. Preencha pelo menos um dos campos.");
					dadosIncorretos.setLocationRelativeTo(null);
					dadosIncorretos.setVisible(true);

					//JOptionPane.showMessageDialog(null, "CPF e Passaporte estão vazios. Preencha pelo menos um dos campos.");
				} else {
					if (!cpf.isEmpty()) {
						hos.setCpf(Integer.valueOf(cpf));
					}
					if (!passaporte.isEmpty()) {
						hos.setPassaporte(passaporte);
					} else {
				    if (!cpf.isEmpty() && !cpf.trim().isEmpty()) {

				        if (!validarCPF(cpf)) {
				            // Exibir mensagem de erro 
				        	TelaErro dadosIncorretos = new TelaErro("CPF inválido. Por favor, insira um CPF válido.");
							dadosIncorretos.setLocationRelativeTo(null);
							dadosIncorretos.setVisible(true);

				            //JOptionPane.showMessageDialog(null, "CPF inválido. Por favor, insira um CPF válido.");
				        } else {
				        	hos.setCpf(Integer.valueOf(cpf));				        }
				    }
				    if (!passaporte.isEmpty() && !passaporte.trim().isEmpty()) {
				        if (!validarPassaporte(passaporte)) {
				            // Exibir mensagem de erro
				        	TelaErro dadosIncorretos = new TelaErro("Passaporte inválido. Por favor, insira um passaporte válido.");
							dadosIncorretos.setLocationRelativeTo(null);
							dadosIncorretos.setVisible(true);

				           //JOptionPane.showMessageDialog(null, "Passaporte inválido. Por favor, insira um passaporte válido.");
				        } else {
				            hos.setPassaporte(passaporte);
				        }
				    }
				}

				String email = txtEmail.getText();
				hos.setEmail(email);

				// TESTE / ALTERAR
				//				Endereco ende = new Endereco();
				//				ende.setId(1);
				//				hos.setEndereco(ende);
//				Hospede resp = new Hospede();
//				resp.setId(6);
//				hos.setResponsavel(resp);

				if (erro == false) {
					HospedeDAO dao = HospedeDAO.getInstancia();

					int validacao = dao.inserirHospede(hos);

					if (validacao != 0) {
						dispose();
						TelaListagemHospede lh = new TelaListagemHospede(funcionarioLogado);
						lh.setVisible(true);
						lh.setExtendedState(JFrame.MAXIMIZED_BOTH);
						hos.setId(validacao);
						TelaConfirmacao telaConfirmacao = new TelaConfirmacao(hos);
						telaConfirmacao.setVisible(true);
						dispose();

					} else {
						// mensagem de ERRO
					}
				}
			}
		}
			private boolean validarPassaporte(String passaporte) {
				// TODO Auto-generated method stub
				return false;
			}

			private boolean validarCPF(String cpf) {
				// TODO Auto-generated method stub
				return false;
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
		lblBotaoSalvar.setBounds(1300, 915, 300, 60);
		contentPane.add(lblBotaoSalvar);

		// BOTAO CANCELAR

		JLabel lblBotaoCancelar = new JLabel("");
		lblBotaoCancelar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new TelaListagemHospede(funcionarioLogado).setVisible(true);
				dispose();
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
		lblBotaoCancelar.setBounds(1670, 930, 150, 40);
		contentPane.add(lblBotaoCancelar);


		// PARAMETROS PRONTOS PARA TESTE
		txtCpf.setText("78945612311");
		txtData.setText("01/01/2000");
		txtNome.setText("Amanda");
		txtSobrenome.setText("Amanda");
		txtNomeSocial.setText("Amanda");
		txtEmail.setText("amanda@ifsc.edu.br");
		txtTelefone.setText("477894561230");
		txtPassaporte.setText("123456");

	}
}
