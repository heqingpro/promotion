package cn.ipanel.apps.xpress.edition.management.util;


import javax.servlet.http.HttpServletRequest;

/**
 * 页面DataTable 条件查询组装sql
 * @author luzh
 * createTime 2016年11月17日 下午11:05:54
 */
public class AnalyticParameter {

	/**
	 * 封装请求函数 cols参数代表列名 不同的表格不确定，需要自己定义传入
	 */
	public static Object[] getRequestValue(HttpServletRequest request, String[] cols) {
		// 获取请求次数
		String draw = "0";
		draw = request.getParameter("draw");
		// 数据起始位置
		String start = request.getParameter("start");
		// 数据长度
		String length = request.getParameter("length");
		// 获取客户端需要排序的列名
		String orderColumn = "0";
		orderColumn = request.getParameter("order[0][column]");
		orderColumn = cols[Integer.parseInt(orderColumn)];
		// 获取排序方式 默认为asc
		String orderDir = "asc";
		orderDir = request.getParameter("order[0][dir]");
		// 获取用户搜索的字段
		String searchValue = request.getParameter("search[value]");
		// 组装参数
		Object[] requestObj = new Object[] { draw, start, length, orderColumn, orderDir, searchValue, cols };
		return requestObj;
	}

	/**
	 * 根据传来的参数组装条件查询语句
	 */
	public static String getSql(Object[] obj, String hql) {
		// 取参数，obj格式固定
		String orderColumn = obj[3].toString();
		String orderDir = obj[4].toString();
		String serachValue = StringFilter.replaceString(obj[5].toString());
		Object[] cols = (Object[]) obj[6];
		// 根据列名和搜索条件组装搜索语句
		// 先将like语句装入list 然后遍历
		int len = cols.length;
		String individualSearchSql = "";
		if (!serachValue.equals("")) {
			for (int i = 0; i < len - 1; i++) {
				individualSearchSql += "" + cols[i] + " like '%" + serachValue + "%' or ";
			}
			individualSearchSql += "" + cols[len - 1] + " like '%" + serachValue + "%'";
		}

		String orderSql = " order by " + orderColumn + " " + orderDir;
		String sql = "";
		if (individualSearchSql == "") {
			sql = orderSql;
		} else {
			if (cols.length > 1) {
				if(hql.contains("where")){
					// 模糊查询 加括号确定sql语句的唯一
					sql = " and (" + individualSearchSql + ")" + orderSql;
				} else {
					// 模糊查询 加括号确定sql语句的唯一
					sql = " where (" + individualSearchSql + ")" + orderSql;
				}
				
			} else if(cols.length == 1) {
				sql = " where " + individualSearchSql + orderSql;
			}
		}
		return sql;
	}
}
