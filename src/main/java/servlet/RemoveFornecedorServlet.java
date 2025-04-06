package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controle.FornecedorDao;
import modelo.Fornecedor;

@WebServlet("/removeFornecedor")
public class RemoveFornecedorServlet extends HttpServlet{
	
	private static final long serialVersionUID = 8389101344049234240L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {

		//	buscando	os	parâmetros	no	request
		String id = request.getParameter("identificador");

		long identificador = Long.parseLong(id);
		
		//	monta	um	objeto	fornecedor
		Fornecedor fornecedor = new Fornecedor();
		fornecedor.setId(identificador);

		//	salva	o	fornecedor
		FornecedorDao dao = new FornecedorDao();
		dao.remove(fornecedor);

		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/visao/fornecedor_excluido.jsp");
		rd.forward(request,response);
	}

}
