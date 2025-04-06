package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controle.AeroportoDao;
import modelo.Aeroportos;

@WebServlet("/removeAeroporto")
public class RemoveAeroportoServlet extends HttpServlet {

	private static final long serialVersionUID = 5980695339353183316L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {

		String id = request.getParameter("identificador");
		
		int identificador = Integer.parseInt(id);
		//int identificador = Integer.parseInt(request.getParameter("id"));

		Aeroportos aeroporto = new Aeroportos();
		aeroporto.setId(identificador);

		// salva o aeroporto 
		AeroportoDao dao = new AeroportoDao();
		dao.remove(aeroporto);

		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/visao/aeroporto-excluido.jsp");
		rd.forward(request, response);
	}
}

