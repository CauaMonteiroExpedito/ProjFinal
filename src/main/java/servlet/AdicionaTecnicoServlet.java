package servlet;

import java.io.IOException;
import java.text.ParseException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controle.TecnicoDao;
import modelo.Tecnico;

@WebServlet("/adicionaTecnico")
public class AdicionaTecnicoServlet extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {


		//	buscando	os	parâmetros	no	request
		String nome = request.getParameter("nome");
		String cpf = request.getParameter("cpf");
		String telefone = request.getParameter("telefone");
		String setor = request.getParameter("setor");
		

		//	monta	um	objeto	contato
		Tecnico tecnico = new Tecnico();
		tecnico.setNome(nome);
		tecnico.setCpf(cpf);
		tecnico.setTelefone(telefone);
		tecnico.setSetor(setor);

		//	salva	o	contato
		TecnicoDao dao = new TecnicoDao();
		dao.adiciona(tecnico);
		
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/visao/tecnico_adicionado.jsp");
		rd.forward(request,response);
	}

}
