package sy.model.easyui;

import java.util.ArrayList;
import java.util.List;

/**
 * EasyUI DataGrid模型
 * 
 * @author 孙宇
 * 
 */
public class Grid implements java.io.Serializable {

	private Long total = 0L;  //总记录数
	private List rows = new ArrayList(); //行数

	public Long getTotal() {
		return total;
	}

	public void setTotal(Long total) {
		this.total = total;
	}

	public List getRows() {
		return rows;
	}

	public void setRows(List rows) {
		this.rows = rows;
	}

}
