package tool;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public abstract class Action {
	/**
	 * ページに応じた処理を実行し、フォワード先のJSPファイル名を返却する
	 *
	 *
	 *
	 *
	*/
	public abstract String execute(
		HttpServletRequest req,HttpServletResponse resp
	)throws Exception;
}
