package servlet;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controle.EquipamentoDAO;
import modelo.Equipamento;

@WebServlet("/removeEquipamento")
public class RemoveEquipamentoServlet extends HttpServlet{

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {

		//	buscando	os	parâmetros	no	request
		String id = request.getParameter("identificador");

		long identificador = Long.parseLong(id);
		
		//	monta	um	objeto	equipamento
		Equipamento equipamento = new Equipamento();
		equipamento.setId(identificador);

		//	salva	o	equipamento
		EquipamentoDAO dao = new EquipamentoDAO();
		dao.remove(equipamento);

		//redireciona para o jsp mandar mensagem
		RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/visao/equipamento-excluido.jsp");
		rd.forward(request, response);
		
	}
}
