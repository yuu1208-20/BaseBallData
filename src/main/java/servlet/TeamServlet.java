package servlet;

import java.io.IOException;

import bean.TeamUser;
import dao.TeamDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/team-login")
/**
 * Servlet implementation class TeamServlet
 */
public class TeamServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TeamServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//エンコーディング設定
		response.setContentType("text/html;charset=utf-8");
		response.setCharacterEncoding("UTF-8");
		
		try {
			//パラメータ取得
			String teamUsername = request.getParameter("teamUsername");
			String teamPassword = request.getParameter("teamPassword");
			
			//インスタンス生成
			TeamUser tu = new TeamUser();
			TeamDao td = new TeamDao();
			
			//ログイン情報検索メソッド呼び出し
			tu = td.check(teamUsername, teamPassword);
			
			//ログイン情報がユニークか判定
			if(tu == null) {
				tu = new TeamUser();
				//セッター格納
				tu.setTeamUsername(teamUsername);
				tu.setTeamPassword(teamPassword);
				//ログイン情報登録
				td.insert(tu);
				//登録完了へ画面遷移
				request.getRequestDispatcher("/team/team-comp.jsp").forward(request, response);
			}else {
				//ログイン画面に戻る
				request.getRequestDispatcher("/team/team-login.jsp").forward(request, response);
			}
		}catch(Exception e) {
			e.printStackTrace();
			//エラー画面に遷移
			request.getRequestDispatcher("/error/error.jsp").forward(request, response);
		}
	}
}
