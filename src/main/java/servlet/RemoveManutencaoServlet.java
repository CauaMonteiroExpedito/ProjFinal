package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controle.ManutencaoDao;
import modelo.Manutencao;

@WebServlet("/removeManutencao")
public class RemoveManutencaoServlet extends HttpServlet {

	private static final long serialVersionUID = 5980695339353183316L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {

		String id = request.getParameter("identificador");
		
		int identificador = Integer.parseInt(id);
		//int identificador = Integer.parseInt(request.getParameter("id"));

		Manutencao manutencao= new Manutencao();
		manutencao.setId(identificador);

		// salva o aeroporto 
		ManutencaoDao dao = new ManutencaoDao();
		dao.remove(manutencao);

		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/visao/manutencao-excluida.jsp");
		rd.forward(request, response);
	}
}

