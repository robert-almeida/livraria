package br.com.alura.livraria.servlet;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.livraria.dao.GestaoLivrariaDao;
import br.com.alura.livraria.factory.ConnectionFactory;
import br.com.alura.livraria.modelo.GestaoLivraria;

@WebServlet("/gestoes")
public class GestoesServlet extends HttpServlet {

	private GestaoLivrariaDao dao;

	public GestoesServlet() {
		this.dao = new GestaoLivrariaDao(new ConnectionFactory().getConnection());
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setAttribute("gestoes", dao.listar());

		req.getRequestDispatcher("WEB-INF/jsp/gestoes.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			String nome = req.getParameter("nome");
			String email = req.getParameter("email");
			LocalDate dataNascimento = LocalDate.parse(req.getParameter("dataNascimento"), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
			String miniCurriculo = req.getParameter("miniCurriculo");

			GestaoLivraria gestao = new GestaoLivraria(nome, email, dataNascimento, miniCurriculo);

			dao.cadastrar(gestao);

			resp.sendRedirect("gestoes");
		} catch (NumberFormatException e) {
			resp.sendRedirect("gestoes?erro=campo invalido!");
		}
	}
}