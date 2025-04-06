package servlet;

import java.io.IOException;
import java.text.ParseException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controle.FornecedorDao;
import modelo.Fornecedor;

@WebServlet("/adicionaFornecedor")
public class AdicionaFornecedorServlet extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {


		//	buscando	os	parâmetros	no	request
		String nome = request.getParameter("nome");
		String cnpj = request.getParameter("cnpj");
		String telefone = request.getParameter("telefone");
		String email = request.getParameter("email");
		String endereco = request.getParameter("endereco");
		
		//	monta	um	objeto	contato
		Fornecedor fornecedor = new Fornecedor();
		fornecedor.setNome(nome);
		fornecedor.setCnpj(cnpj);
		fornecedor.setTelefone(telefone);
		fornecedor.setEmail(email);
		fornecedor.setEndereco(endereco);

		//	salva	o	fornecedor
		FornecedorDao dao = new FornecedorDao();
		dao.adiciona(fornecedor);
		
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/visao/fornecedor_adicionado.jsp");
		rd.forward(request,response);
	}

}
