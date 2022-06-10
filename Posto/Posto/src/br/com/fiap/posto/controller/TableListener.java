package br.com.fiap.posto.controller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JTable;

import br.com.fiap.dao.ProdutoDao;
import br.com.fiap.posto.model.Produto;

public class TableListener implements MouseListener{

	ProdutoDao produtoDao = new ProdutoDao();
	Produto produto = new Produto();
	@Override
	public void mouseClicked(MouseEvent e) {
		if(e.getClickCount() == 2) {
			int resposta = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja apagar esta avaliação?");
			if (resposta == JOptionPane.YES_OPTION) {
				JTable tabela = (JTable) e.getSource();
				String id = (String) tabela.getValueAt(tabela.getSelectedRow(), 1);
				System.out.println("Apagar titulo: " + id);
			}
		}
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
