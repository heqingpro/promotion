package cn.ipanel.apps.xpress.edition.management.controller.response;

import com.google.gson.Gson;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.Collections;
import java.util.List;

/**
 * Created with Intellij IDEA.
 *
 * @author luzhihao
 * Create: 2018-05-29 下午4:25
 * Modified By:
 * Description:
 */
@Data
@Slf4j
public class DataTablesVO<T> {
    private Integer draw;
    private Long recordsTotal = 0L;
    private Long recordsFiltered = 0L;
    private List<T> data;

    public DataTablesVO() {
    }

    public DataTablesVO(Integer draw, DataTablesVO<T> vo) {
        this.draw = draw;
        if (null != vo && null != vo.getData()) {
            this.recordsTotal = vo.getRecordsTotal();
            this.recordsFiltered = vo.getRecordsFiltered();
            this.data = vo.getData();
        } else {
            this.data = Collections.emptyList();
        }
    }

    public DataTablesVO(Integer draw, List<T> list) {
        this.draw = draw;
        if (null == list || list.isEmpty()) {
            list = Collections.emptyList();
        }
        this.data = list;
        this.recordsFiltered = Long.parseLong(list.size() + "");
        this.recordsTotal = Long.parseLong(list.size() + "");
    }
}
