package servlet;

import java.io.IOException;

import bean.PlayerUser;
import dao.UserPlayerDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/player-login")
/**
 * Servlet implementation class PlayerServlet
 */
public class PlayerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PlayerServlet() {
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
		//エンコーディング設定
		response.setContentType("text/html;charset=utf-8");
		response.setCharacterEncoding("UTF-8");
		
		try {
			//パラメータ取得
			String userPlayername = request.getParameter("userPlayername");
			String playerPassword = request.getParameter("playerPassword");
			
			//インスタンス生成
			UserPlayerDao upd = new UserPlayerDao();
			PlayerUser pu = new PlayerUser();
			
			
			//ログイン情報検索
			pu = upd.check(userPlayername, playerPassword);
			
			if(pu == null) {
				pu = new PlayerUser();
				//セッターで格納
				pu.setUserPlayername(userPlayername);
				pu.setPlayerPassword(playerPassword);
				//ログイン情報登録メソッド呼び出し
				upd.insert(pu);				
				//登録完了へ画面遷移
				request.getRequestDispatcher("/player/player-comp.jsp").forward(request, response);
			}else {
				//ログイン画面に戻る
				request.getRequestDispatcher("/player/player-login.jsp").forward(request, response);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
			//エラー画面に遷移
			request.getRequestDispatcher("/error/error.jsp").forward(request, response);
		}
	}

}
