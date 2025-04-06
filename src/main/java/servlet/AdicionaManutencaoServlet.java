package servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controle.ManutencaoDao;
import modelo.Manutencao;


@WebServlet("/cadastroManutencao")
public class AdicionaManutencaoServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
				throws IOException, ServletException {
		
		
		// BUSCA OS PARAMETROS NO REQUEST
	        int horimetro = Integer.parseInt(request.getParameter("horimetro"));
	        int idtecnico = Integer.parseInt(request.getParameter("idtecnico"));
	        int idequipamento = Integer.parseInt(request.getParameter("idequipamento"));
	        String motivo = request.getParameter("motivo");
	        String dataEmTexto = request.getParameter("data");
	        Calendar data = null;
	    	
	    	//	fazendo	a	conversão	da	data
			try {
				Date date = new SimpleDateFormat("dd/MM/yyyy").parse(dataEmTexto);
				data = Calendar.getInstance();
				data.setTime(date);
			} catch (ParseException e) {
				//out.println("Erro	de	conversão	da	data");
				
				RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/visao/mensagem-erro_manutencao.jsp");
				rd.forward(request,response);
				
				return; // para a execução do método
			}

				
				
	        // Monta um objeto aeroporto
	        Manutencao manutencao= new Manutencao();
	        manutencao.setHorimetro(horimetro);
	        manutencao.setIdTecnico(idtecnico);
	        manutencao.setIdEquipamento(idequipamento);
	        manutencao.setMotivo(motivo);
	        manutencao.setData(data);

	        // Salva o aeroporto
	        ManutencaoDao dao = new ManutencaoDao();
	        dao.adiciona(manutencao);
	        
	        RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/visao/manutencao-adicionada.jsp");
			rd.forward(request,response);
		
	}
	}
	
