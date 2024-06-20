package tool;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// URLが「〇〇〇.action」という形だったらサーブレットが実行される
@WebServlet(urlPatterns={"*.action"})
public class FrontController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out=resp.getWriter();
		try {
//			リクエストされたページに応じた処理を実行する
			// リクエストされたURLの一文字以降を取り出す
			String path=req.getServletPath().substring(1);
			// pathの「.a」を「A」に置き換え、さらに「/」を「.」に置き換える
			String name=path.replace(".a", "A").replace("/", ".");
//			URLをもとにクラス名を取得したことになる
			// クラス名を元にインスタンスを生成
			Action action=(Action)Class.forName(name).getDeclaredConstructor().newInstance();
			// excuteメソッド実行してフォワード先のJSPファイル名を取得
			String url=action.execute(req, resp);

//			リクエストされたページに応じたJSPにフォワード
			req.getRequestDispatcher(url).forward(req, resp);
		} catch (Exception e) {
//			エラー処理
			e.printStackTrace(out);
		}
	}

}
