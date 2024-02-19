package servlet;

import java.io.IOException;

import bean.TeamUser;
import dao.TeamDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class TeamLoginServlet
 */
public class TeamLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TeamLoginServlet() {
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
		
		//セッションがある場合は一度破棄
		HttpSession session = request.getSession(false);
		//既にせっしょんがある場合は一度破棄
		if(session != null) {
			session.invalidate();
		}
		
		try {
			//パラメータ取得
			String teamUsername = request.getParameter("teamUsername");
			String teamPassword = request.getParameter("teamPassword");
			
			//インスタンス生成
			TeamUser tu = new TeamUser();
			TeamDao td = new TeamDao();
			
			//ログイン情報チェックメソッド呼び出し
			tu = td.check(teamUsername, teamPassword);
			
			if(tu != null) {
				//セッション情報を新規作成
				session = request.getSession(true);
				//セッションオブジェクトに保存
				session.setAttribute("teamUsername", teamUsername);
				//ログイン成功画面に遷移
				request.getRequestDispatcher("/team/team-dashboard.jsp").forward(request, response);
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
