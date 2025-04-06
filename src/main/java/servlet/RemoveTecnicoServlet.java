package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controle.TecnicoDao;
import modelo.Tecnico;

@WebServlet("/removeTecnico")
public class RemoveTecnicoServlet extends HttpServlet{
	
	private static final long serialVersionUID = 8389101344049234240L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {

		//	buscando	os	parâmetros	no	request
		String id = request.getParameter("identificador");

		long identificador = Long.parseLong(id);
		
		//	monta	um	objeto	contato
		Tecnico tecnico = new Tecnico();
		tecnico.setId(identificador);

		//	salva	o	contato
		TecnicoDao dao = new TecnicoDao();
		dao.remove(tecnico);

		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/visao/tecnico_excluido.jsp");
		rd.forward(request,response);
	}

}
