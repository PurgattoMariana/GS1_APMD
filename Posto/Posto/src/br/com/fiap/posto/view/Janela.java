package br.com.fiap.posto.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import br.com.fiap.posto.controller.BotaoListener;
import br.com.fiap.dao.ProdutoDao;
import br.com.fiap.posto.model.Produto;
import br.com.fiap.posto.controller.*;


public class Janela extends JFrame{

	
	private static final long serialVersionUID = 1L;
	JTabbedPane tab;
	JPanel tabPanePrincipal;
	JPanel tabPaneSecundario;
	JPanel painelEsquerda;
	JPanel painelDireita;
	
	
	
	JPanel nomePanel = new JPanel();
	JLabel nome = new JLabel("Nome do Posto");
	JTextField nomeField = new JTextField();
	
	JPanel enderecoPanel = new JPanel();
	JLabel endereco = new JLabel("Endereço");
	JPanel enderecoUm = new JPanel();
	JPanel enderecoDois = new JPanel();
	
	JPanel ruaPanel = new JPanel();
	JLabel rua = new JLabel("Rua");
	JTextField ruaField = new JTextField();
	
	JPanel numeroPanel = new JPanel();
	JLabel numero = new JLabel("Número");
	JTextField numeroField = new JTextField();
	
	JPanel bairroPanel = new JPanel();
	JLabel bairro = new JLabel("Bairro");
	JTextField bairroField = new JTextField();
	
	JPanel cidadePanel = new JPanel();
	JLabel cidade = new JLabel("Cidade");
	JTextField cidadeField = new JTextField();
	
	JPanel estadoPanel = new JPanel();
	JLabel estado = new JLabel("Estado");
	JTextField estadoField = new JTextField();
	
	JPanel plugPanel = new JPanel();
	JLabel tipoPlug = new JLabel("Plugs Disponíveis");	
	JRadioButton tipo1;
	JRadioButton tipo2;
	JRadioButton css2;
	JRadioButton chademo;
	
	JPanel precoPanel = new JPanel();
	JLabel preco = new JLabel("Preço");
	JTextField precoField = new JTextField();
	
	JPanel avaliacaoPanel = new JPanel();
	JLabel avaliacao = new JLabel("Avaliação");
	StarRater starRater = new StarRater(); 
	
	JButton salvar;
	
	JScrollPane scrollPane;

	
	String[] colunas = {"Nome","Rua", "Número", "Bairro", "Cidade", "Estado", "Preço", "Avaliação", "Plugs"};
	DefaultTableModel tableModel = new DefaultTableModel(colunas, 0);
	JTable tabela = new JTable(tableModel);
	
	public Janela() {
		setLayout(new FlowLayout());
		setSize(1100,700);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	public void init() {

		tab = new JTabbedPane();
		tabPanePrincipal = new JPanel();
		tabPanePrincipal.setLayout(new BoxLayout(tabPanePrincipal, BoxLayout.X_AXIS));
		tabPaneSecundario = new JPanel();
		scrollPane = new JScrollPane(tabela);
		scrollPane.setMaximumSize(new Dimension(1000,250));
		scrollPane.setMinimumSize(new Dimension(1000,250));
		scrollPane.setPreferredSize(new Dimension(1000,250));
		tabPaneSecundario.add(scrollPane);
		
		nomePanel.add(nome);
		nomePanel.add(nomeField);
		nomePanel.setLayout(new BoxLayout(nomePanel, BoxLayout.Y_AXIS));
		nomePanel.setBorder(BorderFactory.createEmptyBorder(10, 0, 50, 0));
		nomeField.setAlignmentX(TOP_ALIGNMENT);
		nomeField.setMaximumSize(new Dimension(420,30));
		nomeField.setMinimumSize(new Dimension(420,30));
		nomeField.setPreferredSize(new Dimension(420,30));
		
		
		ruaPanel.add(rua);
		ruaPanel.add(ruaField);
		ruaPanel.setLayout(new BoxLayout(ruaPanel, BoxLayout.Y_AXIS));
		ruaPanel.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 10));
		ruaField.setAlignmentX(TOP_ALIGNMENT);
		ruaField.setMaximumSize(new Dimension(300,30));
		ruaField.setMinimumSize(new Dimension(300,30));
		ruaField.setPreferredSize(new Dimension(300,30));
		
		numeroPanel.add(numero);
		numeroPanel.add(numeroField);
		numeroPanel.setLayout(new BoxLayout(numeroPanel, BoxLayout.Y_AXIS));
		numeroPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 0));
		numeroField.setAlignmentX(TOP_ALIGNMENT);
		numeroField.setMaximumSize(new Dimension(100,30));
		numeroField.setMinimumSize(new Dimension(100,30));
		numeroField.setPreferredSize(new Dimension(100,30));
		
		
		bairroPanel.add(bairro);
		bairroPanel.add(bairroField);
		bairroPanel.setLayout(new BoxLayout(bairroPanel, BoxLayout.Y_AXIS));
		bairroPanel.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 10));
		bairroField.setAlignmentX(TOP_ALIGNMENT);
		bairroField.setMaximumSize(new Dimension(150,30));
		bairroField.setMinimumSize(new Dimension(150,30));
		bairroField.setPreferredSize(new Dimension(150,30));
				
		cidadePanel.add(cidade);
		cidadePanel.add(cidadeField);
		cidadePanel.setLayout(new BoxLayout(cidadePanel, BoxLayout.Y_AXIS));
		cidadePanel.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 10));
		cidadeField.setAlignmentX(TOP_ALIGNMENT);
		cidadeField.setMaximumSize(new Dimension(140,30));
		cidadeField.setMinimumSize(new Dimension(140,30));
		cidadeField.setPreferredSize(new Dimension(140,30));
		
		estadoPanel.add(estado);
		estadoPanel.add(estadoField);
		estadoPanel.setLayout(new BoxLayout(estadoPanel, BoxLayout.Y_AXIS));
		estadoPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 0));
		estadoField.setAlignmentX(TOP_ALIGNMENT);
		estadoField.setMaximumSize(new Dimension(100,30));
		estadoField.setMinimumSize(new Dimension(100,30));
		estadoField.setPreferredSize(new Dimension(100,30));		
		
		enderecoPanel.add(endereco);
		enderecoPanel.add(enderecoUm);
		enderecoPanel.add(enderecoDois);
		enderecoPanel.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));
		enderecoUm.setAlignmentX(TOP_ALIGNMENT);
		enderecoDois.setAlignmentX(TOP_ALIGNMENT);
		enderecoPanel.setLayout(new BoxLayout(enderecoPanel, BoxLayout.Y_AXIS));

		
		enderecoUm.add(ruaPanel);
		enderecoUm.add(numeroPanel);
		enderecoUm.setLayout(new BoxLayout(enderecoUm, BoxLayout.X_AXIS));
		
		enderecoDois.add(bairroPanel);
		enderecoDois.add(cidadePanel);
		enderecoDois.add(estadoPanel);
		enderecoDois.setLayout(new BoxLayout(enderecoDois, BoxLayout.X_AXIS));
		
		tipo1 = new JRadioButton("Tipo 1");
		tipo2 = new JRadioButton("Tipo 2");
		css2 = new JRadioButton("CSS2");
		chademo = new JRadioButton("CHAdeMO"); 
		
		plugPanel.add(tipoPlug);
		plugPanel.add(tipo1);
		plugPanel.add(tipo2);
		plugPanel.add(css2);
		plugPanel.add(chademo);
		plugPanel.setLayout(new BoxLayout(plugPanel, BoxLayout.Y_AXIS));
		plugPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		
		
		TableListener tableListener = new TableListener();
		tabela.addMouseListener(tableListener);
		tabela.setDefaultEditor(Object.class, null);
		
		salvar = new JButton();
		salvar.setText("Salvar");
		BotaoListener listener = new BotaoListener(this);
		salvar.addActionListener(listener);
		
		precoPanel.add(preco);
		precoPanel.add(precoField);
		precoPanel.setLayout(new BoxLayout(precoPanel, BoxLayout.Y_AXIS));
		precoPanel.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 10));
		precoField.setMaximumSize(new Dimension(130,30));
		precoField.setMinimumSize(new Dimension(130,30));
		precoField.setPreferredSize(new Dimension(130,30));
		precoField.setAlignmentX(TOP_ALIGNMENT);
		
		avaliacaoPanel.add(avaliacao);
		avaliacaoPanel.add(starRater);
		avaliacaoPanel.setLayout(new BoxLayout(avaliacaoPanel, BoxLayout.Y_AXIS));
		avaliacaoPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		avaliacaoPanel.setMaximumSize(new Dimension(130,50));
		avaliacaoPanel.setMinimumSize(new Dimension(130,50));
		avaliacaoPanel.setPreferredSize(new Dimension(130,50));
		
		salvar.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 0));
		salvar.setMaximumSize(new Dimension(130,30));
		salvar.setMinimumSize(new Dimension(130,30));
		salvar.setPreferredSize(new Dimension(130,30));
		
		
		painelEsquerda = new JPanel();
		painelEsquerda.setLayout(new BoxLayout(painelEsquerda, BoxLayout.Y_AXIS));	
		painelEsquerda.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

		painelDireita = new JPanel();
		painelDireita.setLayout(new BoxLayout(painelDireita, BoxLayout.Y_AXIS));
		painelDireita.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		
		
		painelEsquerda.add(nomePanel);
		painelEsquerda.add(enderecoPanel);

		painelEsquerda.setMaximumSize(new Dimension(440,270));
		painelEsquerda.setMinimumSize(new Dimension(440,270));
		painelEsquerda.setPreferredSize(new Dimension(440,270));
		
		
		painelDireita.add(plugPanel);
		painelDireita.add(precoPanel);
		painelDireita.add(avaliacaoPanel);
		painelDireita.add(salvar);
		painelDireita.setMaximumSize(new Dimension(200,290));
		painelDireita.setMinimumSize(new Dimension(200,290));
		painelDireita.setPreferredSize(new Dimension(200,290));
		
	
		
		tabPanePrincipal.add(painelEsquerda);
		painelEsquerda.setAlignmentY(LEFT_ALIGNMENT);
		tabPanePrincipal.add(painelDireita);
		painelDireita.setAlignmentY(LEFT_ALIGNMENT);
		
		tab.addTab("Cadastro",tabPanePrincipal);
		tab.addTab("Postos",tabPaneSecundario);
		add(tab);
		setTitle("Cadastro de Postos de Abastecimento de Carros Elétricos");
	}
	
	public void carregarDados() {
		
		tableModel.setRowCount(0);
		List<Produto> lista = new ProdutoDao().listarTodos();
		lista.forEach(produto -> tableModel.addRow(produto.getData()));
	}
	
	public JTextField getNome() {
		return nomeField;
	}
	
	public JTextField getRua() {
		return ruaField;
	}
	public JTextField getNumero() {
		return numeroField;
	}
	public JTextField getBairro() {
		return bairroField;
	}
	public JTextField getCidade() {
		return cidadeField;
	}
	public JTextField getEstado() {
		return estadoField;
	}
	public JTextField getPreco() {
		return precoField;
	}
	
	
	
	public String getTipoPlug() {
		boolean tipoum = tipo1.isSelected();
		boolean tipodois = tipo2.isSelected();
		boolean cssdois = css2.isSelected();
		boolean chademob = chademo.isSelected();
		
		
		if (tipoum && tipodois && cssdois && chademob) {
			return "Tipo 1, Tipo 2, CSS2, CHAdeMO";
		}
		if (tipoum && tipodois && cssdois) {
			return "Tipo 1, Tipo 2, CSS2";
		}		
		if (tipoum && tipodois && chademob) {
			return "Tipo 1, Tipo 2, CHAdeMO";
		}
		if (tipoum && cssdois && chademob) {
			return "Tipo 1, CSS2, CHAdeMO";
		}		
		if (tipodois && cssdois && chademob) {
			return "Tipo 2, CSS2, CHAdeMO";
		}		
		if (tipoum && tipodois) {
			return "Tipo 1, Tipo 2";
		}		
		if (tipoum && cssdois) {
			return "Tipo 1, CSS2";
		}
		if (tipoum && chademob) {
			return "Tipo 1, CHAdeMO";
		}
		if (tipodois && cssdois) {
			return "Tipo 2, CSS2";
		}		
		if (tipodois && chademob) {
			return "Tipo 2, CHAdeMO";
		}
		if (cssdois && chademob) {
			return "CSS2, CHAdeMO";
		}
		if (tipoum) {
			return "Tipo 1";
		}
		if (tipodois) {
			return "Tipo 2";
		}
		if (cssdois) {
			return "CSS2";
		} 
		if (chademob) {
			return "CHAdeMO";
		}else {
			return "";
		}
	}
	
	public StarRater getStarRater() {
		return starRater;
	}
	
}
