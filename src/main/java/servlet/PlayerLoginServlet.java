package servlet;

import java.io.IOException;

import bean.PlayerUser;
import dao.UserPlayerDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/login")
/**
 * Servlet implementation class PlayerLoginServlet
 */
public class PlayerLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PlayerLoginServlet() {
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
		//既にセッションがある場合は破棄
		if(session != null) {
			session.invalidate();
		}
		
		try {			
			//パラメータ取得
			String userPlayername = request.getParameter("userPlayername");
			String playerPassword = request.getParameter("playerPassword");
			
			//インスタンス生成
			UserPlayerDao upd = new UserPlayerDao();
			PlayerUser pu = new PlayerUser();
			
			pu = upd.check(userPlayername, playerPassword);
			
			if(pu != null) {
				//セッション情報を新規作成
				session = request.getSession(true);
				//セッションオブジェクトに保存
				session.setAttribute("userPlayername", userPlayername);
				//ログイン成功画面遷移
				request.getRequestDispatcher("/player/player-dashboard.jsp").forward(request, response);
			}else {
				//ログイン失敗時の処理
				//ログイン画面にエラーメッセージを表示
//				request.setAttribute("errorMessage", "ユーザー名かパスワードが違います。");
				request.getRequestDispatcher("/player/player-login.jsp").forward(request, response);
			}
			
		}catch(Exception e) {
			//エラー画面に遷移
			request.getRequestDispatcher("/error/error.jsp").forward(request,response);
		}
	}

}
