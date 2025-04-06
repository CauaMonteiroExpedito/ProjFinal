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

	
@WebServlet("/alteraFornecedor")
public class AlteraFornecedorServlet extends HttpServlet {
		
		protected void service(HttpServletRequest request, HttpServletResponse response)
				throws IOException, ServletException {

			//	buscando	os	parâmetros	no	request
			String id = request.getParameter("id");
			String nome = request.getParameter("nome");
			String cnpj = request.getParameter("cnpj");
			String telefone = request.getParameter("telefone");
			String email = request.getParameter("email");
			String endereco = request.getParameter("endereco");
			

			long identificador = Long.parseLong(id);
					
					//	monta	um	objeto	tecnico
					Fornecedor fornecedor = new Fornecedor();
					fornecedor.setId(identificador);
					fornecedor.setNome(nome);
					fornecedor.setCnpj(cnpj);
					fornecedor.setTelefone(telefone);
					fornecedor.setEmail(email);
					fornecedor.setEndereco(endereco);
					
		
					//	salva	o	contato
					FornecedorDao dao = new FornecedorDao();
					dao.altera(fornecedor);
		
					RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/visao/fornecedor_alterado.jsp");
					rd.forward(request,response);

			
		}

}




