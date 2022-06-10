package br.com.fiap.posto.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JTable;

import br.com.fiap.posto.*;
import br.com.fiap.dao.ProdutoDao;
import br.com.fiap.posto.model.*;
import br.com.fiap.posto.AbrePosto;
import br.com.fiap.posto.view.Janela;

public class BotaoListener implements ActionListener, MouseListener{
	
	private Janela view;
	private ProdutoDao dao = new ProdutoDao();

	public BotaoListener(Janela view) {
		this.view = view;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		Produto produto = new Produto();
		produto.setNome(view.getNome().getText());
		produto.setRua(view.getRua().getText());
		produto.setNumero(view.getNumero().getText());
		produto.setBairro(view.getBairro().getText());
		produto.setCidade(view.getCidade().getText());
		produto.setEstado(view.getEstado().getText());
		produto.setPreco(view.getPreco().getText());
		produto.setTipoPlug(view.getTipoPlug());
		produto.setStars(view.getStarRater().getSelection());

		
		dao.inserir(produto);
		
		view.carregarDados();
		
		List<Produto> lista = dao.listarTodos();
		lista.forEach(System.out::println);
	}	
	
	@Override
	public void mouseClicked(MouseEvent e){
		if(e.getClickCount() == 2){
			int resposta = JOptionPane.showConfirmDialog(null, "Deseja realmente apagar esse posto?");
			if(resposta == JOptionPane.YES_OPTION){
				JTable tabela = (JTable) e.getSource();
				String id = (String) tabela.getValueAt(tabela.getSelectedRow(), 0);
				dao.apagar(Long.valueOf(id));
				view.carregarDados();
			}
		}	
	}

	@Override
	public void mousePressed(MouseEvent e){
		
	}

	@Override
	public void mouseReleased(MouseEvent e){

	}

	@Override
	public void mouseEntered(MouseEvent e){

	}

	@Override
	public void mouseExited(MouseEvent e){

	}
}
