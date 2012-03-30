package br.com.teste;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.classic.Session;

import br.com.bean.Produto;

public class ProdutoTeste {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static void exibirProdutos(Session session) {
		Query query = session.createQuery("from Produto");
		List<Produto> lista = query.list();
		for (Produto produto : lista) {
			System.out.println(produto.getNome());
		}
	}
	
	public static void delete(Session session) {
		Query query = session.createQuery("delete from Produto where quantidade = :qtde");
		query.setInteger("qtde", 0);
		query.executeUpdate();
		session.getTransaction().commit();
	}
	
	public static void ordernando(Session session) {
		String hql = "from Produto as p order by p.nome asc";
		Query query = session.createQuery(hql);
		List<Produto> lista = query.list();
		for (Produto produto : lista) {
			System.out.println(produto.getNome());
		}
	}
	
	public static void somar(Session session) {
		String hql = "select sum(prod.quantidade) from Produto as prod";
		Query query = session.createQuery(hql);
		List<Long> lista = query.list();
		for (Long total : lista) {
			System.out.println(total);
		}
	}
	
	public static void atualizar(Session session) {
		String hql = "update Produto set nome = :novonome where nome = :nome";
		Query query = session.createQuery(hql);
		query.setString("nome", "Iphone");
		query.setString("novonome'", "Iphone 4G");
		int linha = query.executeUpdate();
		System.out.println("linha atualizada " + linha);
	}
	
	public static void unico(Session session) {
		String hql = "from Produto where quantidade > 100";
		Query query = session.createQuery(hql);
		Produto prod = (Produto) query.uniqueResult();
	}

}
