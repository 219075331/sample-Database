

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.StudentDTO;


@WebServlet("/editStudent")
public class EditStudentServlet extends HttpServlet {
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		String msg = "生徒全員の情報を表示";
		
		// 入力値を取得
		request.setCharacterEncoding("utf-8");
		String btn = request.getParameter("btn");
		
		StudentDAO3 sdao = new StudentDAO3();
		
		if(btn.equals("追加")) {
			int no = Integer.parseInt(request.getParameter("no"));
			String name = request.getParameter("name");
			int score = Integer.parseInt(request.getParameter("score"));
			sdao.insert(no, name, score);
			msg = "番号 " + no + " の生徒を追加しました";
		
		}else if(btn.equals("修正")) {
			int no = Integer.parseInt(request.getParameter("no"));
			String name = request.getParameter("name");
			int score = Integer.parseInt(request.getParameter("score"));
			sdao.update(no,name,score);
			msg = "番号 " + no + " の生徒を修正しました。";
		
		}else if(btn.equals("削除")) {
			int no = Integer.parseInt(request.getParameter("no"));
			sdao.delete(no);
			msg = "番号 " + no + " の生徒を削除しました。";
		}
		
		StudentDTO sdto = sdao.select();
		request.setAttribute("sdto", sdto);
		request.setAttribute("msg", msg);
		
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/editstudent.jsp");
		rd.forward(request, response);
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		doPost(request, response);
	}

}
