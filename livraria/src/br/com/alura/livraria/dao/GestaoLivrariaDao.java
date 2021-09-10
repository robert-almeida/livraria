package br.com.alura.livraria.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.alura.livraria.modelo.GestaoLivraria;

public class GestaoLivrariaDao {
	
	private Connection conexao;
	
	public GestaoLivrariaDao(Connection conexao) {
		this.conexao = conexao;
	}

	public void cadastrar(GestaoLivraria gestao) {
		try {
			
			String sql = "insert into gestoes(nome, email, dataNascimento, miniCurriculo) values(?, ?, ?, ?)";
			
			java.sql.PreparedStatement ps = conexao.prepareStatement(sql);
			ps.setString(1, gestao.getNome());
			ps.setString(2, gestao.getEmail());
			ps.setDate(3, Date.valueOf(gestao.getDataNascimento()));
			ps.setString(4, gestao.getMiniCurriculo());
			
			ps.execute();
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}
	
	public List<GestaoLivraria> listar() {
		try {
			String sql = "select * from gestoes";

			java.sql.PreparedStatement ps = conexao.prepareStatement(sql);

			ResultSet rs = ps.executeQuery();
			
			List<GestaoLivraria> gestoes = new ArrayList<>();

			while (rs.next()) {
				GestaoLivraria g = new GestaoLivraria();
				g.setNome(rs.getString("nome"));
				g.setEmail(rs.getString("email"));
				g.setDataNascimento(rs.getDate("dataNascimento").toLocalDate());
				g.setMiniCurriculo(rs.getString("miniCurriculo"));
				gestoes.add(g);
			}
			return gestoes;

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}
}
