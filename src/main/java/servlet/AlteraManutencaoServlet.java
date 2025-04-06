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

@WebServlet("/alteraManutencao")
public class AlteraManutencaoServlet extends HttpServlet{
	
	private static final long serialVersionUID = 9100795197695392325L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		
			String id = request.getParameter("id");
			String horimetro = request.getParameter("horimetro");
			String idtecnico = request.getParameter("idtecnico");
			String idequipamento = request.getParameter("idequipamento");
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
				
				RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/visao/mensagem-erro.jsp");
				rd.forward(request,response);
				
				return; // para a execução do método
			}
			
	        int identificador = Integer.parseInt(id);
	        int Horimetro = Integer.parseInt(horimetro);
	        int Idtecnico = Integer.parseInt(idtecnico);
	        int Idequipamento = Integer.parseInt(idequipamento);
	
	        
        
            
            
            Manutencao manutencao = new Manutencao();
	        
	        
            manutencao.setId(identificador);
            manutencao.setHorimetro(Horimetro);
            manutencao.setIdTecnico(Idtecnico);
            manutencao.setIdEquipamento(Idequipamento);
            manutencao.setMotivo(motivo);
            manutencao.setData(data);

	        // Salva a manutencao
	        ManutencaoDao dao = new ManutencaoDao();
	        dao.altera(manutencao);
	        
	        RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/visao/manutencao-alterada.jsp");
			rd.forward(request,response);
	}

}
